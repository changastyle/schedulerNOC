package util;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;

public class Mes 
{
    private int numeroMes;
    private String nombreMes;
    private int year;
    private int cantidadDias;
    private java.util.ArrayList<Dia> arrDiasDelMes;

    
    public Mes(int numeroMes, int year)
    {
        this.numeroMes = numeroMes;
        this.year = (year - 1900);
        
        switch(numeroMes)
        {
            case 0: nombreMes = "Enero";break;
            case 1: nombreMes = "Febrero";break;
            case 2: nombreMes = "Marzo";break;
            case 3: nombreMes = "Abril";break;
            case 4: nombreMes = "Mayo";break;
            case 5: nombreMes = "Junio";break;
            case 6: nombreMes = "Julio";break;
            case 7: nombreMes = "Agosto";break;
            case 8: nombreMes = "Setiembre";break;
            case 9: nombreMes = "Octubre";break;
            case 10: nombreMes = "Noviembre";break;
            case 11: nombreMes = "Diciembre";break;
        }  
        this.cantidadDias = resolverCantidadDiasEnElMes();
        this.arrDiasDelMes = new java.util.ArrayList<Dia>();
        resolverArrDiasEnElMes();
    }
    
    //<editor-fold desc="GYS">
    public void setArrDiasDelMes(ArrayList<Dia> arrDiasDelMes) 
    {
        this.arrDiasDelMes = arrDiasDelMes;
    }    
    public int getNumeroMes()
    {
        return numeroMes;
    }

    public void setNumeroMes(int numeroMes) {
        this.numeroMes = numeroMes;
    }

    public String getNombreMes() {
        return nombreMes;
    }

    public void setNombreMes(String nombreMes) {
        this.nombreMes = nombreMes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public ArrayList<Dia> getArrDiasDelMes() {
        return arrDiasDelMes;
    }

    //</editor-fold>
    
    public int resolverCantidadDiasEnElMes() 
    {
        int cantidadDiasDelMes = 0;
        
        Date primeroMes = new Date(this.year,this.numeroMes, 1);
        
        for(int i = 0 ; i < 40 ; i++)
        {
            int mes = new Date(year, numeroMes, i).getMonth();
            
            if(mes == numeroMes)
            {
                cantidadDiasDelMes++;
            }
        }
        
        
        return cantidadDiasDelMes;
    }
    public void resolverArrDiasEnElMes()
    {
        for(int i = 1 ; i <= this.cantidadDias ; i++)
        {
            int diaDeLaSemana = i;
            
            Dia dia = new Dia(i,this.getNumeroMes(), this.year);
            
            this.arrDiasDelMes.add(dia);
        }
    }

    @Override
    public String toString() 
    {
        return "Mes{" + "numeroMes=" + numeroMes + ", nombreMes=" + nombreMes + ", year=" + year + ", cantidadDias=" + cantidadDias + ", arrDiasDelMes=" + imprimirArray() + '}';
    }
    public String toJSON()
    {
        String json = "{";
        
        json += "\"numeroMes\":" + this.numeroMes  + ",";
        json += "\"nombreMes\": \"" + this.nombreMes + "\",";
        json += "\"year\":" + ( this.year + 1900 ) +",";
        json += "\"arrDiasDelMes\":[";
        
        for(Dia d : arrDiasDelMes)
        {
            json += d.toJSON() ;
            if(arrDiasDelMes.lastIndexOf(d) == arrDiasDelMes.size()-1)
            {
                json += "]";
            }
            else
            {
                json += ",";
            }
        }
       
        
        
        json += "}";
        
        return json;
    }

    private String imprimirArray()
    {
        String salida = "\n";
        
        for(Dia d : this.arrDiasDelMes)
        {
            salida += d.toString() + "\n";
        }
        
        return salida;
    }
    
}
