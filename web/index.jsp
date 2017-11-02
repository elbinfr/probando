<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html class="no-js"> 
    <head>
        <meta charset="utf-8">
        <title>Mowa MES</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--ARCHIVOS CSS-->
        <link rel="stylesheet" href="login/normalize.min.css">
        <link rel="stylesheet" href="login/main.css">
        <link rel="stylesheet" href="login/bootstrap.css">
        <link rel="stylesheet" href="login/style.css">
        <link rel="shortcut icon" href="icono.ico">
        <script src="login/modernizr-2.6.2.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,300" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" type="text/css">
    </head>
    <body>
            
        <header>
            <div id="logo"><h1><img src="img/logo_mowa.png" alt='Mowa Consultora & Soluciones Móviles'></h1></div>
            <div id="navegacion">
                <nav id="nav" class="nombre_fuente">
                    <a href=""></a>
                    <ul id='navegacionPrincipal'>
                        <li><a href='#index'>INICIO</a></li>
                        <li><a href='#solucion'>SOLUCIÓN</a></li>
                        <li><a href='#portafolio'>CLIENTES</a></li>
                        <li><a href='#planes'>PLANES</a></li>
                        <li><a href='#contacto'>CONTACTO</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <!--SECCION INDEX-->          
        <section class="fullScreen header-11-sub" id='index'>
            <div class="background">
                <img src="img/3016.png" alt="" width="100%"/>
            </div>
            
            <div class="container">
                <div class="row">                   
                    <div class="col-sm-7">
                        <br />
                        <br />                       
                        <h2>Comienza tu campaña de Marketing SMS</h2>
                        <h4 style="font-family: Roboto; font-size: 18px; color: #000000">
                            Ayudamos a captar y fidelizar clientes a través del marketing móvil, gracias a MES ,Messaging Enterprise Service, nuestra moderna plataforma bidireccional y autodidáctica.
                        </h4>
                        <br />
                        <button class='myButton' onclick='mostrar()'>Log-In</button>
                    </div>
                    <div class="col-sm-4 col-sm-offset-1 player-wrapper">
                       
                    </div>
                </div>
            </div>
        </section>
        <!--SECCION SOLUCION-->           
        <section class="fullScreen header-11-sub" id="solucion" >
            <br />
            <br />
            <br />
            <div class="container"> 
                <h3 style="color:#1f65ab !important">El Software de Mensajería más Novedoso del Mundo</h3>
             
                <p style="color:#727272; font-family: Open Sans !important">El Software de Mensajería MOWA  te Permite Crear y Personalizar Campañas de Marketing SMS via On-line Fácilmente.</p>
                <div class="col-md-4">
                    <div class='caracteristica'>
                        <span class='lupa' onclick='abrir01()'></span>
                        <div class='img c7' ></div>
                        <h4>Usa nuestra API</h4>
                        <ul>
                            <li>Envía SMS desde tu sitio Web o App</li>
                            <li>Integra tus sistemas fácilmente</li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class='caracteristica'>
                        <span class='lupa' onclick='abrir02()'></span>
                        <div class='img c10'></div>
                        <h4>Campañas SMS</h4>
                        <ul>
                            <li>Envía mensajes personalizados</li>
                            <li>Obten informes de entrega detallada</li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class='caracteristica'>
                        <span class='lupa' onclick='abrir03()'></span>
                        <div class='img c12'></div>
                        <h4>Construye tu CRM Móvil</h4>
                        <ul>
                            <li>Fortalece y mejora la relación con tus clientes</li>
                        </ul>
                        <p></p>
                    </div>
                </div>
                </div>
        </section>
        
        <!--SECCION PORTAFOLIO-->           
        <section class='fullScreen header-11-sub' id="portafolio">
            <div class="container">
                <h3 style="color: #1f65ab !important">Nuestros clientes</h3>
                <br />
                <div class="col-sm-4">
                    <h4>Casos de Éxito</h4>
                    <ul class="e2">
                        <li>Aplicaciones moviles (Android)</li>
                        <li>Sistema de Marketing SMS</li>
                        <li>Responsive Design</li>
                    </ul>
                    <ul class="e3">
                        <li>10 mil alumnos recibieron mensajes de confirmación al momento de matricularse</li>
                        <li>20 mil mensajes enviando resultados a alumnos</li>
                    </ul>
                </div>
                <div class="col-sm-2"><img style="width: 150px;" class='p2' src="img/logo_mowa.png" alt="Mowa"></div>
                <div class="col-sm-2"><img style="height: 100px;" class='p3' src="img/logo_uni.png" alt="Universidad Nacional de Ingeniería"></div>
                <div class="col-sm-2"><img style="height: 100px;" class='p3' src="img/caja-trujillo.png" alt="Caja Trujillo"></div>
                <br />
                <div class="col-sm-2"><img style="height: 100px; position: relative; top: 70px; right: 600px; " class='p3' src="img/geincos.png" alt="Geincos"></div>
                
                <br/><br/>
            </div>
        </section>
        <!--SECCION PLANES-->          
        <script type="text/x-jquery-tmpl" id='precioTemplate'>
            <div>
            <div class="ribbon"></div>
            <h3></h3>
            <p><strong>Contenido del paquete</strong></p>
            <ol>
            <li></li>
            </ol>
            <p class="costo"></p>
            <a id="regresar-ventana">Regresar</a>
            </div>
        </script>
        <section id="planes" class='fullScreen callig'>
            <div class="marginTop">
                <h3>Conozca Nuestros Planes</h3>
                <div class="precio" >
                    <div class="ribbon"></div>
                    <h3>Professional</h3>
                    <ul>
                        <li>10,000 mensajes</li>
                        <li>data <strong>Ilimitada </strong></li>
                    </ul>
                    <p class="costo">S/.</p>
                    <a class="ver-mas" data-number='0'>Conoce más del paquete</a>
                </div>
                <div class="precio" >
                    <div class="ribbon"></div>
                    <h3>Business</h3>
                    <ul>
                        <li>20,000 mensajes</li>
                        <li>data <strong>Ilimitada </strong></li>
                    </ul>
                    <p class="costo">S/.</p>
                    <a class="ver-mas" data-number='1'>Conoce más del paquete</a>
                </div>
                <div class="precio" >
                    <div class="ribbon"></div>
                    <h3>Gold</h3>
                    <ul>
                        <li>50,000 mensajes</li>
                        <li>data <strong>Ilimitada </strong></li>
                    </ul>
                    <p class="costo">S/.</p>
                    <a class="ver-mas" data-number='2'>Conoce más del paquete</a>
                </div>
            </div>
        </section>
        <!--SECCION CONTACTO-->           
        <section class='fullScreen header-11-sub' id="contacto">
            <div class="container" style="width: 1170px; height: 400px;">
                <h3>Contáctanos</h3>
                <br /> 
                <div class="col-sm-2"></div>
                <div class="col-sm-3">
                    <p><b>Dirección</b><br />
                        Jr. Pablo Bermúdez 286<br />
                        Oficina 503<br/>
                        Jesus María, Lima<br/><br />
                        <b>Teléfono</b><br/>
                        994 612 885
                    </p>
                </div>
                <div class="col-sm-5">
                    <p>Te contactaremos inmediatamente</p>
                    <form action="mail" method='post' onsubmit="return validacion03();">
                        <div class="form-group"><input type="text" class="form-control" placeholder="Nombre" name="name" ></div>
                        <div class="form-group"><input type="text" class="form-control" placeholder="Email" name="mail"></div>
                        <div class="form-group"><input type="text" class="form-control" placeholder="Asunto" name="asun"></div>
                        <div class="form-group"><textarea rows="2" class="form-control" placeholder="Message" name="cont"></textarea></div>
                        <div class='col-md-6'><input type="reset" style="position: relative; left: 20px; bottom: 5px" value="Limpiar" class='btn-style-1 btn-lg'></div>
                        <div class='col-md-6'><input  type='submit' style="position: relative; right: 20px; bottom: 5px" value="Enviar" class='btn-style-1 btn-lg'></div>
                    </form>
                </div>
            </div>
        </section>
        <!--DIV  LOGUEO-->
        <div id='logueo' class='fondonegro'>
            <div class="loginbox radius" style="background: #FAFAFA !important">
                <h4 style="color:#000; text-align:center; font-size: 19px; font-family: Futura LT Light, Helvetica, sans-serif;">Servicio de Mensajería Empresarial</h4>
                <a href="#" class="close-btn" onclick='ocultar()'>×</a>
                <div class="loginboxinner radius">
                    <div class="loginheader">
                       
                        <div class="logo" ><img src="img/logo3.png" alt="Mowa"/></div>
                    </div><!--loginheader-->

                    <div class="loginform">

                        <form id="login" action="<s:url action="login" />" method="post">
                            <p>
                                <label for="username" class="bebas">Usuario:</label>
                                <input type="text" id="username" name="username" class="radius2" style="background: #e6e6e6; color:#000 !important">
                            </p>
                            <p>
                                <label for="password" class="bebas">Contraseña:</label>
                                <input type="password" id="password" name="password"  class="radius2" style="background: #e6e6e6; color:#000 !important" >
                            </p>
                            <p>
                                <input type="submit" name="client_login" value="Ingresar" style="background:#1f65ab ; color:#fff; font-size: 16px  !important">
                            </p>
                        </form>
                    </div><!--loginform-->
                </div><!--loginboxinner-->
            </div><!--loginbox-->
        </div>
        <!--DIV FEATURE 01-->
        <div id='feature01' class='fondonegro'>
            <div class='feature_box'>
                <a href="#" class="close-btn" onclick='ocultar01()'>×</a>
                <div class='img_2 f2' ></div>
               <h4 style="color:#1f65ab; font-family: Open Sans; font-weight: bold">Usa nuestra API</h4>
                    
               <p style="font-size: 15px">Con nuestra tecnología API construye aplicaciones que envíen SMS para:</p>
               <ul>
                                <li style="font-size: 15px; font-family: Open Sans">Alertas</li> 
                                <li style="font-size: 15px; font-family: Open Sans">Notificaciones</li> 
                                <li style="font-size: 15px; font-family: Open Sans">Validaciones</li> 
                            </ul>    
                        
                     
            </div>
        </div>
                <!--DIV FEATURE 02-->
        <div id='feature02' class='fondonegro'>
            <div class='feature_box'>
                <a href="#" class="close-btn" onclick='ocultar02()'>×</a>
                <div class='img_2 f1' ></div>
               <h4 style="color:#1f65ab; font-family: Open Sans; font-weight: bold">Campañas SMS</h4>
                    <ul>
                        <li>Envía campañas o programa su envío</li>
                        <li>Personaliza el mensaje de tus campañas por cliente</li>
                        <li>Obtén reportes detallados sobre tus campañas</li>
                        <li>Monitorea el progreso del envío de tus campañas</li>
                        <li>Genera plantillas de mensajes para tus campañas</li>
                    </ul> 
            </div>
        </div>
                        <!--DIV FEATURE 03-->
        <div id='feature03' class='fondonegro'>
            <div class='feature_box'>
                <a href="#" class="close-btn" onclick='ocultar03()'>×</a>
                <div class='img_2 f3' ></div>
                <h4  style="color:#1f65ab; font-family: Open Sans; font-weight: bold">Construye CRM Móvil</h4>
                    <ul>
                        <li>Interactua con tus clientes mediante comunicación bidireccional en tiempo real</li>
                        <li>Gestiona tus segmentos de clientes para una comunicación más efectiva</li>
                        <li>Adapta tu estrategia de marketing móvil para enriquecer tus segmentos de clientes</li>
                    </ul> 
            </div>
        </div>
        <!--DIV ERROR 1-->
        <div id='error01' class='fondonegro'>
            <div class='feature_box2'>
                <a href="#" class="close-btn" onclick='ocultar04()'>×</a>
                <h4 style="color: #1f65ab; font-weight: bold; font-size: 18px; font-family: Open Sans">Error:</h4>
                <p style="font-size: 15px" id="messageError"></p>
            </div>
        </div>
        
        <!--ARCHIVOS JAVA SCRIPT-->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="login/js/vendor/jquery-1.10.2.min.js"><\/script>');</script>
        <script src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script>
        <script src="login/js/plugins.js"></script>   
        <script src="login/js/jquery.ui.core.min.js"></script>
        <script src="login/js/jquery.ui.effect.min.js"></script>
        <script src="login/js/jquery.flip.min.js"></script>
        <script src="login/js/scrollto.min.js"></script>
        <script src="login/js/localscroll.min.js"></script>
        <script src="login/js/localscroll.min.js"></script>
        <script src="login/js/stellar.min.js"></script> 
        <script src="login/js/jquery.scrollorama.js"></script>
        <script src="login/js/main.js"></script>  

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            
            $(document).on('ready',function(){
                var message='<s:property value="errorMessage"/>';
            if(message!=""){
                $("#messageError").html(message);
                $("#error01").fadeIn(500);
            }
            
            var sesion='<%String param=request.getParameter("message"); out.print(param); %>';
            if(sesion=="caduco"){
                $("#error04").fadeIn(500);
            }
            
            });
        </script>
    </body>
</html>

