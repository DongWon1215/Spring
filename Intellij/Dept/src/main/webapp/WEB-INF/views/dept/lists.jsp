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
    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/bootstrap/offcanvas.css" rel="stylesheet">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    <a class="navbar-brand mr-auto mr-lg-0" href="#">DEPT MANAGER</a>
    <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Dashboard <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Notifications</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Switch account</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="https://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Settings</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<main role="main" class="container">

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

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="js/assets/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="js/assets/vendor/popper.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/assets/js/vendor/holder.min.js"></script>
<script src="js/bootstrap/offcanvas.js"></script>
</body>
</html>
