<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading tab-bg-dark-navy-blue ">
                <ul class="nav nav-tabs">
                    <li class="" id="personalizado">
                        <a data-toggle="tab" href="#home">Personalizado</a>
                    </li>
                    <li class="" id="archivo">
                        <a data-toggle="tab" href="#file-xlsx">Archivo Excel</a>
                    </li>
                    <li class="" id="lista">
                        <a data-toggle="tab" href="#profile">Lista</a>
                    </li>
                </ul>
            </header>
            <div class="panel-body">
                <div class="tab-content">
                    <div id="home" class="tab-pane active">
                        Home
                    </div>
                    <div id="file-xlsx" class="tab-pane">
                        <s:include value="simple-file.jsp" />
                    </div>
                    <div id="profile" class="tab-pane">Profile</div>
                    <div id="contact" class="tab-pane">Contact</div>
                </div>
            </div>
        </section>
    </div>
</div>

<script type="text/javascript">
    (function(){
        var optionCampaign = '<s:property value="#session.optionCampaign"/>';
        
        function load(){
            setActiveTab();
        }
        
        function setActiveTab(){
            $('#'+optionCampaign).children('a').trigger( "click" );
        }
        
        load();        
        
    })();
</script>