<!-- Modal -->
<div class="modal fade" id="share-document-box" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Document</h4>
            </div>
            <div class="modal-body">

                <%--share-document-box--%>
                <div class="popup">
                    <%--Register form content--%>
                    <div class="row">
                        <form:form action="share-document" method="post" class="form-horizotal" commandName="documentResource">
                            <div class="form-group">
                                <label class="control-label col-md-5" for="doc">Document</label>
                                <div class="col-md-7 col-sm-12">
                                    <input type="file" class="form-control" id="doc" name="filePath" required/>
                                    <form:errors path="filePath"></form:errors>
                                </div>
                            </div>
                            <div class="clearfix">

                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-5" for="desc">Description*</label>
                                <div class="col-sm-7">
                                    <textarea class="form-control" id="desc" name="description" required></textarea>
                                    <form:errors path="description"></form:errors>
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
                                    <form:errors path="topic"></form:errors>
                                </div>
                            </div>
                            <div class="clearfix">

                            </div>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-default">Invite</button>

                        </form:form>
                    </div>
                </div><!--create-topic-box-end-->

            </div>
        </div>

    </div>
</div>




