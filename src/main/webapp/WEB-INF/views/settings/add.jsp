<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Add Settings</h1>
</div>
<form method="post" action="${SITE_URL}/settings/save">
    <div class="row">
        <div class="form-group">
            <div class="col-md-12">
                <label>Name</label>
                <input type="text" name="name" class="form-control" required="required"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group">
            <div class="col-md-12">
                <label>Value</label>
                <textarea name="value" class="form-control" required="required"></textarea>
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-success">Save</button>
    <a href="${SITE_URL}/settings" class="btn btn-danger">Back</a>
   
</form>
<%@include file="../shared/footer.jsp" %>