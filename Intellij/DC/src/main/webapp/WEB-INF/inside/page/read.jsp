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
    <!--bootstrap.css--><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
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
            <td><textarea rows="40" cols="120" style="resize : none"  name="context" readonly>${post.content}</textarea> </td>
        </tr>
    </table>
    <a href="/page/main">목록</a>
    <c:if test="${loginInfo ne null}">
        <a href="/page/modify?index=${param.index}">수정/삭제</a>
    </c:if>

    <div class="comment">
        <form action="/comment/" method="post">
            <div class="fl">
            <input type="text" name="id" placeholder="이름" style="vertical-align: ">
            <input type="text" name="password" laceholder="비밀번호">
            </div>
            <textarea rows="3" cols="50" style="resize: none" name="context"></textarea>

            <input type="submit" value="작성">
        </form>
    </div>
<div class="container">
    <div class="form-group">
        <form method="post" enctype="multipart/form-data" action="/commentAdd.jsp?"
    </div>
</div>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>
