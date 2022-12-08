<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-05
  Time: 오전 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>

<table>
    <tr>
        <td>번호</td>
        <td>제목</td>
        <td>작성자</td>
        <td>조회수</td>
    </tr>

    <c:forEach var="post" items="${postList}" varStatus="status" begin="${beginPost}">
        <tr>
            <td>${post.index}</td>
            <td><a href="/page/read?index=${post.index}">${post.title}<c:if test="${post.commentnum > 0}">
                <small><b style="color: red">[&nbsp;<c:out value="${post.commentnum}" />&nbsp;]</b></small>
                </c:if></a></td>
            <td>${post.writer}</td>
            <td>${post.views}</td>
        </tr>
    </c:forEach>
</table>
<nav aria-label="Page navigation">
    <ul class="pagination justify-content-center">
        <c:if test="${page.isPrevExist}">
            <li class="page-item">
                <span class="page-link" href="${post.startpage - 1}">Previous</span>
            </li>
        </c:if>
        <li class="page-item"><a class="page-link" href="#">1</a></li>

        <c:forEach var = "index" items="${post.list}" varStatus="status">
            <c:choose>
                <c:when test="">
                    <li class="page-item active" aria-current="page">
                        <span class="page-link">${status.index + 1}</span>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="/main/list?p=${status.index + 1}">${status.index + 1}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${page.isNextExist}">
            <li class="page-item">
                <a class="page-link" href="${post.endPage + 1}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>
