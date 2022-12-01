<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-01
  Time: 오전 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td><input type="text" name="title" value="${postList.postTitle}" readonly> </td>
        </tr>
        <tr>
            <td>${postList.postWriter}} </td>
            <td>${postList.postViews}} </td>
        </tr>
        <tr>
            <td>상태 </td>
            <td><textarea name="context" ${postList.postContent} readonly > </td>
        </tr>
    </table>
    <c:if test="${loginInfo eq null}">
        <a href="/page/modify?index=${param.index}">Modify/Remove</a> <a href="/page/main">Todo List</a>
        $("
    </c:if>

</body>
</html>
