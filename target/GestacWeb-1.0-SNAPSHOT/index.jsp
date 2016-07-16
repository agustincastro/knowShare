<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>

    <jsp:attribute name="header">
        <!-- Page specific JS / CSS  -->
        <script src="<c:url value='/static/js/index.js'/>" type="text/javascript" ></script>
    </jsp:attribute>

    <jsp:body>
        <t:nav/>
        <section class="content">
            <!-- /Cuerpo de ventana-------------------------->
            <div class="wrapper">

                <c:if test="${requestScope.UNSOLVED_PROBLEMS && sessionScope.LOGGED_USER_TYPE eq 'SOURCE'}">
                    <div>
                        <h3>Problemas sin resolver</h3>
                        <ul class="items-list clearfix">

                            <li class="item-box">
                                <div  style="color:rgb(255, 0, 71)" class="item-box__visual">
                                    <i class="fa fa-warning fa-5x"></i>
                                </div>
                                <!-- /<div class="item-box__visual">
                                                  <img src="problemas_nuevos.jpg" alt />
                                </div>
                                    <!-- / Item box visual -->
                                <div class="item-box__content">
                                    <h4 class="item-box__title">Existen Problemas sin resolver</h4>
                                    <p class="item-box__description">El sistema presenta problemas sin resolver, la fuente que posea el concimiento para resolver los mismos obtendra una mejor ponderación.</p>
                                </div>
                                <!-- / Item box content -->
                                <div class="item-box__actions">
                                    <a class="item-box__actions__more" href="<c:url value='/problems-to-solve'/>">Ver detalles</a>
                                </div>
                                <!-- Item box actions -->
                            </li>
                        </ul>
                    </div>
                </c:if>

                <div id="knowledges-to-improve" class="hidden">
                    <h3>Conocimientos a mejorar</h3>
                    <ul class="items-list clearfix">

                        <li class="item-box">
                            <div  style="color:rgb(255, 0, 71)" class="item-box__visual">
                                <i class="fa fa-warning fa-5x"></i>
                            </div>
                            <!-- /<div class="item-box__visual">
                                              <img src="problemas_nuevos.jpg" alt />
                            </div>
                                <!-- / Item box visual -->
                            <div class="item-box__content">
                                <h4 class="item-box__title">Existen conocimientos a mejorar</h4>
                                <p class="item-box__description">El sistema presenta conocimientos que usted puede mejorar.</p>
                            </div>
                            <!-- / Item box content -->
                            <div class="item-box__actions">
                                <a class="item-box__actions__more" href="<c:url value='/knowledges-to-improve'/>">Ver detalles</a>
                            </div>
                            <!-- Item box actions -->
                        </li>
                    </ul>
                </div>


                <div>
                    <h3>Conocimientos Favoritos</h3>
                    <ul class="items-list clearfix">
                        <c:forEach items="${requestScope.KNOWLEDGES_LIST}" var="knowledge">
                            <li   class="item-box">
                                <div style="color:rgb(32,178,170)" class="item-box__visual">
                                    <i class="fa fa-book fa-5x"></i>
                                </div>
                                <!-- / Item box visual -->
                                <div class="item-box__content">
                                    <h4 class="item-box__title">${knowledge.title}</h4>
                                    <p class="item-box__description">${knowledge.briefDescription}</p>
                                </div>
                                <!-- / Item box content -->
                                <div class="item-box__actions">
                                    <a class="item-box__actions__more" href="<c:url value='rateknowledge?id=${knowledge.id}'/>">Ver detalles</a>
                                </div>
                                <!-- Item box actions -->
                            </li>
                        </c:forEach>
                    </ul>

                    <!-- Items List -->
                    <h3>Fuentes con mejor Calificacion</h3>
                    <ul class="items-list clearfix">
                        <c:forEach items="${requestScope.SOURCES_LIST}" var="source">
                            <li class="item-box">
                                <div style="color:rgb(255, 69, 0)" class="item-box__visual">
                                    <i class="fa fa-user fa-5x"></i>
                                    <!--<img src="fuente_conocimiento_tacito_comun_favorito.jpg" alt />  -->
                                </div>
                                <!-- / Item box visual -->
                                <div class="item-box__content">
                                    <h4 class="item-box__title"><c:out value="${source.name}"/></h4>
                                    <p class="item-box__description"><c:out value="${source.description}"/></p>
                                </div>
                                <!-- / Item box content -->
                                <div class="item-box__actions">
                                    <a class="item-box__actions__more" href="<c:url value='editsource?id=${source.id}'/>">Ver detalles</a>
                                </div>
                                <!-- Item box actions -->
                            </li>
                        </c:forEach>
                        <!-- / Wrapper -->
                    </ul>
                </div>
            </div>
        </section>

        <c:if test="${not empty requestScope.LOGGED_USER_ID}">
            <script>
                $(document).ready(function(){

                    var checkKnowledgesToImprove = function(){
                        $.ajax({
                            url: "rest/knowledges/improve/${requestScope.LOGGED_USER_ID}",
                            data: {},
                            success: function(response){

                                if(response.knowledges.length > 0){
                                    $("#knowledges-to-improve").show();

                                }else{
                                    $("#knowledges-to-improve").hide();
                                }
                            },
                            dataType: 'json'
                        });
                    }

                    checkKnowledgesToImprove();

                    setInterval(function(){

                           checkKnowledgesToImprove();

                    }, 30000);


                });

            </script>
        </c:if>
    </jsp:body>
</t:template>

