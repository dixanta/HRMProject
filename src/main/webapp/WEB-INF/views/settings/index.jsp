<%@include file="../shared/header.jsp" %>
        <h1>Settings!</h1>
        <div class="pull-right">
            <p>
                <a href="${SITE_URL}/settings/add" class="btn btn-default">
                    <span class="glyphicon glyphicon-plus"></span>
                </a>
            </p>
        </div>
        <table class="table table-hover table-striped">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Action</th>
                
            </tr>
            <c:forEach var="setting" items="${settings}">
                <tr>
                    <td>${setting.id}</td>
                    <td>${setting.name}</td>
                    <td>
                        <a href="${SITE_URL}/settings/edit/${setting.id}" class="btn btn-default">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </a>
                        <a href="${SITE_URL}/settings/delete/${setting.id}" class="btn btn-default">
                            <span class="glyphicon glyphicon-trash"></span>
                        </a>
                    </td>
                </tr>
                </c:forEach>
        </table>
<%@include file="../shared/footer.jsp" %>