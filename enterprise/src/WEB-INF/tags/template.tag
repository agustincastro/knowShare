<%@tag description="Main Wrapper Tag" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="nav" fragment="true" %>
<%@attribute name="header" fragment="true" %>

<c:set var="loggedUser" value="${sessionScope.LOGGED_USER_OBJ}"/>

<html class="no-js">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width">
        <title>Acceso - Plataforma GESTAC</title>
        <link rel="stylesheet" href="<c:url value='/static/css/normalize.css'/>">
        <link rel="stylesheet" href="<c:url value='/static/css/font-awesome.css'/>">
        <link rel="stylesheet" href="<c:url value='/static/css/jquery.remodal.css'/>">
        <link rel="stylesheet" href="<c:url value='/static/css/output.css'/>">
        <link rel="stylesheet" href="<c:url value='/static/css/output2.css'/>">
        <link rel="stylesheet" href="<c:url value='/static/css/knowshare.css'/>">
        <script src="<c:url value='/static/js/modernizr.js'/>"></script>

        <script src="<c:url value='/static/js/jquery.js'/>"></script>
        <script src="<c:url value='/static/js/main.js'/>"></script>

        <!-- this is to let specific pages include JS and CSS in the header -->
        <jsp:invoke fragment="header"/>

    </head>

    <body>

        <header class="clearfix">
            <h1 class="site-logo">GESTAC</h1>

            <c:if test="${sessionScope.LOGGED_USER != null}">
                <!-- Avatar de persona que se logueo al sistema-->
                <ul class="cpanel">
                    <li class="avatar">
                        <a href="<c:url value='view-user'/>"></a>
                    </li>
                    <li>
                        <a href="<c:url value='view-user'/>" id="userName">${sessionScope.LOGGED_USER}</a>
                    </li>
                    <li class="ptrigger">
                        <a class="user-cpanel-trigger" href="#"><i class="fa fa-cogs"></i></a>
                    </li>
                </ul>
                <!-- FIN Avatar de persona que se logueo al sistema-->
                <!-- Opciones para persona que se loguea al sistema-->
                <div class="user-cpanel">
                    <ul>
                        <li><a href="<c:url value='view-user'/>">Editar perfil</a></li>
                        <li><a class="exit" href="<c:url value='logout'/>">Salir</a></li>
                    </ul>
                </div>
                <!--.user-cpanel-->
            </c:if>
        </header>
        <section class="main">
            <jsp:doBody/>
        </section>
    </body>

    <footer class="footer">
        <p>Gestion de Conocimientos Tacitos</p>
        <div class="footer__logotypes"></div>
        <p><a href="<c:url value='legal'/>">Política de uso y privacidad</a></p>
    </footer>
</html>
