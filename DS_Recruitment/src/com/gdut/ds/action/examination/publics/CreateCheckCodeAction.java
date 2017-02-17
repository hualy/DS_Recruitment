package com.gdut.ds.action.examination.publics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CreateCheckCodeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ByteArrayInputStream inputStream;
	
	private int width = 150;//定义图片的width
	private int height = 50;//定义图片的height
	private int codeCount = 4;//定义图片上显示验证码的个数
	private int fontHeight = 40;
	private int fontWidth = width / codeCount;// 字体的宽度
	private int codeY = height - 5;
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z','0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}



	@Override
	public String execute() throws Exception {
	
		
		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
//		Graphics2D gd = buffImg.createGraphics();
		//Graphics2D gd = (Graphics2D) buffImg.getGraphics();
		Graphics gd = buffImg.getGraphics();
		// 创建一个随机数生成器类
		Random random = new Random();
		// 将图像填充为白色
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);

		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
		
		// 设置字体。
		gd.setFont(font);
		// 画边框。
		gd.setColor(Color.BLACK);
		gd.drawRect(0, 0, width - 1, height - 1);

		// 随机产生60条干扰线，使图象中的认证码不易被其它程序探测到。
		gd.setColor(Color.BLACK);
		for (int i = 0; i < 60; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = x + random.nextInt(width);
			int yl = y + random.nextInt(height);
			gd.drawLine(x, y, x + xl, y + yl);
		}
		
		// 添加噪点
		float yawpRate = 0.02f;// 噪声率
		int area = (int) (yawpRate * width * height);
		for (int i = 0; i < area; i++) {
		  int x = random.nextInt(width);
		  int y = random.nextInt(height);
		  buffImg.setRGB(x, y, random.nextInt(255));
		}
		

		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;

		// 随机产生codeCount数字的验证码。
		for (int i = 0; i < codeCount; i++) {
				// 得到随机产生的验证码数字。
			String code = String.valueOf(codeSequence[random.nextInt(36)]);
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);

			// 用随机产生的颜色将验证码绘制到图像中。
			gd.setColor(new Color(red, green, blue));
			gd.drawString(code, i*fontWidth+3, codeY);

			// 将产生的四个随机数组合在一起。
			randomCode.append(code);
		}
		
		// 将四位数字的验证码保存到Session中。
		//Map<String, Object> session = ActionContext.getContext().getSession();
//		System.out.println(randomCode);
		ServletActionContext.getRequest().getSession().setAttribute("checkCode",randomCode.toString().toLowerCase());

		// 禁止图像缓存。
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);						//有效期为0
		response.setContentType("image/jpeg");

		// 将图像输出到Servlet输出流中。
//		ServletOutputStream sos = response.getOutputStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(buffImg, "jpeg", outputStream);
		ByteArrayInputStream input = new ByteArrayInputStream(outputStream.toByteArray());

	    this.setInputStream(input);
		
	    input.close();
        outputStream.close();
//		sos.close();
		
	
		return SUCCESS;
	}
}
