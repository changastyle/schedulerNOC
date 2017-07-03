package controller;


import util.Mes;
import util.Fecha;
import model.Integrante;
import model.Grupo;
import java.util.ArrayList;
import java.util.Date;
import model.FechaRespuesta;
import util.Dia;

public class Controller
{
    private final static Fecha fechaPivot = new Fecha(30,11,2015);
    
    private static ArrayList<Grupo> arrDeGrupos = new ArrayList<Grupo>();
    
    private final static int rutinaA[] = {2,2,0,0,2,2,4,0,0,2,2,2,2,0,2,2,2,2,0,0,0};
    private final static int rutinaB[] = {1,1,2,2,0,0,0,2,2,0,0,1,1,4,0,0,1,1,2,2,0};
    private final static int rutinaC[] = {0,0,1,1,1,1,0,1,1,1,1,0,0,0,1,1,0,0,1,1,4};
    
    private static Grupo grupoA = new Grupo("grupoA");
    private static Grupo grupoB = new Grupo("grupoB");
    private static Grupo grupoC = new Grupo("grupoC");
    
    private final static Integrante integranteNG = new Integrante("Nicolas", "Grossi");
    private final static Integrante integranteDM = new Integrante("Diego", "Molinaro");
    private final static Integrante integranteAV = new Integrante("Alejando", "Vergani");
    private final static Integrante integranteJL = new Integrante("Jorge", "Lamperti");
    private final static Integrante integranteES = new Integrante("Esteban", "Sosa");
    private final static Integrante integranteDC = new Integrante("Diego", "Cejas");
        
    private static void armarTeams()
    {
        grupoA.addIntegrante(integranteNG);
        grupoA.addIntegrante(integranteDM);
        grupoA.setupRutina(rutinaA);
        
        grupoB.addIntegrante(integranteAV);
        grupoB.addIntegrante(integranteJL);
        grupoB.setupRutina(rutinaB);
        
        grupoC.addIntegrante(integranteES);
        grupoC.addIntegrante(integranteDC);
        grupoC.setupRutina(rutinaC);
        
        arrDeGrupos.add(grupoA);
        arrDeGrupos.add(grupoB);
        arrDeGrupos.add(grupoC);
        
    }
    
    public static Mes resolverMes(int numeroMes , int year)
    {
        Mes mesRespuesta = null;
        
        mesRespuesta = new Mes(numeroMes, year);
        
        for(Dia d : mesRespuesta.getArrDiasDelMes())
        {
            calcular(d);
        }
        
        return mesRespuesta;
    }
    
    public static void calcular(Dia hoy)
    {
        armarTeams();
            
        if(hoy.timestamp() > fechaPivot.getTime())
        {
            long distancia = (hoy.timestamp() - fechaPivot.getTime()) / (3600 * 1000 * 24);
            
            
            while(distancia > 21)
            {
                distancia -= 21;
            }
            
            int dis = (int) distancia;
            
            //DOMINGO:
            if(hoy.isDomingo())
            {
                for(Grupo grupo : arrDeGrupos)
                {
                    if(grupo.getRutina().get(dis) == 4)
                    {
                       hoy.setGrupoMañanero(grupo);
                       hoy.setGrupoTarde(grupo);
                       break;
                    }
                }
                if( hoy.getGrupoMañanero().equals(null) )
                {
                    System.out.println("" + hoy );
                }
            }
            //DIA NO DOMINGO:
            else if( !hoy.isDomingo() )
            {
                boolean encontreM = false, encontreT  = false;
                
                for(Grupo grupo : arrDeGrupos)
                {
                   if(grupo.getRutina().get(dis) == 1)
                   {
                       hoy.setGrupoMañanero(grupo);
                       encontreM = true;
                       if(encontreT)
                       {
                           break;
                       }
                   } 
                   else if(grupo.getRutina().get(dis) == 2)
                   {
                       hoy.setGrupoTarde(grupo);
                       encontreT = true;
                       if(encontreM)
                       {
                           break;
                       }
                   } 
                }
                if(hoy.getGrupoMañanero().equals(null))
                {
                    System.out.println("hoy:" + hoy);
                }
            }
        } 
        else
        {
            System.out.println("fecha menor al dia de hoy..");
        }
    }
    
    
    //<editor-fold desc="GYS">
    public static Grupo getGrupoA()
    {
        return grupoA;
    }

    public static Grupo getGrupoB()
    {
        return grupoB;
    }

    public static Grupo getGrupoC()
    {
        return grupoC;
    }
    //</editor-fold>

}
