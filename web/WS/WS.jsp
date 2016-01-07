<%@page import="java.util.Date"%>
<%@page import="controller.Controller"%>
<%
    Date today = new Date();
    String strYear = session.getAttribute( "year" ).toString();
    int year = 0;
    
    if(strYear != null)
    {
        year = Integer.parseInt(strYear);
    }
    else
    {
        year = (today.getYear() + 1900);
    }
    
    
    out.print("[");
    for(int i = 0 ; i < 12 ;i++)
    {
        out.println( Controller.resolverMes( i , year ).toJSON() );
        
        if(i < (12 - 1) )
        {
            out.print(",");
        }
    }
    out.print("]");
    
%>