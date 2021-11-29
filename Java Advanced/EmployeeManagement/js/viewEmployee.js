var employee = [];

$(function () {
  $("#main_page").load("../html/manager/home.html");
});

function clickNavViewListEmployees() {
  $("#main_page").load("../html/manager/viewEmployee.html", function () {
    buildTable();
  });
}
