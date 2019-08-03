
function searchArticles() {
    //alert("hi");
    document.getElementById("searchResult").innerHTML = '';
    var search = document.getElementById("searchInput").value;
    console.log(search);
    $.get("http://localhost:9090/newpr_war_exploded/search?textSearch=" + search, function (responseJson) {
        //var $div1 = $("<div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-12\">").appendTo($("#searchResult"));
        var $container = $("<div class=\"container-fluid\">").appendTo("#searchResult")
        var $row = $("<div class=\"row\">").appendTo($container)
        $.each(responseJson, function (index, product) {
            var $div1 = $("<div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-12\">").appendTo($row)
            var $div2 = $("<div class=\"box-part text-center\">").appendTo($div1)
                .append($("<i class=\"fab fa-font-awesome-flag\"></i>").text(""))

            $("<div class=\"title\">").appendTo($div2)
                .append($("<h4>").text(product.name))
            $("<div class=\"text\">").appendTo($div2)
                .append($("<span>").text(product.description))
            $("<div class=\"price\">").appendTo($div2)
                .append($("<span>").text(product.price+" UAH"))

        });
    });
}

$(document).ready(function() {
    $(window).keydown(function(event){
        if(event.keyCode == 13) {
            event.preventDefault();
            searchArticles();
        }
    });
});

