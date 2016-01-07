package util;

import com.google.gson.Gson;
import java.util.Date;
import model.Grupo;

public class Dia
{
    public int mes;
    public int year;
    private int numeroDiaEnElMes;
    private int numeroDiaEnLaSemana;
    private String nombreDia;
    private boolean domingo;
    private boolean feriado;
    private Grupo grupoMañanero;
    private Grupo grupoTarde;

    public Dia(int dia , int mes, int year) 
    {
        this.numeroDiaEnElMes = dia;
        this.mes = mes;
        this.year = year;
        
        //NUMERO DIA DE LA SEMANA:
        Date dateProvisoria = new Date(year,mes,dia);
        this.numeroDiaEnLaSemana = dateProvisoria.getDay();

        
        //NOMBRE DIA DE LA SEMANA:
        switch(this.numeroDiaEnLaSemana)
        {
            case 1: this.nombreDia = "Lunes";break;
            case 2: this.nombreDia = "Martes";break;
            case 3: this.nombreDia = "Miercoles";break;
            case 4: this.nombreDia = "Jueves";break;
            case 5: this.nombreDia = "Viernes";break;
            case 6: this.nombreDia = "Sabado";break;
            case 0: this.nombreDia = "Domingo";break;
        }
        
        //DOMINGOS:
        if(numeroDiaEnLaSemana == 0)
        {
            domingo = true;
        }
        
        //FERIADOS:
        this.feriado = false;
        
        //controller.Controller.calcular(this);
    }
    
    //<editor-fold desc="GYS">
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getNumeroDiaEnElMes() {
        return numeroDiaEnElMes;
    }

    public void setNumeroDiaEnElMes(int numeroDiaEnElMes) {
        this.numeroDiaEnElMes = numeroDiaEnElMes;
    }

    public int getNumeroDiaEnLaSemana() {
        return numeroDiaEnLaSemana;
    }

    public void setNumeroDiaEnLaSemana(int numeroDiaEnLaSemana) {
        this.numeroDiaEnLaSemana = numeroDiaEnLaSemana;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
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
        return "Dia{" + "mes=" + mes + ", year=" + year + ", numeroDiaEnElMes=" + numeroDiaEnElMes + ", numeroDiaEnLaSemana=" + numeroDiaEnLaSemana + ", nombreDia=" + nombreDia + ", domingo=" + domingo + ", feriado=" + feriado + ", grupoMa\u00f1anero=" + grupoMañanero + ", grupoTarde=" + grupoTarde + '}';
    }
    public String toJSON()
    {
        String json = "{";
        
        json += "\"numeroDiaEnElMes\":" + this.numeroDiaEnElMes + ",";
        json += "\"mes\":" + this.mes + ",";
        json += "\"year\":" + (this.year + 1900) + ",";
        json += "\"nombreDia\":\"" + this.nombreDia + "\",";
        json += "\"grupoMananero\":\"" + this.grupoMañanero + "\",";
        json += "\"grupoTarde\":\"" + this.grupoTarde +"\"";
        
        json += "}";
        
        return json;
    }
    public long timestamp()
    {
        return new Date(this.year,this.mes,this.numeroDiaEnElMes).getTime();
    }
    
}
