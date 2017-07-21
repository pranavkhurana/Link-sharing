<%@ page import="com.ttnd.entity.Topic" %>
<%@ page import="com.ttnd.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://www.springframework.org/tags/form" %>
<c:set var="uri" value="forward:/dashboard"></c:set>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />

<!DOCTYPE html>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${baseURL}/resources/css/custom.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${baseURL}/resources/js/popup.js"></script>
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
                            <%--<a class="dp" href="#"><img src="${baseURL}/resources/images/${user.userid}.jpg"></a>--%>
                        </div>
                        <div class="media-body">
                            <a class="black" href="#"><h2 class="media-heading">${user.firstname} ${user.lastname}</h2></a>
                            <p><span class="text-muted">@${user.username}</span></p>
                            <div class="row">
                                <div class="col-xs-6">
                                    <span class="text-muted">Subscriptions</span>
                                    <p><a>${noOfSubscriptions}</a></p>
                                </div>
                                <div class="col-xs-6">
                                    <span class="text-muted">Topics</span>
                                    <p><a>${noOfTopics}</a></p>
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
                    <c:forEach items="${subscribedTopicList}" var="topic">
                        <c:if test="${topic.createdBy.userid==user.userid}">
                            <%@include file="topics/personal-topic.jsp"%>
                        </c:if>
                        <c:if test="${topic.createdBy.userid!=user.userid}">
                            <%@include file="topics/subscribed-topic.jsp"%>
                        </c:if>
                    </c:forEach>
                </div>
                <hr>
                <%--Subsciption end--%>

                <!--Panel Trending Topics-->
                <div class="row rounded-top">
                    <h5 class="inline">Trending topics</h5>
                </div>
                <div class="row">
                    <c:forEach items="${trendingTopicList}" var="topic">
                        <c:if test="${topic.createdBy.userid==user.userid}">
                            <%@include file="topics/personal-topic.jsp"%>
                        </c:if>
                        <c:if test="${topic.createdBy.userid!=user.userid}">
                            <%@include file="topics/no-subscription-mention-topic.jsp"%>
                        </c:if>
                    </c:forEach>
                </div>
                <hr>
                <%--Trending topics end--%>
            </div>
        </div>
        <div class="col-md-7">
            <div class="wrap">
                <%--<div class="text-center font-weight-bold"><h3>${popupMessage}</h3></div>--%>
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

<script>

    //visibility and subscription seriousness form submit on topic media
    $('.jsSubmit select').change(function() {
        $(this).closest('form').submit();
    });

    //jquery
    $(document).ready(function(){

        //topic delete on trash click
        $("html").on("click",".js-topic-delete-trash",function () {
            if (!confirm('Are you sure you want to delete this topic? All Posts and Subscriptions will be lost!')) {return 0;}
            var topicid=$(this).attr("id");
            $.ajax({
                type:"POST",
                url:"edit-profile/delete-topic",
                data:{topicid:topicid},
                success:function(data){
                    console.log(data);
                }
            });
            $(this).parent().parent().prev().hide("slow");
            $(this).parent().parent().hide();
        });


        //topic pagination on edit-profile page
        $("#topics").on("click",".change",function(){
            var pageno=$(this).attr("value");
            $.ajax({
                type:"POST",
                url:"edit-profile/paginate-topics",
                data:{pageno:pageno},
                success:function(data){
                    $("#topics").html(data);
                }
            });
        });
    });

</script>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
