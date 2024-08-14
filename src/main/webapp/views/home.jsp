<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<script>
document.addEventListener('DOMContentLoaded', () => {
    const token = localStorage.getItem('jwtToken');
    
    // Function to fetch data from a protected API
    function fetchProtectedData() {
        if (!token) {
            console.error('No token found. User might not be authenticated.');
            return;
        }

        fetch('/homee', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`,
/*                 'Content-Type': 'application/json'
 */            }
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
/*             window.location.href= "/homee";
 */  
 		return response.json();
        })
        .then(data => {
            console.log('Data:', data);
            // Handle the response data (display it or use it as needed)
            document.getElementById('data-container').textContent = JSON.stringify(data, null, 2);
        })
        .catch(error => console.error('Error:', error));
    }

    // Call the function to fetch protected data
    fetchProtectedData();
});

// Function to handle logout
function handleLogout() {
    localStorage.removeItem('jwtToken');
    window.location.href = '/login'; // Redirect to login page
}
</script>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div>
		<h1>Welcome to Your Home Page</h1>
		<div id="data-container">Loading data...</div>
		<button onclick="handleLogout()">Logout</button>
	</div>
</body>
</html>
