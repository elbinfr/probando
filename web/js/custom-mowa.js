
var menu = '';
var submenu = '';

function clearBreadcrumb(){
    menu = '';
    submenu = '';
};

function setBreadcrumb(){
    
    if(menu === undefined || menu.length <= 0){
        $('#menu').html(null);
    }else{
        $('#menu').html(menu);
    }
    if(submenu === undefined || submenu.length <= 0){
        $('#submenu').html(null);
    }else{
        $('#submenu').html(submenu);
    }
    
};

$('.menu').on('click', function(event){
    event.preventDefault();
    
    $(this).addClass('active');
    clearBreadcrumb();
    menu = $(this).data('menu');
    '<s:set var="menu" value="'+menu+'"/>';
    submenu = $(this).data('submenu');
    setBreadcrumb();
    
    var url = $(this).attr('href') + '?numero=100';
    console.log(url);
    
    location.href = url;

});

