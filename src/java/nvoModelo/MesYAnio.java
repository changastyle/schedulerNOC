package nvoModelo;

import nuevo.Mes;

public class MesYAnio
{
    private Mes mes;
    private int year;

    public MesYAnio() {
    }

    public MesYAnio(int numeroMes, int year) {
        this.mes = new Mes(numeroMes);
        this.year = year;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public String getStrMes()
    {
        String nombreMes = "";
        switch(mes.getNumeroMes())
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
            case 12: nombreMes = "Enero"; break;
        }  
        return nombreMes;
    }
}
