<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>

        <section class="content">
            <div class="wrapper">
                <ul class="login">
                    <li class="copy">
                        <p><strong>KNOWSHARE</strong>, Intelligent Tacit Knowledge and Information management PaaS (Platform as a Service) for enterprises.
                        </p>
                        <ul>
                            <li>
                                <i style="font-family: FontAwesome; content: \f086" class="fa fa-comments"></i>What is KNOWSHARE?
                                <p style="font-size:12px" >A tool that captures, registers and manages necessary tacit knowledge INTELLIGENTLY in an enterprise environment.</p>
                            </li>
                            <li>
                                <i class="fa fa-cloud"></i>Why KNOWSHARE?
                                <p style="font-size:12px" >KNOWSHARE provides a centralised hub to store valuable enterprise knowledge. Its core utilises an INTELLIGENT multiagent system to organise, sort and filter knowledge, sources and information according to relative critera. Main features include:<br><br>
                                    • Interactive and central problem, knowledge and source directory<br>
                                    • Source and Knowledge Ranking sorted by its relevance<br>
                                    • The service feeds from diverse information provided within the platform.<br>
                            </li>
                                <p style="font-size: 12px; font-weight: bold;">Simply register to the platform with a valid <strong>email address</strong> and <strong>password</strong>.</p>
                            </li>
                            <li>
                                <br><a href="<c:url value='register'/> " class="button--primary">Register</a>
                            </li>
                        </ul>
                    </li>
                    <li class="form">
                        <form id="login" class="forms" method="post" action="<c:url value="login"/>">
                            <ul>
                                <li>
                                    <label for="username">Username<span class="reference--required" title="Required">*</span>
                                        <input type="text" name="username" id="username" title="Username is requered." required />
                                    </label>
                                </li>
                                <li>
                                    <label for="password">Password<span class="reference--required" title="Required">*</span>
                                        <input type="password" name="password" id="password" minlength="5" title="Password is required, and it should at least be 5 characters long." required />
                                    </label>
                                </li>
                                <li class="clearfix">
                                    <button type="submit">Enter</button>
                                </li>
                            </ul>
                        </form>
                    </li>
                </ul>
            </div><!--.wrapper -->
        </section><!--.content-->
</t:template>
