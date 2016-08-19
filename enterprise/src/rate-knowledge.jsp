<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="knowledge" value="${requestScope.KNOWLEDGE}"/>

<t:template>
    <t:nav/>

    <section class="content">
        <!-- Descripcion Inicial de conocimiento Fuente y Ponderacion actual de los mismos-->
        <div class="wrapper">
            <h3>Conocimiento Tácito</h3>
            <div class="item-view">
                <div class="item-view__product">
                    <div style="color:rgb(32,178,170)" class="item-box__visual">
                        <i class="fa fa-book fa-5x"></i>
                    </div>
                </div>
                <!-- / Inicio informacion de nombres de FUENTES que aportaron el conocimiento -->
                <div class="item-view__details">
                    <div class="item-view__profile">
                    <span class="item-view__label">Nombre de la Fuente que aportó el conocimiento</span>
                    <a href="editsource?id=${knowledge.sourceWithKnowledge.id}">${knowledge.sourceWithKnowledge.name}</a>
                    </div>
                    <div class="item-view__profile">
                        <span class="item-view__label">Nombre de la Fuente que escribió el Conocimiento Tácito</span>
                        <a href="editsource?id=${knowledge.sourceWithKnowledge.id}">${knowledge.sourceWhoWrote.name}</a>
                    </div>
                </div>
            </div>
            <!-- / FIN informacion de nombres de FUENTES que aportaron el conocimiento -->

            <!-- / Descripcion principal del conocimiento y problema que soluciona, se dan mas datos de la Fuente. -->
            <div class="item-view__description">
                <ul class="item-view__fields">
                    <li class="item-view__field-title">Titulo del Conocimiento Tácito</li>
                    <li class="item-view__field-content">${knowledge.title}</li>
                    <li class="item-view__field-title">Tipo de Problema que resuelve</li>
                    <li class="item-view__field-content"><a href="<c:url value='editproblem?id=${knowledge.problem.id}'/>">${knowledge.problem.title}</a></li>
                    <li class="item-view__field-title">Correo electrónico de la Fuente</li>
                    <li class="item-view__field-content"><a href="mailto:${knowledge.sourceWithKnowledge.email}" target="_blank">${knowledge.sourceWithKnowledge.email}</a></li>
                </ul>
            </div>
            <!-- / FIN de descripcion principal del conocimiento y problema que soluciona, se dan mas datos de la Fuente -->

            <fieldset style="height:300px">
                <h3>Reporte sobre el Conocimiento</h3>
                <div class="item-view__profile">
                    <span class="item-view__label">Reuso del Conocimiento</span>
                    <a>${knowledge.usageFrecuency}</a>
                </div>
                <div class="item-view__profile">
                    <span class="item-view__label">Veracidad del Conocimiento</span>
                    <a>${knowledge.veracity}</a>
                </div>
                <div class="item-view__profile">
                    <span class="item-view__label">Tiempo</span>
                    <a>${knowledge.timeToSolved}</a>
                </div>
                <br>
                <div class="item-view__profile">
                    <span class="item-view__label">Nivel de Seguridad de Fuente</span>
                    <a>${knowledge.sourceWithKnowledge.expertiseLevel}</a>
                </div>
            </fieldset>
            <!-- FIN de Descripcion Inicial de conocimiento Fuente y Ponderacion actual de los mismos-->

            <!-- Comienzo de Descripcion del conocimiento tacito que da solucion al problema-->
            <a>Descripción</a>
            <fieldset style="overflow:auto; padding: 1em; margin: .5em 5.5em .5em .5em; height:220px">
                ${knowledge.description}
            </fieldset>
            <!-- FIN de Descripcion del conocimiento tacito que da solucion al problema-->
            <!-- Comienzo de cuandro para ponderar la fuente y el conocimiento -->
            <form class="forms" id="ponderacion" method="post" action="<c:url value='rateknowledge'/>">
                <input type="hidden" name="id" value="${knowledge.id}"/>

                <ul>
                    <c:if test="${not (sessionScope.LOGGED_USER_TYPE eq 'USER')}">
                    <input type="hidden" name="source_id" value="${knowledge.sourceWithKnowledge.id}"/>
                    <h3>Ponderación de la Fuente</h3>
                    <fieldset>
                        <!-- Comienzo de area de ponderacion del Nivel de Experiencia en la Interacción de la Fuente -->
                        <legend>Experiencia de trabajo</legend>
                        <ol>
                            <li>
                                <fieldset>
                                    <legend>¿Cómo le resulto la explicación del conocimiento?</legend>
                                    <ol>
                                        <li>
                                            <input id="very_good" name="question_1" type=radio value="1">
                                            <label for="very_good">MUY BUENA EXPLICACIÓN</label>
                                        </li>
                                        <li>
                                            <input id="good" name="question_1" type=radio value="0.75">
                                            <label for="good">BUENA EXPLICACIÓN</label>
                                        </li>
                                        <li>
                                            <input id=regular name="question_1" type=radio value="0.5">
                                            <label for=regular>REGULAR</label>
                                        </li>
                                        <li>
                                            <input id="below_regular" name="question_1" type=radio value="0.25">
                                            <label for="below_regular">MALO EXPLICANDO</label>
                                        </li>
                                        <li>
                                            <input id="poor" name="question_1" type=radio value="0">
                                            <label for="poor">MUY MALO EXPLICANDO</label>
                                        </li>
                                    </ol>
                                </fieldset>
                            </li>
                            <li>
                                <fieldset>
                                    <legend>¿Cuál fue la disposición y motivación de la Fuente?</legend>
                                    <ol>
                                        <li>
                                            <input id="completely_agree" name="question_2" type=radio value="1">
                                            <label for="completely_agree">MUY BUENA</label>
                                        </li>
                                        <li>
                                            <input id="agree" name="question_2" type=radio value="0.75">
                                            <label for="agree">BUENA</label>
                                        </li>
                                        <li>
                                            <input id="medium" name="question_2" type=radio value="0.5">
                                            <label for="medium">MEDIO</label>
                                        </li>
                                        <li>
                                            <input id="bad" name="question_2" type=radio value="0.25">
                                            <label for="bad">MALO</label>
                                        </li>
                                        <li>
                                            <input id="very_bad" name="question_2" type=radio value="0">
                                            <label for="very_bad">MUY MALO</label>
                                        </li>
                                    </ol>
                                </fieldset>
                            </li>
                        </ol>
                    </fieldset>
                    <!--fin de area de ponderacion del Nivel de Experiencia en la Interacción de la Fuente-->
                    <!--Comienzo de area de ponderacion del Nivel de conocimientos transmitidos de la Fuente-->
                    <fieldset>
                        <legend>Nivel de conocimientos</legend>
                        <ol>
                            <li>
                                <fieldset>
                                    <legend>¿En qué nivel de conocimientos asociaría a la fuente que brindo el conocimiento?</legend>
                                    <ol>
                                        <li>
                                            <input id="rookie" name="question_3" type=radio value="0">
                                            <label for="rookie">NOVATO</label>
                                        </li>
                                        <li>
                                            <input id="beginner" name="question_3" type=radio value="0.25">
                                            <label for="beginner">PRINCIPIANTE</label>
                                        </li>
                                        <li>
                                            <input id="competent" name="question_3" type=radio value="0.5">
                                            <label for="competent">COMPETENTE</label>
                                        </li>

                                        <li>
                                            <input id="expert" name="question_3" type=radio value="0.75">
                                            <label for="expert">EXPERTO</label>
                                        </li>
                                        <li>
                                            <input id="master" name="question_3" type=radio value="1">
                                            <label for="master">MAESTRO</label>
                                        </li>

                                    </ol>
                                </fieldset>
                            </li>
                        </ol>
                    </fieldset>
                    <!--Fin de area de ponderacion del Nivel de conocimientos transmitidos de la Fuente-->
                </ul>
                </c:if>
                <!-- cuandro de ponderacion del conocimiento cosumido-->
                <ul>
                    <h3>Ponderación del Conocimiento Tácito.</h3>
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
                                            <option value="0" <c:if test="${knowledge.usageFrecuency eq 0}">selected</c:if>>NO SE USA:: EL CONOCIMIENTO SE USA CADA MÁS DE 1 AÑO</option>
                                            <option value="0.25" <c:if test="${knowledge.usageFrecuency eq 0.25}">selected</c:if>>USO BAJO:: EL CONOCIMIENTO SE USA AL MENOS 1 VEZ POR AÑO</option>
                                            <option value="0.5" <c:if test="${knowledge.usageFrecuency eq 0.5}">selected</c:if>>USO BASICO:: EL CONOCIMIENTO SE USA AL MENOS 1 VEZ POR MES</option>
                                            <option value="0.75" <c:if test="${knowledge.usageFrecuency eq 0.75}">selected</c:if>>USO MEDIO::EL CONOCIMIENTO SE USA AL MENOS 1 VEZ CADA 15 DÍAS</option>
                                            <option value="1" <c:if test="${knowledge.usageFrecuency eq 1}">selected</c:if>>MUCHO USO:: EL CONOCIMIENTO SE APLICA AL MENOS 1 VEZ POR SEMANA</option>
                                        </select>
                                    </label>
                                </ol>
                            </fieldset>
                        </li>
                    </ol>
                    </fieldset>

                    <fieldset>
                        <legend>Veracidad del conocimiento</legend>
                        <ol>
                            <li>
                                <fieldset>
                                    <legend>¿Cómo resolvió el problema utilizando el conocimiento?</legend>
                                    <ol>
                                        <label for="veracidad">Veracidad del Conocimiento.
                                            <select id="veracidad" name="veracity" size="1" title="Considera que para aplicar este conocimiento se debera de recurrir a la fuente:" required>
                                                <option value="0" <c:if test="${knowledge.veracity eq 0}">selected</c:if>>Seleccionar</option>
                                                <option value="0" <c:if test="${knowledge.veracity eq 0.25}">selected</c:if>>EL PROBLEMA NO SE RESOLVIÓ UTILIZANDO EL CONOCIMIENTO ESCRITO, SE DEBIÓ CONSULTAR A LA FUENTE DE CONOCIMIENTO PARA RESOLVER EL PROBLEMA Y LUEGO SE RESOLVIÓ</option>
                                                <option value="0.5" <c:if test="${knowledge.veracity eq 0.5}">selected</c:if>>EL PROBLEMA NO SE RESOLVIÓ UTILIZANDO EL CONOCIMIENTO ESCRITO, SE DEBIÓ CONSULTAR A LA FUENTE QUE EXPLICITÓ EL CONOCIMIENTO Y LUEGO SE RESOLVIÓ</option>
                                                <option value="1" <c:if test="${knowledge.veracity eq 1}">selected</c:if>>SE RESOLVIÓ EL PROBLEMA UTILIZANDO EL CONOCIMIENTO</option>
                                            </select>
                                        </label>
                                    </ol>
                                </fieldset>
                            </li>
                        </ol>
                    </fieldset>

                    <fieldset>
                        <legend>Tiempo de resolución</legend>
                        <ol>
                            <li>
                                <fieldset>
                                <legend>Sabiendo que el tiempo de resolución es X, ¿Cuánto demoró en solucionar el problema teniendo en cuenta el tiempo de resolución inicial?</legend>
                                    <ol>
                                        <label for="tiemporesolucion">Tiempo estimado de resolución
                                            <select id="tiemporesolucion" name="time_to_solved" size="1" title="¿En cuanto tiempo considera que se puede aplicar exitosamente este conocimiento?" required>
                                                <option value="0" <c:if test="${knowledge.timeToSolved eq 0}">selected</c:if>>Seleccionar</option>
                                                <option value="0" <c:if test="${knowledge.timeToSolved eq 0}">selected</c:if>>NO PUDO RESOLVER EL PROBLEMA</option>
                                                <option value="0.25" <c:if test="${knowledge.timeToSolved eq 0}">selected</c:if>>RESOLVIÓ EL PROBLEMA UTILIZANDO  DEL TIEMPO INICIAL CUADRIPLICANDO EL TIEMPO INICIAL</option>
                                                <option value="0.5" <c:if test="${knowledge.timeToSolved eq 0.25}">selected</c:if>>RESOLVIÓ EL PROBLEMA UTILIZANDO MÁS DEL DOBLE DEL TIEMPO INICIAL</option>
                                                <option value="0.75" <c:if test="${knowledge.timeToSolved eq 0.5}">selected</c:if>>RESOLVIÓ EL PROBLEMA UTILIZANDO MENOS DEL  DOBLE DEL TIEMPO INICIAL</option>
                                                <option value="1" <c:if test="${knowledge.timeToSolved eq 1}">selected</c:if>>RESOLVIÓ EL PROBLEMA UTILIZANDO EL TIEMPO INICIAL</option>
                                            </select>
                                        </label>
                                    </ol>
                                </fieldset>
                            </li>
                        </ol>
                    </fieldset>

                    <li>
                        <button class="publish">Cancelar</button>
                    </li>
                    <li class="clearfix">
                        <button>Guardar</button>
                    </li>
                </ul>
            </form>
        </div>
    </section>
</t:template>