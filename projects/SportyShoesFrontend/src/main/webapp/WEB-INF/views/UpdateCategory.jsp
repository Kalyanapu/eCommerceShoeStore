<%@page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/Header.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="<c:url value="/UpdateCategory"/>" method="post">

	<table align="center" class="table">

		<tr>

			<td colspan="2">
				<h2>
					<center>Category</center>
				</h2>
			</td>
		</tr>

		<tr>
			<td>Category Id</td>
			<td><input type="text" name="catgId"
				value="${category.categoryId}" readonly /></td>
		</tr>

		<tr>
			<td>Category Name</td>
			<td><input type="text" name="catgName"
				value="${category.categoryName}" /></td>
		</tr>

		<tr>
			<td>Category Description</td>
			<td><input type="text" name="catgDesc"
				value="${category.categoryDesc}" /></td>
		</tr>

		<tr>
			<td colspan="2">
				<center> <input type="submit" value="UPDATE CATEGORY"/></center></td>
	</table>







</form>