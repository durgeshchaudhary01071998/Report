<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h3 class="pb-3 pt-3 text-md-center">Report Application</h3>
		<hr>

		<form:form action="search" modelAttribute="search" method="POST">

			<table class="table table-striped table-hover">
				<tr>
					<td>Plan Name:</td>
					<td><form:select path="planName">
							<form:option value="">-Select-</form:option>
							<form:options items="${names}" />
						</form:select></td>
					<td>Plan Status:</td>
					<td><form:select path="planStatus">
							<form:option value="">-Select-</form:option>
     <<form:options items="${status}" />
						</form:select></td>
					<td>Gender:</td>
					<td><form:select path="gender">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Fe-Male">Fe-Male</form:option>
						</form:select></td>
					<td>Start Date:</td>
					<td><form:input path="startDate" type="Date" /></td>
					<td>End Date:</td>
					<td><form:input path="endDate" type="Date" /></td>
				</tr>

			</table>
			<div class="text-md-center ">
				<a class="btn btn-primary" href="/" role="button">Clear</a> <input
					type="submit" value="Search" class="btn btn-primary ">
			</div>


		</form:form>

		<hr>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>S.No.</th>
					<th>Holder Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Benefit Amt</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans }" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.gender}</td>
						<td>${plan.planName}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEndDate}</td>
						<td>${plan.benefitAmt}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8" class="text-md-center"><c:if
							test="${empty plans }">
				    No Records Found In Database
				  </c:if></td>
				</tr>
			</tbody>
		</table>

		<hr>
		Export: <a href="excel">Excel</a> <a href="pdf">Pdf</a>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>

</body>
</html>