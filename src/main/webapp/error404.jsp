<%-- 
    Document   : error
    Created on : Sep 8, 2011, 4:03:52 PM
    Author     : mkrasilnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Страница не найдена!</title>
    </head>
    <body>
        <h1>Запрашиваемая страница не найдена.</h1>
        <br /><br />
        Если Вы видите это сообщение, это значит, что по Вашему запросу не была найдена страница.<br />
        Сейчас произойдет автоматический переход на главную страницу.<br /><br />
        <img src="img/face/eror-404.jpg" alt="error 404"/>
        
        <script type="text/javascript">
            function locs(){
                document.location.href="loginpage.htm";
            }
            setTimeout("locs()", 5000);
        </script>
    </body>
</html>
