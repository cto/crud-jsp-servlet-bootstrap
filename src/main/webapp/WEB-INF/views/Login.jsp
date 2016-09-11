<%@include file="../common/header.jspf"%>

<%@include file="../common/navigation-not-loggedin.jspf"%>

<div class="container">
	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<form action="/login.action" method="post">
		Please enter your name <input type="text" name="name" /> Please enter
		your password <input type="password" name="password" /> <input
			type="submit" value="Login" />
	</form>

</div>

<%@include file="../common/footer.jspf"%>