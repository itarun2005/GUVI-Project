document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Simple validation
    if (email === '' || password === '') {
        alert('Please fill in all fields.');
        return;
    }

    // Simulate login
    alert('Login successful!');
});

document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Simple validation
    if (name === '' || email === '' || password === '') {
        alert('Please fill in all fields.');
        return;
    }

    // Simulate registration
    alert('Registration successful!');
});

function deleteAccount() {
    if (confirm('Are you sure you want to delete your account?')) {
        alert('Account deleted successfully!');
        // Logic to delete account goes here
    }
}
