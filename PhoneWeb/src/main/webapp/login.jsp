<!-- Login 12 - Bootstrap Brain Component -->
<section class="py-3 py-md-5 py-xl-8">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="mb-5">
          <h2 class="display-5 fw-bold text-center">Sign in</h2>
          <p class="text-center m-0">Don't have an account? <a href="SignUp.jsp">Sign up</a></p>
        </div>
      </div>
    </div>
    <p class="alert-danger" role="alert">
 	${mess}
	</p>
    <div class="row justify-content-center">
      <div class="col-12 col-lg-10 col-xl-8">
        <div class="row gy-5 justify-content-center">
          <div class="col-12 col-lg-5">
			<form action="logindumamay" method="post">
              <div class="row gy-3 overflow-hidden">
                <div class="col-12">
				  <div class="form-floating mb-3">
				    <input type="text" class="form-control border-0 border-bottom rounded-0" name="user" id="user" placeholder="Username" required>
				    <label for="user" class="form-label">Username</label>
				  </div>
				</div>
					
                <div class="col-12">
                  <div class="form-floating mb-3">
                    <input type="password" class="form-control border-0 border-bottom rounded-0" name="pass" id="pass" value="" placeholder="Password" required>
                    <label for="password" class="form-label">Password</label>
                  </div>
                </div>
                <div class="col-12">
                  <div class="row justify-content-between">
                    <div class="col-6">
                      <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" name="remember_me" id="remember_me">
                        <label class="form-check-label text-secondary" for="remember_me">
                          Remember me
                        </label>
                      </div>
                    </div>
                    <div class="col-6">
                      <div class="text-end">
                        <a href="#!" class="link-secondary text-decoration-none">Forgot password?</a>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-12">
                  <div class="d-grid">
                    <button class="btn btn-lg btn-dark rounded-0 fs-6" type="submit">Log in</button>
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="col-12 col-lg-5 d-flex align-items-center">
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://unpkg.com/bs-brain@2.0.3/components/logins/login-12/assets/css/login-12.css">