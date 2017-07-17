<!-- Modal -->
<div class="modal fade" id="send-invite-box" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>
            <div class="modal-body">

                <%--send-invite-box--%>
                <div class="popup">
                    <%--Register form content--%>
                    <div class="row">
                        <form action="send-invite" method="post" class="form-horizotal">
                            <div class="form-group">
                                <label class="control-label col-sm-5" for="email">Email*</label>
                                <div class="col-sm-7">
                                    <input type="email" class="form-control" id="email" name="email" required/>
                                </div>
                            </div>
                            <div class="clearfix">

                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-5" for="topic">Topic*</label>
                                <div class="col-sm-7">
                                    <select name="topic" id="topic" class="form-control">
                                        <option value="1">topic1</option>
                                        <option value="2">topic2</option>
                                    </select>
                                </div>
                            </div>
                            <div class="clearfix">

                            </div>
                            <%--<div class="form-group">
                            <label class="control-label col-md-5" for="photo">Photo</label>
                            <div class="col-md-7 col-sm-12">
                                <input type="file" class="form-control" id="photo" name="photo"/>
                            </div>
                        </div>--%>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-default">Invite</button>

                        </form>
                    </div>
                </div><!--create-topic-box-end-->

            </div>
        </div>

    </div>
</div>


