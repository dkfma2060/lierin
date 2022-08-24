<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
Date nowTime = new Date();
SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="/middle/css/import.css" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>order</title>
<script type="text/javascript">
	//이름 / 값 / 저장 시킬 시간
	function SetCookie(cookie_name, value, hours) {
		if (hours) {
			var date = new Date();
			date.setTime(date.getTime() + (hours * 60 * 60 * 1000));
			var expires = "; expires=" + date.toGMTString();
		} else {
			var expires = "";
		}
		document.cookie = cookie_name + "=" + value + expires + "; path=/";
	}

	setInterval("dpTime()", 1000);
	function dpTime() {
		var now = new Date();
		hours = now.getHours();
		minutes = now.getMinutes();
		seconds = now.getSeconds();

		if (hours > 12) {
			hours -= 12;
			ampm = "오후 ";
		} else {
			ampm = "오전 ";
		}
		if (hours < 10) {
			hours = "0" + hours;
		}
		if (minutes < 10) {
			minutes = "0" + minutes;
		}
		if (seconds < 10) {
			seconds = "0" + seconds;
		}
		document.getElementById("dpTime").innerHTML = ampm + hours + ":"
				+ minutes + ":" + seconds;
	}
</script>
<style type="text/css">
ul li {
	list-style: none;
}

a {
	text-decoration: none;
	color: #333;
}
/* 글자크기를 16px 맑은 고딕 굵게하고 width넓이 200, 높이 30, 글자색은 검정색, 라인높이30px
menu박스 가운데정렬, 글자가운데 정렬 */
#menu2 {
	font: bold 16px "malgun gothic";
	width: 180px;
	color: black;
	line-height: 30px;
	margin: 0 auto;
	text-align: center;
}

/* menu태그 자식의 ul의 자식 li를 왼쪽정렬과 넓이 140설정 */
#menu2>ul>li {
	float: left;
	width: 120px;
	position: relative;
}

#menu2>ul>li>ul {
	width: 120px;
	display: none;
	position: absolute;
	font-size: 14px;
}

#menu2>ul>li:hover>ul {
	display: block;
}

#menu2>ul>li>ul>li:hover {
	background: pink;
	transition: ease 1s;
}
</style>
</head>
<body>
	<form action='qna' method='get'>
		<header class="header" style="z-index: 2;">
			<div class="header__img">
				<img src="/middle/img/logoWorker.png" />
			</div>

			<div style="margin-right: 125px; float: right; margin-top: -90px;"><%=sf.format(nowTime)%></div>
			<div style="margin: 20px; float: right; margin-top: -90px;">
				<span id="dpTime">오후 01:44:40</span>
			</div>
			<div class="header__img" style="margin-top: -60px;">
				<i class="fas fa-user-cog fa-3x"></i>&nbsp;&nbsp;&nbsp;<span>${authInfo.name}
					님 로그인</span>
			</div>

		</header>
		<script src="https://kit.fontawesome.com/4a9dbb7224.js"
			crossorigin="anonymous"></script>
		<nav class="menu">
			<table>
				<tr>
					<th style="border: 4px outset pink;" onclick="location.href='list'">관리자
						정보</th>
				</tr>
				<tr>
					<th style="border: 4px outset pink;"
						onclick="location.href='management'">회원 관리</th>
				</tr>
				<tr style="height: 140px;">
					<th style="border: 4px outset pink;">
						<div id="menu2">
							<ul>
								<li><a href="kind=1">상품 관리 &nbsp;&nbsp;&nbsp;</a>
									<ul>
										<li><a href="reg">상품 등록 &nbsp;&nbsp;&nbsp;</a></li>
										<li><a href="kind=1">상품 관리 &nbsp;&nbsp;&nbsp;</a></li>
									</ul></li>
								<ul>
									<li>&nbsp;&nbsp;</li>
									<li>&nbsp;&nbsp;</li>
								</ul>
							</ul>
						</div>
					</th>
				</tr>
				<tr>
					<th style="border: 4px outset pink;" onclick="location.href='event'">이벤트 관리</th>
				</tr>
				<tr style="height: 140px;">
					<th style="border: 4px outset pink;">
						<div id="menu2">
							<ul>
								<li><a href="board">게시판 관리 &nbsp;&nbsp;&nbsp;</a>
									<ul>
										<li><a href="board">게시판 등록 &nbsp;&nbsp;&nbsp;</a></li>
										<li><a href="qna">Q & A &nbsp;&nbsp;&nbsp;</a></li>
										<li><a href="notice">공지사항 &nbsp;&nbsp;&nbsp;</a></li>
									</ul></li>
								<ul>
									<li>&nbsp;&nbsp;</li>
									<li>&nbsp;&nbsp;</li>
									<li>&nbsp;&nbsp;</li>
									<li>&nbsp;&nbsp;</li>
								</ul>
							</ul>
						</div>
					</th>
				</tr>
				<tr>
					<th style="border: 4px outset pink;"
						onclick="location.href='seller_order'">주문내역 관리</th>
				</tr>
				<tr>
					<th style="border: 4px outset pink;">
					<div id="menu2">
						<ul>
							<li><a href="sales">매출 관리 &nbsp;&nbsp;&nbsp;</a>
								<ul>
									<li><a href="sales">이익 관리&nbsp;&nbsp;&nbsp;</a></li>
									<li><a href="expenditure">지출 관리 &nbsp;&nbsp;&nbsp;</a></li>
								</ul></li>
							<ul>
								<li>&nbsp;&nbsp;</li>
							</ul>
						</ul>
					</div>
				</th>
				</tr>
			</table>
		</nav>

		<main class="to_do_list">
			<article
				style="padding-left: 150px; padding-right: 100px; z-index: 1;">
				<h3>Bulletin Board</h3>
				<p>&nbsp;
				<h4>자주하는 질문</h4>
				<table
					style="width: 100%; border-top: 1px solid #444444; border-collapse: collapse;">
					<tr>
						<th style="border-bottom: 1px solid #444444; padding: 10px; width:5%;"><b>No</b></th>
						<th style="border-bottom: 1px solid #444444; padding: 10px; width:10%;"><b>Name</b></th>
						<th style="border-bottom: 1px solid #444444; padding: 10px; width:15%;"><b>title</b></th>
						<th style="border-bottom: 1px solid #444444; padding: 10px; width:50%;"><b>Subject</b></th>
						<th style="border-bottom: 1px solid #444444; padding: 10px; width:5%;"><b>hits</b></th>
						<th style="border-bottom: 1px solid #444444; padding: 10px; width:15%;"><b>Date</b></th>
					</tr>
					<tr></tr>
					<c:forEach items="${qna}" var="qna">
						<tr align="center">
							<td style="border-bottom: 1px solid #444444; padding: 10px;">${qna.wseq}</td>
							<td style="border-bottom: 1px solid #444444; padding: 10px;">${qna.name}</td>
							<td style="border-bottom: 1px solid #444444; padding: 10px;">${qna.title}</td>
							<td style="border-bottom: 1px solid #444444; padding: 10px;">${qna.detail}</td>
							<td style="border-bottom: 1px solid #444444; padding: 10px;">${qna.hits}</td>
							<td style="border-bottom: 1px solid #444444; padding: 10px;">
								<fmt:formatDate pattern="yyyy-MM-dd"
									value="${qna.reg_date}" /><br><input
								style="background-color: #FFF0F5; border-color: #FFF0F5;"
								type="button" value="수정"
								onclick="location.href='board_update?wseq=${qna.wseq}'"> <input
								style="background-color: light-gray; border-color: light-gray;" type="button" value="삭제"
								onclick="location.href='board_delete'">
							</td>
						</tr>
					</c:forEach>
				</table>
			</article>
		</main>
	</form>
</body>
</html>