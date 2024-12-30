// Validate Login Form
function validateLoginForm() {
  var email = document.getElementById("loginEmail").value;
  var password = document.getElementById("loginPassword").value;

  if (email === "" || password === "") {
    alert("Please fill out all fields in the login form.");
    return false;
  }
  return true;
}

// Validate Register Form
function validateRegisterForm() {
  var name = document.getElementById("registerName").value;
  var email = document.getElementById("registerEmail").value;
  var password = document.getElementById("registerPassword").value;
  var confirmPassword = document.getElementById("registerConfirmPassword").value;

  if (name === "" || email === "" || password === "" || confirmPassword === "") {
    alert("Please fill out all fields in the registration form.");
    return false;
  }

  if (password !== confirmPassword) {
    alert("Passwords do not match.");
    return false;
  }

  return true;
}
