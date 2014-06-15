/**
 * ['formatDate']
 */
(function(){
	
	var tplBody = Handlebars.compile($("#tpl-body").html());
	var tplHead = Handlebars.compile($("#tpl-head").html());
	
	var roomNoSet = {
	    	room2nd : ["201", "202", "203"],
	    	room3rd : ["301", "302", "303"],
	    	room4th : ["401", "402"],
			df : ["df1", "df2", "df3", "df4", "df5"],
			dm : ["dm1", "dm2", "dm3", "dm4", "dm5"]
	};
	roomNoSet.room = roomNoSet.room2nd.concat(roomNoSet.room3rd).concat(roomNoSet.room4th);
	
	var roomNos = roomNoSet.room.concat(roomNoSet.df).concat(roomNoSet.dm);
	
	var $tableBody = $("#table-body");
	var $tableHead = $("#table-head");
	var $reserveFormModal = $("#reserveFormModal");
	
	var $form = {
			form : $reserveFormModal.find("form"),
			reserveDate : $reserveFormModal.find('[name=reserveDate]'),
			roomNo : $reserveFormModal.find('[name=roomNo]'),
			chkin : $reserveFormModal.find('[name=chkin]'),
			nights : $reserveFormModal.find('[name=nights]'),
			payPerDay : $reserveFormModal.find('[name=payPerDay]'),
			payment : $reserveFormModal.find('[name=payment]'),
			deposit : $reserveFormModal.find('[name=deposit]'),
			balance : $reserveFormModal.find('[name=balance]'),
			via : $reserveFormModal.find('[name=via]'),
			rName : $reserveFormModal.find('[name=rname]'),
			gender : $reserveFormModal.find('[name=gender]'),
			nationality : $reserveFormModal.find('[name=nationality]'),
			phone : $reserveFormModal.find('[name=phone]'),
			email : $reserveFormModal.find('[name=email]')
	};
	
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
		return  (temp.getMonth() +1) +"/" + temp.getDate();
	});
	
	Handlebars.registerHelper("roomHelper", function(room){
		if(room.chked){
			return "checked"
		} else {
			return "unchecked";
		}
	});
	
	Handlebars.registerHelper("roomTypeHelper", function(roomNo){
		
//		console.log(roomNo);
//		console.log("room : " + $.inArray(roomNo, roomNoSet.room));
//		console.log("room2nd : " + $.inArray(roomNo, roomNoSet.room2nd));
//		console.log("room3nd : " + $.inArray(roomNo, roomNoSet.room3rd));
//		console.log("room4nd : " + $.inArray(roomNo, roomNoSet.room4th));
//		
//		console.log("df : " + $.inArray(roomNo, roomNoSet.df));
//		console.log("dm : " + $.inArray(roomNo, roomNoSet.dm));
		
		
		if($.inArray(roomNo, roomNoSet.room) !== -1){
			if($.inArray(roomNo, roomNoSet.room2nd ) !== -1){
				return "room2nd";
			} else if($.inArray(roomNo, roomNoSet.room3rd) !== -1){
				return "room3rd";
			} else if($.inArray(roomNo, roomNoSet.room4th) !== -1){
				return "room4th";
			}
			return "room";
		} else if($.inArray(roomNo, roomNoSet.df) !== -1){
			return "df";
		} else if($.inArray(roomNo, roomNoSet.dm) !== -1){
			return "dm";
		} else {
			return "";
		}
	});
	
	var $monthHeader = $("#month-header"), $monthPrev = $("#month-toPrev"), $monthNext = $("#month-toNext");

	
	
	var now = new FormatDate(new Date());
	
	var isExist = function(rooms, roomNo){
		rooms.forEach(function(room){
			if(room.roomNo === roomNo){
				return true;
			}
		});
		return false;
	};
	
	var createCalenderHeader = function(){
		$tableHead.append(tplHead({rooms : roomNos}));
	};
	
	var createCalender = function(){
		var data = {
				start : now.getDate(),
				end : now.getNextDate()
		};
		
		$("#table-body").empty();
		$.ajax({
			url : "selectCalender.roi",
			contentType: "application/json",
			data:JSON.stringify(data),
			dataType:"json",
			type:"POST"
		}).success(function(data){
			$monthHeader.html(now.getMonth);
//		console.log(data);
			data.forEach(function(calender, index){
//				console.log(calender);
				if(calender.rooms == null){
					var rooms = [];
					roomNos.forEach(function(roomNo){
						rooms.push({
							roomNo : roomNo,
							chked : false
						});
					});
					calender.rooms = rooms;
				}
			});
//			console.log(data);
//			console.log(JSON.stringify(data));
			
			$("#table-body").append(tplBody({data : data}));
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
		createCalenderHeader();
		createCalender(now);
	});
	
	(function(){
		
		var flag = false;
		var state = {
				roomNo : undefined
		};
		
		var cancel = function(){
			flag = false;
			$(".room.reserved").removeClass("reserved");
		};
		
		var isSameRoom = function($target){
			if($target.attr("roomNo") != state.roomNo){
				return false;
			} else {
				return true;
			}
		};
		
		var isAvailable = function($target){
			if($target.hasClass("unchecked")){
				return true;
			} else {
				return false;
			}
		};
		
		var isReserved = function($target){
			if($target.hasClass("checked")){
				return true;
			} else {
				return false;
			}
		};
		
		var getChkinDate = function(){
			var selected = $tableBody.find(".mouseover");
			var dateArr = [];
			
			for(var i =0;i< selected.length;i++){
				var cell = selected[i];
				dateArr.push($(cell).parent().attr("date"));
			}
			dateArr.sort();
			return Number(dateArr[0]);
		};
		
		$tableBody.mouseover(function(e){
			e.stopPropagation();
			var $target = $(e.target);
			if(flag && !isSameRoom($target)){
				cancel();
			}
			
			if(isReserved($target)){
				var $selected = $("[reserveid="+$target.attr("reserveid")+"]");
				$selected.addClass("reserved");
			}
			
			if(isAvailable($target)){
				$target.addClass("mouseover");
			} else {
				cancel();
			}
		});
		
		$tableBody.mouseout(function(e){
			e.stopPropagation();
			var $target = $(e.target);
			if(!flag){
				if($target.hasClass("unchecked") && $target.hasClass("mouseover")){
					$target.removeClass("mouseover");
				}
			}
			
			if(isReserved($target)){
				var $selected = $("[reserveid="+$target.attr("reserveid")+"]");
				$selected.removeClass("reserved");
			}
		});
		
		$tableBody.mousedown(function(e){
			e.stopPropagation();
			flag = true;
			state.roomNo = $(e.target).attr("roomNo");
		});
		
		$tableBody.mouseup(function(e){
			e.stopPropagation();
			var $target = $(e.target);
			if(isAvailable($target)){
				var nights = $tableBody.find(".mouseover").length;
				var roomNo = state.roomNo;
				var chkin = now.getformatDate(getChkinDate());
				console.log(chkin);
				$form.reserveDate.val(now.getformatDate(Date.now()));
				$form.nights.val(nights);
				$form.roomNo.val(roomNo);
				$form.chkin.val(chkin);
				$reserveFormModal.modal('show');
			}
			
			cancel();
		});
	})();
	
	(function(){
		//금액 자동완성
		var calPayment = function() {
			var payPerDay = $form.payPerDay.val();
			var nights = $form.nights.val();

			if (payPerDay === "" || payPerDay.length == 0) {
				return;
			}
			if (nights === "" || nights.length == 0) {
				return;
			}
			var result = payPerDay * nights;

			$form.payment.val(result);
		};
		$form.nights.change(calPayment);
		$form.payPerDay.change(calPayment);

		$form.deposit.change(function() {
			var payment = $form.payment.val();
			var deposit = $form.deposit.val();

			if (payment === "" || payment.length == 0) {
				return;
			}
			if (deposit === "" || deposit.length == 0) {
				return;
			}

			var result = payment - deposit;
			$form.balance.val(result);
		});
		
		//입력할 필요가 없는 필드에 커서가 오면 다음 항목으로 포커스를 옮김
		$form.payment.focus(function(e){
			$form.deposit.focus();
		});
		$form.balance.focus(function(e){
			$form.via.focus();
		});
	})();
	
		var makeReserve = function(data) {
			var reserve = {};
			var reserveName = [ 'reservDate', 'roomNo', 'chkin', 'nights',
			                    'reserver', 'payPerDay', 'payment', 'deposit', 'balance',
			                    'via' ];
			for ( var i in reserveName) {
				for ( var j in data) {
					if (data[j].name === reserveName[i]) {
						reserve[reserveName[i]] = data[j].value;
						break;
					}
				}
			}
			return reserve;
		};
		
		var makeReserver = function(data) {
			var reserver = {};
			var reserverName = [ 'rName', 'gender', 'nationality', 'phone',
			                     'email' ];
			for ( var i in reserverName) {
				for ( var j in data) {
					if (data[j].name === reserverName[i]) {
						reserver[reserverName[i]] = data[j].value;
						break;
					}
				}
			}
			return reserver;
		};
		
		$(".form-submit").click(function(e){
			
			var arr = $form.form.serializeArray();
			
			var data = {
					reserverModel : makeReserver(arr),
					reserveModel : makeReserve(arr)
			};
			
//			data = {"reserverModel":{"rName":"ddd","gender":"M","nationality":"kor","phone":"010101","email":"fdf@df.com"},"reserveModel":{"reservDate":"2014-04-27","roomNo":"201","chkin":"2014-04-30","nights":"3","rName":"ddd","payPerDay":"30000","payment":"90000","deposit":"40000","balance":"50000","via":"no"}};
			
			console.log(data);
			$.ajaxSetup({
				contentType : "application/json"
			});
			
			$.post("postInputForm.roi", JSON.stringify(data), function(response){
				console.log(response);
				if(response){
					alert("input success!");
					location.href = "dashboard.roi";
				} else {
					alert("input fail!!");
					location.reload(true);
				}
			});
		});
	
})();