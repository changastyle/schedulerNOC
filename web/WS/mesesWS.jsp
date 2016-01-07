<%
    out.print("[");
    String[] nombreMeses = {"enero","febrero","marzo","abril","mayo","junio", "julio", "agosto","septiembre", "octubre","noviembre","diciembre"};
    int year = (2016-1900);
    
    for(int i = 0 ; i < 12; i++)
    {
        out.print("{\"numero\":" +i + " , \"nombre\":\"" + nombreMeses[i] + "\",\"cantidadDias\":\""+controller.Controller.cantidadDiasEnMes(i,year)+"\"}");
        
        
        if( i < 11)
        {
            out.print(",");
        }
        
    }
    out.print("]");
%>