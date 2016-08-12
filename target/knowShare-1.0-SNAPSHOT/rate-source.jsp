<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="source" value="${requestScope.SOURCE}"/>

<t:template>

    <jsp:attribute name="header">
        <!-- Page specific JS / CSS  -->
        <script src="<c:url value='/static/js/rate-source.js'/>" type="text/javascript" ></script>
    </jsp:attribute>

    <jsp:body>
        <t:nav/>

        <section class="content">
            <!--Carga de datos para nuevo Usuario Fuente-->
            <div class="wrapper">
                <h3><i class="fa fa-user fa-2x"></i> :: :: Datos Personales</h3>

                <form class="forms" id="rate-source-form" method="post" action="<c:url value='ratesource'/>">
                    <ul>
                        <li>
                            <label class="mid" for="nombre">Nombres
                                <input type="text" name="nombre" id="nombre" value="${source.name}" disabled/>
                            </label>
                            <label class="mid" for="apellido">Apellidos
                                <input type="text" name="apellido" id="apellido" value="${source.lastName}" disabled/>
                            </label>
                        </li>

                        <li>
                            <label class="mid" for="area"> Área
                                <select name="area" id="area" value="" title="Este campo es requerido." disabled>
                                    <c:forEach items="${requestScope.AREAS_LIST}" var="area">
                                        <option value="${area.id}" <c:if test="${source.area.id eq area.id}">selected </c:if> >${area.name}</option>
                                    </c:forEach>
                                </select>
                            </label>

                            <label class="mid" for="comunidad">Comunidad
                                <select id="comunidad" name="comunidad" size="1" disabled>
                                    <c:forEach items="${requestScope.COMMUNITIES_LIST}" var="community">
                                        <option value="${community.id}" <c:if test="${source.community.id eq community.id}">selected </c:if> >${community.name}</option>
                                    </c:forEach>
                                </select>

                            </label>

                        </li>

                        <li>
                            <label class="mid" for="email">Email
                                <input type="text" name="email" id="email" value="${source.email}" disabled/>
                            </label>
                        </li>


                        <!------------------------------------->
                        <h3>Caracteristicas Iniciales de la Fuente</h3>
                        <fieldset>
                            <legend>PERCEPCIÓN</legend>
                            <ol>
                                <li>
                            <fieldset>
                                <legend>¿Conoce a alguna fuente que pertenezca a esta plataforma?</legend>
                                <ol>
                                    <li>
                                    <li>
                                        <ol>
                                            <li>
                                                <label for="perception_flag_true">Si</label>
                                                <input type="radio" id="perception_flag_true" name="perception_flag" value="true" checked/>
                                            </li>
                                            <li>
                                                <label for="perception_flag_true">No</label>
                                                <input type="radio" id="perception_flag_false" name="perception_flag" value="false"/>
                                            </li>
                                        </ol>
                                    </li>
                                    <li>

                                        <fieldset id="question_1">
                                            <legend>¿Cuál es su nivel de conocimiento con respecto a la o las fuentes que conoce?</legend>
                                            <ol>
                                                <li>
                                                    <input id="inferior_q1" name="question_1" type="radio" value="0">
                                                    <label for="inferior_q1">MENOR</label>
                                                </li>
                                                <li>
                                                    <input id="equal_q1" name="question_1" type="radio" value="0.5">
                                                    <label for="equal_q1">IGUAL</label>
                                                </li>
                                                <li>
                                                    <input id="greater_q1" name="question_1" type="radio" value="1">
                                                    <label for="greater_q1">SUPERIOR</label>
                                                </li>
                                            </ol>
                                        </fieldset>
                                    </li>


                                    <li>
                                        <fieldset id="question_2">
                                            <legend>¿Cuál es su posición con respecto a la o las fuentes que conoce?</legend>
                                            <ol>
                                                <li>
                                                    <input id="inferior_q2" name="question_2" type="radio" value="0">
                                                    <label for="inferior_q2">MENOR</label>
                                                </li>
                                                <li>
                                                    <input id="equal_q2" name="question_2" type="radio" value="0.5">
                                                    <label for="equal_q2">IGUAL</label>
                                                </li>
                                                <li>
                                                    <input id="greater_q2" name="question_2" type="radio" value="1">
                                                    <label for="greater_q2">SUPERIOR</label>
                                                </li>
                                            </ol>
                                        </fieldset>
                                    </li>
                                </ol>
                        </fieldset>

                                    </li>
                                </ol>
                            </fieldset>

                        <fieldset>
                            <legend>EXPERIENCIA DE TRABAJO</legend>
                            <ol>
                                <li>

                                <li>
                                    <fieldset id="question_3">
                                        <legend>¿Considera que es bueno trabajando en equipo?</legend>
                                        <ol>
                                            <li>
                                                <input id="very_good" name="question_3" type="radio" value="1">
                                                <label for=very_good>MUY BUENO</label>
                                            </li>

                                            <li>
                                                <input id="good" name="question_3" type="radio" value="0.75">
                                                <label for=good>BUENO</label>
                                            </li>

                                            <li>
                                                <input id="regular" name="question_3" type="radio" value="0.5">
                                                <label for="regular">REGULAR</label>
                                            </li>
                                            <li>
                                                <input id="under_average" name="question_3" type="radio" value="0.25">
                                                <label for="under_average">POR DEBAJO DE LA MEDIA</label>
                                            </li>
                                            <li>
                                                <input id="better_alone" name="question_3" type="radio" value="0">
                                                <label for="better_alone">TRABAJO MEJOR SOLO</label>
                                            </li>
                                        </ol>
                                    </fieldset>
                                </li>
                            </ol>
                        </fieldset>
                        </li>
                        </ol>
                        </fieldset>


                        <fieldset>
                            <legend>NIVEL DE CONOCIMIENTO</legend>
                            <ol>
                                <li>
                        <fieldset>
                            <legend>¿Cuál es su Nivel de Conocimientos dentro de los siguientes cargos o roles?</legend>
                            <ol>
                                <li>
                                    <fieldset id="question_4">
                                        <legend>Dirección de empresas</legend>
                                        <ol>
                                            <select id="business_admin" name="question_4" size="1">
                                                <option value="" selected>Seleccionar</option>
                                                <option value="0.25">0-4 AÑOS</option>
                                                <option value="0.5">5-9 AÑOS</option>
                                                <option value="0.75">10-19 AÑOS</option>
                                                <option value="1">20 A MÁS AÑOS</option>
                                            </select>
                                        </ol>
                                    </fieldset>
                                    <fieldset id="question_5">
                                        <legend>Gestión</legend>
                                        <ol>
                                           <select id="management" name="question_5" size="1">
                                                <option value="" selected>Seleccionar</option>
                                                <option value="0.25">0-4 AÑOS</option>
                                                <option value="0.5">5-9 AÑOS</option>
                                                <option value="0.75">10-19 AÑOS</option>
                                                <option value="1">20 A MÁS AÑOS</option>
                                            </select>
                                        </ol>
                                    </fieldset>
                                </li>

                                <li>
                                    <fieldset id="question_6">
                                        <legend>Proyectos</legend>
                                        <ol>
                                                <select id="projects" name="question_6" size="1">
                                                    <option value="" selected>Seleccionar</option>
                                                    <option value="0.25">0-4 AÑOS</option>
                                                    <option value="0.5">5-9 AÑOS</option>
                                                    <option value="0.75">10-19 AÑOS</option>
                                                    <option value="1">20 A MÁS AÑOS</option>
                                                </select>

                                        </ol>

                                    </fieldset>

                                    <fieldset id="question_7">
                                        <legend>CAPACITACIÓN</legend>
                                        <ol>
                                            <select id="training" name="question_7" size="1">
                                                <option value="" selected>Seleccionar</option>
                                                <option value="0.25">0-4 AÑOS</option>
                                                <option value="0.5">5-9 AÑOS</option>
                                                <option value="0.75">10-19 AÑOS</option>
                                                <option value="1">20 A MÁS AÑOS</option>
                                            </select>

                                        </ol>
                                    </fieldset>

                                </li>

                                <li>
                                    <fieldset id="question_8">
                                        <legend>ADMINISTRACIÓN/ATENCIÓN AL PÚBLICO</legend>
                                        <ol>
                                            <select id="administration" name="question_8" size="1">
                                                <option value="" selected>Seleccionar</option>
                                                <option value="0.25">0-4 AÑOS</option>
                                                <option value="0.5">5-9 AÑOS</option>
                                                <option value="0.75">10-19 AÑOS</option>
                                                <option value="1">20 A MÁS AÑOS</option>
                                            </select>
                                        </ol>
                                    </fieldset>

                                    <fieldset id="question_9">
                                        <legend>SOPORTE Y APOYO</legend>
                                        <ol>
                                            <select id="support" name="question_9" size="1">
                                                <option value="" selected>Seleccionar</option>
                                                <option value="0.25">0-4 AÑOS</option>
                                                <option value="0.5">5-9 AÑOS</option>
                                                <option value="0.75">10-19 AÑOS</option>
                                                <option value="1">20 A MÁS AÑOS</option>
                                            </select>
                                        </ol>
                                    </fieldset>
                                </li>
                            </ol>

                        </fieldset>
                            </li>
                        </ol>
                    </fieldset>

                        <fieldset>
                            <legend>POSICIÓN</legend>
                            <ol>
                                <li>
                                    <fieldset id="question_10">
                                        <legend>¿Cuál es su posición en la empresa?</legend>
                                        <ol>
                                            <li>
                                                <input id="directive" name="question_10" type="radio" value="1">
                                                <label for="directive">DIRECTIVO</label>
                                            </li>
                                            <li>
                                                <input id="manager" name="question_10" type="radio" value="0.75">
                                                <label for="manager">GERENTE</label>
                                            </li>
                                            <li>
                                                <input id="boss" name="question_10" type="radio" value="0.5">
                                                <label for="boss">JEFE</label>
                                            </li>
                                            <li>
                                                <input id="expert_employee" name="question_10" type="radio" value="0.25">
                                                <label for="expert_employee">EMPLEADOS EXPERTOS</label>
                                            </li>
                                            <li>
                                                <input id="basic_employee" name="question_10" type="radio" value="0">
                                                <label for="basic_employee">EMPLEADOS BÁSICOS</label>
                                            </li>
                                        </ol>
                                    </fieldset>
                                </li>
                            </ol>

                        </fieldset>
                    </ul>

                        <li class="clearfix">
                            <button>Guardar</button>
                        </li>
                    </ul>
                </form>
            </div><!--.wrapper-->
        </section><!--.content-->
    </jsp:body>
</t:template>