<%@tag description="Nav Tag" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--.Banner izquierdo: funcionalidades -->
<nav>
    <ul class="site-nav">
        <li><a href="<c:url value='index'/>">
            <i class="fa fa-home"></i>Home</a>
        </li>
        <li><a href="<c:url value='search'/>">
            <i class="fa fa-search"></i>Search</a>
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
        </i>Knowledge</a>
            <ul class="sub">
                <li><a href="<c:url value='/manageknowledge'/>">Manage Knowledge</a></li>
                <c:if test="${sessionScope.LOGGED_USER_TYPE eq 'SOURCE'}">
                    <li><a href="<c:url value='/newknowledge'/>">New Knowledge</a></li>
                </c:if>
            </ul>
        </li>

        <c:if test="${sessionScope.LOGGED_USER_TYPE eq 'SOURCE' && not sessionScope.SOURCE_RATED}">
            <li><a href="#"><i class="fa fa-user">
            </i>Sources</a>
                <ul class="sub">
                    <li><a href="<c:url value='ratesource'/>">Source Profile</a></li>
                </ul>
            </li>
        </c:if>

        <c:if test="${sessionScope.LOGGED_USER_TYPE eq 'ADMIN'}">
            <li><a href="#"><i class="fa fa-user">
            </i>Sources</a>
                <ul class="sub">
                    <li><a href="<c:url value='managesources'/>">Manage Sources</a></li>
                    <li><a href="<c:url value='newsource'/>">New Source</a></li>
                </ul>
            </li>
        </c:if>

        <c:if test="${sessionScope.LOGGED_USER_TYPE eq 'ADMIN'}">
            <li><a href="#"><i class="fa fa-users">
            </i>Practice Community</a>
                <ul class="sub">
                    <li><a href="<c:url value='managecommunities'/>">Manage Practice Communities</a></li>
                    <li><a href="<c:url value='newcommunity'/>">New Practice Community</a></li>

                </ul>
            </li>
            <li><a href="#"><i class="fa fa-codepen">
            </i>Area</a>
                <ul class="sub">
                    <li><a href="<c:url value='manageareas'/>">Manage Areas</a></li>
                    <li><a href="<c:url value='newarea'/>">New Area</a></li>
                </ul>
            </li>
        </c:if>
        <li><a href="#"><i class="fa fa-warning">
        </i>Problems</a>
            <ul class="sub">
                <c:if test="${sessionScope.LOGGED_USER_TYPE eq 'ADMIN'}">
                    <li><a href="<c:url value='manageproblems'/>">Manage Problemas</a></li>
                </c:if>
                <li><a href="<c:url value='newproblem'/>">New Problem</a></li>
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
