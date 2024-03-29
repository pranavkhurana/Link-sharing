<!-- navbar -->
<div class="container-fluid">
    <div class="header">
        <h2><a>Link Sharing</a></h2>
        <div class="dropdown">
            <button id="username-navbar" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">${user.username}
                <span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="${baseURL}/edit-profile">Edit profile</a></li>
                <li><a href="${baseURL}/logout">Logout</a></li>
            </ul>
        </div>
        <a style="margin-left:7px" class="fa fa-user"></a>
        <a class="fa fa-envelope-o  send-invite" data-toggle="modal" data-target="#send-invite-box"></a>
        <a class="fa fa-chain  share-link" data-toggle="modal" data-target="#share-link-box"></a>
        <a class="fa fa-file-o share-document" data-toggle="modal" data-target="#share-document-box"></a>
        <a class="fa fa-comment-o  create-topic" data-toggle="modal" data-target="#create-topic-box"></a>
        <form class="form-inline" action="#" method="post">
            <div class="form-group">
                <label class="control-label" for="search"> <a href="#"> <span id="search" class="fa fa-search"></span></a></label>
                <input type="text" class="form-control" name="" value="Search" style="height:29px">
                <a href="#"><span id="cross" class="fa fa-times"></span></a>
            </div>
        </form>
    </div>
</div><!-- navbar ends -->

<div class="text-center font-weight-bold"><h3>${popupMessage}</h3></div>
<%--Popups--%>
<%@include file="../popup/create-topic.jsp"%>
<%@include file="../popup/send-invite.jsp"%>
<%@include file="../popup/share-document.jsp"%>
<%@include file="../popup/share-link.jsp"%>
<%@include file="subscribe-form.jsp"%>