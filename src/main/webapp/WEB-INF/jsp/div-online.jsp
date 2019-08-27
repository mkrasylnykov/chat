<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>

<p><font id=isonline><fmt:message key="label.monline"/></font></p>

<c:forEach items="${users}" var="user">
    <br><font id=isnuser><fmt:message key="label.muser"/> <c:out value="${user.username}"/></font>
</c:forEach>

<p><fmt:message key="label.mtotalUsers"/> ${users.size()}</p>