/**
 * ['formatDate']
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
	
	var $monthHeader = $("#month-header"), $monthPrev = $("#month-toPrev"), $monthNext = $("#month-toNext");

	
	
	var now = new FormatDate(new Date());
	
	
	var createCalender = function(){
		var data = {
				start : now.getDate(),
				end : now.getNextDate()
		};
		
		$("#table-body").empty();
		console.log(data);
		//spring의 timestamp 파싱 문제로 post를 사용
		$.ajax({
			url : "selectCalender",
			contentType: "application/json",
			data:JSON.stringify(data),
			dataType:"json",
			type:"POST"
		}).success(function(data){
			$monthHeader.html(now.getMonth);
//		console.log(data);
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
	};
	
	$monthPrev.click(function(e) {
		now.setDate(now.getPrevMonth());
		createCalender(now);
	});

	$monthNext.click(function(e) {
		now.setDate(now.getNextMonth());
		createCalender(now);
	});
	$(document).ready(function(){
		createCalender(now);
	});
	
})();