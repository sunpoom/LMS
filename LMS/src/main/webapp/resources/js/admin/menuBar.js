$(document).on("click", ".item", function () {
    $("#main").children().css("display", "none")
    if ($(this).text() === '기본정보') {
        $("#personalInformationWrap").css("display", "block")
    } else if ($(this).text() === '개인정보 변경') {
        $("#personalModifyWrap").css("display", "block");
    } else if ($(this).text() === '학생추가') {
        $("#studentAddWrap").css("display", "block");
    } else if ($(this).text() === '학생조회') {
        $("#studentSearchWrap").css("display", "block");
    }
})