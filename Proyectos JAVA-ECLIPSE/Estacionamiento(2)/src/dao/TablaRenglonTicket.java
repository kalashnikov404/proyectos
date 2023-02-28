package dao;

import java.sql.Connection;
import java.sql.SQLException;

import conversores.Conversor;
import modelo.RenglonTicket;
import modelo.Ticket;
import servicios.ServiceEstacionamientoImpl;
import servicios.ServiceTicketImpl;


public class TablaRenglonTicket {

	private Connection conexion;
	private java.sql.Statement statement;

	public TablaRenglonTicket(Connection conexion) {
		super();
		this.conexion = conexion;
		crearSentencia();
	}

	private  void crearSentencia() {
		try {
			statement=conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			statement=null;
		}
	}

	public String guardar(Ticket ticket) {
		ServiceTicketImpl impl= new ServiceTicketImpl();
		String salida="";
		int i=0;
		String sql=null;
		while(i<ticket.getItems().size()) {
			sql = "insert into renglonticket values(null, " + ticket.getItems().get(i).getCosto() + ", " 
					+ impl.obtenerIdTicket(ticket) +","+ Conversor.convertirDeServicio(ticket.getItems().get(i).getServicio()) +")";
			i++;

			if(statement!=null) {
				try {
					statement.executeUpdate(sql);
					salida= "RenglonTicket registrado";
				} catch (SQLException e) {
					System.out.println(e.toString());

				}
			}else {
				System.out.println("eror, no hay sentencia");
			}
		}
		return salida;

	}

	public String eliminar(int idTicket, int idServicio) {
		String salida="";
		String sql=null;

		sql = "delete from renglonticket where cve_tic=" + idTicket + " && cve_ser=" + idServicio;

		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				salida= "RenglonTicket eliminado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return salida;
	}
	
	public String guardarCnIdTicket(RenglonTicket renglonTicket, int idTicket) {
		String salida="";
		String sql=null;
		
			sql = "insert into renglonticket values(null, " + renglonTicket.getCosto() + ", " + idTicket + ", " + Conversor.convertirDeServicio(renglonTicket.getServicio()) + ")";
			

			if(statement!=null) {
				try {
					statement.executeUpdate(sql);
					salida= "RenglonTicket registrado";
				} catch (SQLException e) {
					System.out.println(e.toString());

				}
			}else {
				System.out.println("eror, no hay sentencia");
			}
		
		return salida;

	}


}



