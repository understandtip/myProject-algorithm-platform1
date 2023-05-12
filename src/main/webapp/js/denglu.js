$(function() {
	$('form button').css("font-size", "130%");

	$('#login').click(function() {
		//先移除然后在添加
		$('.switch span').removeClass('active')

		$(this).addClass('active')

		$(this).parents('.content').removeClass('signup')

		$(this).parents('.content').addClass('login')

		$('form button').text('登录');
		$('form button').css("font-size", "130%");
	})

	$('#signup').click(function() {
		$('.switch span').removeClass('active')
		$(this).addClass('active')

		$(this).parents('.content').removeClass('login')
		$(this).parents('.content').addClass('signup')

		$('form button').text('注册')
		$('form button').css("font-size", "130%");

	})

	
	$('.input input').on('focus', function() {
		$(this).parent().addClass('focus')
	})

	$('.input input').on('blur', function() {
		if($(this).val() === '')
			$(this).parent().removeClass('focus')
		else
		$(this).parent().addClass('focus')
	})
	
   
})


	