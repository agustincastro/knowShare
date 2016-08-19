<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>

        <section class="content">
            <div class="wrapper">
                <ul class="login">
                    <li class="copy">
                        <p><strong>KNOWSHARE CHNAAAGEEEEEE</strong>, la Plataforma para el manejo de Conocimientos Tácitos de su Organización.
                        </p>
                        <ul>
                            <li>
                                <i style="font-family: FontAwesome; content: \f086" class="fa fa-comments"></i>¿Qué es GESTAC?
                                <p style="font-size:12px" >Es un un programa que permite capturar, registrar y gestionar conocimientos tácitos necesarios para el logro de los objetivos empresariales.</p>
                            </li>
                            <li>
                                <i class="fa fa-cloud"></i>¿Qué es la Plataforma?
                                <p style="font-size:12px" >La plataforma GESTAC permite la volatilidad de los conocimientos registrados y sus permanentes cambios, es flexible frente a la eventual modificación de los conocimientos y/o su sustitución por otros conocimientos.  Evalua en situaciones empresariales reales mediante un sistema multi-agente. GESTAC comprende varias funcionalidades:<br><br>
                                    • Un directorio interactivo de conocimientos y fuentes de conocimientos<br>
                                    • Ponderacion de fuentes y del conocimiento que se brindo a la plataforma<br>
                                    • Funcionalidades de alta, baja y modificacion de los distintos objetos que se utilizaran como insumos en la pltaforma.
                            </li>
                                <p style="font-size: 12px; font-weight: bold;">Registrese en la plataforma simplemente con un <strong>e-mail</strong> y <strong>contraseña</strong> adecuada.</p>
                            </li>
                            <li>
                                <br><a href="<c:url value='register'/> " class="button--primary">Registrarse</a>
                            </li>
                        </ul>
                    </li>
                    <li class="form">
                        <form id="login" class="forms" method="post" action="<c:url value="login"/>">
                            <ul>
                                <li>
                                    <label for="username">Nombre de Usuario<span class="reference--required" title="Requerido">*</span>
                                        <input type="text" name="username" id="username" title="Este campo es requerido." required />
                                    </label>
                                </li>
                                <li>
                                    <label for="password">Contraseña<span class="reference--required" title="Requerido">*</span>
                                        <input type="password" name="password" id="password" minlength="5" title="Este campo es requerido, y debe tener al menos 5 caracteres." required />
                                    </label>
                                </li>
                                <li class="clearfix">
                                    <button type="submit">Ingresar</button>
                                </li>
                            </ul>
                        </form>
                    </li>
                </ul>
            </div><!--.wrapper -->
        </section><!--.content-->
</t:template>
