<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<link href="resources/css/calender.css" rel="stylesheet">
</head>

<body>
<div class="container">
	<div class="row">
		<div class="col-md-12 column">
			<h1>
				Calender
			</h1>
			<div class="text-center">
			<h1>
			<span id="month-toPrev" class="glyphicon glyphicon-chevron-left" style="cursor:pointer"></span>
			<span id="month-header"></span>
			<span id="month-toNext" class="glyphicon glyphicon-chevron-right" style="cursor:pointer"></span>
			</h1>
			</div>
			<table class="table table-bordered">
				<thead id="table-head">
					
				</thead>
					<tbody id="table-body"  onselectstart="return false">
				</tbody>
			</table>
		</div>
	</div>
</div>
	<!-- /container -->
	
	<!-- modal -->

<div class="modal fade" id="reserveFormModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">예약</h4>
      </div>
      <div class="modal-body">
        <form id="modal-form" class="form-reserve form-horizontal" onsubmit="return false;">
       		<div class="form-group">
	        	<label class="col-sm-2 control-label">체크인</label>
	        	<div class="col-sm-4">
		        	<input type="date" name="chkin" class="form-control" placeholder="체크인">
	        	</div>
	        	<label class="col-sm-2 control-label">예약일</label>
	        	<div class="col-sm-4">
		        	<input type="date" name="reserveDate" class="form-control" readonly="readonly">
	        	</div>
        	</div>
        	<div class="form-group">
	        	<label class="col-sm-2 control-label">방번호</label>
	        	<div class="col-sm-4">
		        	<input type="text" name="roomNo" class="form-control" placeholder="방번호">
	        	</div>
        	</div>
        	<div class="form-group">
	        	<label class="col-sm-2 control-label">박 수</label>
	        	<div class="col-sm-4">
		        	<input type="number" name="nights" class="form-control" placeholder="박 수">
	        	</div>
        	</div>
        	<hr />
			<div class="form-group">
	        	<label class="col-sm-2 control-label">예약자명</label>
	        	<div class="col-sm-4">
		        	<input type="text" name="rName" class="form-control" placeholder="예약자">
	        	</div>
	        	<label class="col-sm-2 control-label">성별</label>
	        	<div class="col-sm-4">
	        		남 <input type="radio" name="gender" value="M"> 녀 <input type="radio" name="gender" value="F">
	        	</div>
        	</div>
        	<div class="form-group">
	        	<label class="col-sm-2 control-label">국적</label>
	        	<div class="col-sm-4">
		        	<input type="text" name="nationality" class="form-control" placeholder="국적">
	        	</div>
        	</div>
			<div class="form-group">
	        	<label class="col-sm-2 control-label">전화번호</label>
	        	<div class="col-sm-4">
		        	<input type="tel" name="phone"  class="form-control" placeholder="전화번호">
	        	</div>
	        	<label class="col-sm-2 control-label">이메일</label>
	        	<div class="col-sm-4">
		        	<input type="email" name="email"  class="form-control" placeholder="이메일">
	        	</div>
        	</div>
        	<hr />
        	<div class="form-group">
	        	<label class="col-sm-2 control-label">1박 가격</label>
	        	<div class="col-sm-4">
		        	<input type="number" name="payPerDay"  class="form-control" placeholder="1박 가격">
	        	</div>
	        	<label class="col-sm-2 control-label">총액</label>
	        	<div class="col-sm-4">
		        	<input type="number" name="payment"  class="form-control" placeholder="총액">
	        	</div>
        	</div>
        	<div class="form-group">
	        	<label class="col-sm-2 control-label">입금</label>
	        	<div class="col-sm-4">
		        	<input type="number" name="deposit"  class="form-control" placeholder="입금">
	        	</div>
	        	<label class="col-sm-2 control-label">잔금</label>
	        	<div class="col-sm-4">
		        	<input type="number" name="balance"  class="form-control" placeholder="잔금">
	        	</div>
        	</div>
        	<hr />
        	<div class="form-group">
	        	<label class="col-sm-2 control-label">경유</label>
	        	<div class="col-sm-4">
		        	<input type="text" name="via"  class="form-control" placeholder="경유">
	        	</div>
        	</div>
        	<div class="form-group">
        		<label class="col-sm-2 control-label">메모</label>
	        	<div class="col-sm-10">
	        		<textarea name="comment" class="form-control"></textarea>
	        	</div>
        	</div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
        <button type="button" class="btn btn-primary form-submit">저장</button>
      </div>
    </div>
  </div>
</div>
	<!-- modal -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="handlebars-template" id="tpl-head">
		<tr>
			<td>#</td>
			{{#each rooms}}
			<td>{{this}}</td>
			{{/each}}
		</tr>
	</script>
	<script type="handlebars-template" id="tpl-body">
	{{#each data}}
		<tr date="{{this.calenderDate}}">
			<td class="date {{weekendHelper this.calenderDate}}">{{dateHelper this.calenderDate}}</td>
			{{#each this.rooms}}
				<td class="room {{roomHelper this}} {{roomTypeHelper this.roomNo}}" 
				{{#if this.id}}reserveId="{{this.id}}"{{/if}} roomNo="{{this.roomNo}}">{{#if this.chked}}예약{{/if}}</td>
			{{/each}}
		</tr>
	{{/each}}
	</script>
	
	<script type="text/javascript" src="resources/js/util/formatDate.js"></script>
	<script type="text/javascript" src="resources/js/calender.js">
	</script>	
</body>
</html>