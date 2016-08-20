<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>
    <t:nav/>

    <section class="content">
        <!--Manejo de Problemas-->
        <div class="wrapper">
            <h3><i class="fa fa-warning fa-2x"></i> :: :: Problem Management</h3>

            <table id="problemsTable" class="fa-table">
                <thead>
                <th></th>
                <th>Area</th>
                <th>Name</th>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.PROBLEMS_LIST}" var="problem">
                    <tr>
                        <td><a href="<c:url value="editproblem?id=${problem.id}"/>">Edit</a></td>
                        <td>${problem.area.name}</td>
                        <td>${problem.title}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div><!--.wrapper-->
    </section><!--.content-->
</t:template>
