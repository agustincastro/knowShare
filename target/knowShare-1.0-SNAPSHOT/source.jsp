<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="source" value="${requestScope.SOURCE}"/>

<t:template>
    <t:nav/>

    <section class="content">

        <!--Carga de datos para nuevo Usuario Fuente-->
        <div class="wrapper">
            <c:choose>
                <c:when test="${!(source == null)}">
                    <h3><i class="fa fa-user fa-2x"></i> :: :: Editar Fuente</h3>
                </c:when>
                <c:otherwise>
                    <h3><i class="fa fa-user fa-2x"></i> :: :: Nueva Fuente</h3>
                </c:otherwise>
            </c:choose>

            <form class="forms" method="post" action="
                <c:choose>
                    <c:when test="${!(source == null)}">
                        <c:url value='editsource?id=${source.id}'/>
                    </c:when>
                    <c:otherwise>
                        <c:url value='newsource'/>
                    </c:otherwise>
                </c:choose>
                ">
                <ul>
                    <li>
                        <label class="mid" for="name">Nombre<span class="reference--required" title="Requerido">*</span>
                            <input type="text" name="name" id="name" value="${source.name}" required />
                        </label>
                        <label class="mid" for="last-name">Apellido<span class="reference--required" title="Requerido">*</span>
                            <input type="text" name="last-name" id="last-name" value="${source.lastName}" required />
                        </label>

                    </li>
                    <li>
                        <label class="mid" for="email">Email<span class="reference--required" title="Requerido">*</span>
                            <input type="text" name="email" id="email" value="${source.email}" title="Este campo es requerido." required />
                        </label>
                        <label class="mid" for="password">Contraseña<span class="reference--required" title="Requerido">*</span>
                            <input type="password" name="password" id="password" value="" title="Este campo es requerido."
                                    <c:choose>
                                        <c:when test="${!(source == null)}">
                                            disabled
                                        </c:when>
                                        <c:otherwise>
                                            required
                                        </c:otherwise>
                                    </c:choose>

                            />
                        </label>
                    </li>
                    <li>
                        <label class="mid" for="area">Área<span class="reference--required" title="Requerido">*</span>
                            <select name="area" id="area" title="Este campo es requerido." required>
                                <option value="0">Elegir área</option>
                                <c:forEach items="${requestScope.AREAS_LIST}" var="area">
                                    <option value="${area.id}" <c:if test="${area.id eq source.area.id}"> selected </c:if>>${area.name}</option>
                                </c:forEach>
                            </select>
                        </label>
                        <label class="mid" for="source_type">Tipo<span class="reference--required" title="Requerido">*</span>
                            <select name="source_type" id="source_type" value="" title="Este campo es requerido." required >
                                <option value="0">Elegir tipo</option>
                                <option value="INTERNAL" <c:if test="${source.sourceType eq 'INTERNAL'}"> selected </c:if>>Interna</option>
                                <option value="EXTERNAL" <c:if test="${source.sourceType eq 'EXTERNAL'}"> selected </c:if>>Externa</option>
                            </select>
                        </label>
                    </li>
                    <li>
                        <label class="mid" for="community">Comunidad de práctica
                            <select name="community" id="community">
                                <option value="0">Elegir comunidad</option>
                                <c:forEach items="${requestScope.COMMUNITIES_LIST}" var="community">
                                    <option value="${community.id}" <c:if test="${community.id eq source.community.id}"> selected </c:if>>${community.name}</option>
                                </c:forEach>
                            </select>
                        </label>
                    </li>
                    <li>
                        <label class="mid" for="description">Descripción<span class="reference--required" title="Requerido">*</span>
                            <textarea name="description" id="description" maxlength="1000">${source.description}</textarea>
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



