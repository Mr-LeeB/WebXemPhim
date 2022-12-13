<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="./css/login.css">

    </head>
    <body>
        <!-- partial:index.partial.html -->
    <html lang="en">
        <head>
            <!-- Latest compiled and minified CSS -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        </head>

        <body>
            <div id="form">
                <div class="container">
                    <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-md-8 col-md-offset-2">
                        <div id="userform">
                            <ul class="nav nav-tabs nav-justified" role="tablist">
                                <li class="active"><a href="#login"  role="tab" data-toggle="tab">Log in</a></li>
                                <li><a href="#signup"  role="tab" data-toggle="tab">Sign up</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane fade in" id="signup">
                                    <h2 class="text-uppercase text-center"> Sign Up</h2>
                                    <form id="signup" action="signup" method="post">
                                        <div class="form-group">
                                            <label><span class="req"></span> </label>
                                            <input placeholder="User Name" type="text" name = "username" class="form-control" id="username" required data-validation-required-message="Please enter your user name." autocomplete="off">
                                            <p class="help-block text-danger"></p>
                                        </div>
                                        <div class="form-group">
                                            <label> <span class="req"></span> </label>
                                            <input placeholder="Your Email" type="email" name = "email" class="form-control" id="email" required data-validation-required-message="Please enter your email address." autocomplete="off">
                                            <p class="help-block text-danger"></p>
                                        </div>
                                        <div class="form-group">
                                            <label><span class="req"></span> </label>
                                            <input placeholder="Your Phone" type="tel" name = "phonenum" class="form-control" id="phonenum" required data-validation-required-message="Please enter your phone number." autocomplete="off">
                                            <p class="help-block text-danger"></p>
                                        </div>
                                        <div class="form-group">
                                            <label><span class="req"></span> </label>
                                            <input placeholder="Password" type="password" name = "password" class="form-control" id="password" required data-validation-required-message="Please enter your password" autocomplete="off">
                                            <p class="help-block text-danger"></p>
                                        </div>
                                        <div class="form-group">
                                            <label><span class="req"></span> </label>
                                            <input placeholder="Confirm password" type="password" name = "confirmpassword" class="form-control" id="confirmpassword" required data-validation-required-message="Please confirm your password" autocomplete="off">
                                            <p class="help-block text-danger"></p>
                                        </div>
                                        <div class="form-group">
                                            <label><span class="req"></span> </label>
                                            <input oninput="checkCode(this)" placeholder="Verification" type="text" id="Verification" class="form-control" id="usercode" required data-validation-required-message="Please enter Verification in your email" autocomplete="off">
                                            <p class="help-block text-danger"></p>
                                            <input onclick="sendEmail()" value="Get Verification Code" type="button">
                                        </div>
                                        <p id="checkCode"></p>
                                        <p style="color: red">${message}</p>
                                        <div class="mrgn-30-top">
                                            <button type="submit" class="btn btn-larger btn-block">
                                                Sign up
                                            </button>
                                        </div>
                                    </form>
                                </div>
                                <div class="tab-pane fade active in" id="login">
                                    <h2 class="text-uppercase text-center"> Log in</h2>
                                    <form id="login" method="post" action="login">
                                        <div class="form-group">
                                            <label><span class="req"></span> </label>
                                            <input placeholder="Your Email" type="email" name ="email" value="${email}" class="form-control" id="email" required data-validation-required-message="Please enter your email address." autocomplete="off">
                                            <p class="help-block text-danger"></p>
                                        </div>
                                        <div class="form-group">
                                            <label><span class="req"></span> </label>
                                            <input placeholder="Password" type="password" name ="password" class="form-control" id="password" required data-validation-required-message="Please enter your password" autocomplete="off">
                                            <p class="help-block text-danger"></p>
                                        </div>

                                        <p style="color: red">${message}</p>

                                        <div class="mrgn-30-top">
                                            <input type="submit" value = "Log in"class="btn btn-larger btn-block"/>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container --> 
            </div>--

        </body>
        <!-- partial -->
        <script  src="./js/login.js"></script>
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
                integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script>
                                                function sendEmail() {
                                                    
                                                    let emailto = document.getElementById("email");
                                                    if (emailto.value === "")
                                                        return;
                                                    $.ajax({
                                                        url: "/WebXemPhim/SendMail",
                                                        type: "get", //send it through get method
                                                        data: {
                                                            email: emailto.value
                                                        },
                                                        success: function (data) {
                                                            alert(data);
                                                        },
                                                        error: function (xhr) {
                                                            alert("error");
                                                        }
                                                    });
                                                }
                                                function checkCode(code) {
                                                    $.ajax({
                                                        url: "/WebXemPhim/ChechkVerification",
                                                        type: "get", //send it through get method
                                                        data: {
                                                            usercode: code.value
                                                        },
                                                        success: function (data) {
                                                            document.getElementById("checkCode").innerHTML = data;
                                                        },
                                                        error: function (xhr) {
                                                        }
                                                    });
                                                }
        </script>
    </body>
</html>
