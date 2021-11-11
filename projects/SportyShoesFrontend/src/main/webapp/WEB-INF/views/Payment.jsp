<%@page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>

<div class="container">

	<form action="<c:url value="/receipt"/>" method="post">
		<table class="table" table-bordered" width="50%" align="center">

			<tr class="success">


				<td colspan="2"><center>Payment Detail</center></td>
			</tr>
			<tr class="info">
				<td colspan="2">
					<center>

						<input type="radio" name="rd" value="cc">Credit Card <input
							type="radio" name="rd" value="cod">Cash on Delivery
					</center>
				</td>
			</tr>

			<tr class="warning">
				<td>Card number</td>
				<td><input type="text" name="cardno" /></td>
			</tr>

			<tr class="warning">
				<td>Valid</td>
				<td><input type="text" name="valid" /></td>
				<td>CW<input type="text" name="CW/" /></td>
			</tr>

			<tr class="success">
				<td colspan="2"><center>
						<input type="submit" value="Pay" class="btn btn-success" />
					</center>
			</tr>


			</center>

		</table>




	</form>


</div>