$(function(){
	$('#msg').fadeOut(5000);
	$('table a').click(function(){
		if(!confirm('确认要删除该记录吗？')){
			return false;		
		}
	});
});