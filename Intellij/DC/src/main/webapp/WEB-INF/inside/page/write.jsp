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
<form method="post">
    <table>
        <c:if test="${loginInfo eq null}">
            <tr>
                <td>작성자</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="password"></td>
            </tr>
        </c:if>

        <tr>
            <td>제목</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea rows="60" cols="150" style="resize : none" name="content"></textarea></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="reset">
                <input type="submit" value = "register">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
