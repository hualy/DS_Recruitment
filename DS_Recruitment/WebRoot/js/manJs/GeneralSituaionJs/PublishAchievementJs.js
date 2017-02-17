jQuery(document).ready(function(){
	

	$("#publish-ach-btn").click(function(){
		if(ach_formValidation()){
			$("#pub-ach").submit();
		}
	});
	
	
	
	
});