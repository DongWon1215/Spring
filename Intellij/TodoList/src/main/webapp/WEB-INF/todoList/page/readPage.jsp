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
        <td><input type="text" name="index" value="${param.index}" readonly></td>
    </tr>
    <tr>
        <td>할일 </td>
        <td><input type="text" name="title" value="${todoList.title}" readonly> </td>
    </tr>
    <tr>
        <td>기한 </td>
        <td><input type="date" name="dueDate" value="${todoList.dueDate}" readonly> </td>
    </tr>
    <tr>
        <td>상태 </td>
        <td><input type="checkbox" name="finish" ${todoList.finish ? 'checked' : '' } > </td>
    </tr>
</table>

<form action="" method="post">
<a href="/page/modify?index=${param.index}">Modify/Remove</a> <a href="/page/main">Todo List</a>
</form>
</body>
</html>
