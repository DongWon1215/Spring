<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-01
  Time: 오전 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Post Modify</h1>
<form method="post">
    <table>
        <tr>
            <td></td>
            <td><input type="text" name="title" value="${post.title}" readonly> </td>
        </tr>
        <tr>
            <td></td>
            <td><textarea rows="60" cols="150" style="resize : none" name="content">${post.content}</textarea> </td>
        </tr>
        <tr>
            <td><input type="hidden" name="password" value="${post.password}"></td>
            <td>
                <input type="reset">
                <input type="submit" value="수정">
            </td>
        </tr>
    </table>
</form>
<!-- Vertically centered modal -->
<div class="modal-dialog modal-dialog-centered">
    ...
</div>

<!-- Vertically centered scrollable modal -->
<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
    ...
</div>
<form action="/page/delete" method="post" >
    <input type="hidden" name="index" value="${param.index}">
    <input type="submit" value="삭제">
</form>
</body>
</html>
