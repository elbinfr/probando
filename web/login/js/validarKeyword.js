function validar() {
    $('<p class="error"></p>').appendTo('.modal-body');
    var tip = $('#tip').val();
    var nombre = $('input[name=nom]').val();
    if(nombre==''){
      $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un nombre</p>');
        $('#myModal').modal('show');
        return false;  
    }
    var descripcion = $('input[name=des]').val();
    if(descripcion==''){
      $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar una desripcion</p>');
        $('#myModal').modal('show');
        return false;  
    }
    $('input[name=key1]').val(function() {
        return this.value.toUpperCase();
    });
    $('input[name=key2]').val(function() {
        return this.value.toUpperCase();
    });
    var key1 = $('input[name=key1]').val();
    if(key1==''){
      $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe un KEY1</p>');
        $('#myModal').modal('show');
        return false;  
    }
    var receptor = $('select[name=rec]').val();
    if(receptor==0){
      $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe seleccionar un receptor</p>');
        $('#myModal').modal('show');
        return false;  
    }
    var texto = $('textarea[name=reply_txt]').val();
    if(texto==''){
      $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un texto de respuesta</p>');
        $('#myModal').modal('show');
        return false;  
    }
 
    if(!$('input[name=visible]:checked').val()){
      $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe selecionar opcion Visible</p>');
        $('#myModal').modal('show');
        return false;  
    }

    if(!$('input[name=activo]:checked').val()){
      $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe selecionar opcion Activo</p>');
        $('#myModal').modal('show');
        return false;  
    }
    if (tip == 'N') {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe seleccionar un tipo</p>');
        $('#myModal').modal('show');
        return false;  
    }
    if (tip == 'A') {

    }
    if (tip == 'S') {

    }
    if (tip == 'T') {

    }
}
function validacion02() {
    valor = $('#mensaje').val().length;
    $('<p class="error"></p>').appendTo('.modal-body');
    if (valor == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar algun mensaje</p>');
        $('#myModal').modal('show');
        document.paso2.mensaje.focus();
        return false;
    }
    var fecha = document.getElementById("fecha");
    if (!document.paso2.fecha.value) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingesar una fecha</p>');
        $('#myModal').modal('show');
        document.paso2.fecha.focus();
        return false;
    }
    var value = $("#fecha").val();
    var currentDate = new Date();
    var yyyy = currentDate.getFullYear();
    var MM = currentDate.getMonth() + 1;
    if (MM < 10) {
        MM = '0' + MM;
    }
    var dd = currentDate.getDate();
    if (dd < 10) {
        dd = '0' + dd;
    }
    var fecha = yyyy + '-' + MM + '-' + dd;
    if (value < fecha) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">La fecha no puede ser anterior a este día</p>');
        $('#myModal').modal('show');
        return false;
    }
    if (value == fecha) {
        var h = currentDate.getHours();
        var horas = $("#horas").val();
        if (horas < h) {
            $('.error').remove();
            $("#myModal").css({opacity: 1});
            $('.modal-body').append('<p class="error">La hora seleccionada no puede ser anterior a la hora actual</p>');
            $('#myModal').modal('show');
            return false;
        }
        var m = currentDate.getMinutes();
        var minutos = $("#minutos").val();
        if (minutos < m) {
            $('.error').remove();
            $("#myModal").css({opacity: 1});
            $('.modal-body').append('<p class="error">Los minutos seleccionados  no pueden ser anteriores a este día</p>');
            $('#myModal').modal('show');
            return false;
        }
    }

}
function validacionSenders() {
    valor = $('#msisdn').val().length;
    $('<p class="error"></p>').appendTo('.modal-body');
    if (valor == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un numero para el msisdn</p>');
        $('#myModal').modal('show');
        document.formulario.msisdn.focus();
        return false;
    }

}
function validacionPlans() {
    $('<p class="error"></p>').appendTo('.modal-body');
    nom = $('#nom').val().length;
    if (nom == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un nombre</p>');
        $('#myModal').modal('show');
        document.formulario.nom.focus();
        return false;
    }
    des = $('#des').val().length;
    if (des == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar una descripcion</p>');
        $('#myModal').modal('show');
        document.formulario.des.focus();
        return false;
    }
    min = $('#min').val().length;
    if (min == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un valor minimo</p>');
        $('#myModal').modal('show');
        document.formulario.min.focus();
        return false;
    }
    max = $('#max').val().length;
    if (max == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un valor maximo</p>');
        $('#myModal').modal('show');
        document.formulario.max.focus();
        return false;
    }
    pre = $('#pre').val().length;
    if (pre == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un precio</p>');
        $('#myModal').modal('show');
        document.formulario.pre.focus();
        return false;
    }
    exc = $('#exc').val().length;
    if (exc == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un exceso</p>');
        $('#myModal').modal('show');
        document.formulario.exc.focus();
        return false;
    }
    lin = $('#lin').val().length;
    if (lin == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un exceso</p>');
        $('#myModal').modal('show');
        document.formulario.lin.focus();
        return false;
    }
    key = $('#key').val().length;
    if (key == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un exceso</p>');
        $('#myModal').modal('show');
        document.formulario.key.focus();
        return false;
    }

}
function validacionCorporates() {
    $('<p class="error"></p>').appendTo('.modal-body');
    nom = $('#nom').val().length;
    if (nom == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un nombre</p>');
        $('#myModal').modal('show');
        document.formulario.nom.focus();
        return false;
    }
    usr = $('#usr').val().length;
    if (usr == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un usuario</p>');
        $('#myModal').modal('show');
        document.formulario.usr.focus();
        return false;
    }
    pwd = $('#pwd').val().length;
    if (pwd == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un password</p>');
        $('#myModal').modal('show');
        document.formulario.pwd.focus();
        return false;
    }
    ema = $('#ema').val().length;
    if (ema == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un email</p>');
        $('#myModal').modal('show');
        document.formulario.ema.focus();
        return false;
    }
    vel = $('#vel').val().length;
    if (vel == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar una velocidad</p>');
        $('#myModal').modal('show');
        document.formulario.vel.focus();
        return false;
    }
    tip = $('#tip').val();
    if (tip == 'ninguno') {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe seleccionar una tipo</p>');
        $('#myModal').modal('show');
        document.formulario.tip.focus();
        return false;
    }

}
function validacionContracts() {
    corp_id = $('#corp_id').val();
    if (corp_id == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe seleccionar un tipo</p>');
        $('#myModal').modal('show');
        document.formulario.corp_id.focus();
        return false;
    }
    plan_id = $('#plan_id').val();
    if (plan_id == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe seleccionar un plan</p>');
        $('#myModal').modal('show');
        document.formulario.plan_id.focus();
        return false;
    }
    var from_date = document.getElementById("from_date");
    if (!document.formulario.from_date.value) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe seleccionar un fecha de inicio</p>');
        $('#myModal').modal('show');
        document.formulario.from_date.focus();
        return false;
    }
    var to_date = document.getElementById("to_date");
    if (!document.formulario.to_date.value) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe seleccionar un fecha de fin</p>');
        $('#myModal').modal('show');
        document.formulario.to_date.focus();
        return false;
    }
    mon = $('#mon').val().length;
    if (mon == 0) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe ingresar un monto</p>');
        $('#myModal').modal('show');
        document.formulario.mon.focus();
        return false;
    }
    var due_date = document.getElementById("due_date");
    if (!document.formulario.due_date.value) {
        $('.error').remove();
        $("#myModal").css({opacity: 1});
        $('.modal-body').append('<p class="error">Debe seleccionar un fecha de vencimiento pago</p>');
        $('#myModal').modal('show');
        document.formulario.due_date.focus();
        return false;
    }

}