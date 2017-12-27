package ws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import json.Dia;
import nuevo.Mes;
import nuevo.Semana;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.springframework.web.bind.annotation.*;

@RestController
public class wsHorario {
    
    @RequestMapping(value = "queDiaEsHoy")
    public json.Dia queDiaEsHoy(@RequestParam(value = "contadorAumento",required = false ,defaultValue = "0") int contadorAumento) throws ParseException
    {
        Dia hoy = new Dia(new Date().getTime());
        if(contadorAumento != 0)
        {
            final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            
            
            String str = "" + hoy.getYear()+"/" + hoy.getMes() + "/" + hoy.getDia();
            final Date date = format.parse(str);
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, contadorAumento);
            
            
            //hoy = format.format(calendar.getTime());
            System.out.println("la concha tuya:" + calendar.getTimeInMillis());
            
            hoy = new Dia(calendar.getTimeInMillis());
        }
        return hoy;
    }
    @RequestMapping(value = "calendarioNoc")
    public util.Mes calendarioNoc(@RequestParam(value = "mes") int mes,@RequestParam(value = "year") int year) 
    {
        return controller.Controller.resolverMes(mes, year);
    }
    
    @RequestMapping(value="formatoCalendario")
    public static nuevo.Mes formatoCalendario(int mesParametro ,int anioParametro)
    {
        
        nuevo.Mes mesAux = new nuevo.Mes(mesParametro -1);
        
        // 1 - CREO UN CALENDARIO:
        Calendar cal = Calendar.getInstance();
        Date hoy = new Date((anioParametro - 1900), (mesParametro -1) , 1);
        cal.setTime(hoy);
        
        
        int cantSemanasMes = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        int cantDiasMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("El mes (" + (hoy.getMonth() +1)  +"/" + (hoy.getYear() + 1900) +") tiene " + cantSemanasMes + " semanas y " + cantDiasMes + " dias");
        
        
        String formatoSemana[] = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        
        int dia = hoy.getDate();
        int mes = hoy.getMonth();
        int year = hoy.getYear();
        int diaFormateado = dia;
        int mesFormateado = mes + 1;
        int yearFormateado = year + 1900;
        
        
        System.out.println("cantidad de semanas del mes: " + cantSemanasMes);
        
        boolean comenzo = false;
        int corrimiento = 0;
        
        // 1 -  RECORRO TODAS LAS SEMANAS DEL MES:
        for(int semanaLoop = 0 ; semanaLoop < cantSemanasMes ;semanaLoop ++)//cantSemanasMes
        {
            System.out.println("semana loop " + semanaLoop);
            Semana semanaAux = new Semana();
            
            // 2 - VOY GENERANDO CADA DIA DE CADA SEMANA:
            for(int indiceDiaDeLaSemana = 0; indiceDiaDeLaSemana < formatoSemana.length; indiceDiaDeLaSemana++)
            {
                
                int diaDeLaSemana = ( semanaLoop * 7) + indiceDiaDeLaSemana - corrimiento;
                Date dateDelDiaLaboral = new Date(year , mes , diaDeLaSemana);
                if(!comenzo)
                {
                    System.out.println("dia de la semana que empieza el mes = " +  dateDelDiaLaboral + " corrimiento: " + dateDelDiaLaboral.getDay());
                    comenzo = true;
                    corrimiento  = ( dateDelDiaLaboral.getDay() -1 );
                    diaDeLaSemana = ( semanaLoop * 7) + (indiceDiaDeLaSemana - corrimiento);
                    dateDelDiaLaboral = new Date(year , mes , diaDeLaSemana);
                }
                
                nuevo.Dia diaLaboral = diaLaboral = new nuevo.Dia( dateDelDiaLaboral );
                
                
                if ( dateDelDiaLaboral.getMonth() != hoy.getMonth())
                {
                    diaLaboral.setEsDelMesPasado(true);
                    if(semanaLoop == 0)
                    {
                        diaLaboral.setMes(mes-1);
                        diaLaboral.setStrMes(resolverNombreMes(mes-1));
                    }
                    else
                    {
                        diaLaboral.setMes(mes+1);
                        diaLaboral.setStrMes(resolverNombreMes(mes+1));
                    }
                }
                else
                {
                    diaLaboral.setMes(mes);
                    diaLaboral.setStrMes(resolverNombreMes(mes));
                }
                
                semanaAux.addDiaALaSemana(diaLaboral);
            }
                
                
            mesAux.addSemanaAlMes(semanaAux);
            
        }
        
        
        
        return mesAux;
    }
    public static String resolverNombreMes(int mes)
    {
        String nombreMes = "";
        switch(mes)
        {
            case -1: nombreMes = "Diciembre";break;
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
