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

<h1>Todo Modify</h1>
<form method="post">
    <table>
        <tr>
            <td>번호</td>
            <td><input type="text" name="index" value="${todo.titleNo}" readonly></td>
        </tr>
        <tr>
            <td>할일 </td>
            <td><input type="text" name="title" value="${todo.todoTitle}" > </td>
        </tr>
        <tr>
            <td>기한 </td>
            <td><input type="date" name="dueDate" value="${todo.dueDate}" > </td>
        </tr>
        <tr>
            <td>상태 </td>
            <td><input type="checkbox" name="finish" ${todo.finished ? 'checked' : ''} > </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="reset">
                <input type="submit" value="Modify">
            </td>
        </tr>
    </table>
</form>

<form action="/todolist/remove" method="post" >
    <input type="hidden" name="tno" value="${todo.titleNo}">
    <input type="submit" value="Remove">
</form>

<a href="/todolist/todolist">Todo List</a>

</body>
</html>
