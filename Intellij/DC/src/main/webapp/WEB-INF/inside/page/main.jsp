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
<div id="loginBox">
<c:if test="${loginInfo eq null}">
    <a href="/login/login">로그인</a>
</c:if>

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
</div>
<%@ include file="/WEB-INF/inside/page/list.jsp"%>

    <form action="/page/write" method="get">
        <input type="submit" value="글쓰기">
    </form>


<%--<c:if test="${postList.size()/10 > 1}">--%>
<%--    <nav aria-label="...">--%>
<%--        <ul class="pagination">--%>
<%--                <c:choose>--%>
<%--                    <c:when test="">--%>
<%--                    <li class="page-item disabled">--%>
<%--                        <span class="page-link" href="#" tabindex="-1" aria-disabled="false">Previous</span>--%>
<%--                    </li>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <li class="page-item">--%>
<%--                        <span class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</span>--%>
<%--                        </li>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>
<%--            <c:forEach var="" items="" begin="" end="">--%>
<%--                <c:if test="">--%>
<%--                    <li class="page-item active" aria-current="page">--%>
<%--                        <span class="page-link">2</span>--%>
<%--                    </li>--%>
<%--                </c:if>--%>
<%--            <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--            </c:forEach>--%>
<%--            <c:choose>--%>
<%--                <c:when test="">--%>
<%--                    <li class="page-item disabled">--%>
<%--                        <span class="page-link" href="#" tabindex="+1" aria-disabled="false">Next</span>--%>
<%--                    </li>--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <li class="page-item">--%>
<%--                        <span class="page-link" href="#" tabindex="+1" aria-disabled="true">Next</span>--%>
<%--                    </li>--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
<%--        </ul>--%>
<%--    </nav>--%>
<%--</c:if>--%>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"/>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"/>
<script src="https://unpkg.com/axios/dist/axios.min.js"/>
</body>
</html>
