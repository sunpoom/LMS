$(document).on("click", "#modifyBtn", function () {
    var num = $('.numInput').val()
    var data = {
        id: $('.idIput').val(),
        email: $('#emailInput').val(),
        pw: $('#passwordInput').val(),
    };
    $.ajax({
        url: "api/admin/modify/" + num, // 데이터를 가져올 URL
        method: "PATCH",
        dataType: "text",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        success: function (data) {
            alert("로그인을 다시하세요")
            window.location.href = "/index/login";
        },
        error: function (xhr, status, error) {
            alert(xhr.responseText)
        }
    })
})

$(document).on("click", "#studentAddBtn", function () {
    var data = {
        name: $('.nameAdd').val(),
        student_id: $('.studentNumAdd').val(),
        major: $('.majorAdd').val(),
        pw: $('.passwordAdd').val(),
    };
    $.ajax({
        url: "api/admin/StudentAdd", // 데이터를 가져올 URL
        method: "POST",
        dataType: "text",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        success: function (data) {
            alert("등록되었습니다.")
            $("#studentAddWrap input").val("")
        },
        error: function (xhr, status, error) {
            alert(xhr.responseText)
        }
    })
})


$(document).on("click", "#studentSearchBtn", function () {
    var data = {
        name: $('.nameSearch').val(),
        student_id: $('.NumSearch').val(),
    };
    $.ajax({
        url: "api/admin/studentSearch", // 데이터를 가져올 URL
        method: "POST",
        dataType: "JSON",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        success: function (data) {
            $("#studentSearchArea").css("display", "block")
            $("#searchName").text("이름 : " + data.name);
            $("#searchNum").text("학번 : " + data.student_id);
            $("#searchYear").text("학년 : " + data.year);
            $("#searchMajor").text("학과 : " + data.major);
            $("#searchRegistrationDate").text("등록된 날짜 : " + data.registrationDate);
        },
        error: function (xhr, status, error) {
            alert(xhr.responseText)
        }
    })
})