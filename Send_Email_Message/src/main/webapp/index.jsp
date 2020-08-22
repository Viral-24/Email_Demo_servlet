<html>
<body>
	<h2>Contact Us !!!</h2>
	<form action="MyServlet/sendemail" method="post">
		<table>
			<tr>
				<td align="left"><b>To     </b></td>
				<td><input type="text" name="email" size="75"></td>
			</tr>
			
			<tr>
				<td align="left"><b>Subject </b></td>
				<td><input type="text" name="subject" size="75"></td>
			</tr>
			
			<tr>
				<td align="left"><b>Message </b></td>
				<td><textarea rows="6" cols="78" name="message"></textarea></td>
			</tr>
			
			<tr>
				<td></td>
				<td><button type="submit">Submit</button></td>
			</tr>
			
		</table>
	</form>
</body>
</html>
