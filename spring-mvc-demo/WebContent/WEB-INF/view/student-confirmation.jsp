<!-- used to allow elements from spring on the view -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Student Confirmation</title>
	</head>
	
	<body>
			<!-- use name of the attribute you add to the model -->
		The student is confirmed: ${student.firstName} ${student.lastName} 
		
		<br><br>
		Country: ${student.country}
		
		<br><br>
		Favorite programming language: ${student.favoriteLanguage}
		
		<br><br>
		Operating Systems:
			<ul>
				<!-- used to read every element in the array -->
				<c:forEach var="temp" items="${student.operatingSystems}">
					<li> ${temp} </li>
				</c:forEach>
				
			</ul>
	</body>
</html>