<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="problem" value="${requestScope.PROBLEM}"/>

<t:template>
    <t:nav/>

    <section class="content">
        <div class="wrapper">
            <c:choose>
                <c:when test="${!(problem == null)}">
                    <h3><i class="fa fa-user fa-2x"></i> :: :: Edit Problem</h3>
                </c:when>
                <c:otherwise>
                    <h3><i class="fa fa-user fa-2x"></i> :: :: New Problem</h3>
                </c:otherwise>
            </c:choose>
            <form class="forms" method="post" action="
                <c:choose>
                    <c:when test="${!(problem == null)}">
                        <c:url value='editproblem?id=${problem.id}'/>
                    </c:when>
                    <c:otherwise>
                        <c:url value='newproblem'/>
                    </c:otherwise>
                </c:choose>
                ">
                <ul>
                    <li>
                        <label class="mid" for="title">Name<span class="reference--required" title="Required">*</span>
                            <input type="text" name="title" id="title" value="${problem.title}" required />
                        </label>
                        <label class="mid" for="area">Area<span class="reference--required" title="Required">*</span>
                            <select name="area" id="area" required >
                                <c:forEach items="${requestScope.AREAS_LIST}" var="area">
                                    <option value="${area.id}" <c:if test="${area.id eq problem.area.id}"> selected </c:if>>${area.name}</option>
                                </c:forEach>
                            </select>
                        </label>
                    </li>
                    <li>
                        <label class="mid" for="description">Description<span class="reference--required" title="Required">*</span>
                            <textarea name="description" id="description" maxlength="1000">${problem.description}</textarea>
                        </label>
                    </li>
                    <li class="clearfix">
                        <button type="submit">Save</button>
                    </li>
                </ul>
            </form>
        </div><!--.wrapper-->
    </section><!--.content-->

</t:template>
