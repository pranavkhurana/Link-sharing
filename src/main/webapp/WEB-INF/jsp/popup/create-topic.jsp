<!-- Modal -->
<div class="modal fade" id="create-topic-box" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create new topic</h4>
            </div>
            <div class="modal-body">

                <%--send-invite-box--%>
                <div class="popup">
                    <%--Register form content--%>
                    <div class="row">
                        <form:form action="create-topic" method="post" class="form-horizotal" commandName="topic">
                            <div class="form-group">
                                <label class="control-label col-sm-5" for="name">Name*</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="name" name="name" required/>
                                    <script>
                                        $(function(){
                                            console.log("hello");
                                            $("#name").on("input",function(){
                                                $.ajax({
                                                    url: "/hello",
                                                    data:{email:"value"},
                                                    success:function(d){console.log(d);}
                                                });
                                            })
                                        });
                                    </script>
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
                                </div>
                            </div>
                            <div class="clearfix">

                            </div>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-default">Create</button>

                        </form:form>
                    </div>
                </div><!--create-topic-box-end-->

            </div>
        </div>

    </div>
</div>