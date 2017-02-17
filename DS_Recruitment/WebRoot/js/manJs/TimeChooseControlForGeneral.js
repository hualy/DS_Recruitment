jQuery(document).ready(function(){
	
	var thisYear = new Date().getFullYear();
	var thisMonth = new Date().getMonth()+1;
	var thisDay = new Date().getDate();
	var today = thisYear+'-'+thisMonth+'-'+thisDay;
	
	$(".timeChooser").attr("value",today);
	
	$(".timeChooser").datetimepicker({
    //一堆参数

    format:"yyyy-mm-dd",
    weekStart: 0,
    todayBtn:  1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 1,
    showMeridian: 0,
    minView:2

    });
});