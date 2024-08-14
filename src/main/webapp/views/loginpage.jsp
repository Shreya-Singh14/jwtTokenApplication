<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER LOGIN</title>
<script>
    async function handleLogin(event) {
        event.preventDefault(); // Prevent the default form submission

        const form = event.target;
        const formData = new FormData(form);
        const username = formData.get('username');
        const password = formData.get('password');

        try {
            const response = await fetch('/authlogin', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: new URLSearchParams({
                    'username': username,
                    'password': password
                })
            });

            if (response.ok) {
                const result = await response.json();
                if (result.token) {
                    localStorage.setItem('jwtToken', result.token);
                    console.log("___________________");
                    console.log(result.token);
                    console.log("######################################################################");
                    
                    const token = localStorage.getItem('jwtToken');
                    console.log(token);

                    window.location.href = '/homee'; // Redirect after successful login 
                } else {
                    showError('Login failed. Please try again.');
                }
            } else {
                showError('Login failed. Please check your username and password.');
            }
        } catch (error) {
            console.error('Error:', error);
            showError('An error occurred during login.');
        }
    }

    function showError(message) {
        const errorDiv = document.getElementById('error-message');
        errorDiv.textContent = message;
        errorDiv.style.display = 'block';
    }

    document.addEventListener('DOMContentLoaded', () => {
        document.getElementById('login-form').addEventListener('submit', handleLogin);
    });
</script>
</head>
<body>
    <form id="login-form">
        <h1>USER LOGIN</h1><br>
        <div id="error-message" style="color: red; display: none; margin-top: 10px;"></div>
        <div>User-name:</div>
        <input id="username" name="username" type="text" placeholder="Enter your username" required><br><br>
        <div>Password:</div>
        <input id="password" name="password" type="password" placeholder="Enter password" required><br><br>
        <input type="submit" value="Login"><br><br>
    </form>
    <div class="signup-link">
        <p id="register">
            Don't have an account? <a href="/signup">Sign up here</a>
        </p>
    </div>
</body>
</html>
