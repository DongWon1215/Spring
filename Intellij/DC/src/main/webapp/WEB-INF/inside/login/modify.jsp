<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-01
  Time: 오전 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="id" readonly></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>사진</td>
                <td><input type="file" name="photo"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="변경"></td>
            </tr>
        </table>
    </form>
    <form action="/login/withdrawal" method="post">
        <input type="submit" value="회원탈퇴">
    </form>
</body>
</html>
