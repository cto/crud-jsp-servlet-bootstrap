<%@include file="../common/header.jspf"%>

<%@include file="../common/navigation-loggedin.jspf"%>

<div class="container">
	<p>Welcome ${userName}
	<p>Enter name (description) and category of the item here</p>

	<form action="/addItem.action" method="post">
		<fieldset class="form-group">
			<label>Description</label> <input type="text" class="form-control"
				name="nameOfOneMoreItem" /><br />
		</fieldset>
		<fieldset class="form-group">
			<label>Category</label> <input type="text" class="form-control"
				name="categoryOfOneMoreItem" /><br />
		</fieldset>
		<input type="submit" class="btn btn-success" value="Add"></input>
	</form>

</div>

<%@include file="../common/footer.jspf"%>