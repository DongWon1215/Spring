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
    <!--bootstrap.css--><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
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
            <td><textarea rows="40" cols="120" style="resize : none" name="content">${post.content}</textarea> </td>
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
</form><script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>
