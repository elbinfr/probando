
    var valor, contador, parrafo;
    $('<p class="agregado help-block">Tienes 160 caracteres restantes </p>').appendTo('#contador');
    $(document).on('ready',function(){
    WordCountOnLine();
        });
    function WordCountOnLine() {

        valor = $('#mensaje').val().length;
        setTimeout("WordCountOnLine();", 300);
        contador = 160 - valor;
        $('.text-danger').remove();
        $('.agregado').remove();
        if (contador < 0) {
            parrafo = '<p class="text-danger">';
        }
        else {
            parrafo = '<p class="agregado help-block">';
        }     
        $('#contador').append(parrafo + 'Tienes ' + contador + ' caracteres restantes</p>');
    } 
    
        