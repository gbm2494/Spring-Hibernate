<!-- allows to use form structure of spring -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration Form</title>
	</head>
	
	<body>
			<!--modelAttribute is the same than in the controller  -->
		<form:form action="processForm" modelAttribute="student">
		
			<!-- you use as path name attributes from the model  -->
			First name: <form:input path="firstName"></form:input>
			<br><br>
			
			Last name: <form:input path="lastName"></form:input>
			<br><br>
			
			Country: 
			
			<!-- it works when you want to use hard code countries
			<form:select path="country">
				<form:option value="Costa Rica" label="Costa Rica"></form:option>
				<form:option value="España" label="España"></form:option>
				<form:option value="USA" label="USA"></form:option>
				<form:option value="Brasil" label="Brasil"></form:option>
			</form:select>
			-->
			
			<form:select path="country">
				<!-- to use hashmap list of countries created in the class -->
				<form:options items="${student.countryOptions}"></form:options>
			</form:select>
			
			<br><br>
			
			Favorite programming language:
			<br><br>
			
			<!--  
			 <form:radiobutton path="favoriteLanguage" value="Java"/>Java
			 <form:radiobutton path="favoriteLanguage" value="C#"/>C#
			 <form:radiobutton path="favoriteLanguage" value="HTML"/>HTML
			 <form:radiobutton path="favoriteLanguage" value="C++"/>C++
			-->
			
			<!-- to use hashmap list of languages created in the class -->
			 <form:radiobuttons path="favoriteLanguage" items="${student.languageOptions}"  />
			
			<br><br>
			
			Operating systems:
			<form:checkbox path="operatingSystems" value="Windows"/>Windows
			<form:checkbox path="operatingSystems" value="Linux"/>Linux
			<form:checkbox path="operatingSystems" value="MacOS"/>MacOS
			
			<br><br>
			<input type="submit" value="Submit"/>
			
		</form:form>
	</body>
</html>