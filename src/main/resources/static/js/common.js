$(document).ready(function(){

	// gnb
	$("nav > ul > li.has_sub > a").click(function(e){
		if($(this).parent().has("> ul")) {
			e.preventDefault();
		}

		if(!$(this).hasClass("on")) {
			$(this).next("ul").stop().slideDown(200);
			$(this).addClass("on");
			$(this).parent().siblings().find(" > a").removeClass("on").end().find(" > ul").stop().slideUp(200);
		}else if($(this).hasClass("on")) {
			$(this).removeClass("on");
			$(this).next("ul").stop().slideUp(200);
		}
	});

	// menu_toggle
	$(".menu_toggle").click(function(){
		$('#container .menu_toggle').toggleClass('active');
		$('body').toggleClass('snb_none');
		$(window).trigger('resize');
	});
	// cm_list
	$(".cm_list > div > a").click(function(){
		var submenu = $(this).next("div.hide_view");
		if( submenu.is(":visible") ){
			submenu.removeClass("open");
		}else{
			submenu.addClass("open");
		}
	});

	// 댓글
	$(".cm_re_info > button").click(function(){
		var submenu = $(this).parent().next("div.hide_view");
		if( submenu.is(":visible") ){
			submenu.removeClass("open");
		}else{
			submenu.addClass("open");
		}
	});

	// 첨부파일
	$(".file_input input[type='file']").on('change',function(){
		var fileName = $(this).val().split('/').pop().split('\\').pop();
		$(this).parent().siblings("input[type='text']").val(fileName);
	});
	// 파일업로드 미리보기
	$('.file_upload input[type=file]').change(function(event) {
		var tmppath = URL.createObjectURL(event.target.files[0]);
		$(this).parent('label').parent('.file_upload').parent('.file_preview').find("img").attr('src',tmppath);
	});
});

//gnb add on
function gnbClassOn(uri){
	console.log('hihihihi');
	if(uri.includes('about')){
		console.log('hihi');
	}
}

// 레이어 팝업(기본)
function layerPop(popName){
	var $layer = $("#"+ popName);
	$layer.fadeIn(500).css('display', 'inline-block').wrap( '<div class="overlay_t"></div>');
	$('body').css('overflow','hidden');
}
function layerPopClose(){
	$(".popLayer").hide().unwrap( '');
	$('body').css('overflow','auto');
	$(".popLayer video").each(function() { this.pause(); this.load(); });
}
function layerPopClose2(popName){
	$("#"+ popName).hide().unwrap( '');
	$('body').css('overflow','auto');
}

// 클릭시 새창 팝업 띄우기
function popup_win(str,id,w,h,scrollchk){
	var pop = window.open(str,id,"width="+w+",height="+h+",scrollbars="+scrollchk+",resize=no,location=no ");
	pop.focus();
}

function responsive(){
//main_visual Height
    var innerH = $(window).innerHeight();
    var headerH = $('#header').innerHeight();
    var roomH = $('article.area_room .tab_content').innerHeight();

    $('.area_visual').css('height', innerH);
    $('.vs_text').css('padding-top', headerH);
    $('article.area_room .tab_container').css('height', roomH);

    //header
    var res = ""
    var param = $("#header");
    var nav = $("#header nav");
    var navClone = $("#header nav").clone();
    var gnbClone = navClone.find(".gnb");
    var gnbArea = $(".gnb > li");
    var gnbLink = gnbArea.children("a");
    $('#header nav .gnb > li ul').addClass('active');
    $('#header nav').prepend('<h1 class="font_jalnan">almond kids poolvilla</h1>');
    $('#header .btn_menu_pc').prepend('<i><span></span><span></span><span></span><span></span></i>');
    $('#header .btn_menu').prepend('<i><span></span><span></span><span></span><span></span></i>');
    $('.full_menu .full_gnb').prepend(gnbClone);

    //lng + sub title
    var subTitle = $('#header .gnb > li > a.on').html();
    var pageTitle = $('#header .gnb > li > ul > li > a.on').html();
    var lnbHtml = $('#header .gnb > li > a.on').next('ul').html();

    $('.sv_text h2').html(subTitle);
    $('.sub_tit').html(pageTitle);
    $('.area_lnb ul').append(lnbHtml);
    $('.area_lnb ul > li').each(function(){
        var lnbLink = $(this).find('a').attr('href');
        $(this).find('a').attr('href',lnbLink + '#lnb');
    });

    nav.hover(function(){
        param.addClass("active");

    }, function(){
        param.removeClass("active");
    });

    gnbLink.hover(function() {
        if(param.attr("class") == "web" || param.attr("class") && "web"){

            $(this).addClass("active").parent().addClass("active");
            $(this).parent().hover(function() {
            }, function(){
                $(this).removeClass("active", function(){
                    $(this).parent().find("a").removeClass("active");
                });
            });

            if(!($(this).parent().find("ul").length > 0)) {
                $(this).parent().removeClass("active").find("a").removeClass("active");
            }
        }
    });

    //default
    if(!$(".btn_menu").is(":hidden")) res = "mob";
    else res = "web";
    param.attr("class",res);
    def(param);

    $(window).resize(function(){
        if(!$(".btn_menu").is(":hidden")) res2 = "mob";
        else res2 = "web";
        param.attr("class",res2);
        if(res != res2){
            res = res2;
            def(param);
        }
    });

    $('.btn_menu_pc').on('click',function(){
        if($(this).hasClass('active')){
            $('.btn_menu_pc').removeClass('active');
            $('.full_menu').removeClass('active');
            posY = $('body').attr('data-scroll');
            $(window).scrollTop(posY);
        }else{
            posY = window.scrollY || document.documentElement.scrollTop;
            $(this).toggleClass('active');
            $('.full_menu').toggleClass('active');
            $('body').attr('data-scroll',posY);
        }
        return false;
    });


    //mobile
    $('.btn_menu').on('click',function(){
        if($(this).hasClass('active')){
            $('.btn_menu').removeClass('active');
            $('body').removeClass('active');
            $('.area_until > ul').removeClass('active');
            param.find('nav').removeClass('on');
            gnbLink.removeClass('on');
            gnbLink.parent().find('ul').slideUp();
            posY = $('body').attr('data-scroll');
            $(window).scrollTop(posY);
        }else{
            posY = window.scrollY || document.documentElement.scrollTop;
            $(this).toggleClass('active');
            $('.area_until > ul').toggleClass('active');
            setTimeout(function() {
                 $('body').toggleClass('active');
            }, 0);
            param.find('nav').toggleClass('on');
            gnbLink.removeClass('active');
            gnbLink.parent().find('ul').slideUp();
            $('body').attr('data-scroll',posY);
        }
        return false;
    });

    $('.btn_close').on('click',function(){
        $('.btn_menu').removeClass('active');
        $('.full_menu').removeClass('active');
        $('body').removeClass('active');
        param.find('nav').removeClass('active');
        gnbLink.removeClass('active');
        gnbLink.parent().find('ul').slideUp();
        return false;
    });

    function def(param){
        if(param.attr("class") == "web" ){
            $('#header .gnb > li > a').unbind('click');
            $('#header .gnb > li > ul').removeAttr('style');
            $('.btn_menu, body, #header nav').removeClass('active');
            gnbLink.removeClass('active');

            gnbLink.hover(function() {
                if(param.attr("class") == "web" || param.attr("class") && "web"){
                    $(this).addClass("active").parent().addClass("active");
                    $(this).parent().hover(function() {
                    }, function(){
                       $(this).removeClass("active", function(){
                            $(this).parent().find("a").removeClass("active");
                       });
                    });
                      //하위메뉴가 없을경우  a에 active 추가 없음
                    if(!($(this).parent().find("ul").length > 0)) {
                       $(this).parent().removeClass("active").find("a").removeClass("active");
                    }
                }
            });

        } else if (param.attr("class") == "mob"){
            $('#header .gnb li').off('mouseenter mouseleave');

            $('#header.mob .gnb > li').each(function(){
                var gnbLink = $(this).children('a');
                if($(this).children('ul').length > 0){
                    gnbLink.on('click',function(e){
                        e.preventDefault();
                        $('#header .gnb a').removeClass('active');
                        gnbArea.children('ul').stop().slideUp();
                        $(this).addClass('active');
                        $(this).siblings('a').addClass('active');
                        $(this).parent().children('ul').stop().slideDown();
                        return false;
                    });
                }
            });
        }
    }
}
