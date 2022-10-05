<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <title>Student Grading System</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <style>
        body{
            background-color: #FAFAFC;
        }

    </style>

    </head>
    <body>
    <h1 class="text-center mt-5 pt-5">Student Grading System</h1>
        <section class="w-75 p-5 shadow-lg rounded bg-white m-auto">
          <div class="container-fluid h-custom">
            <div class="row d-flex justify-content-center align-items-center h-100">
              <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://img.freepik.com/premium-vector/online-registration-sign-up-with-man-sitting-near-smartphone_268404-95.jpg?w=740"
                  class="img-fluid" alt="Sample image">
              </div>
              <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form action="login" method="post">
                  <!-- username input -->
                  <div class="form-outline mb-4">
                    <input name="username" type="username" id="username" class="form-control form-control-lg"
                      placeholder="username" />
                    <label class="form-label" for="username">username</label>
                  </div>

                  <!-- Password input -->
                  <div class="form-outline mb-3">
                    <input name="password" type="password" id="password" class="form-control form-control-lg"
                      placeholder="Enter password" />
                    <label class="form-label" for="password">Password</label>
                  </div>
                    <%
                        if (request.getAttribute("errorMessage") != null){
                            out.println("<font color='red'>" + request.getAttribute("errorMessage") + "</font>");
                        }
                    %>
                  <div class="text-center text-lg-start mt-4 pt-2">
                    <button type="submit" class="btn btn-primary btn-lg"
                      style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                  </div>

                </form>
              </div>
            </div>
          </div>
        </section>
    </body>
</html>