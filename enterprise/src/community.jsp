<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="community" value="${requestScope.COMMUNITY}"/>

<t:template>
    <t:nav/>

    <section class="content">
        <div class="wrapper">
            <c:choose>
                <c:when test="${!(community == null)}">
                    <h3><i class="fa fa-user fa-2x"></i> :: :: Editar Comunidad de Práctica</h3>
                </c:when>
                <c:otherwise>
                    <h3><i class="fa fa-user fa-2x"></i> :: :: Nueva Comunidad de Práctica</h3>
                </c:otherwise>
            </c:choose>

            <form class="forms" method="post" action="
                <c:choose>
                    <c:when test="${!(community == null)}">
                        <c:url value='editcommunity?id=${community.id}'/>
                    </c:when>
                    <c:otherwise>
                        <c:url value='newcommunity'/>
                    </c:otherwise>
                </c:choose>
                ">
                <ul>
                    <li>
                        <label class="mid" for="name">Name<span class="reference--required" title="Required">*</span>
                            <input type="text" name="name" id="name" value="${community.name}" required />
                        </label>
                    </li>
                    <li>
                        <label class="mid" for="description">Description<span class="reference--required" title="Required">*</span>
                            <textarea name="description" id="description" maxlength="1000">${community.description}</textarea>
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
