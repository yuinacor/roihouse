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
			</h1>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							201
						</th>
						<th>
							202
						</th>
						<th>
							203
						</th>
						<th>
							301
						</th>
						<th>
							302
						</th>
						<th>
							303
						</th>
						<th>
							401
						</th>
						<th>
							402
						</th>
						<th>
							dm1
						</th>
						<th>
							dm2
						</th>
						<th>
							dm3
						</th>
						<th>
							dm4
						</th>
						<th>
							dm5
						</th>
						<th>
							df1
						</th>
						<th>
							df2
						</th>
						<th>
							df3
						</th>
						<th>
							df4
						</th>
						<th>
							df5
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
	{{#each data}}
		<tr>
			<td class="date {{weekendHelper this.calenderDate}}">{{dateHelper this.calenderDate}}</td>
			{{#each this.rooms}}
				<td class="room {{roomHelper this}}">{{#if this.chked}}!{{/if}}</td>
			{{/each}}
		</tr>
	{{/each}}
	</script>
	<script type="text/javascript" src="resources/js/calender.js">
	</script>	
</body>
</html>