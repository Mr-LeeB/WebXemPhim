<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Movie Website</title>

        <!-- FONT-AWESOME -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.4.0/css/all.min.css"
              integrity="sha512-eBNnVs5xPOVglLWDGXyZnZZ2K2ixXhR/3aECgCpFnW2dGCd/yiqXZ6fcB3BubeA91kM6NX234b6Wrah8RiYAPA=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
              integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />

        <!-- BOOTSTRAP -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <!-- OWL CAROUSEL -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">

        <!-- CSS -->
        <link rel="stylesheet" href="css/index.css">
        <link rel="stylesheet" href="css/profile.css">
        <link rel="stylesheet" href="css/login.css">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap" rel="stylesheet">
        <!--         Bootstrap CSS 
                <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
                 Font Awesome CSS 
                <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css'>-->
    </head>

    <body>
        <div class="total container-fluid">
            <div class="total_child d-flex">
                <div class="colLeft">
                    <div class="colLeft_child">
                        <a class="exec_click" href="home">
                            <div class="colLeft_logo__content row">
                                <span class="colLeft__Logo col-2 ps-48">
                                    <img class="w-10 h-10" src="image/index/logo.png" alt="#">
                                </span>
                                <h1 class="colLeft__text col-10" style="font-size: 1.4rem;">
                                    <span>MOON</span><span class="text-primary">LIGHT</span>
                                </h1>
                            </div>
                        </a>
                        <div class="colLeft_Menu">MENU</div>
                        <div class="colLeft_menu_item">
                            <a class="item active" href="home">
                                <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 1024 1024" height="25"
                                     width="25" xmlns="http://www.w3.org/2000/svg">
                                <path
                                    d="M946.5 505L560.1 118.8l-25.9-25.9a31.5 31.5 0 0 0-44.4 0L77.5 505a63.9 63.9 0 0 0-18.8 46c.4 35.2 29.7 63.3 64.9 63.3h42.5V940h691.8V614.3h43.4c17.1 0 33.2-6.7 45.3-18.8a63.6 63.6 0 0 0 18.7-45.3c0-17-6.7-33.1-18.8-45.2zM568 868H456V664h112v204zm217.9-325.7V868H632V640c0-22.1-17.9-40-40-40H432c-22.1 0-40 17.9-40 40v228H238.1V542.3h-96l370-369.7 23.1 23.1L882 542.3h-96.1z">
                                </path>
                                </svg>
                                <span>Home</span>
                            </a>
                            <a class="item">
                                <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 24 24" height="25" width="25"
                                     xmlns="http://www.w3.org/2000/svg">
                                <path fill="none" d="M0 0h24v24H0V0z"></path>
                                <path
                                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8zm-5.5-2.5l7.51-3.49L17.5 6.5 9.99 9.99 6.5 17.5zm5.5-6.6c.61 0 1.1.49 1.1 1.1s-.49 1.1-1.1 1.1-1.1-.49-1.1-1.1.49-1.1 1.1-1.1z">
                                </path>
                                </svg>
                                <span>Explorer</span>
                            </a>
                            <a class="item">
                                <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 24 24" height="25" width="25"
                                     xmlns="http://www.w3.org/2000/svg">
                                <path
                                    d="M10 18a7.952 7.952 0 0 0 4.897-1.688l4.396 4.396 1.414-1.414-4.396-4.396A7.952 7.952 0 0 0 18 10c0-4.411-3.589-8-8-8s-8 3.589-8 8 3.589 8 8 8zm0-14c3.309 0 6 2.691 6 6s-2.691 6-6 6-6-2.691-6-6 2.691-6 6-6z">
                                </path>
                                </svg>
                                <span>Search</span>
                            </a>
                        </div>
                        <div class="colLeft_Menu">PERSONAL</div>
                        <div class="colLeft_personal_item">
                            <a class="item" <c:if test="${sessionScope.user != null}">href="bookmarked"</c:if>
                               <c:if test="${sessionScope.user == null}">href="login"</c:if>>
                                   <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 16 16" height="25" width="25"
                                        xmlns="http://www.w3.org/2000/svg">
                                   <path fill-rule="evenodd" d="M8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z">
                                   </path>
                                   <path
                                       d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z">
                                   </path>
                                   </svg>
                                   <span>Bookmarked</span>
                               </a>
                               <a class="item">
                                   <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 1024 1024" height="25"
                                        width="25" xmlns="http://www.w3.org/2000/svg">
                                   <path
                                       d="M536.1 273H488c-4.4 0-8 3.6-8 8v275.3c0 2.6 1.2 5 3.3 6.5l165.3 120.7c3.6 2.6 8.6 1.9 11.2-1.7l28.6-39c2.7-3.7 1.9-8.7-1.7-11.2L544.1 528.5V281c0-4.4-3.6-8-8-8zm219.8 75.2l156.8 38.3c5 1.2 9.9-2.6 9.9-7.7l.8-161.5c0-6.7-7.7-10.5-12.9-6.3L752.9 334.1a8 8 0 0 0 3 14.1zm167.7 301.1l-56.7-19.5a8 8 0 0 0-10.1 4.8c-1.9 5.1-3.9 10.1-6 15.1-17.8 42.1-43.3 80-75.9 112.5a353 353 0 0 1-112.5 75.9 352.18 352.18 0 0 1-137.7 27.8c-47.8 0-94.1-9.3-137.7-27.8a353 353 0 0 1-112.5-75.9c-32.5-32.5-58-70.4-75.9-112.5A353.44 353.44 0 0 1 171 512c0-47.8 9.3-94.2 27.8-137.8 17.8-42.1 43.3-80 75.9-112.5a353 353 0 0 1 112.5-75.9C430.6 167.3 477 158 524.8 158s94.1 9.3 137.7 27.8A353 353 0 0 1 775 261.7c10.2 10.3 19.8 21 28.6 32.3l59.8-46.8C784.7 146.6 662.2 81.9 524.6 82 285 82.1 92.6 276.7 95 516.4 97.4 751.9 288.9 942 524.8 942c185.5 0 343.5-117.6 403.7-282.3 1.5-4.2-.7-8.9-4.9-10.4z">
                                   </path>
                                   </svg>
                                   <span>History</span>
                               </a>
                            </div>
                            <div class="colLeft_Menu">GENERAL</div>
                            <div class="colLeft_general_item">
                                <a class="item active" <c:if test="${sessionScope.user != null}">href="profile"</c:if>
                               <c:if test="${sessionScope.user == null}">href="login"</c:if>>
                                   <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 24 24" height="25" width="25"
                                        xmlns="http://www.w3.org/2000/svg">
                                   <path
                                       d="M12 2A10.13 10.13 0 0 0 2 12a10 10 0 0 0 4 7.92V20h.1a9.7 9.7 0 0 0 11.8 0h.1v-.08A10 10 0 0 0 22 12 10.13 10.13 0 0 0 12 2zM8.07 18.93A3 3 0 0 1 11 16.57h2a3 3 0 0 1 2.93 2.36 7.75 7.75 0 0 1-7.86 0zm9.54-1.29A5 5 0 0 0 13 14.57h-2a5 5 0 0 0-4.61 3.07A8 8 0 0 1 4 12a8.1 8.1 0 0 1 8-8 8.1 8.1 0 0 1 8 8 8 8 0 0 1-2.39 5.64z">
                                   </path>
                                   <path
                                       d="M12 6a3.91 3.91 0 0 0-4 4 3.91 3.91 0 0 0 4 4 3.91 3.91 0 0 0 4-4 3.91 3.91 0 0 0-4-4zm0 6a1.91 1.91 0 0 1-2-2 1.91 1.91 0 0 1 2-2 1.91 1.91 0 0 1 2 2 1.91 1.91 0 0 1-2 2z">
                                   </path>
                                   </svg>
                                   <span>Profile</span>
                               </a>
                            <c:if test="${sessionScope.user == null}">
                                <a class="item active" href="login">
                                    <svg stroke="currentColor" fill="none" stroke-width="0" viewBox="0 0 24 24" height="30" width="30"
                                         xmlns="http://www.w3.org/2000/svg">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                          d="M11 16l-4-4m0 0l4-4m-4 4h14m-5 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h7a3 3 0 013 3v1">
                                    </path>
                                    </svg>
                                    <span>Login</span>
                                </a>
                            </c:if>
                            <c:if test="${sessionScope.user != null}">
                                <a class="item active" href="logout">
                                    <svg stroke="currentColor" fill="none" stroke-width="0" viewBox="0 0 24 24" height="30" width="30"
                                         xmlns="http://www.w3.org/2000/svg">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                          d="M11 16l-4-4m0 0l4-4m-4 4h14m-5 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h7a3 3 0 013 3v1">
                                    </path>
                                    </svg>
                                    <span>Log Out</span>
                                </a>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="colCenter" style=" width: 82%; height: 800px">
                    <div class="colCenter_menu d-flex">
                        <div class="div1 d-flex" style="width: 100%;">
                            <span style="width: 100%;font-size: 35px;font-weight: 700" class="Movie active">ACCOUNT SETTINGS</span>
                        </div>
                    </div>
                    <div class="student-profile py-4">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="card shadow-sm">
                                        <div class="card-header bg-transparent text-center">
                                            <img class="profile_img" style="width: 150px; height: 150px;" src="image/index/defaultAvatar.jpg" alt="">
                                            <h3>${user.userName}</h3>
                                        </div>
                                        <div class="card-body">
                                            <p class="mb-0"><strong class="pr-1">Email: </strong>${user.email}</p>
                                            <p class="mb-0"><strong class="pr-1">User Name: </strong>${user.userName}</p>
                                            <p class="mb-0"><strong class="pr-1">Phone: </strong>${user.phoneNum}</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-8">
                                    <div class="card shadow-sm">
                                        <div class="card-header bg-transparent border-0">
                                            <h3 class="mb-0"><i class="far fa-clone pr-1"></i>Change Information</h3>
                                        </div>
                                        <div class="card-body pt-0">
                                            <form action="update" method="post">
                                                <table class="table table-bordered">

                                                    <tr>
                                                        <th width="30%">Email</th>
                                                        <td width="2%">:</td>
                                                        <td>
                                                            <input type="email" name ="email" value="${user.email}" class="form-control" id="email" required data-validation-required-message="Please enter your email address." autocomplete="off">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th width="30%">User Namer</th>
                                                        <td width="2%">:</td>
                                                        <td>
                                                            <input type="text" name = "username" value="${user.userName}" class="form-control" id="username" required data-validation-required-message="Please enter your user name." autocomplete="off">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th width="30%">Phone</th>
                                                        <td width="2%">:</td>
                                                        <td>
                                                            <input type="tel" name = "phonenum" value="${user.phoneNum}" class="form-control" id="phonenum" required data-validation-required-message="Please enter your phone number." autocomplete="off">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th width="30%">Pass Word</th>
                                                        <td width="2%">:</td>
                                                        <td>
                                                            <input type="password" name ="password" class="form-control" id="password" required data-validation-required-message="Please enter your password" autocomplete="off">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th width="30%">New Pass Word</th>
                                                        <td width="2%">:</td>
                                                        <td>
                                                            <input type="password" name = "newpassword" class="form-control" id="confirmpassword" autocomplete="off">
                                                        </td>
                                                    </tr>
                                                </table>
                                                <c:if test="${sessionScope.user != null}">
                                                    <div class="mrgn-30-top">
                                                        <button type="submit" class="btn btn-larger"/>
                                                        Update
                                                        </button>
                                                    </div>
                                                </c:if>

                                            </form>

                                            <c:if test="${sessionScope.user == null}">
                                                <form action="login" method="post">
                                                    <div class="mrgn-30-top">
                                                        <button type="submit" class="btn btn-larger"/>
                                                        Login
                                                        </button>
                                                    </div>
                                                </form>
                                            </c:if>
                                            <c:if test="${message!=null}">${message}</c:if>
                                        </div>
                                    </div>
                                    <div style="height: 26px"></div>
                                    <div class="card shadow-sm">
                                        <div class="card-header bg-transparent border-0">
                                            <h3 class="mb-0"><i class="far fa-clone pr-1"></i>Other Information</h3>
                                        </div>
                                        <div class="card-body pt-0">
                                            <p>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>


        <!-- BOOTSTRAP -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
        </script>

        <!-- JQUERY -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
                integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

        <!-- CAROUSEL -->
        <script src="js/owl.carousel.min.js"></script>

        <script>
                    $('.popular__carousel').owlCarousel({
                        loop: true,
                        margin: 25,
                        nav: true,
                        dots: false,
                        responsive: {
                            0: {
                                items: 1
                            },
                            600: {
                                items: 3
                            },
                            1000: {
                                items: 4.2
                            }
                        }
                    })
        </script>
        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <script src="js/index.js"></script>
    </body>

</html>