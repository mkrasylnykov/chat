<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="chrome=1" />
        <meta name="keywords" content="chat" />
        <meta name="description" content="chat" />

        <title><fmt:message key="label.welcome" /></title>
        <link id="icon1" rel="shortcut icon" type="image/x-icon" href="img/tc.ico" />
        <link id="icon2" rel="icon" type="image/x-icon" href="img/tc.ico" />
        <link href="style/style.css" rel="stylesheet" type="text/css">

        <script type="text/javascript" src="script/jquery-1.6.1.js"></script>
        <script type="text/javascript" src="script/login-script.js"></script>
    </head>

    <body>
        <div id="main_login">
            <div id="splash">
                <form action="<c:url value="/j_spring_security_check" />" method="POST" id="splash_form" name="splash_form" onsubmit="if (!chek_login()) {return false;};">
                    <div class="login_info_panel">
                        <div id="login_form">
                            <span id="username_label"><fmt:message key="label.username" /></span>
                            <input type="text" name="j_username" id="login_username" />
                            <br />
                            <span id="password_label"><fmt:message key="label.password" /></span>
                            <input type="password" name="j_password" id="login_password" />

                            <div id="reg_new_user" onclick="window.open('register.htm', 'new')">
                                <fmt:message key="label.registernewuser" />
                            </div>
                            <div id="forgot_password" onclick="forgot_password()">
                                <fmt:message key="label.forgotpassword" />
                            </div>
                        </div>
                        <div id="remember_me">
                            <input type="checkbox" id="splash_rememberme" name="_spring_security_remember_me" />
                            <label for="remember_me"><fmt:message key="label.rememberme" /></label>
                        </div>
                    </div>

                    <div class="login_b_panel">
                        <div class="login_div_submit">
                            <input type="image" src="img/button2.gif" name="submit" class="login_b_submit" />
                        </div>
                    </div>
                </form>
            </div>

            <div id="footer">
                <c:if test="${not empty param.error}">
                    <font color="red"> Error: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
                </c:if>
            </div>
        </div>
    </body>
</html>
