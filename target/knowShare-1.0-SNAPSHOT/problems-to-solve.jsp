<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>

    <jsp:attribute name="header">
        <!-- Page specific JS / CSS  -->
        <script src="<c:url value='/static/js/problems-to-solve.js'/>" type="text/javascript" ></script>
    </jsp:attribute>

    <jsp:body>
        <t:nav/>

        <section class="content">
            <!--Manejo de Problemas-->
            <div class="wrapper">
                <h3><i class="fa fa-warning fa-2x"></i> :: :: Problemas a resolver</h3>

                <table id="areasTable" class="fa-table">
                    <thead>
                        <th></th>
                        <th>Nombre</th>
                        <th>Fuentes que pueden resolver</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.UNSOLVED_PROBLEMS}" var="problem">
                        <tr>
                            <td>
                                <form action="<c:url value="newknowledge"/>" method="GET">
                                    <input type="hidden" name="problem" value="${problem.id}">
                                    <input type="hidden" name="source" value="">
                                    <input type="submit" value="Resolver"/>
                                </form>
                            </td>
                            <td>${problem.title}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty problem.area.sources}">
                                       <span>No existe fuente que pueda resolver este problema</span>
                                    </c:when>
                                   <c:otherwise>
                                       <select id="select-source">

                                           <option value="0" selected>Elegir fuente</option>
                                           <c:forEach items="${problem.area.sources}" var="source">
                                               <option value="${source.id}">${source.name}</option>
                                           </c:forEach>
                                       </select>
                                   </c:otherwise>
                                </c:choose>

                            </td>

                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

            </div><!--.wrapper-->
        </section><!--.content-->
    </jsp:body>
</t:template>
