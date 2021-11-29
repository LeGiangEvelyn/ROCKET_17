$(function () {
  $("#header").load("../html/manager/header.html");
  $("#left_nav").load("../html/manager/menu.html");
  $("#main_page").load("../html/manager/home.html");
  $("#footer").load("../html/manager/footer.html");
});

function clickNavHome() {
  $("#main_page").load("../html/manager/home.html", function () {});
}
