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
                <h3><i class="fa fa-user fa-2x"></i> :: :: Personal Data</h3>

                <form class="forms" id="rate-source-form" method="post" action="<c:url value='ratesource'/>">
                    <ul>
                        <li>
                            <label class="mid" for="nombre">Name
                                <input type="text" name="nombre" id="nombre" value="${source.name}" disabled/>
                            </label>
                            <label class="mid" for="apellido">Surname
                                <input type="text" name="apellido" id="apellido" value="${source.lastName}" disabled/>
                            </label>
                        </li>

                        <li>
                            <label class="mid" for="area"> Area
                                <select name="area" id="area" value="" title="This field is required" disabled>
                                    <c:forEach items="${requestScope.AREAS_LIST}" var="area">
                                        <option value="${area.id}" <c:if test="${source.area.id eq area.id}">selected </c:if> >${area.name}</option>
                                    </c:forEach>
                                </select>
                            </label>

                            <label class="mid" for="comunidad">Practice Community
                                <select id="comunidad" name="comunidad" size="1" disabled>
                                    <c:forEach items="${requestScope.COMMUNITIES_LIST}" var="community">
                                        <option value="${community.id}" <c:if test="${source.community.id eq community.id}">selected </c:if> >${community.name}</option>
                                    </c:forEach>
                                </select>

                            </label>

                        </li>

                        <li>
                            <label class="mid" for="email">Email Address
                                <input type="text" name="email" id="email" value="${source.email}" disabled/>
                            </label>
                        </li>


                        <!------------------------------------->
                        <h3>Initial Source Data</h3>
                        <fieldset>
                            <legend>PERCEPTION</legend>
                            <ol>
                                <li>
                            <fieldset>
                                <legend>Do you know other sources in KNOWSHARE?</legend>
                                <ol>
                                    <li>
                                    <li>
                                        <ol>
                                            <li>
                                                <label for="perception_flag_true">Yes</label>
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
                                            <legend>What is your Knowledge Level compared to other sources?</legend>
                                            <ol>
                                                <li>
                                                    <input id="inferior_q1" name="question_1" type="radio" value="0">
                                                    <label for="inferior_q1">LESS THAN</label>
                                                </li>
                                                <li>
                                                    <input id="equal_q1" name="question_1" type="radio" value="0.5">
                                                    <label for="equal_q1">EQUAL TO</label>
                                                </li>
                                                <li>
                                                    <input id="greater_q1" name="question_1" type="radio" value="1">
                                                    <label for="greater_q1">SUPERIOR TO</label>
                                                </li>
                                            </ol>
                                        </fieldset>
                                    </li>


                                    <li>
                                        <fieldset id="question_2">
                                            <legend>What is your hierarchy compared to the majority of the other sources?</legend>
                                            <ol>
                                                <li>
                                                    <input id="inferior_q2" name="question_2" type="radio" value="0">
                                                    <label for="inferior_q2">LESS THAN</label>
                                                </li>
                                                <li>
                                                    <input id="equal_q2" name="question_2" type="radio" value="0.5">
                                                    <label for="equal_q2">EQUAL TO</label>
                                                </li>
                                                <li>
                                                    <input id="greater_q2" name="question_2" type="radio" value="1">
                                                    <label for="greater_q2">SUPERIOR TO</label>
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
                            <legend>WORK EXPERIENCE</legend>
                            <ol>
                                <li>

                                <li>
                                    <fieldset id="question_3">
                                        <legend>Good team player?</legend>
                                        <ol>
                                            <li>
                                                <input id="very_good" name="question_3" type="radio" value="1">
                                                <label for=very_good>VERY GOOD</label>
                                            </li>

                                            <li>
                                                <input id="good" name="question_3" type="radio" value="0.75">
                                                <label for=good>GOOD</label>
                                            </li>

                                            <li>
                                                <input id="regular" name="question_3" type="radio" value="0.5">
                                                <label for="regular">REGULAR</label>
                                            </li>
                                            <li>
                                                <input id="under_average" name="question_3" type="radio" value="0.25">
                                                <label for="under_average">UNDER PAR</label>
                                            </li>
                                            <li>
                                                <input id="better_alone" name="question_3" type="radio" value="0">
                                                <label for="better_alone">LONE WOLF</label>
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
                            <legend>KNOWLEDGE LEVEL</legend>
                            <ol>
                                <li>
                        <fieldset>
                            <legend>Kowledge level in the following areas:</legend>
                            <ol>
                                <li>
                                    <fieldset id="question_4">
                                        <legend>Business Management</legend>
                                        <ol>
                                            <select id="business_admin" name="question_4" size="1">
                                                <option value="" selected>Select</option>
                                                <option value="0.25">0-4 YEARS</option>
                                                <option value="0.5">5-9 YEARS</option>
                                                <option value="0.75">10-19 YEARS</option>
                                                <option value="1">20+ YEARS</option>
                                            </select>
                                        </ol>
                                    </fieldset>
                                    <fieldset id="question_5">
                                        <legend>Management</legend>
                                        <ol>
                                           <select id="management" name="question_5" size="1">
                                                <option value="" selected>Select</option>
                                                <option value="0.25">0-4 YEARS</option>
                                                <option value="0.5">5-9 YEARS</option>
                                                <option value="0.75">10-19 YEARS</option>
                                                <option value="1">20+ YEARS</option>
                                            </select>
                                        </ol>
                                    </fieldset>
                                </li>

                                <li>
                                    <fieldset id="question_6">
                                        <legend>Projects</legend>
                                        <ol>
                                                <select id="projects" name="question_6" size="1">
                                                    <option value="" selected>Select</option>
                                                    <option value="0.25">0-4 YEARS</option>
                                                    <option value="0.5">5-9 YEARS</option>
                                                    <option value="0.75">10-19 YEARS</option>
                                                    <option value="1">20+ YEARS</option>
                                                </select>

                                        </ol>

                                    </fieldset>

                                    <fieldset id="question_7">
                                        <legend>TRAINING</legend>
                                        <ol>
                                            <select id="training" name="question_7" size="1">
                                                <option value="" selected>Select</option>
                                                <option value="0.25">0-4 YEARS</option>
                                                <option value="0.5">5-9 YEARS</option>
                                                <option value="0.75">10-19 YEARS</option>
                                                <option value="1">20+ YEARS</option>
                                            </select>

                                        </ol>
                                    </fieldset>

                                </li>

                                <li>
                                    <fieldset id="question_8">
                                        <legend>CUSTOMER SUCCESS</legend>
                                        <ol>
                                            <select id="administration" name="question_8" size="1">
                                                <option value="" selected>Select</option>
                                                <option value="0.25">0-4 YEARS</option>
                                                <option value="0.5">5-9 YEARS</option>
                                                <option value="0.75">10-19 YEARS</option>
                                                <option value="1">20+ YEARS</option>
                                            </select>
                                        </ol>
                                    </fieldset>

                                    <fieldset id="question_9">
                                        <legend>SUPPORT AND HELPFULNESS</legend>
                                        <ol>
                                            <select id="support" name="question_9" size="1">
                                                <option value="" selected>Select</option>
                                                <option value="0.25">0-4 YEARS</option>
                                                <option value="0.5">5-9 YEARS</option>
                                                <option value="0.75">10-19 YEARS</option>
                                                <option value="1">20+ YEARS</option>
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
                            <legend>POSITION</legend>
                            <ol>
                                <li>
                                    <fieldset id="question_10">
                                        <legend>Current position within the company?</legend>
                                        <ol>
                                            <li>
                                                <input id="directive" name="question_10" type="radio" value="1">
                                                <label for="directive">DIRECTORY</label>
                                            </li>
                                            <li>
                                                <input id="manager" name="question_10" type="radio" value="0.75">
                                                <label for="manager">UPPER MANAGEMENT</label>
                                            </li>
                                            <li>
                                                <input id="boss" name="question_10" type="radio" value="0.5">
                                                <label for="boss">MANAGER</label>
                                            </li>
                                            <li>
                                                <input id="expert_employee" name="question_10" type="radio" value="0.25">
                                                <label for="expert_employee">EXPERT EMPLOYEE</label>
                                            </li>
                                            <li>
                                                <input id="basic_employee" name="question_10" type="radio" value="0">
                                                <label for="basic_employee">NORMAL EMPLOYEE</label>
                                            </li>
                                        </ol>
                                    </fieldset>
                                </li>
                            </ol>

                        </fieldset>
                    </ul>

                        <li class="clearfix">
                            <button>Save</button>
                        </li>
                    </ul>
                </form>
            </div><!--.wrapper-->
        </section><!--.content-->
    </jsp:body>
</t:template>
