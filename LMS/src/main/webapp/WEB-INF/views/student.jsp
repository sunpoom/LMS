<%@ page import="com.lms.www.springboot.model.user.UserLoginResponseDTO" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <script src="../../resources/js/jquery-3.6.0.min.js"></script>
    <style>
        #headCon {
            display: flex;
            height: 100px;
            border: 1px solid;
            align-items: center;
        }

        .headLeft {
            margin-right: 60px;
        }

        #MainLogo {
            font-size: 50px;
            margin: 20px;
            cursor: pointer;
        }

        #clientName {
            margin-left: 0; /* 왼쪽으로 살짝 이동 */
            font-size: 30px; /* 폰트 크기 조절 */
        }


        .headLeft span {
            margin: 50px;
        }

        .headRight {
            margin-left: auto;
        }

        #navAndMain {
            position: relative;
            border: 1px solid;
            height: 1000px;
        }

        #navWrap {
            position: absolute;
            height: 100%;
            width: 200px;
            left: 0;
            border: 1px solid;
            background-color: gray;
            padding: 0;
        }

        #navWrap > ul {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        #navWrap > ul > li {
            cursor: pointer;
            margin: 0;
            text-align: left;
            color: white;
        }

        #navWrap > ul > li > div {
            font-size: 18px;
            padding: 5px 3px;
        }

        #mainWrap {
            position: absolute;
            border: 1px solid;
            width: calc(100% - 200px);
            left: 200px;
            height: 100%;
        }

        .headRight span {
            margin: 10px; /* Adjusted margin for better spacing */
            font-size: 18px; /* Adjusted font size */
        }

        .headRight button {
            font-size: 18px; /* Adjusted font size */
            padding: 5px 10px; /* Added padding for better button appearance */
        }


        .navItem {
            display: block;
            list-style: none;
            padding: 0;
            background-color: white;
        }

        .navItem li {
            margin-left: 10px;
            padding: 3px 0;
            color: black;
        }

        #timeTable {

        }
    </style>
</head>
<body>
<div id="headCon">
    <div class="headLeft">
    <span id="MainLogo">
        신세계교육
    </span>
        <span id="clientName">
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <c:set var="user" value="${sessionScope.user}"/>
                    <c:if test="${not empty user.role}">
                        ${user.role}
                    </c:if>
                </c:when>
            </c:choose>
        클래스넷
    </span>
    </div>

    <div class="headRight">
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <c:set var="user" value="${sessionScope.user}"/>
                <c:choose>
                    <c:when test="${not empty user.role}">
                        ${user.name}
                    </c:when>
                    <c:otherwise>
                        <span>회원이름</span>
                    </c:otherwise>
                </c:choose>
            </c:when>
        </c:choose>
        <span>
          <c:choose>
              <c:when test="${empty sessionScope.user}">
                  <a href="index/login"><button id="loginBtn">로그인</button></a>
              </c:when>
              <c:otherwise>
                  <a href="api/logout"><button id="logoutBtn">로그아웃</button></a>
              </c:otherwise>
          </c:choose>
        </span>
    </div>
</div>

<div id="navAndMain">
    <div id="navWrap">
        <ul>
            <li>
                <div class="navBtn">my page</div>
                <ul class="navItem">
                    <li class="item">기본정보</li>
                    <li class="item">개인정보 변경</li>
                </ul>
            </li>
            <li>
                <div class="navBtn">수강정보</div>
                <ul class="navItem">
                    <li class="item">수강신청</li>
                    <li class="item">수강현황</li>
                </ul>
            </li>
            <li>
                <div class="navBtn">성적정보</div>
                <ul class="navItem">
                    <li class="item">전체성적조회</li>
                    <li class="item">금학기성적조회</li>
                </ul>
            </li>
            <li>
                <div class="navBtn">이용사항</div>
                <ul class="navItem">
                    <li class="item">공지사항</li>
                    <li class="item">Q&A</li>
                    <li class="item">메뉴얼</li>
                </ul>
            </li>
        </ul>
    </div>
    <div id="mainWrap">
        <div id="noticeWrap">
            <div>공지사항</div>
            <table id="noticeTable">
                <tr>
                    <td></td>
                </tr>
            </table>
        </div>

        <div id="timeTableWrap">
            <div>수강과목</div>
            <table id="timeTable">
                <tr>
                    <td>과목명</td>
                    <td>강의실</td>
                    <td>수강인원</td>
                    <td>수강계획</td>
                </tr>
                <tr>
                </tr>
            </table>
        </div>
    </div>

</div>

<script>
    $(document).on("click", "#MainLogo", function () {
        window.location.href = "/"
    })
    $(document).on("click", ".navBtn", function () {
        if ($(this).next().css("display") === 'block') {
            $(this).next().css("display", "none")
        } else {
            $(this).next().css("display", "block")
        }
    })
    $(document).on("click", ".item", function () {
        console.log($(this))
        <%
       UserLoginResponseDTO userLoginResponseDTO = (UserLoginResponseDTO) session.getAttribute("user");
       if (userLoginResponseDTO == null) {
   %>
        alert("로그인하세요하고 이용하세요");
        <% } %>
    })
</script>
</body>
</html>