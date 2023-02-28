package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import conversores.Conversor;
import modelo.Ticket;


public class TablaTicket {

	private Connection conexion;
	private java.sql.Statement statement;

	public TablaTicket(Connection conexion) {
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

		String sql = "insert into ticket values(null, '" + Conversor.convertirFecha(ticket.getFecha()) + "', '" 
				+ ticket.getPlacas()+"')";
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Ticket registrado";
			} catch (SQLException e) {
				System.out.println(e.toString());

			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();

	}

	public int obtenerIdTicket(Ticket ticket) {
		int res=0;

		String sql = "select cve_tic from ticket where fecha_tic='"+Conversor.convertirFecha(ticket.getFecha())+"' && placas_veh='"+ticket.getPlacas()+"'";


		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		if (rs!=null){
			try {
				while(rs.next()){
					try {
						res = Integer.parseInt(rs.getObject(1).toString());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;

	}
	
	public int obtenerIdTicketRecienteCnPlc(String placas) {
		int res=0;

		String sql = "select cve_tic from ticket where placas_veh='" + placas + "' && fecha_tic=(select max(fecha_tic) from ticket where placas_veh='" + placas + "' group by placas_veh)";


		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		if (rs!=null){
			try {
				while(rs.next()){
					try {
						res = Integer.parseInt(rs.getObject(1).toString());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;

	}

}
