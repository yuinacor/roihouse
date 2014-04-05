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
<!-- <link href="resources/bootstrap/css/signin.css" rel="stylesheet"> -->

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


		<form class="form-reserve" role="form" action="insertReserve" method="post" onsubmit="return false;">
			<h1 class="text-center">예약 추가</h1>
			<input type="date" name="reservDate"  class="form-control" value="new Date()" readonly="readonly">
			<input type="text" name="roomNo" class="form-control" placeholder="방번호" autofocus="autofocus">
			<input type="date" name="chkin"  class="form-control" placeholder="체크인">
			<input type="number" name="nights"  class="form-control" placeholder="박수">
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
	<script type="text/javascript">
		$(document).ready(function(){
			var form = $('.form-reserve');
			var calPayment = function(){
				var payPerDay =form.find('[name=payPerDay]').val(); 
				var nights = form.find('[name=nights]').val();
				
				if(payPerDay === "" || payPerDay.length == 0){
					return;
				}
				if(nights === "" || nights.length == 0){
					return;
				}
				var result = payPerDay * nights;
				
				form.find('[name=payment]').val(result);
			};
			
			var makeReserve = function(data){
				var reserve = {};
				var reserveName = ['reservDate',
				                   'roomNo',
				                   'chkin',
				                   'nights',
				                   'rName',
				                   'payPerDay',
				                   'payment',
				                   'deposit',
				                   'balance',
				                   'via']; 
				for(var i in reserveName){
					for(var j in data){
						if(data[j].name === reserveName[i]){
							reserve[reserveName[i]] = data[j].value;
							break;
						}
					}
				}
				return reserve;
			};
			
			var makeReserver = function(data){
				var reserver = {};
				var reserverName = ['rName',
				                    'gender',
				                    'nationality',
				                    'phone',
				                    'email'];
				for(var i in reserverName){
					for(var j in data){
						if(data[j].name === reserverName[i]){
							reserver[reserverName[i]] = data[j].value;
							break;
						}
					}
				}
				return reserver;
			};
			
			(function autoDate () {
				var tDay = new Date();
				var tMonth = tDay.getMonth()+1;
				var tDate = tDay.getDate();
				if ( tMonth < 10) tMonth = "0"+tMonth;
				if ( tDate < 10) tDate = "0"+tDate;
				form.find('[name=reservDate]').val(tDay.getFullYear()+"-"+tMonth+"-"+tDate);
			 })();
			
			form.find('[name=nights]').change(calPayment);
			form.find('[name=payPerDay]').change(calPayment);
			
			form.find('[name=deposit]').change(function(){
				var payment = form.find('[name=payment]').val();
				var deposit = form.find('[name=deposit]').val();
				
				if(payment === "" || payment.length == 0){
					return;
				}
				if(deposit === "" || deposit.length == 0){
					return;
				}
				
				var result = payment - deposit;
				form.find('[name=balance]').val(result);
			});
			
			form.submit(function(e){
				var arr = form.serializeArray();
				$.ajaxSetup({contentType : "application/json"});
				$.post('insertReserver', JSON.stringify(makeReserver(arr)), function(data){
					$.post('insertReserve', makeReserve(arr), function(data){
						if(data){
							window.href="dashboard.roi";
						}
					});
				});
				
			});
		});
	</script>
</body>
</html>