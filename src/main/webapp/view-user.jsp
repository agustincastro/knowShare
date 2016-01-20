
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="user" value="${requestScope.USER}"/>

<t:template>
    <t:nav/>
 
    <section class="content">
        <!--Carga de datos para nuevo Usuario Fuente-->
        <div class="wrapper">
        <h3><i class="fa fa-user fa-2x"></i> :: :: Datos de la Fuente</h3>

            <!--
        <form class="forms" id="datosPersonales" enctype="multipart/form-data" method="post" action="people-information_w.w">
        -->

            <div>
                <label class="mid" for="nombre">Nombres
                    <a>${user.name}</a>
                </label>
                <br/>
                <label class="mid" for="apellido">Apellidos
                    <a>${user.lastName}</a>
                </label>
                <br/>
                <label for="email">Email
                    <a>${user.email}</a>
                </label>
            </div>
                <!--
                <li>
                    <label class="mid" for="cargo">Cargo<span class="reference--required" title="Requerido">*</span>
                         <a> poner cargo </a>
                    </label>
                    <label class="mid" for="area"> Área<span class="reference--required" title="Requerido">*</span>
                         <a> poner area </a>

                    </label>
                </li>
                <li>
                    <label class="mid" for="comunidad">Comunidad<span class="reference--required" title="Requerido">*</span>
                     <a> poner comunidad </a>

                    </label>
                </li>
                -->


    </ul>

    <!------------------------------
            <ul>
                                        <li>
                                            <label class="mid" for="tel1">Teléfono
                                                    <a> poner telefono </a>
                                            </label>
                                            <label class="mid" for="tel2">Móvil<span class="reference--required" title="Requerido">*</span>
                                                    <a> poner celular </a>
                                            </label>
                                        </li>


                                        <li>
                                            <label class="mid" for="social1">Más Info. en Red social
                                                   <a> poner linkedin </a>
                                            </label>

                                        </li>
                                            <li>
                                            <label for="pais">País<span class="reference--required" title="Requerido">*</span>
                                                <a> nombre del pais</a>
                                            </label>
                                            </li>
    <li>
        <label for="provincia">Departamento, Provincia o Estado<span class="reference--required" title="Requerido">*</span>
            <a> poner departamento o provincia </a>
        </label>
    </li>

            </ul>
    <fieldset>
      <ul>
                <h3>Reporte sobre la Fuente</h3>
                <div>
                    <span class="item-view__label">Nivel de Experiencia Previa Interaccion con equipos de Trabajo</span>
                    <a>Aqui va % que indica dicho valor</a>
                </div>
                <div>
                    <span class="item-view__label">Nivel de Conocimientos en su área</span>
                    <a>Aqui va % que indica dicho valor</a>
                </div>
                <div>
                    <span class="item-view__label">Nivel o grado de posicionamiento dentro de la comunidad GESTAC</span>
                    <a>Aqui va % que indica dicho valor</a>
                </div>
                <div>
                    <span class="item-view__label">Nivel de intuicion o grado con el que interactua con el restode las fuentes</span>
                    <a>Aqui va % que indica dicho valor</a>
                </div>
                </ul>

    </fieldset>
    --->
            <!--
        </form>
        -->

        </div><!--.wrapper-->
        </section>

</t:template>
