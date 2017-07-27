<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<h3>Rating Details</h3>
<h4>Total Reviews:</h4><h4>${count}</h4>
<h4>Total Rating:</h4><h4>${avg}</h4>
<c:if test="${!empty ratings}">
	<table class="tg">
	<tr>
		<th width="80">TITLE</th>
		<th width="120">USERNAME</th>
		<th width="120">RATING</th>
		<th width="60">DATE OF STAY</th>
		<th width="60">REVIEW</th>
	</tr>
	<c:forEach items="${ratings}" var="r">
		<tr>
			<td>${r.title}</td>
			<td>${r.userName}</td>
			<td>${r.rating}</td>
			<td>${r.dateOfStay}</td>
			<td>${r.desc}</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>