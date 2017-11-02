<%@ taglib prefix="s" uri="/struts-tags" %>

<form action="<s:url action="load-campaign-file"/>" method="post" class="form-horizontal tasi-form" enctype="multipart/form-data" id="form">
    <div class="form-group">
        <label class="control-label col-md-2">Ingrese un archivo</label>
        <div class="controls col-md-6">
            <div class="fileupload fileupload-new" data-provides="fileupload">
                <span class="btn btn-white btn-file">
                    <span class="fileupload-new"><i class="fa fa-paper-clip"></i> Seleccionar archivo xlsx</span>
                    <span class="fileupload-exists"><i class="fa fa-undo"></i> Cambiar archivo xlsx</span>
                    <input type="file" class="default" name="campaignFile"/>
                </span>
                <span class="fileupload-preview" style="margin-left:5px;"></span>
                <a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none; margin-left:5px;"></a>
            </div>
            
        </div>
        <div class="controls col-md-4">
            <span class="label label-danger">NOTA !</span>
            <span>
                &nbsp;Solo excel de versiones 2007 en adelante *.xlsx
            </span>
        </div>
    </div>
    <button type="submit" class="btn btn-default">Cargar</button>
</form>
<s:if test="%{stage=='loadfile'}">
    <form action="#" method="post" class="form-horizontal" enctype="multipart/form-data" id="form">
        <div class="form-group">
            <label class="col-lg-2 col-sm-2 control-label">Archivo Cargado</label>
            <div class="col-lg-10">
                <p class="form-control-static"><s:property value="#session.sending.fileUrl"/></p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 col-sm-2 control-label">Número de Registros</label>
            <div class="col-lg-10">
                <p class="form-control-static"><s:property value="#session.sending.totalMessages"/></p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 col-sm-2 control-label">Descripción</label>
            <div class="col-lg-10">
                <textarea></textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 col-sm-2 control-label">Tipo de envio</label>
            <div class="col-lg-10 radios">
                <label class="label_radio" for="radio-01">
                    <input name="sample-radio" id="radio-01" value="1" type="radio" checked />Inmediato
                </label>
                &nbsp;
                <label class="label_radio" for="radio-01">
                    <input name="sample-radio" id="radio-01" value="1" type="radio" checked />Programado
                </label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 col-sm-2 control-label">Usar keyword</label>
            <div class="col-lg-10">
                <div class="make-switch switch-mini">
                    <input type="checkbox" checked>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 col-sm-2 control-label">Filtrar Black List INDECOPI</label>
            <div class="col-lg-10">
                <div class="make-switch switch-mini">
                    <input type="checkbox" checked>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-default">Siguiente</button>
    </form>
</s:if>
    
<script type="text/javascript">
    (function(){
        
        function load(){
            verifyStatusAction();
        }
        
        function verifyStatusAction(){
            <s:if test="%{statusAction == 'error'}">
                var errorMessage = '<s:property value="errorMessage" />';
                swal({
                    title: "Error!",
                    text: errorMessage,
                    type: "error",
                    confirmButtonText: "Aceptar",
                    html: true
                });
            </s:if>
        }
        
        load();
              
        
    })();
</script>
