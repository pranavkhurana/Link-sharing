<%--send-invite-box--%>
<div id="send-invite-box" class="display popup">
    <%--Register panel--%>
    <div class="row rounded-top">
        <h5>Send Invitation</h5>
    </div>
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
            <button type="submit" class="btn btn-default send-invite">Cancel</button>
            <button type="submit" class="btn btn-default">Invite</button>

        </form>
    </div><hr>
</div><!--create-topic-box-end-->