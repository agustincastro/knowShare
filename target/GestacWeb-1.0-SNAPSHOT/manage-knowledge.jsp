<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>
    <t:nav/>

    <section class="content">
        <!--Manejo de Problemas-->
        <div class="wrapper">
            <h3><i class="fa fa-warning fa-2x"></i> :: :: Administración de Conocimientos</h3>

            <table id="knowledgesTable" class="fa-table">
                <thead>
                <th>Título</th>
                <th>Problema que resuelve</th>
                <th>Ponderación</th> 
                <c:if test="${sessionScope.LOGGED_USER_TYPE eq 'ADMIN'}">
                    <th>Acciones</th>
                </c:if>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.KNOWLEDGES_LIST}" var="knowledge">
                    <tr>                        
                        <td>${knowledge.title}</td>
                        <td>${knowledge.problem.title}</td>
                        <td>${knowledge.rating}</td>

                        <c:if test="${sessionScope.LOGGED_USER_TYPE eq 'ADMIN'}">
                            <td><a href="<c:url value="editknowledge?id=${knowledge.id}"/>">Editar</a>/<a href="<c:url value="rateknowledge?id=${knowledge.id}"/>">Ponderar</a>/<a href="<c:url value="deleteknowledge?id=${knowledge.id}"/>">Borrar</a></td>
                        </c:if>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div><!--.wrapper-->
    </section><!--.content-->
</t:template>
