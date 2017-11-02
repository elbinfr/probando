<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <div class="panel-body">
                <form action="<s:url action="descargaExcel" />" method=""post>
                    <div class="col-md-5">
                         <label>Desde:</label>
                         <input autocomplete="on" type="input" class="form-control datepicker" name="from_date" required="true">
                     </div>
                     <div class="col-md-5">
                         <label>Hasta:</label>
                         <input autocomplete="on" type="input" class="form-control datepicker" name="to_date" required="true">
                     </div>
                     <input type="hidden" id="altformat">
                     <div class="col-md-2">
                         <br><input class="btn btn-primary btn-block" type="submit" value="Descargar"></input>
                     </div>
                </form>
             </div>
        </section>
     </div>
</div>

<script type="text/javascript">
    var todayDate = new Date().getDate();
    var endD= new Date(new Date().setDate(todayDate - 15));
    var currDate = new Date();

    $( ".datepicker" ).datepicker({
        useCurrent: false,
        format: 'dd/mm/yyyy',
        autoclose: true,
        language: 'es',
        minDate: endD,
    }).datepicker("setDate", currDate);
</script>