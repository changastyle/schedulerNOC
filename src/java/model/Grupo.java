package model;

import com.google.gson.Gson;
import java.util.ArrayList;


public class Grupo
{
    private int id;
    private java.util.ArrayList<Integrante> integrantes;
    private java.util.ArrayList<Integer> rutina;
    private String nombreGrupo;
    
    public Grupo(int id, String nombreGrupo)
    {
        this.id = id;
        this.nombreGrupo = nombreGrupo;
        rutina = new java.util.ArrayList<Integer>();
        integrantes = new java.util.ArrayList<Integrante>();
    }
    public Grupo(int id, String nombreGrupo, ArrayList<Integrante> integrantes, ArrayList<Integer> rutina)
    {
        this.id = id;
        this.nombreGrupo = nombreGrupo;
        this.integrantes = integrantes;
        this.rutina = rutina;
    }
    
    //<editor-fold desc="GYS">
    public ArrayList<Integrante> getIntegrantes()
    {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<Integrante> integrantes)
    {
        this.integrantes = integrantes;
    }

    public ArrayList<Integer> getRutina()
    {
        return rutina;
    }

    public void setRutina(ArrayList<Integer> rutina)
    {
        this.rutina = rutina;
    }
    //</editor-fold>

    public void addIntegrante (model.Integrante integrante)
    {
        if(this.integrantes != null)
        {
            this.integrantes.add(integrante);
        }
    }
    
    public void setupRutina(int[] arr)
    {
        for(int i = 0 ; i < arr.length ; i ++)
        {
            this.rutina.add(arr[i]);
        }
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    
    public String toString()
    {
        return this.nombreGrupo;
    }
    public String toString2()
    {
        String salida =  "|-------- " + nombreGrupo + " --------|\n";
        
        for(Integrante integrante : this.integrantes)
        {
           salida+= integrante.toString() + "\n";
        }
        salida += " Rutina:\n";
        for(Integer rutina : this.getRutina())
        {
            switch(rutina)
            {
                case 0 : salida += "    descanso \n";break;
                case 1 : salida += "    mañana \n";break;  
                case 2 : salida += "    tarde \n";break;
                case 4 : salida += "    domingo \n";break;
            }
        }
        
        return salida;
    }
    
    public String toJSON()
    {
        Gson gson = new Gson();
        
        return gson.toJson(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
