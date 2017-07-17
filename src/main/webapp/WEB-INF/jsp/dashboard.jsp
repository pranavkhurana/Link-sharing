<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/custom.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="resources/js/popup.js"></script>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta charset="utf-8">
    <title>Dashboard | Link Sharing</title>
</head>
<body>
<%@include file="includes/navbar-all-icons.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-5">
            <div class="wrap">
                <!--rounded username panel-->
                <div class="row rounded-all">
                    <div class="media">
                        <div class="media-left">
                            <a class="dp" href="#"><span class="glyphicon glyphicon-user"></span></a>
                        </div>
                        <div class="media-body">
                            <a class="black" href="#"><h2 class="media-heading">${user.firstname} ${user.lastname}</h2></a>
                            <p><span class="text-muted">@${user.username}</span><p>
                            <div class="row">
                                <div class="col-xs-6">
                                    <span class="text-muted">Subscriptions</span>
                            <p><a>50</a></p>
                        </div>
                        <div class="col-xs-6">
                            <span class="text-muted">Topics</span>
                            <p><a>50</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--Panel for subscriptions-->
        <div class="row rounded-top">
            <h5>Subscriptions</h5>
            <div class="panel-heading-right-text"><a>View All</a></div>
        </div>
        <div class="row">
            <%@include file="subscriptions/not-personal-subscription.jsp"%>
            <%@include file="subscriptions/personal-subscription.jsp"%>
        </div>
        <hr>
        <%--Subsciption end--%>

        <!--Panel Trending Topics-->
        <div class="row rounded-top">
            <h5 class="inline">Trending topics</h5>
        </div>
        <div class="row">
            <%@include file="topics/personal-topic.jsp"%>
            <%@include file="topics/unsubscribed-topic.jsp"%>
        </div>
        <hr>
        <%--Trending topics end--%>
    </div>
</div>
<div class="col-md-7">
    <div class="wrap">
        <div class="text-center font-weight-bold"><h3>${popupMessage}</h3></div>
            <%--Popups--%>
            <%@include file="popup/create-topic.jsp"%>
            <%@include file="popup/send-invite.jsp"%>
            <%@include file="popup/share-document.jsp"%>
            <%@include file="popup/share-link.jsp"%>

            <!--Inbox panel-->
            <div class="row rounded-top">
                <h5>Inbox</h5>
            </div>
            <div class="row">
                <%@include file="inbox/inbox.jsp"%>
                <%@include file="inbox/inbox.jsp"%>
            </div>
            <hr>
            <%--Inbox end--%>

    </div><!--wrap-->
</div> <!--col-md-7-->
</div><!--row-->
</div><!--container-->
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
