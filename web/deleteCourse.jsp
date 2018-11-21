<%@page import="com.prad.webapp.entity.daoimpl.CourseDAOImpl"%>
<%@page import="com.prad.webapp.entity.dao.CourseDAO"%>
<%@page import="com.prad.webapp.entity.dao.CourseDAO"%>

<%
CourseDAO courseDAO= new CourseDAOImpl();
if(request.getParameter("id")!=null){
    int id= Integer.parseInt(request.getParameter("id"));
courseDAO.delete(id); 
response.sendRedirect("index.jsp");
}
%>