var obj,j;
var page=0;
var nowPage=0;//当前页
var listNum=15;//每页显示piece条数
var PagesLen;//总页数
var PageNum=4;//分页链接接数(5个)
jQuery(document).ready(function(){
    
    /***************************分页**************************************/
	
	changepage();
	function changepage()//初始化
	{
		obj=document.getElementsByName("stu-result-piece");
		j=obj.length;
		PagesLen=Math.ceil(j/listNum);
		upPage(0);
	}
	
	/***************************分页**************************************/	
});
function upPage(p)//p为第几页
	{
		nowPage=p;
		//内容变换
		for (var i=0;i<j;i++)
		{
		obj[i].style.display="none";
		}//全部隐藏
		for (var i=p*listNum;i<(p+1)*listNum;i++)//输出第N页的piece
		{
		if(obj[i])obj[i].style.display="block";
		}
		//分页链接变换
		strS='<button class="btn btn-default" onclick="upPage(0)">首页</button>';
		var PageNum_2=PageNum%2==0?Math.ceil(PageNum/2)+1:Math.ceil(PageNum/2);//用来判断过不过半
		var PageNum_3=PageNum%2==0?Math.ceil(PageNum/2):Math.ceil(PageNum/2)+1;
		var strC="",startPage,endPage;
		if (PageNum>=PagesLen) {startPage=0;endPage=PagesLen-1;}//需要分页的数目少于分页链接数的情况
		else if (nowPage<PageNum_2)//需要分页的数目大过分页链接数并当前页靠前的情况
		{
		startPage=0;
		endPage=PagesLen-1>PageNum?PageNum:PagesLen-1;//开始默认都是首页开始。。
		}//首页
		else//需要分页的数目大过分页链接数并当前页靠后的情况
		 {
		 	startPage=nowPage+PageNum_3>=PagesLen?PagesLen-PageNum-1: nowPage-PageNum_2+1;
		 	//当前页越过一半页数之后，分页的开端自动缩进。。能叫缩进么。。。就是那个意思而已。。
		 	var t=startPage+PageNum;//记录一下而已
		 	endPage=t>PagesLen?PagesLen-1:t;
		 }
		for (var i=startPage;i<=endPage;i++)//对外输出分页结果
		{
		 if (i==nowPage)
		 	strC+='<button class="btn btn-default" style="color:red;font-weight:700;" onclick="upPage('+i+')";>'+(i+1)+'</button> ';
		 else 
		 	strC+='<button class="btn btn-default" onclick="upPage('+i+');">'+(i+1)+'</button> ';
		}
		strE=' <button class="btn btn-default" onclick="upPage('+(PagesLen-1)+');">尾页</button>';
		strE2=nowPage+1+"/"+PagesLen+"页"+"  共"+j+"条回复";
		document.getElementById("changepage").innerHTML=strS+strC+strE+strE2;
	}