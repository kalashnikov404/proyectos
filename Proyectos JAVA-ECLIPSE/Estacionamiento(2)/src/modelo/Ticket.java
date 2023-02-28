package modelo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Ticket {
	
	private LocalDateTime fecha;
	private String placas;
	private List<RenglonTicket> items;
	
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public List<RenglonTicket> getItems() {
		return items;
	}
	public void setItems(List<RenglonTicket> items) {
		this.items = items;
	}
	
	
	
}
