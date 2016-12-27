<!-- used to allow elements from spring on the view -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>List of customers</title>
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/style.css">
	</head>
	
	<body>
		
		
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email Name</th>
					</tr>
					
					<c:forEach var="tempCust" items="${customers}">
						<tr>
							<td>${tempCust.firstName}</td>
							<td>${tempCust.lastName}</td>
							<td>${tempCust.email}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>