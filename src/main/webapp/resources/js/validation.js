
// 자바 함수
/*setVolume(a) {
	
	
}*/
// jquery 형 함수
// jquery를 쓰는게 좋음
checkNull = function (obj, value, message){
	if(value == "" || value == null){
			alert("validation.js: " + message);
			obj.focus();
			return false;
		} else {
			return true;
		}
} 

// javascript
/*
function CheckNull (obj, value, message){
	if(value == "" || value == null){
			alert("validation.js: " + message);
			obj.focus();
			return false;
		}
}
*/