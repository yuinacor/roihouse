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

<!-- Custom styles for this template -->

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
	<div class="row">
		<div class="col-md-12 column">
			<h1>
				DashBoard
			</h3>
			<table class="table">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							예약일
						</th>
						<th>
							방번호
						</th>
						<th>
							체크인
						</th>
						<th>
							박 수
						</th>
						<th>
							예약자 이름
						</th>
						<th>
							1박 가격
						</th>
						<th>
							총액
						</th>
						<th>
							선입금
						</th>
						<th>
							잔금
						</th>
						<th>
							경유
						</th>
					</tr>
				</thead>
				<tbody id="table-body">
				</tbody>
			</table>
		</div>
	</div>
</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="handlebars-template" id="tpl">
	<tr>
		<td>
			1
		</td>
		<td>
			{{ reservDate}}
		</td>
		<td>
			{{ roomNo}}
		</td>
		<td>
			{{ chkin}}
		</td>
		<td>
			{{ night}}
		</td>
		<td>
			{{ rName}}
		</td>
		<td>
			{{ payPerDay}}
		</td>
		<td>
			{{ payment}}
		</td>
		<td>
			{{ deposit}}
		</td>
		<td>
			{{ balance}}
		</td>
		<td>
			{{ via}}
		</td>
	</tr>
	</script>
	<script type="text/javascript">
		$(document).ready(function(){
				var TPL = Handlebars.compile($('#tpl').html());
				$.get('selectReserveList.roi',function(data){
					var test = undefined;
					$('#table-body').append(TPL(data));
				});
		});
	</script>	
</body>
</html>