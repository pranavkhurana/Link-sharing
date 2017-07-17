<!-- Modal -->
<div class="modal fade"  id="create-topic-box" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create Topic</h4>
            </div>
            <div class="modal-body">

                <%--create-topic-box--%>
                <div class="display popup">
                    <%--Register panel--%>
                    <%--Register form content--%>
                    <div class="row">
                        <form:form action="create-topic" method="post" class="form-horizontal login-form" commandName="topic">
                            <div class="form-group">
                                <label class="control-label col-sm-5" for="name">Name*</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="name" name="name" required/>
                                </div>
                            </div>
                            <div class="clearfix">

                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-5" for="visi">Visibility*</label>
                                <div class="col-sm-7">
                                    <form:select path="visibility" id="visi">
                                        <form:options/>
                                    </form:select>
                                        <%--
                                                            <select name="visibility" id="visi" class="form-control">
                                                                <option value="1">Private</option>
                                                                <option value="2">Public</option>
                                                            </select>
                                        --%>
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
                            <button type="submit" class="btn btn-default">Save</button>

                        </form:form>
                    </div><hr>
                </div><!--create-topic-box-end-->

            </div>
        </div>

    </div>
</div>


