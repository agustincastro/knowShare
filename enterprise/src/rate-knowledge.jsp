<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="knowledge" value="${requestScope.KNOWLEDGE}"/>

<t:template>
    <t:nav/>

    <section class="content">
        <!-- Descripcion Inicial de conocimiento Fuente y Ponderacion actual de los mismos-->
        <div class="wrapper">
            <h3>Tacit Knowledge</h3>
            <div class="item-view">
                <div class="item-view__product">
                    <div style="color:rgb(32,178,170)" class="item-box__visual">
                        <i class="fa fa-book fa-5x"></i>
                    </div>
                </div>
                <!-- / Inicio informacion de nombres de FUENTES que aportaron el conocimiento -->
                <div class="item-view__details">
                    <div class="item-view__profile">
                    <span class="item-view__label">Source with Tacit Knowledge</span>
                    <a href="editsource?id=${knowledge.sourceWithKnowledge.id}">${knowledge.sourceWithKnowledge.name}</a>
                    </div>
                    <div class="item-view__profile">
                        <span class="item-view__label">Source that LINKED Knowledge</span>
                        <a href="editsource?id=${knowledge.sourceWithKnowledge.id}">${knowledge.sourceWhoWrote.name}</a>
                    </div>
                </div>
            </div>
            <!-- / FIN informacion de nombres de FUENTES que aportaron el conocimiento -->

            <!-- / Descripcion principal del conocimiento y problema que soluciona, se dan mas datos de la Fuente. -->
            <div class="item-view__description">
                <ul class="item-view__fields">
                    <li class="item-view__field-title">Tacit Knowledge Title</li>
                    <li class="item-view__field-content">${knowledge.title}</li>
                    <li class="item-view__field-title">Problem Type it solves</li>
                    <li class="item-view__field-content"><a href="<c:url value='editproblem?id=${knowledge.problem.id}'/>">${knowledge.problem.title}</a></li>
                    <li class="item-view__field-title">Source's email address</li>
                    <li class="item-view__field-content"><a href="mailto:${knowledge.sourceWithKnowledge.email}" target="_blank">${knowledge.sourceWithKnowledge.email}</a></li>
                </ul>
            </div>
            <!-- / FIN de descripcion principal del conocimiento y problema que soluciona, se dan mas datos de la Fuente -->

            <fieldset style="height:300px">
                <h3>Knowledge report</h3>
                <div class="item-view__profile">
                    <span class="item-view__label">Knowledge Reusability</span>
                    <a>${knowledge.usageFrecuency}</a>
                </div>
                <div class="item-view__profile">
                    <span class="item-view__label">Knowledge Truthfulness</span>
                    <a>${knowledge.veracity}</a>
                </div>
                <div class="item-view__profile">
                    <span class="item-view__label">Time</span>
                    <a>${knowledge.timeToSolved}</a>
                </div>
                <br>
                <div class="item-view__profile">
                    <span class="item-view__label">Source Rating</span>
                    <a>${knowledge.sourceWithKnowledge.expertiseLevel}</a>
                </div>
            </fieldset>
            <!-- FIN de Descripcion Inicial de conocimiento Fuente y Ponderacion actual de los mismos-->

            <!-- Comienzo de Descripcion del conocimiento tacito que da solucion al problema-->
            <a>Description</a>
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
                    <h3>Source Rating</h3>
                    <fieldset>
                        <!-- Comienzo de area de ponderacion del Nivel de Experiencia en la Interacción de la Fuente -->
                        <legend>Work Experience</legend>
                        <ol>
                            <li>
                                <fieldset>
                                    <legend>Rate Knowledge Explanation</legend>
                                    <ol>
                                        <li>
                                            <input id="very_good" name="question_1" type=radio value="1">
                                            <label for="very_good">EXCELLENT EXPLANATION</label>
                                        </li>
                                        <li>
                                            <input id="good" name="question_1" type=radio value="0.75">
                                            <label for="good">GOOD EXPLANATION</label>
                                        </li>
                                        <li>
                                            <input id=regular name="question_1" type=radio value="0.5">
                                            <label for=regular>REGULAR EXPLANATION</label>
                                        </li>
                                        <li>
                                            <input id="below_regular" name="question_1" type=radio value="0.25">
                                            <label for="below_regular">BAD EXPLANATION</label>
                                        </li>
                                        <li>
                                            <input id="poor" name="question_1" type=radio value="0">
                                            <label for="poor">VERY POOR EXPLANATION</label>
                                        </li>
                                    </ol>
                                </fieldset>
                            </li>
                            <li>
                                <fieldset>
                                    <legend>Source motivation and availability?</legend>
                                    <ol>
                                        <li>
                                            <input id="completely_agree" name="question_2" type=radio value="1">
                                            <label for="completely_agree">AWESOME</label>
                                        </li>
                                        <li>
                                            <input id="agree" name="question_2" type=radio value="0.75">
                                            <label for="agree">GOOD</label>
                                        </li>
                                        <li>
                                            <input id="medium" name="question_2" type=radio value="0.5">
                                            <label for="medium">REGULAR</label>
                                        </li>
                                        <li>
                                            <input id="bad" name="question_2" type=radio value="0.25">
                                            <label for="bad">POOR</label>
                                        </li>
                                        <li>
                                            <input id="very_bad" name="question_2" type=radio value="0">
                                            <label for="very_bad">REALLY POOR</label>
                                        </li>
                                    </ol>
                                </fieldset>
                            </li>
                        </ol>
                    </fieldset>
                    <!--fin de area de ponderacion del Nivel de Experiencia en la Interacción de la Fuente-->
                    <!--Comienzo de area de ponderacion del Nivel de conocimientos transmitidos de la Fuente-->
                    <fieldset>
                        <legend>Knowledge Level</legend>
                        <ol>
                            <li>
                                <fieldset>
                                    <legend>How do you consider the Source's Knowledge level?</legend>
                                    <ol>
                                        <li>
                                            <input id="rookie" name="question_3" type=radio value="0">
                                            <label for="rookie">NOVICE</label>
                                        </li>
                                        <li>
                                            <input id="beginner" name="question_3" type=radio value="0.25">
                                            <label for="beginner">BEGINNER</label>
                                        </li>
                                        <li>
                                            <input id="competent" name="question_3" type=radio value="0.5">
                                            <label for="competent">COMPETENT</label>
                                        </li>

                                        <li>
                                            <input id="expert" name="question_3" type=radio value="0.75">
                                            <label for="expert">EXPERT</label>
                                        </li>
                                        <li>
                                            <input id="master" name="question_3" type=radio value="1">
                                            <label for="master">MASTERFUL</label>
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
                    <h3>Tacit Knowledge Rating.</h3>
                    <fieldset>
                    <legend>Knowledge reusability</legend>
                    <ol>
                        <li>
                            <fieldset>
                                <legend>How do you consider the Knowledge's usage?</legend>
                                <ol>
                                    <label for="reuse">Reúso
                                        <select id="reuse" name="usage_frequency" size="1" title="Considera que este conocimiento se usa:">
                                            <option value="0" <c:if test="${knowledge.usageFrecuency eq 0}">selected</c:if>>Select</option>
                                            <option value="0" <c:if test="${knowledge.usageFrecuency eq 0}">selected</c:if>>NOT USED:: KNOWLEDGE USED MAXIMUM ONCE A YEAR</option>
                                            <option value="0.25" <c:if test="${knowledge.usageFrecuency eq 0.25}">selected</c:if>>LOW USE:: KNOWLEDGE USED MORE THAN ONCE A YEAR</option>
                                            <option value="0.5" <c:if test="${knowledge.usageFrecuency eq 0.5}">selected</c:if>>MEDIUM USE:: KNOWLEDGE USED AT LEAST THAN ONCE A MONTH</option>
                                            <option value="0.75" <c:if test="${knowledge.usageFrecuency eq 0.75}">selected</c:if>>RELEVANT USE:: KNOWLEDGE USED AT EVERY TWO WEEKS</option>
                                            <option value="1" <c:if test="${knowledge.usageFrecuency eq 1}">selected</c:if>>VERY RELEVANT USE:: KNOWLEDGE USED EVERY WEEK</option>
                                        </select>
                                    </label>
                                </ol>
                            </fieldset>
                        </li>
                    </ol>
                    </fieldset>

                    <fieldset>
                        <legend>Knowledge Truthfulness</legend>
                        <ol>
                            <li>
                                <fieldset>
                                    <legend>¿How did you resolve your problem with the concerning Knowledge?</legend>
                                    <ol>
                                        <label for="veracidad">Knowledge Veracity.
                                            <select id="veracidad" name="veracity" size="1" title="Does the source need to be contacted:" required>
                                                <option value="0" <c:if test="${knowledge.veracity eq 0}">selected</c:if>>Select</option>
                                                <option value="0" <c:if test="${knowledge.veracity eq 0.25}">selected</c:if>>PROBLEM NOT RESOLVED WITH WRITTEN KNOWLEDGE, KNOWLEDGE SOURCE HAD TO BE CONTACTED TO RESOLVE THE PROBLEM</option>
                                                <option value="0.5" <c:if test="${knowledge.veracity eq 0.5}">selected</c:if>>PROBLEM NOT RESOLVED WITH WRITTEN KNOWLEDGE, KNOWLEDGE SOURCE HAD TO BE CONTACTED TO CLARIFY ITS KNOWLEDGE TO THEN RESOLVE THE PROBLEM</option>
                                                <option value="1" <c:if test="${knowledge.veracity eq 1}">selected</c:if>>PROBLEM WAS RESOLVED WITH WRITTEN KNOWLEDGE</option>
                                            </select>
                                        </label>
                                    </ol>
                                </fieldset>
                            </li>
                        </ol>
                    </fieldset>

                    <fieldset>
                        <legend>Resolution time</legend>
                        <ol>
                            <li>
                                <fieldset>
                                <legend>How long did it take for you to solve your proble using this Knowledge?</legend>
                                    <ol>
                                        <label for="tiemporesolucion">Estimated resolution time
                                            <select id="tiemporesolucion" name="time_to_solved" size="1" title="How long does it take to successfully apply this Knowledge?" required>
                                                <option value="0" <c:if test="${knowledge.timeToSolved eq 0}">selected</c:if>>Select</option>
                                                <option value="0" <c:if test="${knowledge.timeToSolved eq 0}">selected</c:if>>COULD NOT RESOLVE PROBLEM</option>
                                                <option value="0.25" <c:if test="${knowledge.timeToSolved eq 0}">selected</c:if>>PROBLEM SOLVED USING 4 TIMES THE ESTIMATED TIME</option>
                                                <option value="0.5" <c:if test="${knowledge.timeToSolved eq 0.25}">selected</c:if>>PROBLEM SOLVED USING 2 TIMES THE ESTIMATED TIME</option>
                                                <option value="0.75" <c:if test="${knowledge.timeToSolved eq 0.5}">selected</c:if>>PROBLEM SOLVED USING THE ESTIMATED TIME</option>
                                                <option value="1" <c:if test="${knowledge.timeToSolved eq 1}">selected</c:if>>PROBLEM SOLVED UNDER THE ESTIMATED TIME</option>
                                            </select>
                                        </label>
                                    </ol>
                                </fieldset>
                            </li>
                        </ol>
                    </fieldset>

                    <li>
                        <button class="publish">Cancel</button>
                    </li>
                    <li class="clearfix">
                        <button>Save</button>
                    </li>
                </ul>
            </form>
        </div>
    </section>
</t:template>
