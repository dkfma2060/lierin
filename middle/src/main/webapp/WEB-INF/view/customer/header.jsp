<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
   margin: 0;
   padding: 0;
}

a {
   text-decoration-line: none;
   
}

.search {
   position: fixed;
   text-align: center;
   margin-left: 700px;
   top: 15px;
   margin-top: 15px;
   padding: 0;
   list-style: none;
   border-radius: 7px;
   box-shadow: 0 2px 2px 2px rgba(0, 0, 0, 0.12);
   padding: 0;
}

.search input {
   width: 270px;
   height: 5px;
   text-align: center;
   border: 1px solid rgba(0, 0, 0, 0.2);
   border-radius: 7px;
   padding: 15px 0 15px 0;
   font-size: 15px;
   border-bottom: 1px solid rgba(0, 0, 0, 0.2);
   transition: border-color 1s ease-in-out;
}
button{
	border: none;
	background: none;
	cursor: pointer;
}
</style>
<script type="text/javascript">
	function searchBtnClick() {
		headerForm.action = "/middle/customer/search";
		headerForm.submit();
	}
</script>
</head>
<body>
<div style="width:1920px; align:center;">
	<form action="" name="headerForm">
		<div class="search_area">
			<div class="search">
			   <div style="padding-right:10px;">
			      <input type="text" name="search" maxlength="10" placeholder="검색어를 입력해주세요" style="width:500px; text-align: center; "/>
			      <button onclick="searchBtnClick()"><i class="fas fa-search"></i></button>	
			   </div>
			</div>
		</div>
	</form>
   <div style="background-color: #FEDD89; color: #31383F; height: 100px; padding: 5px;">
      <a href="/middle/customer/main"><img src="/middle/img/simbol.png"
         style="width: 100px; height: 100px; margin-left: 20px"></a>
     <div style="text-align: center; margin-top: -35px; font-size:22px; color: #12467a;">
			<a href="/middle/customer/main/kind=1">Fruit</a>&nbsp;&nbsp; <a
				href="/middle/customer/main/kind=2">Vegetable</a>&nbsp;&nbsp; <a
				href="/middle/customer/main/kind=3">Rice/Mixed grains</a>&nbsp;&nbsp; <a
				href="/middle/customer/main/kind=4">Nuts</a>
		
	</div>
      <c:choose>
         <c:when test="${empty sessionScope.cAuthInfo}">
            <div style="margin-top: -20px; margin-left: 1670px;">
               <a href="/middle/customer/login">로그인</a>
            </div>
            <div style="margin-top: -22px; margin-left: 1750px;">
               <a href="/middle/customer/joinForm">회원가입</a>
            </div>
         </c:when>
         <c:otherwise>
            <div style="margin-top: -80px; margin-left: 1750px;">
               <span>${sessionScope.cAuthInfo.name}님</span>
            </div>
            <div style="height: 10px;"></div>
            <div class="header__img"
               style="margin-top: 20px; margin-left: 1700px;">
               <a href="/middle/customer/cart/list"><i
                  class="fas fa-shopping-cart fa-xl"></i></a>
            </div>
            <div class="header__img"
               style="margin-top: -22px; margin-left: 1750px;">
               <a href="/middle/customer/likeList"><i class="fas fa-heart fa-xl"></i></a>
            </div>
            <div class="header__img" style="margin-top: -23px; margin-left: 1800px;">
               <a href="/middle/customer/mypage"><i class="fas fa-user fa-xl"></i></a>
            </div>
            <!-- <a href="/WUE/customer/logout">로그아웃</a> -->
         </c:otherwise>
      </c:choose>

   </div>
   <script src="https://kit.fontawesome.com/4a9dbb7224.js"
      crossorigin="anonymous"></script>
</div>
</body>
</html>