<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>

<script>
    function validateForm(event) {
        
        event.preventDefault();

        // Get form elements 
        var user = document.getElementById('user').value;
        var empid = document.getElementById('eid').value;
        var password = document.getElementById('pass').value;
        var conpass = document.getElementById('conpass').value;

        // Check if any required field is empty
        if (user === "" || empid === "" || password === "" || conpass === "") {
            document.getElementById('msg').textContent = 'Please fill out all required fields.';
            document.getElementById('msg').style.display = 'block';
        } else if (password !== conpass) {
            // Check if passwords match, agar nhi kr rha then diaplay appropriate msg
            document.getElementById('msg').textContent = 'Passwords do not match.';
            document.getElementById('msg').style.display = 'block';
        } else {
            // If everything is okay, submit the form
            document.getElementById('msg').textContent = 'You have Signed Up successfully';
            document.getElementById('msg').style.display = 'block';
            document.getElementById('signupForm').submit();
           
           
        }
    }
</script>

</head>
<body>
<form id="signupForm" action="/signup" method="post" onsubmit="validateForm(event)">
    	<h1>Create New User</h1>
        <div>User-name:</div> <input id="user" name="username" type="text" placeholder="Enter username" required><br><br>
        
        <div>Password:</div><input id="pass" name="password" type="password" placeholder="Enter password" required><br><br>
        <div>Confirm Password:</div> <input id="conpass" name="confirmpassword" type="password" placeholder="Re-enter password" required><br><br>
        <div>Employee ID:</div> <input id="eid" name="eid" type="text" placeholder="Enter Employee ID" required><br><br>
        <div>Address:</div> <input id="address" name="address" type="text" placeholder="Enter address"><br><br>
        <div>Designation :</div> <input id="designation" name="designation" type="text" placeholder="Enter your designation"><br><br>
        <div>Gender :</div> <input id="gender" name="gender" type="text" placeholder="Enter your gender"><br><br>
        <div>Date of Birth:</div> <input id="dob" name="dob" type="date" placeholder="Enter date of birth"><br><br>
        <input type="submit" value="Sign Up">
        <div id="msg"></div>
    </form>

</body>
</html>