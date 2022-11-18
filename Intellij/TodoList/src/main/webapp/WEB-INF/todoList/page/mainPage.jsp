<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-17
  Time: 오후 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${title}</h1>

<table>
    <tr>
        <td>번호</td>
        <td>할일</td>
        <td>기간</td>
        <td>완료여부</td>
    </tr>

    <c:forEach var="todo" items="${todoList}" varStatus="stat">
        <tr>
            <td>${todo.tno} / ${stat.count}</td>
            <td><a href="/todo/read?tno=${todo.tno}">${todo.todo}</a></td>
            <td>${todo.dueDate}</td>
            <td>${todo.finished ? '완료' : '진행중'}</td>
        </tr>
    </c:forEach>



</table>


<a href="/todo/register">Todo 등록하기</a>
</body>
</html>
