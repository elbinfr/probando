<%@taglib prefix="s" uri="/struts-tags" %>
<ul class="sidebar-menu" id="nav-accordion">
    <li>
        <a href="<s:url action="inicio" />" class="menu" data-menu="Nosotros">
            <i class="fa fa-dashboard"></i>
            <span>Inicio</span>
        </a>
    </li>

    <li class="sub-menu">
        <a href="javascript:;">
            <i class="fa fa-laptop"></i>
            <span>Campañas</span>
        </a>
        <ul class="sub">
            <li><a  href="<s:url action="create-campaign" />">Crear Campañas</a></li>
            <li><a  href="horizontal_menu.html">Mis campañas</a></li>
        </ul>
    </li>

    <li class="sub-menu">
        <a href="javascript:;">
            <i class="fa fa-book"></i>
            <span>Listas</span>
        </a>
        <ul class="sub">
            <li><a  href="general.html">Gestionar Listas</a></li>
            <li><a  href="buttons.html">Suscripciones</a></li>
            <li><a  href="modal.html">Suscripción DNI</a></li>
        </ul>
    </li>

    <li class="sub-menu">
        <a href="javascript:;">
            <i class="fa fa-cogs"></i>
            <span>Contactos</span>
        </a>
        <ul class="sub">
            <li><a  href="grids.html">Gestionar Contactos</a></li>
        </ul>
    </li>
    <li class="sub-menu">
        <a href="javascript:;" >
            <i class="fa fa-tasks"></i>
            <span>Mensajes</span>
        </a>
        <ul class="sub">
            <li><a  href="<s:url action="outgoing-message" />">Mensajes enviados</a></li>
            <li><a  href="<s:url action="incoming-message" />" >Mensajes recibidos</a></li>
        </ul>
    </li>
    <li class="sub-menu">
        <a href="javascript:;">
            <i class="fa fa-th"></i>
            <span>Keyword</span>
        </a>
        <ul class="sub">
            <li><a  href="basic_table.html">Gestión Keywords</a></li>
        </ul>
    </li>
    <li class="sub-menu">
        <a href="javascript:;" >
            <i class=" fa fa-envelope"></i>
            <span>Reportes</span>
        </a>
        <ul class="sub">
            <li><a  href="inbox.html">Estadísticas</a></li>
        </ul>
    </li>
    <li>
        <a href="google_maps.html" >
            <i class="fa fa-map-marker"></i>
            <span>Respuestas Automáticas</span>
        </a>
    </li>
    <li class="sub-menu">
        <a href="javascript:;">
            <i class=" fa fa-bar-chart-o"></i>
            <span>Blacklist</span>
        </a>
        <ul class="sub">
            <li><a  href="morris.html">Gestionar blacklist</a></li>
            <li><a  href="chartjs.html">Reporte de blacklist</a></li>
            <li><a  href="flot_chart.html">Flot Charts</a></li>
            <li><a  href="xchart.html">xChart</a></li>
        </ul>
    </li>

</ul>
