<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<form id="" name="" method="get" action="/infra/code/codeList">
<select name="shIfcdDelNy">
	<option value="">::삭제여부::
	<option value="1" <c:if test="${vo.shIfcgDelNy eq 1 }">selected</c:if>>Y
	<option value="0" <c:if test="${vo.shIfcgDelNy eq 0 }">selected</c:if>>N
</select>
||
	회원이름: <input type="text" name="shIfcdName" value="<c:out value="${vo.shIfcdName}"/>">
	<input type="submit" name="search">
||
<select name="shOption">
	<option value="">::검색구분::
	<option value="1" <c:if test="${vo.shOption eq 1 }">selected</c:if>>한글
	<option value="2" <c:if test="${vo.shOption eq 2 }">selected</c:if>>영문
</select>
<input type="text" name="shValue" value="<c:out value="${vo.shValue}"/>">
<input type="submit" name="search">
</form>

<c:choose>
	<c:when test="${fn:length(list) eq 0}">
		<tr>
			<td class="text-center" colspan="9">There is no data!</td>
		</tr>	
	</c:when>
	<c:otherwise>
		<c:forEach items="${list}" var="item2" varStatus="status">	
		
		<%-- <c:out value="${item.ifcgSeq}"/> | <c:out value="${item.ifcgName}"/> | <c:out value="${item.delNy}"/> <br> --%>
		<c:out value="${item2.ifcdSeq}"/> | <a href="/infra/code/codeView?ifcdSeq=<c:out value="${item2.ifcdSeq}"/>"><c:out value="${item2.ifcdName}"/></a> | <c:out value="${item2.ifcdDelNy}"/>|<c:out value="${item2.ifcdNameEng}"/> <br>
		
		</c:forEach>
	</c:otherwise>
</c:choose>	 

<c:out value="${vo.startPage}"/>

<nav aria-label="...">
  <ul class="pagination">
    <c:if test="${vo.startPage gt vo.pageNumToShow}">
                <li class="page-item"><a class="page-link" href="/infra/code/codeList?thisPage=${vo.startPage - 1}">Previous</a></li>
</c:if>
<c:forEach begin="${vo.startPage}" end="${vo.endPage}" varStatus="i">
	<c:choose>
		<c:when test="${i.index eq vo.thisPage}">
                <li class="page-item active"><a class="page-link" href="/infra/code/codeList?thisPage=${i.index}">${i.index}</a></li>
		</c:when>
		<c:otherwise>             
                <li class="page-item"><a class="page-link" href="/infra/code/codeList?thisPage=${i.index}">${i.index}</a></li>
		</c:otherwise>
	</c:choose>
</c:forEach>     
<c:if test="${vo.endPage ne vo.totalPages}">                
                <li class="page-item"><a class="page-link" href="/infra/code/codeList?thisPage=${vo.endPage + 1}">Next</a></li>
</c:if>
  </ul>
</nav>