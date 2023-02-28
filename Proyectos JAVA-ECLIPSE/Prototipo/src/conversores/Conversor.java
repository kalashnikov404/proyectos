package conversores;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Conversor {

	public static String[] getArrayDeList(List<String> lista){
		String[] array = new String[lista.size()];
		for(int i=0; i<=lista.size()-1; i++) {
			array[i]=lista.get(i);
		}
		return array;
	}
	
	public static String convertirDate(Date date) {
		String fecha=String.valueOf(date);

		String[] partes = fecha.split(" ");

		String mes="";
		if(partes[1].equals("Jan")) {
			mes="01";
		}
		if(partes[1].equals("Feb")) {
			mes="02";
		}
		if(partes[1].equals("Mar")) {
			mes="03";
		}
		if(partes[1].equals("Apr")) {
			mes="04";
		}
		if(partes[1].equals("May")) {
			mes="05";
		}
		if(partes[1].equals("Jun")) {
			mes="06";
		}
		if(partes[1].equals("Jul")) {
			mes="07";
		}
		if(partes[1].equals("Aug")) {
			mes="08";
		}
		if(partes[1].equals("Sep")) {
			mes="09";
		}
		if(partes[1].equals("Oct")) {
			mes="10";
		}
		if(partes[1].equals("Nov")) {
			mes="11";
		}
		if(partes[1].equals("Dec")) {
			mes="12";
		}
		String salida = partes[5]+"-"+mes+"-"+partes[2];

		return salida;
	}

	public static Date convertirADate(String fecha) {

		String[] partes = fecha.split("-");

		int año = Integer.parseInt(partes[0])-1900;
		int mes = Integer.parseInt(partes[1])-1;
		int dia = Integer.parseInt(partes[2]);

		Date fn = new Date(año, mes, dia);

		return fn;
	}

	public static Time convertirHora(String hora) {

		String[] partes = hora.split(" ");

		String horaCompleta = partes[3];

		String[] partesD = horaCompleta.split(":");

		Time time = new Time(Integer.parseInt(partesD[0]), Integer.parseInt(partesD[1]), Integer.parseInt(partesD[2]));

		return time;
	}
	
	public static String convertirTiempoSistema() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String totalSistema = dtf.format(LocalDateTime.now());
		
		String[] partesT = totalSistema.split(" ");
		
		String[] partesFecha = partesT[0].split("/");
		
		String tiempoTotalMysql = partesFecha[0]+"-"+partesFecha[1]+"-"+partesFecha[2]+" "+partesT[1];
		
		return tiempoTotalMysql;
        
        //2020/09/22 15:07:01
        
	}
	
	public static List<String> getListaDias(){
		
		List<String> dias = new ArrayList<>();
		dias.add("Lunes");
		dias.add("Martes");
		dias.add("Miercoles");
		dias.add("Jueves");
		dias.add("Viernes");
		
		return dias;
		
	}
	
}

