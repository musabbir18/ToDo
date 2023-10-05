<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="component/navbar.jsp"%>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Add Todo</h3>
						<form action="add_todo" method="post">
							<form>
								<div class="form-group">
									<label for="exampleInputEmail1">Name</label> <input type="text"
										class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" name="username">

								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">ToDo</label> <input type="text"
										class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" name="todo">

								</div>
								<div class="form-group">
									<label for="inputState">Status</label> <select id="inputState"
										class="form-control" name="status">
										<option selected>Select</option>
										<option  value="pending">Pending..</option>
										<option  value="complete">Complete</option>

									</select>
								</div>
								<div class="text-center">
									<button type="submit" class="btn btn-primary">Add</button>
								</div>
							</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>