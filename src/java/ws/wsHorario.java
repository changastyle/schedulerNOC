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
            calendar.add(Calendar.DAY_OF_YEAR, contadorAumento);
            
            
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
    public static nuevo.Mes formatoCalendario(int mesParametro)
    {
        nuevo.Mes mesAux = new nuevo.Mes(mesParametro -1);
        Calendar cal = Calendar.getInstance();
        Date hoy = new Date();
        cal.setTime(hoy);
        int cantSemanasMes = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        int cantDiasMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("cantidad Semanas mes(" + (hoy.getMonth() +1)  +"/" + (hoy.getYear() + 1900) +"): " + cantSemanasMes + " " + cantDiasMes);
        
        
        String formatoSemana[] = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        
        int dia = hoy.getDate();
        int mes = hoy.getMonth();
        int year = hoy.getYear();
        int diaFormateado = dia;
        int mesFormateado = mes + 1;
        int yearFormateado = year + 1900;
        
        
        for(int s = 0 ; s < cantSemanasMes ;s ++)//cantSemanasMes
        {
            System.out.println("semana " + s);
            Semana semanaAux = new Semana();
            
            for(int f = 0; f < formatoSemana.length; f++)
            {
                int resta = 0;
                
                
                nuevo.Dia diaAux;
                
                do
                {
                    if(s == 0)
                    {
                        int chota =(s*f) + f - resta;
                        Date d = new Date(year,mes, chota);
                        diaAux = new nuevo.Dia(d);
                        if (d.getMonth() != hoy.getMonth())
                        {
                            diaAux.setEsDelMesPasado(true);
                        }
                        
                        System.out.println("semana "+ s +" " + chota + " " + formatoSemana[f]);
                    }
                    else
                    {
                        int chota = (s*7) + f + resta;
                        Date d = new Date(year,mes, chota);
                        diaAux = new nuevo.Dia(d);
                        if (d.getMonth() != hoy.getMonth())
                        {
                            diaAux.setEsDelMesPasado(true);
                        }
                        System.out.println("semana "+ s +" " + chota + " " + formatoSemana[f]);
                    }
                    
                    
                    resta++;
                    
                }
                while(!diaAux.getDiaDeLaSemana().equalsIgnoreCase(formatoSemana[f]));
                System.out.println(diaAux);
                semanaAux.addDiaALaSemana(diaAux);
            }
                
                
            mesAux.addSemanaAlMes(semanaAux);
            
        }
        
        
        
        return mesAux;
    }
}
