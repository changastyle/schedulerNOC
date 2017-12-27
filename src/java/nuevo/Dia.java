package nuevo;

import controller.Controller;
import static controller.Controller.calcular;
import java.util.Date;
import model.Grupo;

public class Dia 
{
    private Date date;
    private String diaDeLaSemana;           // NO SE USA:
    private int mes;
    private String strMes;
    private boolean esDelMesPasado;
    private Grupo grupoMananero;
    private Grupo grupoTarde;
    private boolean esDomingo;
    private boolean esEspacio;
    
    public Dia(Date date)
    {
        this.date = date;
        esDelMesPasado = false;
        calcular(this);
        esEspacio = false;
    }

    public Dia(Date date, Grupo grupoMananero, Grupo grupoTarde, boolean esDomingo) {
        this.date = date;
        this.grupoMananero = grupoMananero;
        this.grupoTarde = grupoTarde;
        this.esDomingo = esDomingo;
        esEspacio = false;
    }

    public boolean isEsDomingo() {
        boolean esDomingoAux = date.getDay() == 0;
        return esDomingoAux;
    }


    public Grupo getGrupoMananero() {
        return grupoMananero;
    }

    public void setGrupoMananero(Grupo grupoMañanero) {
        this.grupoMananero = grupoMañanero;
    }

    public Grupo getGrupoTarde() {
        return grupoTarde;
    }

    public void setGrupoTarde(Grupo grupoTarde) {
        this.grupoTarde = grupoTarde;
    }
    
    
    
    public int getNumeroMes()
    {
        return date.getDate();
    }

    public int getNumeroDentroDeSemana() {
        return date.getDay();
    }

    public String getDiaDeLaSemana() 
    {
        diaDeLaSemana = "";
        switch(date.getDay() )
        {
            case 1 : diaDeLaSemana = "Lunes";break;
            case 2 : diaDeLaSemana = "Martes";break;
            case 3 : diaDeLaSemana = "Miercoles";break;
            case 4 : diaDeLaSemana = "Jueves";break;
            case 5 : diaDeLaSemana = "Viernes";break;
            case 6 : diaDeLaSemana = "Sabado";break;
            default : diaDeLaSemana = "Domingo";break;
        }  
        return diaDeLaSemana;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getStrMes() {
        return strMes;
    }

    public void setStrMes(String strMes) {
        this.strMes = strMes;
    }
    
    public String getAcronimoMes()
    {
        String acronimo = "";
        if(getStrMes() != null)
        {
            if(getStrMes().length() > 3)
            {
                acronimo = getStrMes().substring(0,3);
            }
        }
        return acronimo;
    }

    public Date getDate() {
        return date;
    }

    public boolean isEsEspacio() {
        return esEspacio;
    }

    public void setEsEspacio(boolean esEspacio) {
        this.esEspacio = esEspacio;
    }

    
    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isEsDelMesPasado() {
        return esDelMesPasado;
    }

    public void setEsDelMesPasado(boolean esDelMesPasado) {
        this.esDelMesPasado = esDelMesPasado;
    }

    
    @Override
    public String toString() {
        return "Dia{" + "date=" + date + '}';
    }
    
}
