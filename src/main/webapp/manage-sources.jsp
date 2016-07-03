<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>
    <t:nav/>

    <section class="content">
        <!--Manejo de Problemas-->
        <div class="wrapper">
            <h3><i class="fa fa-warning fa-2x"></i> :: :: Administración de Fuentes</h3>

            <table id="problemsTable" class="fa-table">
                <thead>
                <th>Email</th>
                <th>Área</th>
                <th>Ponderación</th>
                <th>Acciones</th>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.SOURCES_LIST}" var="source">
                    <tr>
                        <td>${source.email}</td>
                        <td>${source.area.name}</td>
                        <td>${source.expertiseLevel}</td>
                        <td><a href="<c:url value="editsource?id=${source.id}"/>">Editar</a> | <a href="<c:url value="deletesource?id=${source.id}"/>">Borrar</a>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div><!--.wrapper-->
    </section><!--.content-->
</t:template>
