$(function(){
	$(".pl").css("display","none");
	$(".link-a i").click(function(){
		$(this).toggleClass(" red");
	})	
	/*layui-anim layui-anim-scale 跳动的样式*/
	$(".link-b i").click(function(){
		
		$(this).parent().parent().siblings(".pl").show();
		$(this).css("color", "#007DDB");			
	})
	
	$(".pl4").click(function(){
	$(this).parent().hide();
	$(this).parent().siblings(".textfoot").children(".link-b").children("i").css("color", "#737383");
	})	
       															
})

