package com.gdut.ds.filter;

import java.util.Enumeration;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.constructs.blocking.LockTimeoutException;
import net.sf.ehcache.constructs.web.AlreadyCommittedException;
import net.sf.ehcache.constructs.web.AlreadyGzippedException;
import net.sf.ehcache.constructs.web.filter.FilterNonReentrantException;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

 
public class PageEhCacheFilter extends SimplePageCachingFilter {
 
    private final static Logger log = Logger.getLogger(PageEhCacheFilter.class);//日志监控
    
    private final static String FILTER_URL_PATTERNS = "patterns";		//要过滤的url集合（从web.xml配置好的）
    private static String[] cacheURLs;
    
    private void init() throws CacheException {							//初始化将要过滤的url分割分别存好
        String patterns = filterConfig.getInitParameter(FILTER_URL_PATTERNS);
        cacheURLs = StringUtils.split(patterns, ",");
    }
    
    @Override
    protected void doFilter(final HttpServletRequest request,
            final HttpServletResponse response, final FilterChain chain)
            throws AlreadyGzippedException, AlreadyCommittedException,
            FilterNonReentrantException, LockTimeoutException, Exception {
    	
        if (cacheURLs == null) {
            init();
        }
        
        String url = request.getRequestURI();							//获取当前请求的url，判断是否属于我们缓存的页面
        boolean flag = false;
        if (cacheURLs != null && cacheURLs.length > 0) {
            for (String cacheURL : cacheURLs) {
                if (url.contains(cacheURL.trim())) {
                    flag = true;
                    break;
                }
            }
        }
        // 如果包含我们要缓存的url 就缓存该页面，否则执行正常的页面转向
        if (flag) {
            String query = request.getQueryString();			//获取请求url附带的参数
            if (query != null) {
                query = "?" + query;
            }
            
//            log.info("当前请求被缓存：" + url + query);				//调试信息
            
            super.doFilter(request, response, chain);
        } else {
            chain.doFilter(request, response);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    /*
     * 判断请求头是否含有特定参数，用于下面对ie6，7不兼用问题
     */
    private boolean headerContains(final HttpServletRequest request, final String header, final String value) {
        logRequestHeaders(request);
        final Enumeration accepted = request.getHeaders(header);
        while (accepted.hasMoreElements()) {
            final String headerValue = (String) accepted.nextElement();
            if (headerValue.indexOf(value) != -1) {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * @see net.sf.ehcache.constructs.web.filter.Filter#acceptsGzipEncoding(javax.servlet.http.HttpServletRequest)
     * <b>function:</b> 兼容ie6/7 gzip压缩
     */
    @Override
    protected boolean acceptsGzipEncoding(HttpServletRequest request) {
        boolean ie6 = headerContains(request, "User-Agent", "MSIE 6.0");
        boolean ie7 = headerContains(request, "User-Agent", "MSIE 7.0");
        return acceptsEncoding(request, "gzip") || ie6 || ie7;
    }
}
