<!--Media for unsubscribed trending topic-->
<div class="media">
    <div class="media-left">
        <a class="dp" href="${baseURL}/show-topic/${topic.topicid}"><span class="glyphicon glyphicon-user"></span></a>
    </div>
    <div class="media-body">
        <a class="" href="${baseURL}/show-topic/${topic.topicid}"><h3 class="media-heading">${topic.name}</h3></a>
        <div class="row margin-top-15">
            <div class="col-xs-5">
                <span class="text-muted">@${topic.createdBy.username}</span>
                <p><a onclick="submitSubscriptionForm(${topic.topicid})">Subscribe</a></p>
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
<hr>

