<!--media for subscibed-personal trending topic-->
<div class="media">
    <div class="media-left">
        <a class="dp" href="#"><span class="glyphicon glyphicon-user"></span></a>
    </div>
    <div class="media-body">
        <form action="${baseURL}/edit-profile/edit-topic-name" method="post">
            <input type="text" value="${topic.name}" name="topicname"/>
            <input type="hidden" value="${topic.topicid}" name="id"/>
            <input type="hidden" value="${uri}" name="uri"/>
            <input type="submit" value="save"/>
            <input type="button" value="cancel"/>
        </form>
        <div class="row margin-top-16">
            <div class="col-xs-5">
                <span class="text-muted">@${topic.createdBy.username}</span>
                <%--<p class="text-muted"><a>Unsubscribe</a></p>--%>
            </div>
            <div class="col-xs-4">
                <span class="text-muted">Subscriptions</span>
                <p><a>50</a></p>
            </div>
            <div class="col-xs-3">
                <span class="text-muted">Post</span>
                <p><a>30</a></p>
            </div>
        </div>
    </div>
</div>
<div class="after-media clearfix">
    <span>
        <form id="visibilityUpdateForm" action="${baseURL}/edit-profile/edit-topic-visibility" style="display:inline" method="post">
            <select name="visibilityInt" value="${topic.visibility}" onchange="$('#visibilityUpdateForm').submit()">
            <%--<select name="visibilityInt" value="${topic.visibility}" onchange="submitVisibilityUpdateForm()">--%>
                <option selected="selected" disabled="disabled">${topic.visibility}</option>
                <option value="0">Public</option>
                <option value="1">Private</option>
            </select>
            <input type="hidden" value="${topic.topicid}" name="id"/>
            <input type="hidden" value="${uri}" name="uri"/>
        </form>
        <form:form id="subscriptionUpdateForm" commandName="userSubscription" action="${baseURL}/changeSeriousness" cssStyle="display:inline" method="post">
            <form:input path="subscriptionid" id="subscriptionid" value="" cssStyle="display:none"></form:input>
            <form:select path="seriousness" id="seriousness" itemValue="seriousness" onchange="submitSubscriptionUpdateForm(${userSubscription.subscriptionid})">
                <form:options/>
            </form:select>
            <input type="hidden" name="uri" value="${uri}"/>
        </form:form>

        <a class="fa fa-envelope fa-2x" aria-hidden="true"></a>
        <%--<a class="fa fa-pencil fa-2x" aria-hidden="true"></a>--%>
        <a class="fa fa-trash fa-2x" aria-hidden="true"></a>
    </span>
</div>
<hr>
