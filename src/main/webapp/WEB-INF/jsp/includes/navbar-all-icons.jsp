<!-- navbar -->
<div class="container-fluid">
    <div class="header">
        <h2><a>Link Sharing</a></h2>
        <a href="#" style="margin-top:21px">${user.username}</a>
        <a style="margin-left:7px" class="fa fa-user"></a>
        <!-- <a href="#"><span class="fa-stack"><i class="fa fa-file-o fa-stack-2x"></i><i class="fa fa-plus fa-stack-1x"></i></span></a> -->
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
