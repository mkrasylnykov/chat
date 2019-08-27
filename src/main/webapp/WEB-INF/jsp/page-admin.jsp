<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css" media="all">
            @import url(style/style.css);
        </style>
        <title>Admin page</title>
    </head>
    <body>
        <div class="adm_msg">
            <c:out value="${resp_msg}"/>
        </div>
        <div class="adm_commands">
            <a href="adminpage.htm?command=del_all_msg">Удалить все сообщения</a>
        </div>
    </body>
</html>
