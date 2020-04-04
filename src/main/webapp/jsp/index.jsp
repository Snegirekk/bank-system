<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
</head>
<body>
    <ul>
        <%--@elvariable id="customers" type="java.util.List<Customer>"--%>
        <c:forEach var="customer" items="${customers}">
            <li>
                <p><c:out value="${customer.firstName} ${customer.lastName}"/></p>

                <ul>
                    <%--@elvariable id="account" type="com.snegirekk.bank_system.entity.Account"--%>
                    <c:forEach var="account" items="${customer.accounts}" varStatus="loop">
                        <li>
                            <p>Account #${loop.count}: <c:out value="${account.amount}"/></p>
                        </li>
                    </c:forEach>
                </ul>
            </li>
        </c:forEach>
    </ul>
</body>
</html>