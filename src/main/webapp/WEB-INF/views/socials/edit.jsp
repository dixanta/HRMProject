<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Add Edit</h1>
</div>
<form method="post" action="${SITE_URL}/socials/save">
    <div class="form-group">
        <div class="col-md-12">
            <label>Name</label>
            <input type="text" name="name" class="form-control" required="required" value="${social.name}"/>
        </div>
    </div>
    <input type="hidden" name="id" value="${social.id}"/>
    <button type="submit" class="btn btn-success">Save</button>
    <a href="${SITE_URL}/socials" class="btn btn-danger">Back</a>

</form>
<%@include file="../shared/footer.jsp" %>