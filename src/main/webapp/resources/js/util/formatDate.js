/**
 * 
 */

var FormatDate = function(date) {
		var _year = date.getFullYear();
		//month를 0부터 카운트하므로 보
		var _month = date.getMonth()+1;

		//문자열로 된 연,월을 받아서 셋하는 메서
		this.setDate = function(date) {
			_year = Number(date.split("-")[0]);
			_month = Number(date.split("-")[1]);
		};
		
		var monthFormat = function(month){
			if(month < 10){
				month = "0" + month;
			}
			return month;
		};
		
		var getPrev = function(){
			var prevMonth = 0;
			var year = _year;
			if (_month == 1) {
				prevMonth = 12;
				year = _year - 1;
			} else {
				prevMonth = _month - 1;
			}
			
			return year + "-" + monthFormat(prevMonth);
		};
		
		var getNow = function(){
			return _year + "-" + monthFormat(_month);
		};
		
		var getNext = function(){
			var nextMonth = 0;
			var year = _year;
			if (_month == 12) {
				nextMonth = 1;
				year = _year + 1;
			} else {
				nextMonth = _month + 1;
			}
			return year + "-" + monthFormat(nextMonth);
		};

		this.getPrevDate = function() {
			return getPrev() + "-01";
		};

		this.getDate = function() {
			return getNow() + "-01";
		};
		
		this.getNextDate = function() {
			return getNext() + "-01";
		};
		
		this.getMonth = function(){
			return getNow();
		};
		
		this.getPrevMonth = function(){
			return getPrev();
		};
		
		this.getNextMonth = function(){
			return getNext();
		};
	};