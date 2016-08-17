<%@ page import="com.knowshare.models.knowledge.Knowledge" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="knowledge" value="${requestScope.KNOWLEDGE}"/>

<t:template>
    <t:nav/>

    <section class="content">
        <div class="wrapper">
            <c:choose>
                <c:when test="${!(knowledge == null)}">
                    <h3><i class="fa fa-user fa-2x"></i> :: :: Editar Conocimiento</h3>
                </c:when>
                <c:otherwise>
                    <h3><i class="fa fa-user fa-2x"></i> :: :: Nuevo Conocimiento</h3>
                </c:otherwise>
            </c:choose>
            <form class="forms" method="post" action="
                <c:choose>
                    <c:when test="${!(knowledge == null)}">
                        <c:url value='editknowledge?id=${knowledge.id}'/>
                    </c:when>
                    <c:otherwise>
                        <c:url value='newknowledge'/>
                    </c:otherwise>
                </c:choose>
                    ">
                <ul>
                    <li>
                        <label class="mid" for="title">Título<span class="reference--required" title="Requerido">*</span>
                            <input type="text" name="title" id="title" value="${knowledge.title}" required />
                        </label>
                        <label class="mid" for="problem">Problema que resuelve<span class="reference--required" title="Requerido">*</span>
                            <c:choose>
                                <c:when test="${!(knowledge == null)}">
                                    <input type="hidden" name="problem" value="${knowledge.problem.id}">
                                    <select name="problem_id" id="problem" disabled >
                                </c:when>
                                <c:otherwise>
                                    <select name="problem" id="problem" required >
                                </c:otherwise>
                            </c:choose>

                                <c:forEach items="${requestScope.PROBLEMS_LIST}" var="problem">
                                    <option value="${problem.id}" <c:if test="${problem.id eq knowledge.problem.id or problem.id eq param.problem}"> selected </c:if>>${problem.title}</option>
                                </c:forEach>
                            </select>
                        </label>
                    </li>
                    <li>
                        <label class="mid" for="source_who_wrote">Fuente que escribe<span class="reference--required" title="Requerido">*</span>
                            <c:choose>
                                <c:when test="${!(knowledge == null)}">
                                    <select name="source_who_wrote" id="source_who_wrote">
                                        <c:forEach items="${requestScope.SOURCES_LIST}" var="source">
                                            <option value="${source.id}" <c:if test="${source.email eq sessionScope.LOGGED_USER}"> selected </c:if>>${source.name}</option>
                                        </c:forEach>
                                    </select>
                                </c:when>
                                <c:otherwise>
                                    <select name="source_who_wrote" id="source_who_wrote" readonly>
                                        <c:forEach items="${requestScope.SOURCES_LIST}" var="source">
                                            <c:if test="${source.email eq sessionScope.LOGGED_USER}">
                                                <option value="${source.id}" selected >${source.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </c:otherwise>
                            </c:choose>

                        </label>
                        <label class="mid" for="source_with_knowledge">Fuente que resuelve<span class="reference--required" title="Requerido">*</span>
                            <select name="source_with_knowledge" id="source_with_knowledge" required >
                                <option value="0">Elegir fuente</option>
                                <c:forEach items="${requestScope.SOURCES_LIST}" var="source">
                                    <option value="${source.id}" <c:if test="${source.id eq knowledge.sourceWithKnowledge.id or source.id eq param.source}"> selected </c:if>>${source.name}</option>
                                </c:forEach>
                            </select>
                        </label>
                    </li>
                    <li>
                        <label class="mid" for="brief_description">Descripción breve<span class="reference--required" title="Requerido">*</span>
                            <textarea name="brief_description" id="brief_description" maxlength="200">${knowledge.briefDescription}</textarea>
                        </label>
                        <label class="mid" for="description">Descripción<span class="reference--required" title="Requerido">*</span>
                            <textarea name="description" id="description" maxlength="1000">${knowledge.description}</textarea>
                        </label>
                    </li>
                    <li>
                        <label class="mid" for="keywords">Palabras clave (separadas por coma)<span class="reference--required" title="Requerido">*</span>
                            <input type="text" name="keywords" id="keywords" value="${knowledge.keywords}" />
                        </label>
                        <label class="mid" for="videoUrl">Video Url
                            <input type="text" name="videoUrl" id="videoUrl" value="${knowledge.videoUrl}"/>
                        </label>
                    </li>

                    <li>
                        <h3>Ponderación del Conocimiento Tácito.</h3>
                    </li>
                    <li>
                        <fieldset>
                            <legend>Reuso del Conocimiento</legend>
                            <ol>
                                <li>
                                    <fieldset>
                                        <legend>¿Considera que el conocimiento se usa con frecuencia?</legend>
                                        <ol>
                                            <label for="reuse">Reúso
                                                <select id="reuse" name="usage_frequency" size="1" title="Considera que este conocimiento se usa:">
                                                    <option value="0" <c:if test="${knowledge.usageFrecuency eq 0}">selected</c:if>>Seleccionar</option>
                                                    <option value="0" <c:if test="${knowledge.usageFrecuency eq 0}">selected</c:if>>NO SE USA</option>
                                                    <option value="0.25" <c:if test="${knowledge.usageFrecuency eq 0.25}">selected</c:if>>USO BAJO</option>
                                                    <option value="0.5" <c:if test="${knowledge.usageFrecuency eq 0.5}">selected</c:if>>USO BASICO</option>
                                                    <option value="0.75" <c:if test="${knowledge.usageFrecuency eq 0.75}">selected</c:if>>USO MEDIO</option>
                                                    <option value="1" <c:if test="${knowledge.usageFrecuency eq 1}">selected</c:if>>MUCHO USO</option>
                                                </select>
                                            </label>
                                        </ol>
                                    </fieldset>
                                </li>
                            </ol>
                        </fieldset>
                    </li>
                    <li>

                        <fieldset>
                            <legend>Veracidad del conocimiento</legend>
                            <ol>
                                <li>
                                    <fieldset>
                                        <legend>¿Con que veracidad resolvió el problema utilizando el conocimiento que brindo la FUENTE?</legend>
                                        <ol>
                                            <label for="veracidad">Veracidad del Conocimiento.
                                                <select id="veracidad" name="veracity" size="1" title="Considera que para aplicar este conocimiento se debera de recurrir a la fuente:" required>
                                                    <option value="0" <c:if test="${knowledge.veracity eq 0}">selected</c:if>>Seleccionar</option>
                                                    <option value="0" <c:if test="${knowledge.veracity eq 0}">selected</c:if>>LA FUENTE DE CONOCIMIENTO NO BRINDO LA INFORMACIÓN EXACTA, SE DEBIÓ DE HACER MÁS DE UNA REUNIÓN CON LA FUENTE DE CONOCIMIENTO Y ADEMÁS, TRABAJOS EN EQUIPO DE INVESTIGACIÓN PROPIA.</option>
                                                    <option value="0.5" <c:if test="${knowledge.veracity eq 0.5}">selected</c:if>>LA FUENTE DE CONOCIMIENTO NO BRINDO LA INFORMACIÓN EXACTA, SE DEBIÓ DE HACER MÁS DE UNA REUNIÓN CON LA FUENTE DE CONOCIMIENTO.</option>
                                                    <option value="1" <c:if test="${knowledge.veracity eq 1}">selected</c:if>>LA FUENTE DE CONOCIMIENTO BRINDÓ LA INFORMACIÓN EXACTA COMO PARA RESOLVER EL PROBLEMA, EN UNA SOLA REUNIÓN SE GENERÓ EL CONOCIMIENTO EXPLICITO INMEDIATAMENTE</option>
                                                </select>
                                            </label>
                                        </ol>
                                    </fieldset>
                                </li>
                            </ol>
                        </fieldset>
                    </li>

                    <li>
                        <fieldset>
                            <legend>Tiempo de resolución</legend>
                            <ol>
                                <li>
                                    <fieldset>
                                        <legend>¿Cuál es el tiempo en el que se resuelve el conocimiento?</legend>
                                        <ol>
                                            <label for="tiemporesolucion">Tiempo estimado de resolución
                                                <select id="tiemporesolucion" name="time_to_solved" size="1" title="¿En cuanto tiempo considera que se puede aplicar exitosamente este conocimiento?" required>
                                                    <option value="0" <c:if test="${knowledge.timeToSolved eq 0}">selected</c:if>>Seleccionar</option>
                                                    <option value="0" <c:if test="${knowledge.timeToSolved eq 0}">selected</c:if>>EL TIEMPO DE RESOLUCIÓN, UTILIZANDO EL CONOCIMIENTO, LLEVA 24 HORAS MÁXIMO</option>
                                                    <option value="0.25" <c:if test="${knowledge.timeToSolved eq 0.25}">selected</c:if>>EL TIEMPO DE RESOLUCIÓN, UTILIZANDO EL CONOCIMIENTO, LLEVA 16 HORAS MÁXIMO</option>
                                                    <option value="0.5" <c:if test="${knowledge.timeToSolved eq 0.5}">selected</c:if>>EL TIEMPO DE RESOLUCIÓN, UTILIZANDO EL CONOCIMIENTO, LLEVA ENTRE 4 A 8 HORAS MÁXIMO</option>
                                                    <option value="0.75" <c:if test="${knowledge.timeToSolved eq 0.75}">selected</c:if>>EL TIEMPO DE RESOLUCIÓN, UTILIZANDO EL CONOCIMIENTO, LLEVA ENTRE 2 A 4 HORAS MÁXIMO</option>
                                                    <option value="1" <c:if test="${knowledge.timeToSolved eq 1}">selected</c:if>>EL TIEMPO DE RESOLUCIÓN, UTILIZANDO EL CONOCIMIENTO, LLEVA 2 HORAS MÁXIMO</option>
                                                </select>
                                            </label>
                                        </ol>
                                    </fieldset>
                                </li>
                            </ol>
                        </fieldset>
                        </li>
                    </ul>


                    <li class="clearfix">
                        <button type="submit">Guardar</button>
                    </li>
                </ul>
            </form>
        </div><!--.wrapper-->
    </section><!--.content-->

</t:template>
