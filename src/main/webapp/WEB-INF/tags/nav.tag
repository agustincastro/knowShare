<%@tag description="Nav Tag" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--.Banner izquierdo: funcionalidades -->
<nav>
    <ul class="site-nav">
        <li><a href="<c:url value='index'/>">
            <i class="fa fa-home"></i>Inicio</a>
        </li>
        <li><a href="<c:url value='search'/>">
            <i class="fa fa-search"></i>Buscar</a>
        </li>
        <!--
        <li><a href="#"><i class="fa fa-list-alt">
        </i>Directorio &raquo;</a>
            <ul class="sub">
                <li><a href="directory-community.html">Comunidades de Practica</a></li>
                <li><a href="directory-fonts">Fuentes</a></li>
                <li><a href="directory-knowledge">Conocimientos</a></li>
            </ul>
        </li> -->
        <li><a href="#"><i class="fa fa-suitcase">
        </i>Conocimientos &raquo;</a>
            <ul class="sub">
                <li><a href="<c:url value='/manageknowledges'/>">Administrar Conocimientos</a></li>
                <c:if test="${sessionScope.LOGGED_USER_TYPE eq 'SOURCE'}">
                    <li><a href="<c:url value='/newknowledge'/>">Nuevo Conocimiento</a></li>
                </c:if>
            </ul>
        </li>

        <c:if test="${sessionScope.LOGGED_USER_TYPE eq 'SOURCE' && not sessionScope.SOURCE_RATED}">
            <li><a href="#"><i class="fa fa-user">
            </i>Fuentes &raquo;</a>
                <ul class="sub">
                    <li><a href="<c:url value='ratesource'/>">Perfil Fuente</a></li>
                </ul>
            </li>
        </c:if>

        <c:if test="${sessionScope.LOGGED_USER_TYPE eq 'ADMIN'}">
            <li><a href="#"><i class="fa fa-user">
            </i>Fuentes &raquo;</a>
                <ul class="sub">
                    <li><a href="<c:url value='managesources'/>">Administrar Fuentes</a></li>
                    <li><a href="<c:url value='newsource'/>">Nueva Fuente</a></li>
                </ul>
            </li>
        </c:if>

        <c:if test="${sessionScope.LOGGED_USER_TYPE eq 'ADMIN'}">
            <li><a href="#"><i class="fa fa-users">
            </i>Comunidad de Practica &raquo;</a>
                <ul class="sub">
                    <li><a href="<c:url value='managecommunities'/>">Administrar Comunidades</a></li>
                    <li><a href="<c:url value='newcommunity'/>">Nueva Comunidad</a></li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-codepen">
            </i>Area &raquo;</a>
                <ul class="sub">
                    <li><a href="<c:url value='manageareas'/>">Administrar Areas</a></li>
                    <li><a href="<c:url value='newarea'/>">Nueva Area</a></li>
                </ul>
            </li>
        </c:if>
        <li><a href="#"><i class="fa fa-warning">
        </i>Problema &raquo;</a>
            <ul class="sub">
                <c:if test="${sessionScope.LOGGED_USER_TYPE eq 'ADMIN'}">
                    <li><a href="<c:url value='manageproblems'/>">Administrar Problemas</a></li>
                </c:if>
                <li><a href="<c:url value='newproblem'/>">Nuevo Problema</a></li>
            </ul>
        </li>

        <!--
        <li><a href="reports.html"><i class="fa fa-bar-chart-o">
        </i>Reportes</a>
        </li>
        -->
    </ul>
</nav>
<!--.FIN Banner izquierdo: funcionalidades -->