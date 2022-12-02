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
    <!--bootstrap.css--><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<h1>${title}</h1>


<c:if test="${loginInfo ne null}">
    ${loginInfo.userId}
    ${loginInfo.nickName}
    <c:if test="${loginInfo.photo ne null}">
        <img src="/uploadfile/profile/${loginInfo.photo}" width="50" height="50">
    </c:if>
    <form action="/logout" method="post">
        <a href="/logout">로그아웃</a>
    </form>
    <form action="/login/modify">
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
            <td>${post.index}</td>
            <td><a href="/page/read?index=${post.index}">${post.title}</a></td>
            <td>${post.writer}</td>
            <td>${post.views}</td>
        </tr>
    </c:forEach>
</table>
    <form action="/page/write" method="get">
        <input type="submit" value="글쓰기">
        <c:if test="${loginInfo eq null}">
            <a href="/login/login">로그인</a>
        </c:if>
    </form>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>
