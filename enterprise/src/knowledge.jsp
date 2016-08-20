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
                    <h3><i class="fa fa-user fa-2x"></i> :: :: Edit Knowledge</h3>
                </c:when>
                <c:otherwise>
                    <h3><i class="fa fa-user fa-2x"></i> :: :: New Knowledge</h3>
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
                        <label class="mid" for="title">Title<span class="reference--required" title="Requerido">*</span>
                            <input type="text" name="title" id="title" value="${knowledge.title}" required />
                        </label>
                        <label class="mid" for="problem">Problema it solves<span class="reference--required" title="Required">*</span>
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
                        <label class="mid" for="source_who_wrote">Writing Source<span class="reference--required" title="Required">*</span>
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
                        <label class="mid" for="source_with_knowledge">Resolving Source<span class="reference--required" title="Required">*</span>
                            <select name="source_with_knowledge" id="source_with_knowledge" required >
                                <option value="0">Choose source</option>
                                <c:forEach items="${requestScope.SOURCES_LIST}" var="source">
                                    <option value="${source.id}" <c:if test="${source.id eq knowledge.sourceWithKnowledge.id or source.id eq param.source}"> selected </c:if>>${source.name}</option>
                                </c:forEach>
                            </select>
                        </label>
                    </li>
                    <li>
                        <label class="mid" for="brief_description">Brief description<span class="reference--required" title="Required">*</span>
                            <textarea name="brief_description" id="brief_description" maxlength="200">${knowledge.briefDescription}</textarea>
                        </label>
                        <label class="mid" for="description">Description<span class="reference--required" title="Required">*</span>
                            <textarea name="description" id="description" maxlength="1000">${knowledge.description}</textarea>
                        </label>
                    </li>
                    <li>
                        <label class="mid" for="keywords">Keywords (separated by commas)<span class="reference--required" title="Required">*</span>
                            <input type="text" name="keywords" id="keywords" value="${knowledge.keywords}" />
                        </label>
                        <label class="mid" for="videoUrl">Video URL
                            <input type="text" name="videoUrl" id="videoUrl" value="${knowledge.videoUrl}"/>
                        </label>
                    </li>

                    <li>
                        <h3>Tacit Knowledge Ranking</h3>
                    </li>
                    <li>
                        <fieldset>
                            <legend>Knowledge Reusability</legend>
                            <ol>
                                <li>
                                    <fieldset>
                                        <legend>¿Is this knowledge frequently used?</legend>
                                        <ol>
                                            <label for="reuse">Reuse
                                                <select id="reuse" name="usage_frequency" size="1" title="This knowledge is:">
                                                    <option value="0" <c:if test="${knowledge.usageFrecuency eq 0}">selected</c:if>>Select</option>
                                                    <option value="0" <c:if test="${knowledge.usageFrecuency eq 0}">selected</c:if>>NO USAGE</option>
                                                    <option value="0.25" <c:if test="${knowledge.usageFrecuency eq 0.25}">selected</c:if>>LOW USAGE</option>
                                                    <option value="0.5" <c:if test="${knowledge.usageFrecuency eq 0.5}">selected</c:if>>BASIC USAGE</option>
                                                    <option value="0.75" <c:if test="${knowledge.usageFrecuency eq 0.75}">selected</c:if>>MEDIUM USAGE</option>
                                                    <option value="1" <c:if test="${knowledge.usageFrecuency eq 1}">selected</c:if>>VERY FREQUENT USAGE</option>
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
                            <legend>Knowledge veracity</legend>
                            <ol>
                                <li>
                                    <fieldset>
                                        <legend>¿How well did you solve the problem using the SOURCE's knowledge?</legend>
                                        <ol>
                                            <label for="veracidad">Knowledge Veracity.
                                                <select id="veracidad" name="veracity" size="1" title="Knowledge and its source:" required>
                                                    <option value="0" <c:if test="${knowledge.veracity eq 0}">selected</c:if>>Select</option>
                                                    <option value="0" <c:if test="${knowledge.veracity eq 0}">selected</c:if>>SOURCE DID NOT PROVIDE THE INFORMATION ON HOW TO SOLVE THE PROBLEM</option>
                                                    <option value="0.5" <c:if test="${knowledge.veracity eq 0.5}">selected</c:if>>SOURCE DID NOT PROVIDE THE EXACT INFORMATION ON HOW TO SOLVE THE PROBLEM</option>
                                                    <option value="1" <c:if test="${knowledge.veracity eq 1}">selected</c:if>>SOURCE EXPLAINED CLEARLY THE EXACT INFORMATION ON HOW TO SOLVE THE PROBLEM</option>
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
                            <legend>Resolution time</legend>
                            <ol>
                                <li>
                                    <fieldset>
                                        <legend>¿How long did it take to solve problems using the Knowledge?</legend>
                                        <ol>
                                            <label for="tiemporesolucion">Estimated resolution time
                                                <select id="tiemporesolucion" name="time_to_solved" size="1" title="How much time does it take to apply knowledge successfully?" required>
                                                    <option value="0" <c:if test="${knowledge.timeToSolved eq 0}">selected</c:if>>Select</option>
                                                    <option value="0" <c:if test="${knowledge.timeToSolved eq 0}">selected</c:if>>RESOLUTION TIME TAKES UP TO 24 HOURS</option>
                                                    <option value="0.25" <c:if test="${knowledge.timeToSolved eq 0.25}">selected</c:if>>RESOLUTION TIME TAKES UP TO 16 HOURS</option>
                                                    <option value="0.5" <c:if test="${knowledge.timeToSolved eq 0.5}">selected</c:if>>RESOLUTION TIME TAKES UP TO 4 AND 8 HOURS</option>
                                                    <option value="0.75" <c:if test="${knowledge.timeToSolved eq 0.75}">selected</c:if>>RESOLUTION TIME TAKES UP TO 2 AND 4 HOURS</option>
                                                    <option value="1" <c:if test="${knowledge.timeToSolved eq 1}">selected</c:if>>RESOLUTION TIME TAKES UP 2 HOURS</option>
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
                        <button type="submit">Save</button>
                    </li>
                </ul>
            </form>
        </div><!--.wrapper-->
    </section><!--.content-->

</t:template>
