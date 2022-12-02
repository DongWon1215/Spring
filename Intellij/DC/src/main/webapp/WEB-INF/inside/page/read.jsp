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
            <td><input type="text" name="title" value="${post.title}" readonly> </td>
            <td>${post.views} </td>
        </tr>
        <tr>
            <td>${post.writer} </td>
        </tr>
        <tr>
            <td></td>
            <td><textarea rows="60" cols="150" style="resize : none"  name="context" readonly>${post.content}</textarea> </td>
        </tr>
    </table>
    <a href="/page/main">목록</a>
    <c:if test="${loginInfo ne null}">
        <a href="/page/modify?index=${param.index}">수정/삭제</a>
    </c:if>

<div class="container">
    <div class="form-group">
        <form method="post" enctype="multipart/form-data" action="/commentAdd.jsp?"
    </div>
</div>

</body>
</html>
