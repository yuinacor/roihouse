/**
 * 
 */
(function(){
	
	var tpl = Handlebars.compile($("#tpl").html());
	
	var roomNos = [ "201", "202", "203", "301", "302", "303",
	    			"401", "402", "dm1", "dm2", "dm3", "dm4", "dm5", "df1", "df2",
	    			"df3", "df4", "df5"];
	
	Handlebars.registerHelper("weekendHelper", function(date){
		var temp = new Date(date);
		if(temp.getDay() === 6){
			return "sat info";
		} else if(temp.getDay() === 0){
			return "sun danger";
		} else {
			return "day";
		}
	});
	
	Handlebars.registerHelper("dateHelper", function(date){
		var temp = new Date(date);
		return temp.toLocaleDateString();
	});
	
	Handlebars.registerHelper("roomHelper", function(room){
		if(room.chked){
			return "checked"
		} else {
			return "unchecked";
		}
	});
	
	
	var FormatDate = function(date) {
		var _year = date.getFullYear();
		var _month = date.getMonth()+1;

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
			
			if(prevMonth < 10){
				prevMonth = "0" + prevMonth;
			}
			
			return _year + "-" + prevMonth;
		};

		this.getDate = function() {
			var month = _month;
			
			if(month <10){
				month = "0" + month;
			}
			
			return _year + "-" + month;
		};
		this.getNextDate = function() {
			var nextMonth = 0;
			if (_month == 12) {
				nextMonth = 1;
				_year += 1;
			} else {
				nextMonth = _month + 1;
			}
			if(nextMonth <10){
				nextMonth = "0" + nextMonth;
			}
			
			return _year + "-" + nextMonth;
		};
	};
	
	var now = new FormatDate(new Date());
	
	var data = {
			start : now.getDate() + "-01",
			end : now.getNextDate() + "-01"
	};
	
	console.log(data);
	
	$.ajax({
		url : "selectCalender",
		contentType: "application/json",
		data:JSON.stringify(data),
		dataType:"json",
		type:"POST"
	}).success(function(data){
		console.log(data);
		data.forEach(function(value, index){
			var rooms = [];
			roomNos.forEach(function(roomNo){
				if(value.roomNo === roomNo){
					rooms.push(value);
				} else {
					rooms.push({
						roomNo : roomNo,
						chkin : value.calenderDate,
						chked : false
					});
				}
			});
			value.rooms = rooms;
		});
		
		
		$("#table-body").append(tpl({data : data}))
	});
	
	
})();