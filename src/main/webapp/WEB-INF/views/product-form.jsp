<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management</title>
</head>
<body>
<h1>Product Management</h1>
<h2>
    <c:if test="${product != null}">Edit Product</c:if>
    <c:if test="${product == null}">Add New Product</c:if>
</h2>
<form action="<c:if test="${product != null}">update</c:if><c:if test="${product == null}">insert</c:if>" method="post">
    <c:if test="${product != null}">
        <input type="hidden" name="id" value="${product.id}" />
    </c:if>
    <table border="1">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${product.name}" /></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price" value="${product.price}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>