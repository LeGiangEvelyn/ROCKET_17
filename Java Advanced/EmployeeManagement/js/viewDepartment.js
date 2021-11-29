//load into section

function clickNavViewListDepartments() {
  $("#main_page").load("../html/manager/viewDepartment.html", function () {
    buildTable();
  });
}

var departments = [];
var currentPage = 1;
var size = 5;
var sortField = "id";
var isAsc = true;

function getListDepartments() {
  var url = "http://localhost:8080/api/v1/departments";

  url += "?pageNumber=" + currentPage + "&pageSize=" + size;

  url += "&sort=" + sortField + "," + (isAsc ? "asc" : "desc");

  var search = document.getElementById("input-search-department").value;
  if (search) {
    url += "&searchName=" + search;
  }

  // call API from server
  $.get(url, function (data, status) {
    // reset list departments
    departments = [];

    // error
    if (status == "error") {
      // TODO
      alert("Error when loading data");
      return;
    }

    // success
    departments = data;
    console.log(departments);
    fillDepartmentToTable();
    resetDeleteCheckbox();
    pagingTable(data.totalPages);
  });
}

function resetDeleteCheckbox() {
  // reset delete all checkbox
  document.getElementById("checkbox-all").checked = false;

  // reset checkbox item
  var i = 0;
  while (true) {
    var checkboxItem = document.getElementById("checkbox-" + i);
    if (checkboxItem !== undefined && checkboxItem !== null) {
      checkboxItem.checked = false;
      i++;
    } else {
      break;
    }
  }
}
function pagingTable(pageAmount) {
  var pagingStr = "";

  if (pageAmount > 1 && currentPage > 1) {
    pagingStr +=
      '<li class="page-item">' +
      '<a class="page-link" onClick="prevPaging()">Previous</a>' +
      "</li>";
  }

  for (i = 0; i < pageAmount; i++) {
    pagingStr +=
      '<li class="page-item ' +
      (currentPage == i + 1 ? "active" : "") +
      '">' +
      '<a class="page-link" onClick="changePage(' +
      (i + 1) +
      ')">' +
      (i + 1) +
      "</a>" +
      "</li>";
  }

  if (pageAmount > 1 && currentPage < pageAmount) {
    pagingStr +=
      '<li class="page-item">' +
      '<a class="page-link" onClick="nextPaging()">Next</a>' +
      "</li>";
  }

  $("#pagination").empty();
  $("#pagination").append(pagingStr);
}

function resetPaging() {
  currentPage = 1;
  size = 5;
}

function prevPaging() {
  changePage(currentPage - 1);
}

function nextPaging() {
  changePage(currentPage + 1);
}

function changePage(page) {
  if (page == currentPage) {
    return;
  }
  currentPage = page;
  buildTable();
}

//Sort: change variable then call api
//First: click 1 time asc, second time: desc
function changeSort(field) {
  if (field == sortField) {
    isAsc = !isAsc;
  } else {
    sortField = field;
    isAsc = false;
  }
  buildTable;
  currentPage = page;
}

function resetSort() {
  sortField = "id";
  isAsc = true;
}

function resetTable() {
  resetPaging();
  resetSort();
  resetDeleteCheckbox();
}

//Search
function handleSearch() {
  resetTable();
  buildTable();
}

function fillDepartmentToTable() {
  departments.forEach(function (item, index) {
    $("tbody").append(
      "<tr>" +
        '<td><input id="checkbox-' +
        index +
        '" type="checkbox" onClick="onChangeCheckboxItem()"></td>' +
        "<td>" +
        item.id +
        "</td>" +
        "<td>" +
        item.name +
        "</td>" +
        "<td>" +
        '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' +
        item.id +
        ')"><i class="fa fa-edit"></i></a>' +
        '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' +
        item.id +
        ')"><i class="material-icons">&#xE872;</i></a>' +
        "</td>" +
        "</tr>"
    );
  });
}

function buildTable() {
  $("tbody").empty();
  getListDepartments();
}

function openAddModal() {
  openModal();
  resetFormAdd();
}

function resetFormAdd() {
  document.getElementById("titleModal").innerHTML = "Add Department";
  document.getElementById("id").value = "";
  document.getElementById("name").value = "";
}

function openModal() {
  $("#myModal").modal("show");
}

function hideModal() {
  $("#myModal").modal("hide");
}

function addDepartment() {
  // get data
  var name = document.getElementById("name").value;

  // TODO validate
  // then fail validate ==> return;

  var department = {
    name: name,
    authorId: 3,
  };

  $.ajax({
    url: "http://localhost:8080/api/v1/departments",
    type: "POST",
    data: JSON.stringify(department), // body
    contentType: "application/json", // type of body (json, xml, text)
    // dataType: 'json', // datatype return
    success: function (data, textStatus, xhr) {
      console.log(data);
      // success
      hideModal();
      showSuccessAlert();
      resetTable();
      buildTable();
    },
    error(jqXHR, textStatus, errorThrown) {
      alert("Error when loading data");
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
}

function resetFormUpdate() {
  document.getElementById("titleModal").innerHTML = "Update Department";
}

function openUpdateModal(id) {
  $.get(
    "http://localhost:8080/api/v1/departments/" + id,
    function (data, status) {
      // error
      if (status == "error") {
        // TODO
        alert("Error when loading data");
        return;
      }

      // success
      hideModal();
      showSuccessAlert();
      resetTable();
      buildTable();
      // fill data
      document.getElementById("id").value = data.id;
      document.getElementById("name").value = data.name;
    }
  );
}

function save() {
  var id = document.getElementById("id").value;

  if (id == null || id == "") {
    addDepartment();
  } else {
    updateDepartment();
  }
}

function updateDepartment() {
  var id = document.getElementById("id").value;
  var name = document.getElementById("name").value;

  // TODO validate
  // then fail validate ==> return;

  var department = {
    name: name,
  };

  $.ajax({
    url: "http://localhost:8080/api/v1/departments/" + id,
    type: "PUT",
    data: JSON.stringify(department), // body
    contentType: "application/json", // type of body (json, xml, text)
    // dataType: 'json', // datatype return
    success: function (data, textStatus, xhr) {
      console.log(data);
      // success
      hideModal();
      showSuccessAlert();
      resetTable();
      buildTable();
    },
    error(jqXHR, textStatus, errorThrown) {
      alert("Error when loading data");
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
}

function openConfirmDelete(id) {
  // get index from employee's id
  var index = departments.findIndex((x) => x.id == id);
  var name = departments[index].name;

  var result = confirm("Want to delete " + name + "?");
  if (result) {
    deleteDepartment(id);
  }
}

function deleteDepartment(id) {
  // TODO validate

  $.ajax({
    url: "http://localhost:8080/api/v1/departments/" + id,
    type: "DELETE",
    success: function (result) {
      // error
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }

      // success
      showSuccessAlert();
      resetTable();
      buildTable();
    },
  });
}

function onChangeCheckboxItem() {
  var i = 0;
  while (true) {
    var checkboxItem = document.getElementById("checkbox-" + i);
    if (checkboxItem !== undefined && checkboxItem !== null) {
      if (!checkboxItem.checked) {
        document.getElementById("checkbox-all").checked = false;
        return;
      }
      i++;
    } else {
      break;
    }
  }
  document.getElementById("checkbox-all").checked = true;
}

function onChangeCheckboxAll() {
  var i = 0;
  while (true) {
    var checkboxItem = document.getElementById("checkbox-" + i);
    if (checkboxItem !== undefined && checkboxItem !== null) {
      checkboxItem.checked = document.getElementById("checkbox-all").checked;
      i++;
    } else {
      break;
    }
  }
}

function deleteAllDepartment() {
  // get checked
  var ids = [];
  var names = [];
  var i = 0;
  while (true) {
    var checkboxItem = document.getElementById("checkbox-" + i);
    if (checkboxItem !== undefined && checkboxItem !== null) {
      if (checkboxItem.checked) {
        ids.push(departments[i].id);
        names.push(departments[i].name);
      }
      i++;
    } else {
      break;
    }
  }

  // open confirm ==> bạn có muốn xóa bản ghi ...

  var result = confirm("Want to delete " + names + "?");
  if (result) {
    // call API
    $.ajax({
      url: "http://localhost:8080/api/v1/departments?ids=" + ids,
      type: "DELETE",
      success: function (result) {
        // error
        if (result == undefined || result == null) {
          alert("Error when loading data");
          return;
        }

        // success
        showSuccessAlert();
        resetTable();
        buildTable();
      },
    });
  }
}

function showSuccessAlert() {
  $("#success-alert")
    .fadeTo(2000, 500)
    .slideUp(500, function () {
      $("#success-alert").slideUp(500);
    });
}
