<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>
    <t:nav/>

    <section class="content">
        <!--Manejo de Problemas-->
        <div class="wrapper">
            <h3><i class="fa fa-warning fa-2x"></i> :: :: Conocimientos a mejorar</h3>

            <table id="areasTable" class="fa-table">
                <thead>
                <th></th>
                <th>Conocimiento</th>
                <th>Problema</th>
                <th>Fuente</th>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.KNOWLEDGES_LIST}" var="knowledge">
                    <tr>
                        <td><a href="<c:url value="editknowledge?id=${knowledge.id}"/>">Mejorar</a></td>
                        <td>${knowledge.title}</td>
                        <td>${knowledge.problem.title}</td>
                        <td>${knowledge.sourceWithKnowledge.name}</td>

                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div><!--.wrapper-->
    </section><!--.content-->
</t:template>
