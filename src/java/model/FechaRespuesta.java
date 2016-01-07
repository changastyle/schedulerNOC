package model;

import com.google.gson.Gson;

public class FechaRespuesta 
{
    private int dia;
    private int mes;
    private int year;
    private boolean domingo;
    private boolean feriado;
    private Grupo grupoMañanero;
    private Grupo grupoTarde;

    public FechaRespuesta()
    {
        this.dia = 0;
        this.mes = 0;
        this.year = 0;
        this.domingo = false;
        this.feriado = false;
        this.grupoMañanero = null;
        this.grupoTarde = null;
    }
    public FechaRespuesta(int dia, int mes, int year, boolean domingo, boolean feriado, Grupo grupoMañanero, Grupo grupoTarde) {
        this.dia = dia;
        this.mes = mes;
        this.year = year;
        this.domingo = domingo;
        this.feriado = feriado;
        this.grupoMañanero = grupoMañanero;
        this.grupoTarde = grupoTarde;
    }
    
    //<editor-fold desc="GYS:">

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isDomingo() {
        return domingo;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    public boolean isFeriado() {
        return feriado;
    }

    public void setFeriado(boolean feriado) {
        this.feriado = feriado;
    }

    public Grupo getGrupoMañanero() {
        return grupoMañanero;
    }

    public void setGrupoMañanero(Grupo grupoMañanero) {
        this.grupoMañanero = grupoMañanero;
    }

    public Grupo getGrupoTarde() {
        return grupoTarde;
    }

    public void setGrupoTarde(Grupo grupoTarde) {
        this.grupoTarde = grupoTarde;
    }
    //</editor-fold>

    @Override
    public String toString() 
    {
        return "FechaRespuesta{" + "dia=" + dia + ", mes=" + mes + ", year=" + year + ", domingo=" + domingo + ", feriado=" + feriado + ", grupoMa\u00f1anero=" + grupoMañanero + ", grupoTarde=" + grupoTarde + '}';
    }
    
    public String toJSON()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    
    
    
}
