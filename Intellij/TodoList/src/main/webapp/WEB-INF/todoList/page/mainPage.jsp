<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-17
  Time: 오후 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- bootstrap.css>
</head>
<body>
<h1>${title}</h1>


<c:if test="${loginInfo ne null}">
    ${loginInfo.userId}
    ${loginInfo.userName}
    <img src="uploadfile/user/${loginInfo.userPhoto}">
    <form action="/logout" method="post">
    <a href="/logout">로그아웃</a>
    </form>
    <form action="/withdrawal" method="post">
        <input type="submit" value="회원탈퇴">
    </form>
</c:if>

<table>
    <tr>
        <td>번호</td>
        <td>할일</td>
        <td>기간</td>
        <td>완료여부</td>
    </tr>

    <c:forEach var="todo" items="${todoList}" varStatus="status">
        <tr>
            <td>${todo.index}</td>
            <td><a href="/page/read?index=${todo.index}">${todo.title}</a></td>
            <td>${todo.dueDate}</td>
            <td>${todo.finish ? '완료' : '진행중'}</td>
        </tr>
    </c:forEach>

</table>


<a href="/page/regist">Todo 등록하기</a>
</body>
</html>
