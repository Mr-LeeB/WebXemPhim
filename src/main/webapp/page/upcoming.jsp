<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>Tables - Atlantis Lite Bootstrap 4 Admin Dashboard</title>
        <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
        <link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />

        <!-- Fonts and icons -->
        <script src="assets/js/plugin/webfont/webfont.min.js"></script>
        <script>
            WebFont.load({
                google: { "families": ["Lato:300,400,700,900"] },
                custom: { "families": ["Flaticon", "Font Awesome 5 Solid", "Font Awesome 5 Regular", "Font Awesome 5 Brands", "simple-line-icons"], urls: ['assets/css/fonts.min.css'] },
                active: function () {
                    sessionStorage.fonts = true;
                }
            });
        </script>

        <!-- CSS Files -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/atlantis.min.css">
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link rel="stylesheet" href="assets/css/demo.css">
    </head>

    <body data-background-color="dark">
        <div class="wrapper">

            <div class="main-header" style="top: 0; left: 0;">
                <!-- Logo Header -->
                <div class="logo-header" data-background-color="dark2">
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
                </div>
                <!-- End Logo Header -->

                <!-- Navbar Header -->
                <nav class="navbar navbar-header navbar-expand-lg" data-background-color="dark">

                    <div class="container-fluid" style="position: relative;">
                        <div class="selectDropdown">
                            <select id="select_Search" name="category">
                                <option value="Name">Name</option>
                                <option value="Rating">Rating</option>
                                <option value="Release date">Release date</option>
                                <option value="Type">Type</option>
                            </select>
                        </div>
                        <div class="collapse" id="search-nav">
                            <form class="navbar-left navbar-form nav-search mr-md-3">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <button type="submit" class="btn btn-search pr-1">
                                            <i class="fa fa-search search-icon"></i>
                                        </button>
                                    </div>
                                    <input id="input_Search" type="text" placeholder="Search ..." class="form-control"
                                        oninput="Search()">
                                </div>
                            </form>
                        </div>
                        <ul class="navbar-nav topbar-nav ml-md-auto align-items-center">
                            <li class="nav-item toggle-nav-search hidden-caret">
                                <a class="nav-link" data-toggle="collapse" href="#search-nav" role="button"
                                    aria-expanded="false" aria-controls="search-nav">
                                    <i class="fa fa-search"></i>
                                </a>
                            </li>
                            <li class="nav-item dropdown hidden-caret">
                                <a class="nav-link dropdown-toggle" href="#" id="messageDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-envelope"></i>
                                </a>
                                <ul class="dropdown-menu messages-notif-box animated fadeIn"
                                    aria-labelledby="messageDropdown">
                                    <li>
                                        <div class="dropdown-title d-flex justify-content-between align-items-center">
                                            Messages
                                            <a href="#" class="small">Mark all as read</a>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="message-notif-scroll scrollbar-outer">
                                            <div class="notif-center">
                                                <a href="#">
                                                    <div class="notif-img">
                                                        <img src="assets/img/jm_denis.jpg" alt="Img Profile">
                                                    </div>
                                                    <div class="notif-content">
                                                        <span class="subject">Jimmy Denis</span>
                                                        <span class="block">
                                                            How are you ?
                                                        </span>
                                                        <span class="time">5 minutes ago</span>
                                                    </div>
                                                </a>
                                                <a href="#">
                                                    <div class="notif-img">
                                                        <img src="assets/img/chadengle.jpg" alt="Img Profile">
                                                    </div>
                                                    <div class="notif-content">
                                                        <span class="subject">Chad</span>
                                                        <span class="block">
                                                            Ok, Thanks !
                                                        </span>
                                                        <span class="time">12 minutes ago</span>
                                                    </div>
                                                </a>
                                                <a href="#">
                                                    <div class="notif-img">
                                                        <img src="assets/img/mlane.jpg" alt="Img Profile">
                                                    </div>
                                                    <div class="notif-content">
                                                        <span class="subject">Jhon Doe</span>
                                                        <span class="block">
                                                            Ready for the meeting today...
                                                        </span>
                                                        <span class="time">12 minutes ago</span>
                                                    </div>
                                                </a>
                                                <a href="#">
                                                    <div class="notif-img">
                                                        <img src="assets/img/talha.jpg" alt="Img Profile">
                                                    </div>
                                                    <div class="notif-content">
                                                        <span class="subject">Talha</span>
                                                        <span class="block">
                                                            Hi, Apa Kabar ?
                                                        </span>
                                                        <span class="time">17 minutes ago</span>
                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a class="see-all" href="javascript:void(0);">See all messages<i
                                                class="fa fa-angle-right"></i> </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown hidden-caret">
                                <a class="nav-link dropdown-toggle" href="#" id="notifDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-bell"></i>
                                    <span class="notification">4</span>
                                </a>
                                <ul class="dropdown-menu notif-box animated fadeIn" aria-labelledby="notifDropdown">
                                    <li>
                                        <div class="dropdown-title">You have 4 new notification</div>
                                    </li>
                                    <li>
                                        <div class="notif-center">
                                            <a href="#">
                                                <div class="notif-icon notif-primary"> <i class="fa fa-user-plus"></i>
                                                </div>
                                                <div class="notif-content">
                                                    <span class="block">
                                                        New user registered
                                                    </span>
                                                    <span class="time">5 minutes ago</span>
                                                </div>
                                            </a>
                                            <a href="#">
                                                <div class="notif-icon notif-success"> <i class="fa fa-comment"></i>
                                                </div>
                                                <div class="notif-content">
                                                    <span class="block">
                                                        Rahmad commented on Admin
                                                    </span>
                                                    <span class="time">12 minutes ago</span>
                                                </div>
                                            </a>
                                            <a href="#">
                                                <div class="notif-img">
                                                    <img src="assets/img/profile2.jpg" alt="Img Profile">
                                                </div>
                                                <div class="notif-content">
                                                    <span class="block">
                                                        Reza send messages to you
                                                    </span>
                                                    <span class="time">12 minutes ago</span>
                                                </div>
                                            </a>
                                            <a href="#">
                                                <div class="notif-icon notif-danger"> <i class="fa fa-heart"></i> </div>
                                                <div class="notif-content">
                                                    <span class="block">
                                                        Farrah liked Admin
                                                    </span>
                                                    <span class="time">17 minutes ago</span>
                                                </div>
                                            </a>
                                        </div>
                                    </li>
                                    <li>
                                        <a class="see-all" href="javascript:void(0);">See all notifications<i
                                                class="fa fa-angle-right"></i> </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown hidden-caret">
                                <a class="nav-link" data-toggle="dropdown" href="#" aria-expanded="false">
                                    <i class="fas fa-layer-group"></i>
                                </a>
                                <div class="dropdown-menu quick-actions quick-actions-info animated fadeIn">
                                    <div class="quick-actions-header">
                                        <span class="title mb-1">Quick Actions</span>
                                        <span class="subtitle op-8">Shortcuts</span>
                                    </div>
                                    <div class="quick-actions-scroll scrollbar-outer">
                                        <div class="quick-actions-items">
                                            <div class="row m-0">
                                                <a class="col-6 col-md-4 p-0" href="#">
                                                    <div class="quick-actions-item">
                                                        <i class="flaticon-file-1"></i>
                                                        <span class="text">Generated Report</span>
                                                    </div>
                                                </a>
                                                <a class="col-6 col-md-4 p-0" href="#">
                                                    <div class="quick-actions-item">
                                                        <i class="flaticon-database"></i>
                                                        <span class="text">Create New Database</span>
                                                    </div>
                                                </a>
                                                <a class="col-6 col-md-4 p-0" href="#">
                                                    <div class="quick-actions-item">
                                                        <i class="flaticon-pen"></i>
                                                        <span class="text">Create New Post</span>
                                                    </div>
                                                </a>
                                                <a class="col-6 col-md-4 p-0" href="#">
                                                    <div class="quick-actions-item">
                                                        <i class="flaticon-interface-1"></i>
                                                        <span class="text">Create New Task</span>
                                                    </div>
                                                </a>
                                                <a class="col-6 col-md-4 p-0" href="#">
                                                    <div class="quick-actions-item">
                                                        <i class="flaticon-list"></i>
                                                        <span class="text">Completed Tasks</span>
                                                    </div>
                                                </a>
                                                <a class="col-6 col-md-4 p-0" href="#">
                                                    <div class="quick-actions-item">
                                                        <i class="flaticon-file"></i>
                                                        <span class="text">Create New Invoice</span>
                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="nav-item dropdown hidden-caret">
                                <a class="dropdown-toggle profile-pic" data-toggle="dropdown" href="#"
                                    aria-expanded="false">
                                    <div class="avatar-sm">
                                        <img src="assets/img/profile.jpg" alt="..." class="avatar-img rounded-circle">
                                    </div>
                                </a>
                                <ul class="dropdown-menu dropdown-user animated fadeIn">
                                    <div class="dropdown-user-scroll scrollbar-outer">
                                        <li>
                                            <div class="user-box">
                                                <div class="avatar-lg"><img src="assets/img/profile.jpg"
                                                        alt="image profile" class="avatar-img rounded"></div>
                                                <div class="u-text">
                                                    <h4>Hizrian</h4>
                                                    <p class="text-muted">hello@example.com</p><a href="profile.html"
                                                        class="btn btn-xs btn-secondary btn-sm">View Profile</a>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">My Profile</a>
                                            <a class="dropdown-item" href="#">My Balance</a>
                                            <a class="dropdown-item" href="#">Inbox</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Account Setting</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="logout">Logout</a>
                                        </li>
                                    </div>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
                <!-- End Navbar -->
            </div>
            <!-- Sidebar -->
            <div class="sidebar sidebar-style-2" data-background-color="dark2">
                <div class="sidebar-wrapper scrollbar scrollbar-inner">
                    <div class="sidebar-content">
                        <div class="user">
                            <div class="avatar-sm float-left mr-2">
                                <img src="assets/img/profile.jpg" alt="..." class="avatar-img rounded-circle">
                            </div>
                            <div class="info">
                                <a data-toggle="collapse" href="#collapseExample" aria-expanded="true">
                                    <span>
                                        Hizrian
                                        <span class="user-level">Administrator</span>
                                        <span class="caret"></span>
                                    </span>
                                </a>
                                <div class="clearfix"></div>

                                <div class="collapse in" id="collapseExample">
                                    <ul class="nav">
                                        <li>
                                            <a href="#profile">
                                                <span class="link-collapse">My Profile</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#edit">
                                                <span class="link-collapse">Edit Profile</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#settings">
                                                <span class="link-collapse">Settings</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <ul class="nav nav-primary">
                            <li class="nav-item active">
                                <a data-toggle="collapse" href="#dashboard" class="collapsed" aria-expanded="false">
                                    <i class="fas fa-home"></i>
                                    <p>Dashboard</p>
                                    <span class="caret"></span>
                                </a>
                            </li>
                            <li class="nav-section">
                                <span class="sidebar-mini-icon">
                                    <i class="fa fa-ellipsis-h"></i>
                                </span>
                                <h4 class="text-section">Components</h4>
                            </li>
                            <li class="nav-item active submenu">
                                <a data-toggle="collapse" href="#base">
                                    <i class="fas fa-layer-group"></i>
                                    <p>Movie</p>
                                    <span class="caret"></span>
                                </a>
                                <div class="collapse show" id="base">
                                    <ul class="nav nav-collapse">
                                        <li>
                                            <a href="nowplaying-management">
                                                <span class="sub-item">Now Playing</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="popular-management">
                                                <span class="sub-item">Popular</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="toprated-management">
                                                <span class="sub-item">Top Rated</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="hot-management">
                                                <span class="sub-item">Hot</span>
                                            </a>
                                        </li>
                                        <li class="active">
                                            <a href="upcoming-management">
                                                <span class="sub-item">Upcoming</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a data-toggle="collapse" href="#sidebarLayouts">
                                    <i class="fas fa-th-list"></i>
                                    <p>Account</p>
                                    <span class="caret"></span>
                                </a>
                                <div class="collapse" id="sidebarLayouts">
                                    <ul class="nav nav-collapse">
                                        <li>
                                            <a href="admin-account">
                                                <span class="sub-item">Admin</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="user-account">
                                                <span class="sub-item">User</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- End Sidebar -->
            <div class="main-panel">
                <div class="content mt-0">
                    <div class="page-inner" style="padding-left: 0; padding-right: 0;">
                        <div class="page-header">
                            <h4 class="page-title">Movie</h4>
                            <ul class="breadcrumbs">
                                <li class="nav-home">
                                    <a href="#">
                                        <i class="flaticon-home"></i>
                                    </a>
                                </li>
                                <li class="separator">
                                    <i class="flaticon-right-arrow"></i>
                                </li>
                                <li class="nav-item">
                                    <a href="#">Movie</a>
                                </li>
                                <li class="separator">
                                    <i class="flaticon-right-arrow"></i>
                                </li>
                                <li class="nav-item">
                                    <a href="#">UpComing</a>
                                </li>
                            </ul>
                        </div>
                        <!-- Table  -->
                        <div class="card">
                            <div class="card-header" style="position: relative;">
                                <div class="card-title">UpComing Table</div>
                                <div class="addFunction" data-toggle="modal" data-target="#exampleModalCenter"
                                    onclick="Add_ClearInfo()">
                                    <i class="fas fa-plus-circle"></i>
                                    <span class="addFunction_title">Add</span>
                                </div>
                            </div>
                            <div class="card-body" style="padding-top: 0px;">
                                <!-- <div class="card-sub">									
                                    This is the basic table view of the ready dashboard :
                                </div> -->
                                <table id="main_Table" class="table mt-0">
                                    <thead>
                                        <tr>
                                            <th style="font-size: 17px;" scope="col">#</th>
                                            <th style="font-size: 17px;" scope="col">Name</th>
                                            <th style="font-size: 17px; text-align: center;" scope="col">Rating</th>
                                            <th style="font-size: 17px; text-align: center;" scope="col">Release date
                                            </th>
                                            <th style="font-size: 17px;" scope="col">Type</th>
                                            <th style="font-size: 17px;" scope="col">Category</th>
                                        </tr>
                                    </thead>
                                    <tbody class="nowPlaying_tbody">
                                        <c:forEach var="p" items="${ListMovieUpComing}">
                                            <tr id="${p.movieId}" class="nowPlaying_tr" data-toggle="modal"
                                                data-target="#exampleModalCenter" onclick="ThetrClick(${p.movieId})">
                                                <td class="nowPlaying_stt nowPlaying_item"></td>
                                                <td class="nowPlaying_nameEnglish">${p.nameEnglish}</td>
                                                <td class="nowPlaying_rating">${p.movieStar}</td>
                                                <td class="nowPlaying_releaseDate">${p.releaseDate}</td>
                                                <td class="nowPlaying_type">${p.spanList}</td>
                                                <td class="nowPlaying_category">${p.category}</td>

                                                <td style="display: none;" class="nowPlaying_ID">${p.category}</td>
                                                <td style="display: none;" class="nowPlaying_nameVietNam">
                                                    ${p.nameVietnamese}</td>
                                                <td style="display: none;" class="nowPlaying_description">
                                                    ${p.description}</td>
                                                <td style="display: none;" class="nowPlaying_imagemax">${p.imagemax}
                                                </td>
                                                <td style="display: none;" class="nowPlaying_imagemin">${p.imagemin}
                                                </td>
                                                <td style="display: none;" class="nowPlaying_trailerLink">
                                                    ${p.trailerLink}</td>

                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>



                                <!-- Modal -->
                                <div class="modelEdit modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
                                    aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                    <div class="modalDialogEdit modal-dialog modal-dialog-centered" role="document">
                                        <div class="modalcontentEdit modal-content">
                                            <div class="modal-header" style="position: relative;">
                                                <h5 class="modal-title" id="exampleModalCenterTitle">
                                                    <span class="title">MOVIE INFORMATION</span>
                                                    <span class="movieID_infor" id="movieID_infor"></span>
                                                    <span id="input_MovieIDSpan" class="input-group input_MovieIDSpan"
                                                        style="display: none;">
                                                        <input id="input_MovieID" required="" type="text"
                                                            name="imagemin" autocomplete="off" class="input"
                                                            style="width: 100%;">
                                                        <label class="user-label">Movie ID</label>
                                                    </span>
                                                </h5>
                                                <button type="button" class="close" data-dismiss="modal"
                                                    aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="Name formChinhSua">
                                                    <span class="input-group input_EnglishName">
                                                        <input id="input_EnglishName" required="" type="text"
                                                            name="EnglishName" autocomplete="off" class="input"
                                                            style="width: 100%;">
                                                        <label class="user-label">English Name</label>
                                                    </span>
                                                    <span class="input-group input_VietnameseName ml-3">
                                                        <input id="input_VietnamName" required="" type="text"
                                                            name="VietnamName" autocomplete="off" class="input"
                                                            style="width: 100%;">
                                                        <label class="user-label">Vietnamese Name</label>
                                                    </span>
                                                </div>

                                                <div class="Rating_ReleaseDate mt-4">
                                                    <div style="width: 45%;">
                                                        <div class="rating_title mb-2">Rating</div>
                                                        <div class="range-slider m-0" style="display: inline;">
                                                            <input id="input_Rating" class="range-slider__range"
                                                                type="range" name="Rating" value="4" min="0" max="10"
                                                                step="0.1">
                                                            <span class="range-slider__value">5</span>
                                                        </div>
                                                    </div>

                                                    <div style="width: 45%;">
                                                        <div class="releaseDate_title mb-2">Released Date</div>
                                                        <input class="canlender_released" type="date" name="dateofbirth"
                                                            id="dateofbirth" style="width: 100%;">
                                                    </div>
                                                </div>

                                                <div class="type_group mt-4">
                                                    <div class="rating_title">Type</div>
                                                    <div class="TheSpan1">
                                                        <span>
                                                            <input type="checkbox" id="type1" name="Action" value="1">
                                                            <label for="type1">Action</label>
                                                        </span>
                                                        <span>
                                                            <input type="checkbox" id="type2" name="Drama" value="2">
                                                            <label for="type2">Drama</label>
                                                        </span>
                                                        <span>
                                                            <input type="checkbox" id="type3" name="Family" value="3">
                                                            <label for="type3">Family</label>
                                                        </span>
                                                        <span>
                                                            <input type="checkbox" id="type4" name="Comedy" value="4">
                                                            <label for="type4">Comedy</label>
                                                        </span>
                                                        <span>
                                                            <input type="checkbox" id="type5" name="Animation"
                                                                value="5">
                                                            <label for="type5">Animation</label>
                                                        </span>
                                                        <span>
                                                            <input type="checkbox" id="type6" name="Fantasy" value="6">
                                                            <label for="type6">Fantasy</label>
                                                        </span>
                                                        <span>
                                                            <input type="checkbox" id="type7" name="Romance" value="7">
                                                            <label for="type7">Romance</label>
                                                        </span>

                                                    </div>
                                                    <div class="TheSpan2 mt-2">
                                                        <span>
                                                            <input type="checkbox" id="type8" name="Horror" value="8">
                                                            <label for="type8">Horror</label>
                                                        </span>
                                                        <span>
                                                            <input type="checkbox" id="type9" name="Thriller" value="9">
                                                            <label for="type9">Thriller</label>
                                                        </span>
                                                        <span>
                                                            <input type="checkbox" id="type10" name="Mystery"
                                                                value="10">
                                                            <label for="type10">Mystery</label>
                                                        </span>
                                                        <span>
                                                            <input type="checkbox" id="type11" name="Crime" value="11">
                                                            <label for="type11">Crime</label>
                                                        </span>
                                                        <span>
                                                            <input type="checkbox" id="type12" name="Science Fiction"
                                                                value="12">
                                                            <label for="type12">Science Fiction</label>
                                                        </span>
                                                        <span>
                                                            <input type="checkbox" id="type13" name="Werstern"
                                                                value="13">
                                                            <label for="type13">Werstern</label>
                                                        </span>
                                                        <span>
                                                            <input type="checkbox" id="type14" name="Adventure"
                                                                value="14">
                                                            <label for="type14">Adventure</label>
                                                        </span>
                                                    </div>
                                                </div>


                                                <!-- Dropdown memu  -->
                                                <div class="rating_group">
                                                    <div class="rating_title">Category</div>
                                                    <div class="select-dropdown">
                                                        <select id="select_category" name="category">
                                                            <option value="Popular">Upcoming</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="description">
                                                    <div class="description_title">Description</div>
                                                    <textarea name="description" class="form-control"
                                                        id="exampleFormControlTextarea1" rows="3"></textarea>
                                                </div>

                                                <span class="input-group input_Backdrop mt-4">
                                                    <input id="input_Backdrop" required="" type="text" name="imagemax"
                                                        autocomplete="off" class="input" style="width: 100%;">
                                                    <label class="user-label">Backdrop Path</label>
                                                </span>
                                                <span class="input-group input_Poster">
                                                    <input id="input_Poster" required="" type="text" name="imagemin"
                                                        autocomplete="off" class="input" style="width: 100%;">
                                                    <label class="user-label">Poster Path</label>
                                                </span>
                                                <span class="input-group input_Trailer">
                                                    <input id="input_Trailer" required="" type="text" name="TrailerLink"
                                                        autocomplete="off" class="input" style="width: 100%;">
                                                    <label class="user-label">Trailer Link</label>
                                                </span>

                                            </div>
                                            <div class="modal-footer">
                                                <button id="AddButton" type="button" class="btn " onclick="AddClick()">
                                                    Add
                                                </button>
                                                <button id="DeleteButton" type="button" class="btn btn-secondary"
                                                    data-dismiss="modal" onclick="DeleteClick()">
                                                    Delete
                                                </button>
                                                <button id="SaveButton" type="button" class="btn btn-primary"
                                                    onclick="SaveChangeClick()">
                                                    Save changes
                                                </button>

                                            </div>
                                            <a id="returnData" href=""></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- End Modal  -->
                            </div>
                        </div>
                        <!-- End Table  -->
                    </div>
                </div>
            </div>

            <!-- Custom template | don't include it in your project! -->
            <div class="custom-template">
                <div class="title">Settings</div>
                <div class="custom-content">
                    <div class="switcher">
                        <div class="switch-block">
                            <h4>Logo Header</h4>
                            <div class="btnSwitch">
                                <button type="button" class="changeLogoHeaderColor" data-color="dark"></button>
                                <button type="button" class="changeLogoHeaderColor" data-color="blue"></button>
                                <button type="button" class="selected changeLogoHeaderColor"
                                    data-color="purple"></button>
                                <button type="button" class="changeLogoHeaderColor" data-color="light-blue"></button>
                                <button type="button" class="changeLogoHeaderColor" data-color="green"></button>
                                <button type="button" class="changeLogoHeaderColor" data-color="orange"></button>
                                <button type="button" class="changeLogoHeaderColor" data-color="red"></button>
                                <button type="button" class="changeLogoHeaderColor" data-color="white"></button>
                                <br />
                                <button type="button" class="changeLogoHeaderColor" data-color="dark2"></button>
                                <button type="button" class="changeLogoHeaderColor" data-color="blue2"></button>
                                <button type="button" class="changeLogoHeaderColor" data-color="purple2"></button>
                                <button type="button" class="changeLogoHeaderColor" data-color="light-blue2"></button>
                                <button type="button" class="changeLogoHeaderColor" data-color="green2"></button>
                                <button type="button" class="changeLogoHeaderColor" data-color="orange2"></button>
                                <button type="button" class="changeLogoHeaderColor" data-color="red2"></button>
                            </div>
                        </div>
                        <div class="switch-block">
                            <h4>Navbar Header</h4>
                            <div class="btnSwitch">
                                <button type="button" class="changeTopBarColor" data-color="dark"></button>
                                <button type="button" class="changeTopBarColor" data-color="blue"></button>
                                <button type="button" class="changeTopBarColor" data-color="purple"></button>
                                <button type="button" class="changeTopBarColor" data-color="light-blue"></button>
                                <button type="button" class="changeTopBarColor" data-color="green"></button>
                                <button type="button" class="changeTopBarColor" data-color="orange"></button>
                                <button type="button" class="changeTopBarColor" data-color="red"></button>
                                <button type="button" class="changeTopBarColor" data-color="white"></button>
                                <br />
                                <button type="button" class="changeTopBarColor" data-color="dark2"></button>
                                <button type="button" class="changeTopBarColor" data-color="blue2"></button>
                                <button type="button" class="selected changeTopBarColor" data-color="purple2"></button>
                                <button type="button" class="changeTopBarColor" data-color="light-blue2"></button>
                                <button type="button" class="changeTopBarColor" data-color="green2"></button>
                                <button type="button" class="changeTopBarColor" data-color="orange2"></button>
                                <button type="button" class="changeTopBarColor" data-color="red2"></button>
                            </div>
                        </div>
                        <div class="switch-block">
                            <h4>Sidebar</h4>
                            <div class="btnSwitch">
                                <button type="button" class="selected changeSideBarColor" data-color="white"></button>
                                <button type="button" class="changeSideBarColor" data-color="dark"></button>
                                <button type="button" class="changeSideBarColor" data-color="dark2"></button>
                            </div>
                        </div>
                        <div class="switch-block">
                            <h4>Background</h4>
                            <div class="btnSwitch">
                                <button type="button" class="changeBackgroundColor" data-color="bg2"></button>
                                <button type="button" class="changeBackgroundColor selected" data-color="bg1"></button>
                                <button type="button" class="changeBackgroundColor" data-color="bg3"></button>
                                <button type="button" class="changeBackgroundColor" data-color="dark"></button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="custom-toggle">
                    <i class="flaticon-settings"></i>
                </div>
            </div>
            <!-- End Custom template -->
        </div>
        <!--   Core JS Files   -->
        <script src="assets/js/core/jquery.3.2.1.min.js"></script>
        <script src="assets/js/core/popper.min.js"></script>
        <script src="assets/js/core/bootstrap.min.js"></script>
        <!-- jQuery UI -->
        <script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
        <script src="assets/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>

        <!-- jQuery Scrollbar -->
        <script src="assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
        <!-- Atlantis JS -->
        <script src="assets/js/atlantis.min.js"></script>
        <!-- Atlantis DEMO methods, don't include it in your project! -->
        <script src="assets/js/setting-demo2.js"></script>
        <script>
            $('#displayNotif').on('click', function () {
                var placementFrom = $('#notify_placement_from option:selected').val();
                var placementAlign = $('#notify_placement_align option:selected').val();
                var state = $('#notify_state option:selected').val();
                var style = $('#notify_style option:selected').val();
                var content = {};

                content.message = 'Turning standard Bootstrap alerts into "notify" like notifications';
                content.title = 'Bootstrap notify';
                if (style == "withicon") {
                    content.icon = 'fa fa-bell';
                } else {
                    content.icon = 'none';
                }
                content.url = 'index.html';
                content.target = '_blank';

                $.notify(content, {
                    type: state,
                    placement: {
                        from: placementFrom,
                        align: placementAlign
                    },
                    time: 1000,
                });
            });

            // Rating 
            var rangeSlider = function () {
                var slider = $('.range-slider'),
                    range = $('.range-slider__range'),
                    value = $('.range-slider__value');

                slider.each(function () {

                    value.each(function () {
                        var value = $(this).prev().attr('value');
                        $(this).html(value);
                    });

                    range.on('input', function () {
                        $(this).next(value).html(this.value);
                    });
                });
            };

            rangeSlider();
        </script>
        <script src="js/movie.js"></script>
    </body>

    </html>