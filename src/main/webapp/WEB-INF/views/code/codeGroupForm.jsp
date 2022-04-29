<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>

<link href="/infra/resources/jquery/jquery-ui-1.13.1.custom/jquery-ui.css" rel="stylesheet"> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<!-- <form id="form" method="post" action="/infra/code/codeGroupInst"> -->
<form id="form" method="post" action="/infra/code/codeGroupInst" enctype="multipart/form-data">
<input type="hidden" name="thisPage" value="<c:out value="${vo.thisPage }"/>">
	<input type="hidden" name="shOption" value="<c:out value="${vo.shOption }"/>">
	<input type="hidden" name="shValue" value="<c:out value="${vo.shValue }"/>">
	<input type="hidden" name="">
	<input type="text" name="ifcgName" placeholder="아이디">
	<input type="text" id="abcDate" name="abcDate">
	<br><input type="file" name="File" multiple>
	<br><input type="file" name="File1">
<!-- 	<div class="col-sm-6 mt-3 mt-sm-0">
		<label for="file1" class="form-label input-file-button">파일첨부</label>
		<input class="form-control form-control-sm" id="file1" name="file1" type="file"	multiple="multiple" style="display: none;" onchange="upload(1,1);">
		<div class="addScroll">
			<ul id="ulFile0" class="list-group">
			</ul>
		</div>
	</div> -->
	<input type="submit" value="제출">
</form>

<a href="/infra/code/codeGroupList?thisPage=${vo.thisPage}&shOption=<c:out value="${vo.shOption }"/>&shValue=<c:out value="${vo.shValue }"/>">목록</a>

<script src="/infra/resources/jquery/jquery-ui-1.13.1.custom/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		 $("#abcDate").datepicker();
	}); 
	
	$.datepicker.setDefaults({
	    dateFormat: 'yy-mm-dd',
	    prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	    showMonthAfterYear: true,
	    yearSuffix: '년'
	});
</script>
<!-- <script>
	upload = function(seq, div){
		$("#ulFile0").children().remove();
		
		var fileCount = $("input[type=file]")[seq].files.length;
		
		if(checkUploadedTotalFileNumber(fileCount, seq) == false){ return false; }
		
		var totalFileSize;
		for (var i=0; i< fileCount; i++){
			if(div == 1){
				if(checkUploadedAllExt($("input[type=file]")[seq].files[i].name, seq) == false) {return false; }
			} else if(div == 2){
				if(checkUploadedImageExt($("input[type=file]")[seq].files[i].name, seq) == false) {return false; }
			} else {
				return false;
			}
			
			if(checkUploadedEachFileSize($("input[type=file]")[seq].files[i].name, seq) == false ) {return false; }
			totalFileSize += $("input[type=file]")[seq].files[i].size;
		}
		
		if(checkUploadedTotalFileSize(totalFileSize, seq) == false) {return false; }
		
		for (var i = 0; i <fileCount; i++){
			addUploadLi(seq, i, $("input[type=file]")[seq].file[i].name);
		}
	}
	
	addUploadLi = function (seq, index, name){
		
		var ul_list = $("#ulFile0");
		
		li = '<li id="li+'+seq+'_'+index+'" class="list-group-item d- flex justify-content-between align-items-center">';
		li = li + name;
		li = li +'<span class="badge bg-danger rounded-pill" onClick="delLi('+seq+','+index+')"><i class="fa-solid fa-x" style="cursor: pointer;"></li></span>';
		li = li +'</li>';
		
		$("#ulFile" +seq).append(li);
	}
	
	delLi = function(seq, index){
		$("#li_"+seq+"_"+index).remove();
	}
</script> -->