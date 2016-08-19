<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>

        <section class="content">
            <div class="wrapper">
                <ul class="login">
                    <li class="copy">
                         <p>Bienvenidos a <strong>GESTAC</strong>, la Plataforma para el manejo de Conocimientos Tácitos de su Organización.
                         </p>
                        <ul>
                            <li>
                                <i style="font-family: FontAwesome; content: \f086" class="fa fa-comments"></i>¿Qué es GETAC?
                                <p style="font-size:12px" >Es un un programa de permite capturar, registrar y gestionar conocimientos tácitos que necesarios para el logro de los objetivos empresariales.</p>
                            </li>
                            <li>
                                <i class="fa fa-cloud"></i>¿Qué es la Plataforma?
                                <p style="font-size:12px" >
                                    La plataforma GESTAC permite la volatilidad de los conocimientos registrados y sus permanentes cambios, es flexible frente a la eventual modificación de los conocimientos y/o su sustitución por otros conocimientos.  Evalua en situaciones empresariales reales mediante un sistema multi-agente. GESTAC comprende varias funcionalidades:
                                    <br/><br/>
                                    • Un directorio interactivo de conocimientos y fuentes de conocimientos<br>
                                    • Ponderacion de fuentes y del conocimiento que se brindo a la plataforma<br>
                                    • Funcionalidades de alta, baja y modificacion de los distintos objetos que se utilizaran como insumos en la pltaforma.
                                </p>
                            </li>
                            <li>
                                <i class="fa fa-users"></i>¿Quiere entrar como un usuario anonimo?
                                <p style="font-size:12px">Utilice el <strong>usuario</strong>: usuario y <strong>password</strong>: usuario para ingresar a ver de que trata la plataforma. Recuerde que con este usuario no podrá utilizar ninguna funcionalidad. Para poder utilizar la misma debe registrarse.</p>
                                <p style="font-size: 12px; font-weight: bold;">Registrece en la plataforma simplemente con un <strong>e-mail</strong> y <strong>contraseña</strong> adecuada.</p>
                            </li>
                             <li>
                                <br><a href="<c:url value='register'/>" class="button--primary">Registrarse</a>
                            </li>
                        </ul>
                    </li>
                    <li class="form">
                        <ul>
                            <li class="form">
                                <form id="register" class="forms" method="post" action="<c:url value='register'/> ">
                                    <ul>
                                        <li>
                                            <label for="name">Nombre<span class="reference--required" title="Requerido">*</span>
                                                    <input type="text" name="name" id="name" title="Este campo es requerido." required />
                                            </label>
                                        </li>
                                        <li>
                                            <label for="last-name">Apellido<span class="reference--required" title="Requerido">*</span>
                                                    <input type="text" name="last-name" id="last-name" title="Este campo es requerido." required />
                                            </label>
                                        </li>
                                        <li>
                                            <label for="email">Correo electrónico<span class="reference--required" title="Requerido">*</span>
                                                    <input type="email" name="email" id="email" required />
                                            </label>
                                        </li>
                                        <li>
                                            <label for="confirm-email">Confirmar correo electrónico<span class="reference--required" title="Requerido">*</span>
                                                    <input type="email" name="confirm-email" id="confirm-email" equalto="#email" title="Este campo es requerido, y el contenido debe coincidir con el de 'correo electrónico'." required />
                                            </label>
                                        </li>
                                        <li>
                                            <label for="password">Contraseña<span class="reference--required" title="Requerido">*</span>
                                                    <input type="password" name="password" id="password" minlength="5" title="Este campo es requerido, y debe tener al menos 5 caracteres." required />
                                            </label>
                                        </li>
                                        <li>
                                            <label for="confirm-password">Confirmar contraseña<span class="reference--required" title="Requerido">*</span>
                                                    <input type="password" name="confirm-password" id="confirm-password" minlength="5" equalto="#password" title="Este campo es requerido, y el contenido debe coincidir con el de 'contraseña'." required />
                                            </label>
                                        </li>
                                        <li class="clearfix">
                                            <a href="recover-password.html">¿Ya está registrado?</a>
                                            <button type="submit">Registrarse</button>
                                        </li>
                                        <li>
                                            <p>Al registrarse usted está aceptando nuestra <a href="legal.jsp">política de uso y privacidad</a>.</p>
                                        </li>
                                    </ul>
                                </form>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div><!--.wrapper -->
        </section><!--.content-->
</t:template>