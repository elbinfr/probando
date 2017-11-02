<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <div class="panel-body" id="page-wrapper">
                <div class="adv-table">
                    <table class="table table-striped table-bordered table-hover" id="msg">
                        <thead>
                            <tr>
                                <th class="no-sort" width="5%"><input type="checkbox" id="selector" onclick="seleccionGeneral()"></th>
                                <th width="5%">Campaña Id</th>
                                <th width="10%">Enviado desde</th>
                                <th width="20%">Texto</th>
                                <th width="10%">Fecha de Recepción</th>
                                <th width="10%">Fecha de Respuesta</th>
                                <th width="10%">Estado Proceso</th>
                                <th width="15%" style="text-align:center;">Chat CRM <label style="color:red;">(Beta)</label></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${messages}" var="msg">
                                    <tr
                                        <c:if test="${msg.processStatus == 1}">
                                                class="yellow-td"
                                             </c:if>

                                        >
                                        <td>
                                            <input type="checkbox" class="message" id="${msg.id}" onclick="seleccionParticular(${msg.id})">
                                        </td>
                                        <td><c:out value="${msg.campaignId}"/> </td>
                                        <td><c:out value="${msg.msisdn}"/></td>
                                        <td><c:out value="${msg.txtMsg}"/></td>
                                        <td><fmt:formatDate value="${msg.receivedDate}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
                                        <td><fmt:formatDate value="${msg.replyDate}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
                                        <td>
                                             <c:if test="${msg.processStatus == 1}">
                                                 No Leído
                                             </c:if>
                                    <c:if test="${msg.processStatus == 2}">
                                        Leído
                                    </c:if>     
                                    <c:if test="${msg.processStatus == 3}">
                                        No Contestado
                                    </c:if>
                                    <c:if test="${msg.processStatus == 4}">
                                        Contestado
                                    </c:if>  
                                        </td>
                                        <td style="text-align: center;"><a href="historyMessage?id=${msg.id}&node=${msg.node}&msisdn=${msg.msisdn}" ><i class="fa fa-comments fa-fw" style="font-size:25px;color: #1f65ab"></i></a>  </td>
                                </tr>
                               </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
    </div>
</div>
<script type="text/javascript">
    
    var url_incoming = "<s:url action="incoming-message" />";
   
    $('#msg').DataTable( {
        "dom": 'T<"top"lf>rt<"bottom"ip><"clear">',
        tableTools: {
            "sSwfPath": "swf/copy_csv_xls_pdf.swf",
        },
        "language": {
            "lengthMenu": "Muestra _MENU_ registros por página",
            "zeroRecords": "No existen registros",
            "info": "Muestra _START_ - _END_ de un total de _TOTAL_ registros &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Página _PAGE_ de _PAGES_",
            "infoEmpty": "No existen registros",
            "search": "Filtro:",
            "paginate": {
                "first": "Primera",
                "last": "Ultima",
                "next": "Siguiente",
                "previous": "Anterior"
            }},
        "pagingType": "full_numbers",
        "order": [],
        "columnDefs": [{
                "targets": 'no-sort',
                "orderable": false,
          }]
    });
    
    $("div.top").append('<select id="cboOpciones" class ="form-control input-sm col-md-2"><option value="0">Opciones</option><option value="1">Marcar como leído</option><option value="2">Eliminar</option></select><br>');
    $("#selector").prop("checked", false);
    $(".message").prop("checked", false);
    
    $("#page-wrapper").on('change', '#cboOpciones', function(event){
        if($("#cboOpciones").val()==1){
            leerSeleccionados();
        }else if($("#cboOpciones").val()==2){
            eliminarSeleccionados();
        }
    });
            
    var incomingMessages = [];
    function seleccionGeneral(){
        if( $('#selector').prop('checked') ) {

            $( ".message" ).each(function( index ) {
                id = $( this ).attr('id');
                $( "#"+id ).prop("checked", true);
                incomingMessages.push(id);
              });
        }else{
             $(".message").prop("checked", false);
        }
    }

    function seleccionParticular(id){
        if($('#'+id).prop('checked')){
            incomingMessages.push(id);
        }else{
            var i = incomingMessages.indexOf( id );

            if ( i !== -1 ) {
                incomingMessages.splice( i, 1 );
            }
        }
    }
    
    function leerSeleccionados(){
        var jsonString = JSON.stringify(incomingMessages);

        var r = confirm("¿Esta seguro que desea marcar los mensajes como leídos");
        var todos = false;
        if (r == true) {
            if( $('#selector').prop('checked') ) {
                todos = true;
            }
            $('#main').loading({message: 'Procesando...'});
            $.ajax({
                url: "<s:url action="ReadIncomingMessage" />"+"?data="+jsonString+";"+todos,
                contentType: "application/json; charset=utf-8",
                type: 'POST',
                dataType: 'json',
                success: function (data) {
                    location.reload();
                },
                error: function (data) {
                   location.reload();
                }
            });
        } else {
             return false;
        }

    }
    
    function eliminarSeleccionados(){
        var jsonString = JSON.stringify(incomingMessages);
        var r = confirm("¿Esta seguro que desea eliminar los mensajes seleccionados");
        var todos = false;
        if (r == true) {
            if( $('#selector').prop('checked') ) {
                todos = true;
            }
            $('#main').loading({message: 'Procesando...'});
            $.ajax({
                url: "<s:url action="deleteIncomingMessage" />"+"?data="+jsonString+";"+todos,
                contentType: "application/json; charset=utf-8",
                type: 'POST',
                dataType: 'json',
                success: function (data) {
                    location.reload();
                },
                error: function (data) {
                   console.log(data);
                }
            });
        } else {
             return false;
        }

    }
    
</script>