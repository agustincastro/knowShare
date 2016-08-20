<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>
    <t:nav/>

    <section class="content">
        <!--Manejo de Problemas-->
        <div class="wrapper">
            <h3><i class="fa fa-warning fa-2x"></i> :: :: Practice Community Management</h3>

            <table id="communitiesTable" class="fa-table">
                <thead>
                <th></th>
                <th>Title</th>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.COMMUNITIES_LIST}" var="community">
                    <tr>
                        <td><a href="<c:url value="editcommunity?id=${community.id}"/>">Edit</a></td>
                        <td>${community.name}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div><!--.wrapper-->
    </section><!--.content-->
</t:template>
