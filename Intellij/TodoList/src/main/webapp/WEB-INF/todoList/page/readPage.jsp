<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-17
  Time: 오후 4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <td>번호</td>
        <td><input type="text" name="tno" value="${param.titleNo}" readonly></td>
    </tr>
    <tr>
        <td>할일 </td>
        <td><input type="text" name="todo" value="${todo.todoTitle}" readonly> </td>
    </tr>
    <tr>
        <td>기한 </td>
        <td><input type="date" name="dueDate" value="${todo.dueDate}" readonly> </td>
    </tr>
    <tr>
        <td>상태 </td>
        <td><input type="checkbox" name="finished" ${todo.finished ? 'checked' : ''} > </td>
    </tr>
</table>

<a href="/todolist/modify?tno=${param.titleNo}">Modify/Remove</a> <a href="/todolist/todolist">Todo List</a>
</body>
</html>
