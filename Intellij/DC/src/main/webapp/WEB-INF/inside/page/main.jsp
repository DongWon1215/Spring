<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-01
  Time: 오전 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
    <form action="/login/modify" method="post">
        <input type="submit" value="회원 정보 수정">
    </form>
</c:if>

<table>
    <tr>
        <td>번호</td>
        <td>제목</td>
        <td>작성자</td>
        <td>조회수</td>
    </tr>

    <c:forEach var="post" items="${postList}" varStatus="status">
        <tr>
            <td>${post.postIndex}</td>
            <td><a href="/page/read?index=${post.postIndex}">${post.postTitle}</a></td>
            <td>${post.postWriter}</td>
            <td>${post.postViews}</td>
        </tr>
    </c:forEach>
</table>
    <form action="/page/write" method="get">
        <input type="submit" value="글쓰기">
    </form>

</body>
</html>
