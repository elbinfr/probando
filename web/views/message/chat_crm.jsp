<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss a");  
%>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading">
                Conversación con <s:property value="msisdn"/>
                <div class="pull-right">
                    <input type="hidden" name="id" id="id" value="<s:property value="id"/>" >
                    <input type="hidden" name="msisdn" id="msisdn" value="<s:property value="msisdn"/>" >
                    <input type="hidden" name="node" id ="node" value="<s:property value="node"/>" >
                </div>
            </header>
            <div class="panel-body">
                <div class="timeline-messages" style='min-height: 350px;max-height: 350px!important;overflow-y: scroll;'>
                    <c:forEach items="${messages}" var="msg">
                        <!-- Comment -->
                        <div class="msg-time-chat">
                            
                            <a href="#" class="message-img">
                                <c:if test="${msg.type == 1}">
                                    <img class="avatar" src="http://www.mowa.com.pe/img/logos/user.png" alt=""></a>
                                    <div class="message-body msg-out">
                                 </c:if>
                                <c:if test="${msg.type == 2}">
                                    <img class="avatar" src='http://www.mowa.com.pe/img/logos/<s:property value="#session.user.getLogo()" />' alt=""></a>
                                    <div class="message-body msg-in">
                                </c:if>
                                
                                <span class="arrow"></span>
                                <div class="text">
                                    <p class="attribution"><a href="#">
                                    <c:if test="${msg.type == 1}">Cliente</c:if>
                                    <c:if test="${msg.type == 2}"><c:out value="${msg.username}"/></c:if> 
                                    </a> enviado el <c:out value="${msg.date}"/></p>
                                    <p><c:out value="${msg.text}"/></p>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                </div>
                <div class="chat-form">
                    <div class="input-cont ">
                        <input type="text" id="mensaje" class="form-control col-lg-12" placeholder="Escribe tu mensaje aquí...">
                    </div>
                    <div class="form-group">
                        <div class="pull-right chat-features">
                            <a href="javascript:;">
                                <i class="fa fa-camera"></i>
                            </a>
                            <a href="javascript:;">
                                <i class="fa fa-link"></i>
                            </a>
                            <button id='btn-chat' class='btn btn-danger' onclick="replyChat()">Enviar</button>
                        </div>
                    </div>

                </div>
            </div>
        </section>
    </div>
        <!-- /.panel -->
    </div>

<script type="text/javascript">
    $(".timeline-messages").animate({ scrollTop: $('.timeline-messages')[0].scrollHeight}, 10);
    
    function replyChat(){
        msisdn = $("#msisdn").val();
        node = $("#node").val();
        mensaje = $("#mensaje").val();
        logo = '<s:property value="#session.user.logo" />';
        client = '<s:property value="#session.user.username" />';
        $("#btn-chat").prop('disabled',true);
        date = '<%=sdf.format(new Date())%>';
        html = '<div class="msg-time-chat"><a href="#" class="message-img"><img class="avatar" src="http://www.mowa.com.pe/img/logos/'+logo+'" alt=""></a>';
        html += '<div class="message-body msg-in"><span class="arrow"></span><div class="text"><p class="attribution"><a href="#">'+client+'</a>';
        html += 'enviado el '+date+'</p><p>'+mensaje+'</p></div></div></div>';       
        $( ".timeline-messages" ).append(html);
        $(".timeline-messages").animate({ scrollTop: $('.timeline-messages')[0].scrollHeight}, 10);
        $("#mensaje").val("");
        setTimeout(function(){ registerMessage(msisdn,node,mensaje); }, 3000);
    }

    function registerMessage(msisdn,node,mensaje){
        id = $("#id").val();
        $.ajax({async: false,
            global: false,
            url: "replyConversation",
            method:'post',
            data: {msisdn: msisdn ,node : node, text : mensaje, id : id},
             success: function (data) {
                  $("#btn-chat").prop('disabled',false);  
            },
            error: function (data) {
                $("#btn-chat").prop('disabled',false);  
            }
        });
    }
    
</script>