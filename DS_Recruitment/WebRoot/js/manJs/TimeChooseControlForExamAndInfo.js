jQuery(document).ready(function(){
	var thisYear = new Date().getFullYear();
	var thisMonth = new Date().getMonth()+1;
	var thisDay = new Date().getDate();
	var thisHour = new Date().getHours();
	var thisMinute = new Date().getMinutes();
	var thisSecond = new Date().getSeconds();
	var today = thisYear+'-'+thisMonth+'-'+thisDay+' '+thisHour+':'+thisMinute+':'+thisSecond;
	
	$(".timeChooser").attr("value",today);
	
	
	
	
	$(".timeChooser").datetimepicker({
    //一堆参数

    format:"yyyy-mm-dd hh:ii:ss",
    weekStart: 0,
    todayBtn:  true,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 1,
    showMeridian: 1

    });
});