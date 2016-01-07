package util;



import java.util.Date;

public class Fecha extends java.util.Date
{
    public int dia;
    public int mes;
    public int anio;
    public long timestamp;
    private String strDia = "";
    private String strMes = "";

    public Fecha()
    {
        super();
        
        this.dia = this.getDate();
        this.mes = this.getMonth()+1;
        this.anio = this.getYear()+1900;
        this.timestamp = this.getTime();
        
        resolverStr();
    }
    
    
    public Fecha(int dia, int mes, int anio)
    {
        super((anio-1900),(mes-1), dia);
        
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.timestamp = this.getTime();
        
        resolverStr();
    }
    
    //<editor-fold desc="GYS">
    public int getDia()
    {
        return dia;
    }

    public void setDia(int dia)
    {
        this.dia = dia;
    }

    public int getMes()
    {
        return mes;
    }

    public void setMes(int mes)
    {
        this.mes = mes;
    }

    public int getAnio()
    {
        return anio;
    }

    public void setAnio(int anio)
    {
        this.anio = anio;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getStrDia()
    {
        return strDia;
    }

    public void setStrDia(String strDia)
    {
        this.strDia = strDia;
    }

    public String getStrMes()
    {
        return strMes;
    }

    public void setStrMes(String strMes)
    {
        this.strMes = strMes;
    }
    //</editor-fold>

    @Override
    public String toString()
    {
        return getStrDia() +" " + getDia()+ " de " + getStrMes() + " " + getAnio() + " | " + super.toString();
    }

    private void resolverStr()
    {
        switch(dia)
        {
            case 1: strDia = "Lunes";break;
            case 2: strDia = "Martes";break;
            case 3: strDia = "Miercoles";break;
            case 4: strDia = "Jueves";break;
            case 5: strDia = "Viernes";break;
            case 6: strDia = "Sabado";break;
            case 7: strDia = "Domningo";break;
        }
        switch(mes)
        {
            case 1: strMes = "Enero";break;
            case 2: strMes = "Febrero";break;
            case 3: strMes = "Marzo";break;
            case 4: strMes = "Abril";break;
            case 5: strMes = "Mayo";break;
            case 6: strMes = "Junio";break;
            case 7: strMes = "Julio";break;
            case 8: strMes = "Agosto";break;
            case 9: strMes = "Setiembre";break;
            case 10: strMes = "Octubre";break;
            case 11: strMes = "Noviembre";break;
            case 12: strMes = "Diciembre";break;
        }   
    }
    
}
