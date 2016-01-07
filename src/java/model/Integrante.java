package model;


public class Integrante
{
    private String nombre;
    private String apellido;

    public Integrante()
    {
    }

    public Integrante(String nombre, String apellido)
    {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    //<editor-fold desc="GYS">

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
    //</editor-fold>

    @Override
    public String toString()
    {
        return "Integrante{" + "nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
}
