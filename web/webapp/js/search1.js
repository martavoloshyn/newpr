
function searchArticles() {
    document.getElementById("searchResult").innerHTML = '';
    var search = document.getElementById("searchInput").value;
    console.log(search);
    $.get("http://localhost:9090/newpr_war_exploded/search?textSearch=" + search, function (responseJson) {
        var $table = $("<table>").appendTo($("#searchResult")); // Create HTML <table> element and append it to HTML DOM element with ID "somediv".
        $.each(responseJson, function (index, product) {    // Iterate over the JSON array.
            $("<tr>").appendTo($table)                     // Create HTML <tr> element, set its text content with currently iterated item and append it to the <table>.// Create HTML <td> element, set its text content with id of currently iterated product and append it to the <tr>.
                .append($("<td>").text(product.name))      // Create HTML <td> element, set its text content with name of currently iterated product and append it to the <tr>.
                .append($("<td>").text(product.price));    // Create HTML <td> element, set its text content with price of currently iterated product and append it to the <tr>.
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


