<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  
  <!-- JavaScript validation file -->
  <script src="validation.js" defer></script>
</head>
<body>
  <div class="container">
    <div class="row justify-content-center mt-5">
      <!-- Login Form -->
      <div class="col-md-4">
        <h2>Login</h2>
        <form onsubmit="return validateLoginForm()" method="POST">
          <div class="mb-3">
            <label for="loginEmail" class="form-label">Email address</label>
            <input type="email" class="form-control" id="loginEmail" placeholder="Enter your email" required>
          </div>
          <div class="mb-3">
            <label for="loginPassword" class="form-label">Password</label>
            <input type="password" class="form-control" id="loginPassword" placeholder="Enter your password" required>
          </div>
          <button type="submit" class="btn btn-primary">Login</button>
        </form>
        <p class="mt-3">Don't have an account? <a href="register">Register here</a></p>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
