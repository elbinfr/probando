<%@ taglib prefix="s" uri="/struts-tags" %>
<header class="header white-bg">
    <div class="sidebar-toggle-box">
        <i class="fa fa-bars"></i>
    </div>
    <!--logo start-->
    <a href="index.html" class="logo" >MOWA<span>mes</span></a>
    <!--logo end-->
    <div class="top-nav ">
        <ul class="nav pull-right top-menu">
            <!-- inbox dropdown start-->
            <li id="header_inbox_bar" class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-important">5</span>
                </a>
                <ul class="dropdown-menu extended inbox">
                    <div class="notify-arrow notify-arrow-red margin-left-nofication"></div>
                    <li>
                        <p class="red">You have 5 new messages</p>
                    </li>
                    <li>
                        <a href="#">
                            <span class="photo"><img alt="avatar" src="./img/avatar-mini.jpg"></span>
                                  <span class="subject">
                                  <span class="from">Jonathan Smith</span>
                                  <span class="time">Just now</span>
                                  </span>
                                  <span class="message">
                                      Hello, this is an example msg.
                                  </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span class="photo"><img alt="avatar" src="./img/avatar-mini2.jpg"></span>
                                  <span class="subject">
                                  <span class="from">Jhon Doe</span>
                                  <span class="time">10 mins</span>
                                  </span>
                                  <span class="message">
                                   Hi, Jhon Doe Bhai how are you ?
                                  </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span class="photo"><img alt="avatar" src="./img/avatar-mini3.jpg"></span>
                                  <span class="subject">
                                  <span class="from">Jason Stathum</span>
                                  <span class="time">3 hrs</span>
                                  </span>
                                  <span class="message">
                                      This is awesome dashboard.
                                  </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span class="photo"><img alt="avatar" src="./img/avatar-mini4.jpg"></span>
                                  <span class="subject">
                                  <span class="from">Jondi Rose</span>
                                  <span class="time">Just now</span>
                                  </span>
                                  <span class="message">
                                      Hello, this is metrolab
                                  </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">See all messages</a>
                    </li>
                </ul>
            </li>
            <!-- inbox dropdown end -->
            <!-- user login dropdown start-->
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <span class="username"><s:property value="#session.user.username" /></span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu extended logout">
                    <div class="log-arrow-up"></div>
                    <li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
                    <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                    <li><a href="#"><i class="fa fa-bell-o"></i> Notification</a></li>
                    <li><a href="<s:url action="logout" />"><i class="fa fa-key"></i> Cerrar sesión</a></li>
                </ul>
            </li>
        </ul>
    </div>
</header>