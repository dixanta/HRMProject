<%@include file="../shared/header.jsp" %>
        <h1>Companies!</h1>
        <div class="pull-right">
            <p>
                <a href="${SITE_URL}/companies/add" class="btn btn-default">
                    <span class="glyphicon glyphicon-plus"></span>
                </a>
            </p>
        </div>
        <table class="table table-hover table-striped">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Contact No</th>
                <th>Status</th>
                <th>Demands</th>
                <th>Action</th>
                
            </tr>
            <c:forEach var="company" items="${companies}">
                <tr>
                    <td>${company.id}</td>
                    <td>${company.name}</td>
                    <td>${company.email}</td>
                    <td>
                        
                        <label class="label label-primary">Phone: ${company.phoneNo}</label><br/>
                        <label class="label label-info">Mobile: ${company.mobileNo}</label>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${company.status}">
                                <label class="label label-success">Active</label>
                            </c:when>
                            <c:otherwise>
                                <label class="label label-danger">Inactive</label>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${company.totalDemands()}</td>
                    <td>
                        <a href="${SITE_URL}/companies/edit/${company.id}" class="btn btn-default">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </a>
                        <a href="${SITE_URL}/companies/delete/${company.id}" class="btn btn-default">
                            <span class="glyphicon glyphicon-trash"></span>
                        </a>
                    </td>
                </tr>
                </c:forEach>
        </table>
<%@include file="../shared/footer.jsp" %>