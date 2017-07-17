<%--send-invite-box--%>
<div id="share-link-box" class="display popup">
    <%--Register panel--%>
    <div class="row rounded-top">
        <h5>Share Link</h5>
    </div>
    <%--Register form content--%>
    <div class="row">
        <form:form action="share-link" method="post" class="form-horizotal" commandName="link">
            <div class="form-group">
                <label class="control-label col-md-5" for="link">Link</label>
                <div class="col-md-7">
                    <input type="text" class="form-control" id="link" name="link"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-5" for="desc">Description*</label>
                <div class="col-sm-7">
                    <textarea class="form-control" id="desc" name="description" required></textarea>
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
            <button type="submit" class="btn btn-default share-link">Cancel</button>
            <button type="submit" class="btn btn-default">Invite</button>

        </form:form>
    </div><hr>
</div><!--create-topic-box-end-->