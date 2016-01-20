<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="area" value="${requestScope.AREA}"/>

<t:template>
    <t:nav/>

    <section class="content">
        <div class="wrapper">
            <h3><i class="fa fa-user fa-2x"></i> :: :: Nueva Área</h3>

            <form class="forms" method="post" action="
                <c:choose>
                    <c:when test="${area != null}">
                       <c:url value='editarea?id=${area.id}'/>
                    </c:when>
                    <c:otherwise>
                        <c:url value='newarea'/>
                    </c:otherwise>
                </c:choose>
                ">
                <ul>
                    <li>
                        <label class="mid" for="name">Nombre<span class="reference--required" title="Requerido">*</span>
                            <input type="text" name="name" id="name" value="${area.name}" required />
                        </label>
                    </li>
                    <li>
                        <label class="mid" for="description">Descripción<span class="reference--required" title="Requerido">*</span>
                            <textarea name="description" id="description" maxlength="1000">${area.description}</textarea>
                        </label>
                    </li>
                    <li class="clearfix">
                        <button type="submit">Guardar</button>
                    </li>
                </ul>
            </form>
        </div><!--.wrapper-->
    </section><!--.content-->

</t:template>



