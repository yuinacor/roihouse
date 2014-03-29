<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../assets/ico/favicon.ico">

<title>ROI HOUSE</title>

<!-- Bootstrap core CSS -->
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/bootstrap/css/signin.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="container">


		<form class="form-signin" role="form" action="insertReserve" method="post" onsubmit="return false;">
			<h1 class="text-center">예약 추가</h1>
			<input type="date" name="reservDate"  class="form-control">
			<input type="text" name="roomNo" class="form-control" placeholder="방번호" autofocus="autofocus">
			<input type="date" name="chkin"  class="form-control" placeholder="체크인">
			<input type="number" name="night"  class="form-control" placeholder="박수">
			<input type="text" name="rName"  class="form-control" placeholder="예약자 이름">
			<p>성별 : 남 <input type="radio" name="gender" value="M"> 녀 <input type="radio" name="gender" value="F"></p>
			<input type="text" name="nationality"  class="form-control" placeholder="국적">
			<input type="tel" name="phone"  class="form-control" placeholder="전화번호">
			<input type="email" name="email"  class="form-control" placeholder="이메일">
			<input type="number" name="payPerDay"  class="form-control" placeholder="1박 가격">
			<input type="number" name="payment"  class="form-control" placeholder="총액">
			<input type="number" name="deposit"  class="form-control" placeholder="선금">
			<input type="number" name="balance"  class="form-control" placeholder="잔금">
			<input type="text" name="via"  class="form-control" placeholder="경유">
			<input type="submit" class="btn btn-primary btn-lg btn-block">
		</form>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>