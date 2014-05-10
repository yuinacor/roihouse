/**
 * 
 */
(function() {
	Handlebars.registerHelper("timestamp", function(data) {
		return new Date(Number(data)).toLocaleDateString();
	});
	var TPL = Handlebars.compile($('#tpl').html());
	var FormatDate = function(date) {
		var _year = date.getFullYear();
		var _month = date.getMonth();

		this.setDate = function(date) {
			_year = Number(date.split("-")[0]);
			_month = Number(date.split("-")[1]);
		};

		this.getPrevDate = function() {
			var prevMonth = 0;
			if (_month == 1) {
				prevMonth = 12;
				_year -= 1;
			} else {
				prevMonth = _month - 1;
			}
			return _year + "-" + prevMonth;
		};

		this.getDate = function() {
			return _year + "-" + _month;
		};
		this.getNextDate = function() {
			var nextMonth = 0;
			if (_month == 12) {
				nextMonth = 1;
				_year += 1;
			} else {
				nextMonth = _month + 1;
			}
			return _year + "-" + nextMonth;
		};
	};

	var now = new FormatDate(new Date);

	var selectReserveList = function(data) {
		
		$.ajax({
			url : "selectReserveList",
			contentType : "application/json",
			data : data,
			dataType : "json",
			type: "GET"
		}).success(function(data){
			
			console.log(data);
		});
		
//		$.ajaxSetup({
//			contentType : "application/json"
//		});
//		$.get("selectReserveList", data, function(data) {
//			console.log(data);
//			$('#table-body').append(TPL({
//				data : data
//			}));
//		});
	};
	var $monthHeader = $("#month-header"), $monthPrev = $("#month-toPrev"), $monthNext = $("#month-toNext");

	var createBoard = function(formatDate) {
		$monthHeader.html(formatDate.getDate());

		// 시작 시점으로부터 한달 뒤까지를 범위로 설정
		selectReserveList({ 
			start : formatDate.getDate() + "-1",
			end : formatDate.getNextDate()+"-1"
		});
	};
	$monthPrev.click(function(e) {
		now.setDate(now.getPrevDate());
		createBoard(now);
	});

	$monthNext.click(function(e) {
		now.setDate(now.getNextDate());
		createBoard(now);
	});

	$(document).ready(function() {
		createBoard(now);
	});

})();