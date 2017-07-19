<!--media for subscibed-personal trending topic-->
<div class="media">
    <div class="media-left">
        <a class="dp" href="#"><span class="glyphicon glyphicon-user"></span></a>
    </div>
    <div class="media-body">
        <form action="" method="">
            <input type="text" placeholder="${topic.name}" name="" value="">
            <input type="submit" value="save">
            <input type="submit" value="cancel">
        </form>
        <div class="row margin-top-16">
            <div class="col-xs-5">
                <span class="text-muted">@${topic.createdBy.username}</span>
                <p><a>Unsubscribe</a></p>
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
                  <select>
                    <option value="Delete">Delete</option>
                    <option value="Edit">Edit</option>
                    <option value="Private">Private</option>
                  </select>
                  <select>
                    <option value="Serious">Serious</option>
                    <option value="Very serious">Very serious</option>
                    <option value="Casual">Casual</option>
                  </select>
                  <a class="fa fa-envelope fa-2x" aria-hidden="true"></a>
                  <a class="fa fa-pencil fa-2x" aria-hidden="true"></a>
                  <a class="fa fa-trash fa-2x" aria-hidden="true"></a>
                </span>
</div>
<hr>
