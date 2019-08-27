<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${um}" var="umes">
    <br/><font id=t> <c:out value="${umes.time}"/> </font> &nbsp; <font id=n><c:out value="${umes.name}"/></font> &nbsp; <c:out value="${umes.message}" escapeXml="false"/>
</c:forEach>
