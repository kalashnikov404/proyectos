package conversores;

import java.time.LocalDateTime;

import enumeraciones.Secciones;
import enumeraciones.Servicios;
import enumeraciones.Tamaños;
import enumeraciones.Tipos;
import modelo.Lugar;

public class Conversor {
	
	
	public static String convertirDeTamaños(Tamaños tamaño) {
		String tamañoVehiculo = null;
		
		switch(tamaño){
		case CHICO: tamañoVehiculo="Chico"; break;
		case MEDIANO: tamañoVehiculo="Mediano"; break;
		case GRANDE: tamañoVehiculo="Grande"; break;
		}
		
		return tamañoVehiculo;
	}
	
	public static Tamaños convertirATamaños(String tamaño) {
		Tamaños tamañoVehiculo = null;
		
		switch(tamaño){
		case "Chico": tamañoVehiculo=Tamaños.CHICO; break;
		case "Mediano": tamañoVehiculo=Tamaños.MEDIANO; break;
		case "Grande": tamañoVehiculo=Tamaños.GRANDE; break;
		}
		
		return tamañoVehiculo;
	}
	
	
	public static String convertirDeTipos(Tipos tipo) {
		String tipoVehiculo = null;
		
		switch(tipo){
		case MOTO: tipoVehiculo="Moto"; break;
		case CARRO: tipoVehiculo="Carro"; break;
		case CAMIONETA: tipoVehiculo="Camioneta"; break;
		}
		
		return tipoVehiculo;
	}
	
	public static Tipos convertirATipos(String tipo) {
		Tipos tipoVehiculo = null;
		
		switch(tipo){
		case "Moto": tipoVehiculo=Tipos.MOTO; break;
		case "Carro": tipoVehiculo=Tipos.CARRO; break;
		case "Camioneta": tipoVehiculo=Tipos.CAMIONETA; break;
		}
		
		return tipoVehiculo;
	}
	
	
	public static int convertirDeSecciones(Secciones seccion) {
		int seccionEstacionado = 0;
		
		switch(seccion) {
		case CHICA: seccionEstacionado=1; break;
		case MEDIANA: seccionEstacionado=2; break;
		case GRANDE: seccionEstacionado=3; break;
		}
		
		return seccionEstacionado;
	}
	
	public static Secciones convertirASecciones(int seccion) {
		Secciones seccionEstacionado = null;
		
		switch(seccion) {
		case 1: seccionEstacionado=Secciones.CHICA; break;
		case 2: seccionEstacionado=Secciones.MEDIANA; break;
		case 3: seccionEstacionado=Secciones.GRANDE; break;
		}
		
		return seccionEstacionado;
	}
	
	public static int convertirDeServicio(Servicios servicio) {
		int res=0;
		
		switch(servicio) {
		case LAVADO: res=1; break;
		case ENCERADO: res=2; break;
		case ASPIRADO: res=3; break;
		case UNAHRESTACIONADO: res=4; break;
		}
		
		return res;
	}
	
	public static int convertirDeLugar(Lugar lugar) {
		int numLugar=0;
		int espacio=lugar.getEspacio();
		int seccion=convertirDeSecciones(lugar.getSeccion());
		
		if(espacio==1 && seccion==1) {
			numLugar=1;
		}
		if(espacio==2 && seccion==1) {
			numLugar=2;
		}
		if(espacio==3 && seccion==1) {
			numLugar=3;
		}
		if(espacio==4 && seccion==1) {
			numLugar=4;
		}
		if(espacio==5 && seccion==1) {
			numLugar=5;
		}
		if(espacio==6 && seccion==1) {
			numLugar=6;
		}
		if(espacio==7 && seccion==1) {
			numLugar=7;
		}
		if(espacio==1 && seccion==2) {
			numLugar=8;
		}
		if(espacio==2 && seccion==2) {
			numLugar=9;
		}
		if(espacio==3 && seccion==2) {
			numLugar=10;
		}
		if(espacio==4 && seccion==2) {
			numLugar=11;
		}
		if(espacio==5 && seccion==2) {
			numLugar=12;
		}
		if(espacio==6 && seccion==2) {
			numLugar=13;
		}
		if(espacio==7 && seccion==2) {
			numLugar=14;
		}
		if(espacio==1 && seccion==3) {
			numLugar=15;
		}
		if(espacio==2 && seccion==3) {
			numLugar=16;
		}
		if(espacio==3 && seccion==3) {
			numLugar=17;
		}
		if(espacio==4 && seccion==3) {
			numLugar=18;
		}
		if(espacio==5 && seccion==3) {
			numLugar=19;
		}
		if(espacio==6 && seccion==3) {
			numLugar=20;
		}
		if(espacio==7 && seccion==3) {
			numLugar=21;
		}
		
		return numLugar;
	}
	
	public static String convertirFecha(LocalDateTime fecha) {
		String mes="";
		
		if(fecha.getMonth().toString()=="JANUARY") {
			mes="01";
		}
		if(fecha.getMonth().toString()=="FEBRUARY") {
			mes="02";
		}
		if(fecha.getMonth().toString()=="MARCH") {
			mes="03";
		}
		if(fecha.getMonth().toString()=="APRIL") {
			mes="04";
		}
		if(fecha.getMonth().toString()=="MAY") {
			mes="05";
		}
		if(fecha.getMonth().toString()=="JUNE") {
			mes="06";
		}if(fecha.getMonth().toString()=="JULY") {
			mes="07";
		}
		if(fecha.getMonth().toString()=="AUGUST") {
			mes="08";
		}
		if(fecha.getMonth().toString()=="SEPTEMBER") {
			mes="09";
		}
		if(fecha.getMonth().toString()=="OCTOBER") {
			mes="10";
		}
		if(fecha.getMonth().toString()=="NOVEMBER") {
			mes="11";
		}
		if(fecha.getMonth().toString()=="DECEMBER") {
			mes="12";
		}
		return fecha.getYear()+"-"+mes+"-"+fecha.getDayOfMonth()+" "+fecha.getHour()+":"+fecha.getMinute()+":"+fecha.getSecond();
	}
	

}
