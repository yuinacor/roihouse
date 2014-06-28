/**
 * 
 */
(function() {
	Handlebars.registerHelper("timestamp", function(data) {
		return new Date(Number(data)).toLocaleDateString();
	});
	var TPL = Handlebars.compile($('#tpl').html());

	var now = new FormatDate(new Date);

	var selectReserveList = function(data) {
		console.log(data);
		$.ajax({
			url : "selectReserveList.roi",
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : "json",
			type: "POST"
		}).success(function(data){
			console.log(data);
			$('#table-body').empty().append(TPL({
				data : data
			}));
		});
		
//		$.ajaxSetup({
//			contentType : "application/json"
//		});
//		$.get("selectReserveList", data, function(data) {
//			console.log(data);
//		});
	};
	var $monthHeader = $("#month-header"), $monthPrev = $("#month-toPrev"), $monthNext = $("#month-toNext");

	var createBoard = function(formatDate) {
		$monthHeader.html(formatDate.getMonth);

		selectReserveList({ 
			start : formatDate.getDate(),
			end : formatDate.getNextDate()
		});
	};
	
	$monthPrev.click(function(e) {
		now.setDate(now.getPrevMonth());
		createBoard(now);
	});

	$monthNext.click(function(e) {
		now.setDate(now.getNextMonth());
		createBoard(now);
	});

	$(document).ready(function() {
		createBoard(now);
	});

})();