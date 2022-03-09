<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>


<option>

</option>
<form method="post" action="/infra/code/codeUpdt">

<%-- <select name="ifcgSeq">
<c:otherwise>
	<c:forEach items="${list}" var="item2" varStatus="status">
		<option value="<c:out value="${item2.ifcdSeq}"/>"/>
		<option value="<c:out value="${item2.ifcdName}"/>"/>
		<option value="<c:out value="${item2.ifcdSeq}"/>"/>
	</option>
	</c:forEach>
	</c:otherwise> --%>
</select>
<!-- <select name="ifcgSeq">
	<option>코드그룹명1</option>
	<option>코드그룹명2</option>
	<option>코드그룹명3</option>
	<option>코드그룹명4</option>
</select> -->


	<input type="hidden" name="ifcdSeq" value="<c:out value="${item2.ifcdSeq}"/>">
	<input type="text" name="ifcdName" placeholder="아이디" value="<c:out value="${item2.ifcdName}"/>">
	<input type="submit" value="제출">
</form>