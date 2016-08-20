<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>
    <t:nav/>

    <section class="content">
        <!--Manejo de Problemas-->
        <div class="wrapper">
            <h3><i class="fa fa-warning fa-2x"></i> :: :: Area Management</h3>

            <table id="areasTable" class="fa-table">
                <thead>
                    <th></th>
                    <th>Name</th>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.AREAS_LIST}" var="area">
                        <tr>
                            <td><a href="<c:url value="editarea?id=${area.id}"/>">Edit</a></td>
                            <td>${area.name}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

        </div><!--.wrapper-->
    </section><!--.content-->
</t:template>
