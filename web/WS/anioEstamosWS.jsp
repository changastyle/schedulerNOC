<%@page import="java.util.Date"%>
<%

    Date date = new Date();
    
    out.print( (date.getYear() + 1900) );
%>