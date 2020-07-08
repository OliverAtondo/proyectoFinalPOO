import java.util.Date;
import java.text.SimpleDateFormat;

class Fecha{

	public static String agendarFecha(String dia, String mes, String hora, String minutos){

        Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 

        String strDateFormat = hora+":"+minutos+dia+"/"+mes+"/y"; // El formato de fecha está especificado  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 

    	return objSDF.format(objDate);
    }
    }