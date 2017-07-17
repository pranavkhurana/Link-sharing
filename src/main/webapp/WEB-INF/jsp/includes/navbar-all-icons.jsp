<!-- navbar -->
<div class="container-fluid">
    <div class="header">
        <h2><a>Link Sharing</a></h2>
        <a href="#"><u>${user.username}</u></a>
        <a style="margin-left:20px" class="fa fa-user fa-2x"></a>
        <!-- <a href="#"><span class="fa-stack"><i class="fa fa-file-o fa-stack-2x"></i><i class="fa fa-plus fa-stack-1x"></i></span></a> -->
        <a class="fa fa-envelope-o fa-2x send-invite" data-toggle="modal" data-target="#send-invite-box"></a>
        <a class="fa fa-chain fa-2x share-link" data-toggle="modal" data-target="#share-link-box"></a>
        <a class="fa fa-file-o fa-2x share-document" data-toggle="modal" data-target="#share-document-box"></a>
        <a class="fa fa-comment-o fa-2x create-topic" data-toggle="modal" data-target="#create-topic-box"></a>
        <form class="form-inline" action="#" method="post">
            <div class="form-group">
                <label class="control-label" for="search"> <a href="#"> <span id="search" class="fa fa-search"></span></a></label>
                <input type="text" class="form-control" name="" value="Search">
                <a href="#"><span id="cross" class="fa fa-times"></span></a>
            </div>
        </form>
    </div>
</div><!-- navbar ends -->