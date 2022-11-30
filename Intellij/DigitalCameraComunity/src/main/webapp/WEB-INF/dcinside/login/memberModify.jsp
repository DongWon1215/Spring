<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-28
  Time: 오전 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원 정보 변경</h1>
<hr>
<form method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="userId" readonly></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="userPw"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>사진</td>
            <td><input type="file" name="userPhoto"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="변경"></td>
        </tr>
    </table>
</form>

</body>
</html>
