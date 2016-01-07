<%@page import="controller.Controller"%>
<%@page import="util.Fecha"%>
<%
    
    String strDia= request.getParameter("dia");
    String strMes = request.getParameter("mes");
    String strYear = request.getParameter("year");
    
    if(strDia!= null && strMes != null && strYear != null)
    {
        int dia = Integer.parseInt(strDia);
        int mes = Integer.parseInt(strMes);
        int year = Integer.parseInt(strYear);

        out.print( Controller.calcular( new Fecha(dia,mes,year) ).toJSON() );  
    }
    else
    {
        out.print("No se especifico fecha..");
    }
    
%>