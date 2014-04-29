/**
 * 
 */

$(document).ready(
		function() {
			var form = $('.form-reserve');
			var calPayment = function() {
				var payPerDay = form.find('[name=payPerDay]').val();
				var nights = form.find('[name=nights]').val();

				if (payPerDay === "" || payPerDay.length == 0) {
					return;
				}
				if (nights === "" || nights.length == 0) {
					return;
				}
				var result = payPerDay * nights;

				form.find('[name=payment]').val(result);
			};

			var makeReserve = function(data) {
				var reserve = {};
				var reserveName = [ 'reservDate', 'roomNo', 'chkin', 'nights',
						'rName', 'payPerDay', 'payment', 'deposit', 'balance',
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

			(function autoDate() {
				var tDay = new Date();
				var tMonth = tDay.getMonth() + 1;
				var tDate = tDay.getDate();
				if (tMonth < 10)
					tMonth = "0" + tMonth;
				if (tDate < 10)
					tDate = "0" + tDate;
				form.find('[name=reservDate]').val(
						tDay.getFullYear() + "-" + tMonth + "-" + tDate);
			})();

			form.find('[name=nights]').change(calPayment);
			form.find('[name=payPerDay]').change(calPayment);

			form.find('[name=deposit]').change(function() {
				var payment = form.find('[name=payment]').val();
				var deposit = form.find('[name=deposit]').val();

				if (payment === "" || payment.length == 0) {
					return;
				}
				if (deposit === "" || deposit.length == 0) {
					return;
				}

				var result = payment - deposit;
				form.find('[name=balance]').val(result);
			});
			
			form.submit(function(e){
				var arr = form.serializeArray();
				var data = {
						reserverModel : makeReserver(arr),
						reserveModel : makeReserve(arr)
				};
				
//				data = {"reserverModel":{"rName":"ddd","gender":"M","nationality":"kor","phone":"010101","email":"fdf@df.com"},"reserveModel":{"reservDate":"2014-04-27","roomNo":"201","chkin":"2014-04-30","nights":"3","rName":"ddd","payPerDay":"30000","payment":"90000","deposit":"40000","balance":"50000","via":"no"}};
				
				console.log(data);
				$.ajaxSetup({
					contentType : "application/json"
				});
				
				$.post("postInputForm", JSON.stringify(data), function(response){
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

//			form.submit(function(e) {
//				var arr = form.serializeArray();
//				$.ajaxSetup({
//					contentType : "application/json"
//				});
//				$.post('insertReserver', makeReserver(arr),
//						function(data) {
//							$.post('insertReserve', makeReserve(arr), function(
//									data) {
//								if (data) {
//									window.href = "dashboard.roi";
//								}
//							});
//						});
//			});
		});