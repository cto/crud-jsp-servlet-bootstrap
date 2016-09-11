<%@include file="../common/header.jspf"%>

<%@include file="../common/navigation-loggedin.jspf"%>

<div class="container">
	<p>Welcome ${userName}
	<p>You have the following items</p>
	<table class="table table-striped">
		<thead>
		</thead>
		<tbody>
			<th>Description</th>
			<th>Category</th>
			<th>Action</th>
		</tbody>
		<c:forEach items="${items}" var="oneItem">
			<tr>
				<td>${oneItem.name}</td>
				<td>${oneItem.category}</td>
				<td><a class="btn btn-danger"
					href="/deleteItem.action?itemName=${oneItem.name}&itemCategory=${oneItem.category}">Delete
				</a></td>
			</tr>
		</c:forEach>
	</table>

	<a class="btn btn-success" href="/addItem.action"> Add </a>

</div>

<%@include file="../common/footer.jspf"%>