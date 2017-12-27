package ws;

import java.util.Date;
import nvoModelo.MesYAnio;
import org.springframework.web.bind.annotation.*;
import static ws.wsHorario.formatoCalendario;

@RestController
public class wsHorarioNuevo 
{
    @RequestMapping(value = "mesYAnioActual")
    public static MesYAnio mesYAnioActual(@RequestParam(value = "aumento",defaultValue = "0",required = false) int aumento)
    {
        Date hoy = new Date();
        
        int mesActual = (hoy.getMonth() + 1);
        int anioActual = (hoy.getYear() + 1900);
        
        mesActual += aumento;
        while(mesActual > 12)
        {
            anioActual ++;
            mesActual -= 12;
        }
        /*while(mesActual <= -12)
        {
            anioActual --;
            mesActual --;
        }*/
        
        MesYAnio mesYAnioActual = new MesYAnio( mesActual , anioActual );
        mesYAnioActual.setMes(formatoCalendario( mesActual, anioActual));
        return mesYAnioActual;
    }
}
