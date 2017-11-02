var pos=0;
var intv;
var flippedElement;
var opcionesHoteles = [{opciones:[{opcion:'Cuarto individual'},{opcion:'Alberca privada'},
{opcion:'Jacuzzi con burbujas'}],costo: '350',paquete:'Paquete medio'},
{opciones:[{opcion:'Cuarto individual'},{opcion:'Alberca privada'},
{opcion:'Jacuzzi de plata'}],costo: '500',paquete:'Paquete premium'},
{opciones:[{opcion:'Cuarto individual'},
{opcion:'Alberca privada'},{opcion:'Jacuzzi'}],costo: '300',paquete:'Paquete económico'}];
$(document).on('ready',function(){
init();
});
$(window).on('resize',init);
window.addEventListener('orientationchange',init);
function init(){
if($('html').width()>900){
	$.stellar({
		'horizontalScrolling':false,
		hideDistantElements:false
	});
}
var sc = $.scrollorama({blocks:'.fullScreen',enablePin:false});
//sc.animate('.mensajePrincipal',{delay:700,duration:350,property:'top',end:500});
//sc.animate('.mensajePrincipal',{delay:700,duration:200,property:'opacity',end:0});
sc.animate('.caracteristica',{delay:350,duration:100,property:'zoom',start:0,end:1});
sc.animate('.precio',{delay:350,duration:100,property:'opacity',start:0,end:1});
//sc.animate('#google_canvas',{delay:400,duration:200,property:'opacity',start:0,end:1});
$('#navegacionPrincipal').localScroll();
$('.slider_controls li').on('click',handleClick);
$(document).on('click','.ver-mas',flipElement);
$('.p1').hover(
	function(){ 
		$(".e2").stop().fadeIn;
		$(".e3").stop().fadeIn;
		$(".e2").hide();
		$(".e3").hide();
		$(".e1").fadeIn(3000);	
		}
);
$('.p2').hover(
			function(){ 
				$(".e1").stop().fadeIn;
				$(".e3").stop().fadeIn;
				$(".e1").hide();
				$(".e3").hide();
				$(".e2").fadeIn(3000);
			}
);
$('.p3').hover(
			function(){ 
					$(".e1").stop().fadeIn;
					$(".e2").stop().fadeIn;
					$(".e1").hide();
					$(".e2").hide();
					$(".e3").fadeIn(3000);
			}
);
intv=setInterval(handleClick,10000);
}
					function changeViewPort(){
						var e =$('.viewport');
						e.css('top',$(e).data('top'));
						e.removeClass('viewport');
						$(this).addClass('viewport');
						$(this).css('top',0);
					}
					function addBackground(element,width,setSize){
						if(!width) width= $('html').width();
						if(setSize){
							$(element).css({
								'width':width,
								'height':$('html').height()
							});
						}
						var url= $(element).data('background');
						if($('html').width() < 900){url=url+'-movil.jpg';}
						else{url=url+'.jpg';}
						$(element).css('background-image',"url("+(url)+")");
						if($(element).height() > $(element).width()){
							$(element).css('background-size',"auto 100%");
						}
					}
					function flipElement(){
						if(flippedElement != null){
							$(flippedElement).revertFlip();
							flippedElement = null;
						}
						$(flippedElement).remove();
						var padre = $(this).parent();
						flippedElement = padre;
						$('#precioTemplate').template("CompiledTemplate");
						$(padre).flip({
							direction: 'rl',
							speed: 500,
							content:$('#precioTemplate').tmpl(opcionesHoteles[$(this).data('number')]).html(),
							color:'#f7f7f7',
							onEnd: function(){
								$('#regresar-ventana').on('click',function(){
									$(flippedElement).revertFlip();
									flippedElement = null;
								})
							}
						});
					}
					function handleClick(){
						var slide_target = 0;
						if($(this).parent().hasClass('slider_controls')){
							slide_target = $(this).index();
							pos = slide_target;
							clearInterval(intv);
							intv=setInterval(handleClick,10000)
						}
						else{
							pos++;
							if(pos>=$('.slide').length){
								pos =0;
							}
							slide_target=pos;
						}	
$('.slideContainer').fadeOut('slow',function(){
$(this).animate({
	'margin-left':-(slide_target * $('.slider_container').width())+'px'
},'slow',function(){
	$(this).fadeIn();
});
});	
}
var sections = $('section')
  , nav = $('nav')
  , nav_height = nav.outerHeight();

$(window).on('scroll', function () {
  var cur_pos = $(this).scrollTop();
  
  sections.each(function() {
    var top = $(this).offset().top - nav_height,
        bottom = top + $(this).outerHeight();
    
    if (cur_pos >= top && cur_pos <= bottom) {
      nav.find('a').removeClass('active');
      sections.removeClass('active');
      
      $(this).addClass('active');
      nav.find('a[href="#'+$(this).attr('id')+'"]').addClass('active');
    }
  });
});


function mostrar(){
	$("#logueo").fadeIn(500);
        $("#username").focus();
}
function ocultar(){
	$("#logueo").fadeOut(500);
}
function abrir01(){
	$("#feature01").fadeIn(500);
}
function ocultar01(){
	$("#feature01").fadeOut(500);
         $(document).scrollTo('#solucion');
}
function abrir02(){
	$("#feature02").fadeIn(500);
}
function ocultar02(){
	$("#feature02").fadeOut(500);
         $(document).scrollTo('#solucion');
}
function abrir03(){
	$("#feature03").fadeIn(500);
}
function ocultar03(){
	$("#feature03").fadeOut(500);
         $(document).scrollTo('#solucion');
}
function ocultar04(){
	$("#error01").fadeOut(500);
}
function ocultar05(){
	$("#error02").fadeOut(500);
}
function ocultar06(){
	$("#error03").fadeOut(500);
}
function ocultar07(){
	$("#mail01").fadeOut(500);
}
function ocultar08(){
	$("#error04").fadeOut(500);
}