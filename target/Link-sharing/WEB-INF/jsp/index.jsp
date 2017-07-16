<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta charset="utf-8">
    <title>Home | Link Sharing</title>
    <style media="screen">
        .container-fluid{
            border:1px solid;
            border-radius:10px;
            margin-bottom:20px;
        }
        .header h2{
            display:inline-block;
        }
        .header form{
            float:right;
        }
        .header input{
            border:none;
        }
        .header .form-group{
            display:inline-flex;
            border:1px solid;
            border-radius:20px;
            margin-top:10px;
        }
        .header span#search{
            margin-left:10px;
            margin-top: 8px;
        }
        .header span#cross{
            margin-right:10px;
            margin-top:8px;
        }
        /*changes*/
        .header>a{
            float:right;
            margin: 25px 3px 0px 3px;
        }
        .wrap{
            margin:10px;
        }
        /*changes*/
        .col-sm-7>.wrap>.row,.col-sm-5>.wrap>.row,.col-md-7>.wrap>.row,.col-md-5>.wrap>.row{
            border:1px solid;
        }
        .rounded-top{
            border-top-right-radius:5px;
            border-top-left-radius: 5px;
            background-color: #e6e6e6;
            padding-left: 10px;
        }
        .media:last-child{
            padding-bottom: 15px;
        }
        .media{
            padding: 15px 25px 0px 25px;
        }
        .media span.glyphicon-user{
            border:1px solid;
            font-size:100px;
            padding-top:10px;
            padding-bottom: 0px;
        }
        .media .media-body a.right{
            float:right;
        }
        .media .media-body h4{
            display:inline;
        }
        .media .media-left{
            color:#4b4a4a4d;
        }
        form a.right,form button{
            float: right;
            margin-top: 20px;
            margin-right: 15px;
            margin-bottom:10px !important;
        }
        input[type="file"]{
            padding:0px 0px;
            border:none;
        }
        .black{
            color:black;
        }
        #forgot-password{
            margin-top:22px;
        }
        .form-group{
            padding-bottom:1px;
            margin-bottom:45px;
        }
        form{
            padding:10px;
        }
        .login-form .form-group{
            margin-bottom:15px;
        }
        .dropdown{
            float:right;
            margin: 6px;
        }
        .inline{
            display:inline-block;
            padding: 5px;
        }
        .dp{
            color:#4b4a4a4d;
        }
        
        /*dashboard specific*/
        .panel-heading-right-text{
            padding:7px;
            float:right;
        }
        .row.rounded-top h5{
            display:inline-block;
        }
        .rounded-all{
            border-radius:8px;
            margin-bottom:30px;
        }
        .small-underline{
            margin-left:8px;
            text-decoration: underline;
        }
        .margin-top-15{
            margin-top: 30px;
        }
        .margin-top-16{
            margin-top:16px;
        }
        .after-media a{
            float:right;
            padding:4px;
        }
        .after-media{
            margin: 8px 5px 5px 15px;
        }
        .media-body form input[type="text"]{
            width:35%;
        }
        .media-body form input[type="submit"]{
            padding:0px;
        }
        .fa-2x,.fa-stack{
            color:black;
        }

    </style>
</head>
<body>
<div class="container-fluid">
    <div class="header">
        <h2><a class="underlined"><u>Link Sharing</u></a></h2>
        <form class="form-inline" action="#" method="post">
            <div class="form-group">
                <label class="control-label" for="search"> <a href="#"> <span id="search" class="glyphicon glyphicon-search"></span></a></label>
                <input type="text" class="form-control" name="" value="Search">
                <a href="#"><span id="cross" class="glyphicon glyphicon-remove-sign"></span></a>
            </div>
        </form>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-7">
            <div class="wrap">
                <div class="row rounded-top">
                    <h5>Recent Shares</h5>
                </div>
                <div class="row">
                    <div class="media">
                        <div class="media-left">
                            <a class="dp" href="#"><span class="glyphicon glyphicon-user"></span></a>
                        </div>
                        <div class="media-body">
                            <a class="black" href="#"><h4 class="media-heading">Uday Pratap Singh</h4></a>
                            <span class="text-muted">@uday 5min</span>
                            <a class="right" href="#">Grails</a>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            <a class="black" href="#"><span class="fa fa-facebook-square"></span></a>
                            <a class="black" href="#"><span class="fa fa-twitter"></span></a>
                            <a class="black" href="#"><span class="fa fa-google-plus"></span></a>
                            <a class="right" href="#">View post</a>
                        </div>
                    </div>
                    <div class="media">
                        <div class="media-left">
                            <a class="dp" href="#"><span class="glyphicon glyphicon-user"></span></a>
                        </div>
                        <div class="media-body">
                            <a class="black" href="#"><h4 class="media-heading">Uday Pratap Singh</h4></a>
                            <span class="text-muted">@uday 5min</span>
                            <a class="right" href="#">Grails</a>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            <a class="black" href="#"><span class="fa fa-facebook-square"></span></a>
                            <a class="black" href="#"><span class="fa fa-twitter"></span></a>
                            <a class="black" href="#"><span class="fa fa-google-plus"></span></a>
                            <a class="right" href="#">View post</a>
                        </div>
                    </div>
                </div>
                <hr>

                <div class="row rounded-top">
                    <h5 class="inline">Top Posts</h5>
                    <div class="dropdown">
                        <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Posts from
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="#">Today</a></li>
                            <li><a href="#">This week</a></li>
                            <li><a href="#">This month</a></li>
                            <li><a href="#">This year</a></li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="media">
                        <div class="media-left">
                            <a class="dp" href="#"><span class="glyphicon glyphicon-user"></span></a>
                        </div>
                        <div class="media-body">
                            <a class="black" href="#"><h4 class="media-heading">Uday Pratap Singh</h4></a>
                            <span class="text-muted">@uday 5min</span>
                            <a class="right" href="#">Grails</a>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                            <a class="black" href="#"><span class="fa fa-facebook-square"></span></a>
                            <a class="black" href="#"><span class="fa fa-twitter"></span></a>
                            <a class="black" href="#"><span class="fa fa-google-plus"></span></a>
                            <a class="right" href="#">View post</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <div class="col-sm-5">
            <div class="wrap">
                <div class="row rounded-top">
                    <h5>Login</h5>
                </div>
                <div class="row">
                    <div style="text-align: center;margin-bottom: 10px;color:red">${loginMessage}
                        <form:errors path="user.password"/>
                        <form:errors path="user.email"/>
                    </div>
                        <form:form action="login" method="post" class="form-horizontal login-form" commandName="user">

                        <div class="form-group">
                            <label class="control-label col-sm-5" for="email">Email/Username*</label>
                            <div class="col-sm-7">
                                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-5" for="password">Password*</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required/>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-default">Login</button>
                        <a id="forgot-password" class="right" href="#">Forgot password</a>
                    </form:form>
                </div>

                <hr>

                <div class="row rounded-top">
                    <h5>Register</h5>
                </div>
                <div class="row">
                        <div style="text-align: center;margin-bottom: 10px;color:red">
                            <form:errors path="user2.password"/>
                            <form:errors path="user2.email"/>
                            <form:errors path="user2.photo"/>
                        </div>
                        <form:form action="register" method="post" commandName="user2" class="form-horizotal" enctype="multipart/form-data">

                        <div style="text-align: center;margin-bottom: 10px">${registerMessage}</div>
                        <div class="form-group">
                            <label class="control-label col-sm-5" for="first">First name*</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="first" name="firstname" required/>
                            </div>
                        </div>
                        <div class="clearfix">

                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-5" for="last">Last name*</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="last" name="lastname" required/>
                            </div>
                        </div>
                        <div class="clearfix">

                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-5" for="email">Email</label>
                            <div class="col-sm-7">
                                <input type="email" class="form-control" id="email" name="email" required/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-5" for="username">Username*</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="username" name="username" required/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-5" for="password">Password*</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="password" name="password" required/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-5" for="confirm">Confirm password*</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="confirm" name="confirmPassword" required/>
                            </div>
                        </div>
                        <div class="clearfix">

                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-5" for="photo">Photo</label>
                            <div class="col-md-7 col-sm-12">
                                <input type="file" class="form-control" id="photo" name="file"/>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-default">Register</button>
                    </form:form>
                </div>
            </div><!--wrap-->
        </div> <!--col-sm-4-->

    </div><!--row-->


</div><!--container-->

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>