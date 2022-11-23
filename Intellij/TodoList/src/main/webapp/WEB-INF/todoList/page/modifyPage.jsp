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
            <td><input type="text" name="index" value="${param.index}" readonly></td>
        </tr>
        <tr>
            <td>할일 </td>
            <td><input type="text" name="title" value="${todoList.title}" > </td>
        </tr>
        <tr>
            <td>기한 </td>
            <td><input type="date" name="dueDate" value="${todoList.dueDate}" > </td>
        </tr>
        <tr>
            <td>상태 </td>
            <td><input type="checkbox" name="finish" ${todoList.finish ? 'checked' : ''} > </td>
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

<form action="/page/delete" method="post" >
    <input type="hidden" name="index" value="${param.index}">
    <input type="submit" value="Remove">
</form>

<a href="/page/main">Todo List</a>

</body>
</html>
