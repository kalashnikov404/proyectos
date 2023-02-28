package utilidades;

import java.util.*;

import vista.Cine;



public class HilosReloj extends Thread {
	private String segundos, minutos, horas, pmam;
	private Calendar calendar;
	


	@Override
	public void run() {

		for (int i = 0;; i++) {
			calcularHora();

			Cine.getLbReloj().setText(horas + ":" + minutos + ":" + segundos + pmam);

			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}

		}

	}

	public void calcularHora() {
		calendar = new GregorianCalendar();
		Date horaactual = new Date();
		calendar.setTime(horaactual);
		pmam = calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
		if (pmam.equals("PM")) {
			int h = calendar.get(Calendar.HOUR_OF_DAY) - 12;
			horas = h > 9 ? "" + h : "0" + h;
		} else {
			horas = calendar.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendar.get(Calendar.HOUR_OF_DAY)
					: "0" + calendar.get(Calendar.HOUR_OF_DAY);
		}
		minutos = calendar.get(Calendar.MINUTE) > 9 ? "" + calendar.get(Calendar.MINUTE)
				: "0" + calendar.get(Calendar.MINUTE);
		segundos = calendar.get(Calendar.SECOND) > 9 ? "" + calendar.get(Calendar.SECOND)
				: "0" + calendar.get(Calendar.SECOND);
	}
}