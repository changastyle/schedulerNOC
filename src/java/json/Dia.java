package json;

import java.util.Date;

public class Dia 
{
    private long timestamp;
    private int dia;
    private int diaDeLaSemana;
    private int mes;
    private int year;

    public Dia(long timestamp) 
    {
        this.timestamp = timestamp;
        Date aux = new Date(timestamp);
        dia = aux.getDate();
        diaDeLaSemana = aux.getDay();
        mes = aux.getMonth();
        year = aux.getYear();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getDiaDeLaSemana() {
        return diaDeLaSemana;
    }

    public void setDiaDeLaSemana(int diaDeLaSemana) {
        this.diaDeLaSemana = diaDeLaSemana;
    }

    public int getMes() {
        return (mes + 1) ;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getYear() {
        return (year + 1900);
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public String getStrDiaDeLaSemana()
    {
        String strDiaDeLaSemana = "DESCONOCIDO";
        
        if(diaDeLaSemana == 1)
        {
            strDiaDeLaSemana = "Lunes";
        }
        if(diaDeLaSemana == 2)
        {
            strDiaDeLaSemana = "Martes";
        }
        if(diaDeLaSemana == 3)
        {
            strDiaDeLaSemana = "Miercoles";
        }
        if(diaDeLaSemana == 4)
        {
            strDiaDeLaSemana = "Jueves";
        }
        if(diaDeLaSemana == 5)
        {
            strDiaDeLaSemana = "Viernes";
        }
        if(diaDeLaSemana == 6)
        {
            strDiaDeLaSemana = "Sabado";
        }
        if(diaDeLaSemana == 0)
        {
            strDiaDeLaSemana = "Domingo";
        }
        
        return strDiaDeLaSemana;
    }
    public String getStrMes()
    {
        String strMes = "DESCONOCIDO";
        
        if(mes == 0)
        {
            strMes = "Enero";
        }
        if(mes == 1)
        {
            strMes = "Febrero";
        }
        if(mes == 2)
        {
            strMes = "Marzo";
        }
        if(mes == 3)
        {
            strMes = "Abril";
        }
        if(mes == 4)
        {
            strMes = "Mayo";
        }
        if(mes == 5)
        {
            strMes = "Junio";
        }
        if(mes == 6)
        {
            strMes = "Julio";
        }
        if(mes == 7)
        {
            strMes = "Agosto";
        }
        if(mes == 8)
        {
            strMes = "Septiembre";
        }
        if(mes == 9)
        {
            strMes = "Octubre";
        }
        if(mes == 10)
        {
            strMes = "Noviembre";
        }
        if(mes == 11)
        {
            strMes = "Diciembre";
        }
        
        return strMes;
    }
    
    
}
