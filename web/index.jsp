<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 2019-07-02
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>blyskitka</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/b9192cac7d.js"></script>
    <script src="${pageContext.request.contextPath}/webapp/js/search1.js"></script>
    <link href="${pageContext.request.contextPath}/webapp/css/index2.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/webapp/components/header.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <table class="table">
                <thead>
                <c:forEach items="${categoryList}" var="category" varStatus="status">
                    <tr>
                        <th class="categories" scope="col">${category.category} <i class="fas fa-chevron-right"></i>
                        </th>
                    </tr>
                </c:forEach>
                </thead>
            </table>
        </div>
        <div class="col-md-8">
            <div class="container">
                <div class="row">
                    <form>
                        <input id="searchInput" type="text" onkeypress="handleEnter(event)">
                        <i class="fa fa-search" id="searchButton" onclick="searchArticles()"></i>
                    </form>
                </div>
                <div id="searchResult">

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
