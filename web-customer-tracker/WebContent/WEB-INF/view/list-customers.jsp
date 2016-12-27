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
			
			<input type="button" value="Add Customer" 
			onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"/>
				
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email Name</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var="tempCust" items="${customers}">
					
					<!-- construct an update link with customer id for each row -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCust.id}"></c:param>
					</c:url>
					
					<!-- construct a delete link with customer id for each row -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCust.id}"></c:param>
					</c:url>
					
						<tr>
							<td>${tempCust.firstName}</td>
							<td>${tempCust.lastName}</td>
							<td>${tempCust.email}</td>
							<td><a href="${updateLink}">Update</a>
							| 
							<a href="${deleteLink}" 
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false;">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>