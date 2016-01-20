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
                <c:if test="${not sessionScope.LOGGED_USER_TYPE eq 'USER'}">
                <th></th>
                </c:if>
                <th></th>
                <th>Título</th>
                <th>Problema que resuelve</th>
                <th>Ponderación</th>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.KNOWLEDGES_LIST}" var="knowledge">
                    <tr>
                        <c:if test="${not sessionScope.LOGGED_USER_TYPE eq 'USER'}">
                        <td><a href="<c:url value="editknowledge?id=${knowledge.id}"/>">Editar</a></td>
                        </c:if>
                        <td><a href="<c:url value="rateknowledge?id=${knowledge.id}"/>">Ponderar</a></td>
                        <td>${knowledge.title}</td>
                        <td>${knowledge.problem.title}</td>
                        <td>${knowledge.rating}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div><!--.wrapper-->
    </section><!--.content-->
</t:template>
