<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Регистрация</title>

        <style type="text/css" media="all">
            @import url(style/style.css);
        </style>

        <script type="text/javascript" src="script/jquery-1.6.1.js"></script>
        <script type="text/javascript" src="script/reg-script.js"></script>
    </head>

    <body>
        <div id="main_reg">
            <div id="reg_form">
                <form method="POST" name="registration" onsubmit="if (!reg_submit_chk()) {return false;};" id="registration" action="register.htm">
                    <span class="reg_title">Регистрация нового пользователя</span>

                    <div class="reg_top">
                        <div class="reg_f_left">
                            <p>Логин:</p>
                            <p>Пароль:</p>
                            <p>Повторите пароль:</p>
                            <p>Ваш E-Mail:</p><br />
                        </div>
                        <div class="reg_f_right">
                            <p>
                                <input name="name" id="name" style="width: 165px;" class="reg_f_input" type="text" />
                                <input type="button" class="b_reg_check" title="Проверить доступность логина для регистрации" onclick="if (!reg_login_chk()) {return false;};" value="Проверить имя"/>
                            </p>
                            <p>
                                <input name="password1" class="reg_f_input" type="password" />
                            </p>
                            <p>
                                <input name="password2" class="reg_f_input" type="password" />
                            </p>
                            <p>
                                <input name="email" class="reg_f_input" type="text" />
                            </p>
                        </div>
                    </div>
                    <div class="reg_info">
                        <c:if test="${not empty userMess}">
                            <font color = #FF0000>&bull; <c:out value="${userMess}"/></font></br>
                        </c:if>
                    </div>
                    <div class="reg_bot">
                        <input type="submit" class="b_reg_send" value="Отправить" title="Отправить данные на сервер"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
