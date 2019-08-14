
function sendRequest(link){
    $.get(link, function (responseJson) {
        var $container = $("<div class=\"container-fluid\">").appendTo("#searchResult")
        var $row = $("<div class=\"row\">").appendTo($container)
        $.each(responseJson, function (index, product) {
            var $div1 = $("<div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-12\">").appendTo($row)
            var $div2 = $("<div class=\"box-part text-center\">").appendTo($div1)
                .prepend($("<img>",{class:"article-image",src:product.photo}))

            $("<div class=\"title\">").appendTo($div2)
                .prepend($("<a>",{class:"article-name",href:"http://localhost:9090/newpr_war_exploded/articlePage?idArticle="+product.id.toString()}).text(product.name))
            $("<div class=\"text\">").appendTo($div2)
                .append($("<span>").text(product.description))
            $("<div class=\"price\">").appendTo($div2)
                .append($("<span>").text(product.price+" UAH"))

        });
    });
}

function searchArticles() {
    document.getElementById("searchResult").innerHTML = '';
    var search = document.getElementById("searchInput").value;
    sendRequest("http://localhost:9090/newpr_war_exploded/search?textSearch=" + search);
}

$(document).ready(function() {
    $(window).keydown(function(event){
        if(event.keyCode == 13) {
            event.preventDefault();
            searchArticles();
        }
    });
});

function showArticlesByKind(idKind) {
    document.getElementById("searchResult").innerHTML = '';
    sendRequest("http://localhost:9090/newpr_war_exploded/articlesByKind?idKind=" + idKind);
}

function showKinds(categoryId) {
    document.getElementById("selectedKinds").innerHTML = '';

    $.get("http://localhost:9090/newpr_war_exploded/kinds?categoryId=" + categoryId.toString(), function (responseJson) {
        var $list = $("<div class=\"list-group\">").appendTo("#selectedKinds");
        var ids = [];
        $.each(responseJson, function (index, kind) {
            $("<p class=\"list-group-item\">").appendTo($list)
                .append($("<span>").text(kind.kind))
            ids[index]=kind.id;
        });
        var elements = document.getElementsByClassName("list-group-item");
        for(let i = 0;i<elements.length;i++){
            elements[i].onclick = function (event) {
                showArticlesByKind(ids[i]);
            }
        }
    });

}