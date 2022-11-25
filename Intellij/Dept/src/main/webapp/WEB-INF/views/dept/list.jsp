<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-24
  Time: 오후 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Dept List</h1>
<hr>

    <a href="/dept/register">부서 등록</a>

    <div>
        <form>
            검색
            <select name="searchType">
                <option value="dname">부서이름</option>
                <option value="loc">부서위치</option>
            </select>
            <input type="text" name="keyword">
            <input type="submit" value="검색">
        </form>
    </div>

<table border="1">
    <tr>
        <th>부서 번호</th>
        <th>부서 이름</th>
        <th>부서 위치</th>
        <th>관리</th>
    </tr>
    <c:forEach var="dept" items="${deptList}">
        <tr>
            <td>${dept.deptno}</td>
            <td>${dept.dname}</td>
            <td>${dept.loc}</td>
            <td><a href="/dept/edit?no=${dept.deptno}">modify</a>/<a href="/dept/delete?no=${dept.deptno}">remove</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
