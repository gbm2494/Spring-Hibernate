<!DOCTYPE>
<html>
	<body>
		<h2>SPRING MVC DEMO - HOME PAGE</h2>
		
		<hr>
		
		<!-- the correct way to use resources (same way for css, js, ...)
		${pageContext.request.contextPath} is a JSP expression
		 <link rel="stylesheet" type="text/css"           

           href="${pageContext.request.contextPath}/resources/css/my-test.css">

    	<script src="${pageContext.request.contextPath}/resources/js/simple-test.js">
    	</script>
		
		<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png">
		-->
		
		<!-- this href changes according to the parent request mapping from the controller -->
		<a href="helloWorld/showForm">Hello world form</a>
		
		<br><br>
		<a href="student/showForm">Student form</a>
		
	</body>
</html>