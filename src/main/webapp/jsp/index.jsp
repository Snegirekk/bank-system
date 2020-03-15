<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
</head>
<body>
    <ul>
        <%--@elvariable id="customers" type="java.lang.Iterable<Customer>"--%>
        <c:forEach var="customer" items="${customers}">
            <li><c:out value="${customer.firstName} ${customer.lastName}"/></li>
        </c:forEach>
    </ul>
</body>
</html>