<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IT Industries</title>
</head>
<body>


	<h1>${headerValue}</h1>
	<h1> Congratulation! Your Application form processed successfully.</h1>
	<h3> Details Submitted By You: </h3>
	
	<table>
		<tr>
			<td> Student Name: </td>
			<td> ${studentDetails.studentName} </td>
		</tr>
		
		<tr>
			<td> Student Hobby : </td>
			<td> ${studentDetails.studentHobby}</td>	
		</tr>
		
		<tr>
			<td> Student Mobile : </td>
			<td> ${studentDetails.studentMobile}</td>	
		</tr>
		<tr>
			<td> Student DOB : </td>
			<td> ${studentDetails.studentDOB}</td>	
		</tr>	
		
		<tr>
			<td> Student Skills : </td>
			<td> ${studentDetails.studentSkills}</td>	
		</tr>
		<tr>
			<td> Student Address </td>
			<td> country: ${studentDetails.studentAddress.country}
				 city	: ${studentDetails.studentAddress.city}	
				 street : ${studentDetails.studentAddress.street}	
				 pincode: ${studentDetails.studentAddress.pincode}	
			</td>
		</tr>
	</table>
	
</body>
</html>