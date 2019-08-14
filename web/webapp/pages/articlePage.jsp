<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 2019-08-06
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${article.name}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/b9192cac7d.js"></script>
    <script src="${pageContext.request.contextPath}/webapp/js/articlePage.js"></script>
    <link href="${pageContext.request.contextPath}/webapp/css/articlePage.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/webapp/components/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
            <h4 class="article-name">${article.name}</h4>
            <p><span class="characteristics">Category</span>: ${categoryName}</p>
            <p><span class="characteristics">Kind</span>: ${kindName}</p>
            <p><span class="characteristics">Description</span>: ${article.description}</p>
            <p><span class="characteristics">Trade Mark</span>: ${article.tradeMark}</p>
            <p><span class="characteristics">Country</span>: ${article.country}</p>
            <p><span class="characteristics">Volume</span>: ${article.volume}ml</p>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
            <img class="article-image" src=${article.photo}>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 right-col">
            <h4 class="price">${article.price} UAH</h4>
            <a href="http://localhost:9090/newpr_war_exploded/addToCart?idArticle=${article.id}" onclick="cartBlink()"><button type="button" class="btn btn-outline-dark"><i class="fas fa-cart-arrow-down"></i></button></a>
        </div>
    </div>
</div>

</body>
</html>
