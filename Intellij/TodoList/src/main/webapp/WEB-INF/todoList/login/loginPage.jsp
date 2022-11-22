<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-17
  Time: 오후 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 페이지</h1>
<form method="post">
<table>
    <tr>
        <td>아이디</td>
        <td><input type="text" name="userId" id="userId"></td>
    </tr>
    <tr>
        <td>비밀번호</td>
        <td><input type="password" name="userPw" id="userPw"></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="로그인"></td>
    </tr>
    <tr>
        <td></td>
        <td><a href="/login/memberRegisterPage">회원가입</a></td>
    </tr>
</table>
</form>
</body>
</html>
