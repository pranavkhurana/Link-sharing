<%@ page import="java.util.Date" %>
<%@ page import="com.ttnd.entity.Resource" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${baseURL}/resources/css/custom.css">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta charset="utf-8">
    <title>Home | Link Sharing</title>
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
<div style="text-align: center"><h3>${message}${popupMessage}</h3></div>
<div class="container">
    <div class="row">
        <div class="col-sm-7">
            <div class="wrap">
                <%--Recent share panel--%>
                <div class="row rounded-top">
                    <h5>Recent Shares</h5>
                </div>

                <div class="row">
                    <c:forEach items="${recentPublicResources}" var="res">
                    <%--recent share media--%>
                    <div class="media">
                        <div class="media-left">
                            <a class="dp" href="#"><span class="glyphicon glyphicon-user"></span></a>
                        </div>
                        <div class="media-body">
                            <a class="black" href="#"><h4 class="media-heading">${res.createdBy.firstname} ${res.createdBy.lastname}</h4></a>
                            <span class="text-muted">@${res.createdBy.username}
                                <%
                                    Resource resource=(Resource)pageContext.getAttribute("res");
                                    long diff=new Date().getTime()-resource.getDateCreated().getTime();
                                    out.print(diff/3600000+"hr"+" "+(diff%3600000)/60000+"min");
                                %>
                            </span>
                            <a class="right" href="${baseURL}/show-topic/${res.topic.topicid}">${res.topic.name}</a>
                            <p>${res.description}</p>
                            <a class="black" href="#"><span class="fa fa-facebook-square"></span></a>
                            <a class="black" href="#"><span class="fa fa-twitter"></span></a>
                            <a class="black" href="#"><span class="fa fa-google-plus"></span></a>
                            <a class="right" href="#">View post</a>
                        </div>
                    </div><%--recent share media--%>
                    </c:forEach>
                </div><%--recent share--%>
                <hr>

                <%--Top post panel    --%>
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
                <%--Top post media--%>
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
                        <form:form action="${baseURL}/login" method="post" class="form-horizontal login-form">
                        <div style="text-align: center;margin-bottom: 10px;color:red">${loginMessage}</div>

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
                        <form:form action="${baseURL}/register" method="post" commandName="user2" class="form-horizotal" enctype="multipart/form-data">

                        <div style="text-align: center;margin-bottom: 10px">${registerMessage}</div>
                        <div class="form-group">
                            <label class="control-label col-sm-5" for="first">First name*</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="first" name="firstname" required/>
                                <form:errors path="firstname"/>
                            </div>
                        </div>
                        <div class="clearfix">

                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-5" for="last">Last name*</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="last" name="lastname" required/>
                                <form:errors path="lastname"/>
                            </div>
                        </div>
                        <div class="clearfix">

                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-5" for="email">Email</label>
                            <div class="col-sm-7">
                                <input type="email" class="form-control" id="email" name="email" required/>
                                <form:errors path="email"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-5" for="username">Username*</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="username" name="username" required/>
                                <form:errors path="username"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-5" for="password">Password*</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="password" name="password" required/>
                                <form:errors path="password"/>
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
        </div> <!--col-sm-5-->

    </div><!--row-->


</div><!--container-->

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>