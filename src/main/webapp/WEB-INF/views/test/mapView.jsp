<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!doctype html>
<html lang="ko">
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>
	<!--  -->
<div align="center" id="map" style="width:500px;height:800px;"></div>
	

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7cd4aacffe9949b52780dbc9332fce55&libraries=clusterer"></script>
<script>
    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.458812516698835, 128.16112057538854), // 지도의 중심좌표 
        level : 13 // 지도의 확대 레벨 
    });
    
    // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 10 // 클러스터 할 최소 지도 레벨 
    }); 
    
     var positions = [
         {"lat":"37.5041457952342","lng":"126.75670653635","imageSrco":"/infra/resources/mapimg/ph1.jpg","desc":"여기는 어디?1"},
		 {"lat":"37.5025416520547","lng":"126.775312407757","imageSrco":"/infra/resources/mapimg/ph1.jpg","desc":"여기는 어디?2"},
		 {"lat":"37.4840369248427","lng":"126.782649695027","imageSrco":"/infra/resources/mapimg/ph1.jpg","desc":"여기는 어디?3"},
		 {"lat":"37.5063910880502","lng":"126.754135635056","imageSrco":"/infra/resources/mapimg/ph1.jpg","desc":"여기는 어디?4"},
		 {"lat":"37.5040647136354","lng":"126.763949321773","imageSrco":"/infra/resources/mapimg/ph1.jpg","desc":"여기는 어디?5"},
		 {"lat":"37.4848682902839","lng":"126.814294408974","imageSrco":"/infra/resources/mapimg/ph1.jpg","desc":"여기는 어디?"},
		 {"lat":"37.5090549772014","lng":"126.745618159413","imageSrco":"/infra/resources/mapimg/ph1.jpg","desc":"여기는 어디?"},
		 {"lat":"37.5043220835774","lng":"126.755031466805","imageSrco":"/infra/resources/mapimg/ph1.jpg","desc":"여기는 어디?"},
		 {"lat":"37.5043180280618","lng":"126.762084138624","imageSrco":"/infra/resources/mapimg/ph1.jpg","desc":"여기는 어디?"},
		 {"lat":"37.5158442051041","lng":"126.802410566976","imageSrco":"/infra/resources/mapimg/ph1.jpg","desc":"여기는 어디?10"}
		 ];                  
    
    var markers =[];	//markers 배열 생성

    for(var i = 0; i < positions.length; i++) {	//for문으로 position배열 안에 있는 좌표에 마커 입력
    	          	
       var markerPosition  = new kakao.maps.LatLng(positions[i].lat,positions[i].lng);
    
       var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png'; // 마커이미지 주소
       imageSize = new kakao.maps.Size(35, 35);                // 마커이미지의 크기
       imageOption = {offset: new kakao.maps.Point(27, 69)};   // 마커의 좌표와 일치시킬 이미지 안에서의 좌표설정
       
	   // 마커의 이미지정보를 가지고 있는 마커이미지를 생성 
	   var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
    
        var marker	= new kakao.maps.Marker({
    		position: markerPosition,
    		image: markerImage,
    		map: map,
    		clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정
    	});
        markers.push(marker);	//marker객체를 markers에 추가
      // 내용
	    var iwContent = '<div class="modal-body">'+
	    '<h5>스토리 이미지</h5>'+
	    '<hr>'+
	    '<img src="'+positions[i].imageSrco+'" width="100px" height="100px"/><br><br>'+
	    '<h5>여행 스토리</h5>'+
	    '<hr>'+
	    '<p class="modal-body">'+positions[i].desc+'</p>'+
	  	'</div>'
	  	,iwRemoveable = true;
	  	
	  	
	  var infowindow = new kakao.maps.InfoWindow({
		    content : iwContent,
		     removable : iwRemoveable 
		});
	    kakao.maps.event.addListener(marker, 'click', makeClickListener(map, marker, infowindow));
	    
	    
    }	// for문 끝
    

    
    function makeClickListener(map, marker, infowindow) {
        return function() {
            infowindow.open(map, marker);
        };
    }
    
    clusterer.addMarkers(markers);

</script>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>