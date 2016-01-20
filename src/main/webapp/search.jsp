<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>

    <t:nav/>

    <section class="content">
        <t:search/>

        <div class="wrapper">

            <c:if test="${param.queryType eq 'ALL' or param.queryType eq 'PROBLEM'}">
                <!-- Problems table -->
                <h3>Problemas</h3>
                <table id="problemsTable" class="fa-table">
                    <thead>
                        <th>Título</th>
                        <th>Descripción</th>
                        <th>Área</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.PROBLEMS_LIST}" var="problem">
                            <tr>
                                <td>${problem.title}</td>
                                <td>${problem.description}</td>
                                <td>${problem.area.name}</td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </c:if>

            <c:if test="${param.queryType eq 'ALL' or param.queryType eq 'SOURCE'}">
                <!-- Sources table -->
                <h3>Fuentes</h3>
                <table id="problemsTable" class="fa-table">
                    <thead>
                    <th>Título</th>
                    <th>Descripción</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.SOURCES_LIST}" var="source">
                        <tr>
                            <td>${source.name}</td>
                            <td>${source.description}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </c:if>

            <c:if test="${param.queryType eq 'ALL' or param.queryType eq 'KNOWLEDGE'}">
                <!-- Knowledges table -->
                <h3>Conocimientos</h3>
                <table id="knowledgesTable" class="fa-table">
                    <thead>
                    <th>Título</th>
                    <th>Descripción</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.KNOWLEDGES_LIST}" var="knowledge">
                        <tr>
                            <td>${knowledge.title}</td>
                            <td>${knowledge.description}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </c:if>

        </div>
    </section>
</t:template>

