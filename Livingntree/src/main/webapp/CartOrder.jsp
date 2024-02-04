<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css">
</head>
<body>
	<header id="header"></header>
	<section id="order">
		<div class="shipping">
			<div class="title">
				<h2>배송지</h2>
				<i class="fa-solid fa-angle-up" aria-hidden="false"></i>
			</div>
			<div class="contents">
				<div class="shippingInfo">
					<div class="shippingInfoText">
						<strong class="name">
							<span id="deliveryInfoMain">[기본]</span>
							<span id="delieveryInfoName">김사원</span>
						</strong>
						<p class="address">
							[<span id="deliveryInfoPostcode">06620</span>]
							<span id="deliveryInfoAddress">서울 서초구 서초대로74길 11 삼성전자빌딩 asdf</span>
						</p>
						<p class="contact">
							<span id="deliveryInfoPhone">010-5555-5555</span>
						</p>
					</div>
					<span class="sideRight">
						<button type="button" class="btnNormal mini">배송지 목록</button>
					</span>
				</div>
			</div>
		</div>
		<div class="orderProduct">
			<div class="title">
				<h2>주문상품</h2>
				<i class="fa-solid fa-angle-up" aria-hidden="false"></i>
			</div>
			<div class="contents">
				
			</div>
		</div>
		<div class="payment">
			<div class="title">
				<h2>결제정보</h2>
				<i class="fa-solid fa-angle-up" aria-hidden="false"></i>
			</div>
			<div class="contents">
				<div class="segment">
					<table border="0">
						<tr>
							<th class="row">주문상품</th>
							<td class="right">
								<span id="totalProductPrice">${itemTotal}원</span>
							</td>
						</tr>
						<tr>
							<th class="row">배송비</th>
							<td class="right">
								<span id="totalShipPrice">${shippingTotal}원</span>
							</td>
						</tr>
					</table>
				</div>
				<div class="totalPrice">
					<h3 class="heading">최종 결제 금액</h3>
					<strong class="txtStrong">${itemTotal+shippingTotal}원</strong>
				</div>
			</div>
		</div>
		<button type="button" class="btnSubmit" id="btn_payment">
			<span id="totalPrice"></span>
			원 결제하기
		</button>
	</section>
</body>
</html>