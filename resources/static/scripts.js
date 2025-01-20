document.addEventListener("DOMContentLoaded", function() {
    const loginForm = document.getElementById("loginForm");
    const registerForm = document.getElementById("registerForm");

    if (loginForm) {
        loginForm.addEventListener("submit", function(event) {
            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;

            if (!validateEmail(email)) {
                alert("Please enter a valid email address.");
                event.preventDefault();
            }

            if (password.length < 6) {
                alert("Password must be at least 6 characters long.");
                event.preventDefault();
            }
        });
    }

    if (registerForm) {
        registerForm.addEventListener("submit", function(event) {
            const name = document.getElementById("name").value;
            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;

            if (name.trim() === "") {
                alert("Name is required.");
                event.preventDefault();
            }

            if (!validateEmail(email)) {
                alert("Please enter a valid email address.");
                event.preventDefault();
            }

            if (password.length < 6) {
                alert("Password must be at least 6 characters long.");
                event.preventDefault();
            }
        });
    }

    function validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(email).toLowerCase());
    }
});
