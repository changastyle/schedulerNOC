package ws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import json.Dia;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.springframework.web.bind.annotation.*;
import util.Mes;

@RestController
public class wsHorario {
    
    @RequestMapping(value = "queDiaEsHoy")
    public Dia queDiaEsHoy(@RequestParam(value = "contadorAumento",required = false ,defaultValue = "0") int contadorAumento) throws ParseException
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
    public Mes calendarioNoc(@RequestParam(value = "mes") int mes,@RequestParam(value = "year") int year) 
    {
        return controller.Controller.resolverMes(mes, year);
    }
    
}
