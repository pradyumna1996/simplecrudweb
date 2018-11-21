<%-- 
    Document   : index
    Created on : Nov 18, 2018, 10:53:29 AM
    Author     : conne
--%>
<%@page import="com.prad.webapp.entity.dao.CourseDAO"%>
<%@page import="com.prad.webapp.entity.daoimpl.CourseDAOImpl"%>
<%@page import="com.prad.webapp.entity.Course"%>
<%@include file="shared/header.jsp" %>
<h1>Courses</h1>
<div class="pull-right">
    <p>
        <a href="addCourse.jsp" class="btn btn-success btn-xs"><span class="gyphicon glyphicon-plus"></span></a>
    </p>
</div>
<table class="table table-bordered table-striped table-hover">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Fees</th>
        <th>Status</th>
        <th>Added Date</th>
        <th>Action</th>
    </tr>
    <%
        CourseDAO courseDAO = new CourseDAOImpl();
        for (Course c : courseDAO.getAll()) {

    %>
    <tr class="<%=(c.isStatus()) ? "success" : "danger"%>"> 
        <td> <%=c.getId()%> </td>
        <td> <%=c.getName()%> </td>
        <td> <%=c.getFees()%> </td>
        <td> <%=c.isStatus()%> </td>
        <td> <%=c.getAddedDate()%> </td>
        <td>
            <a href="editCourse.jsp?id=<%=c.getId()%>" class="btn btn-success btn-xs">
                <span class="glyphicon glyphicon-pencil" </span>
            </a>    
            <a href="deleteCourse.jsp?id=<%=c.getId()%>" class="btn btn-danger btn-xs" onclick="return confirm('Are You Sure To Delete ?')" >
                <span class="glyphicon glyphicon-trash"> </span>
            </a>

        </td>

    </tr>
    <% }%>
</table>
<%@include file="shared/footer.jsp" %>
