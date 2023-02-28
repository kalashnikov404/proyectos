package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import conversores.Conversor;
import modelo.Estacionamiento;
import modelo.Lugar;
import modelo.Vehiculo;

public class TablaEstacionamiento {
	
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaEstacionamiento(Connection conexion) {
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

	public String guardar(Estacionamiento estacionamiento) {
		String sql = "insert into estacionamiento values(null, '" + Conversor.convertirFecha(estacionamiento.getFechaEntrada()) + "', null,'" 
	+ estacionamiento.getVehiculo().getPlacas()+ "'," + Conversor.convertirDeLugar(estacionamiento.getLugar())+ ")";
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Estacionado registrado";
			} catch (SQLException e) {
				System.out.println(e.toString());
				
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
		
	}
	
	public String modificarHrE(String placas, LocalDateTime fecha) {
		String sql = "update estacionamiento set fechaentrada_est='" + Conversor.convertirFecha(fecha) + "' where cve_est=(select cve_est where placas_veh='"+
	placas+"' && fechasalida_est is null && fechaentrada_est=(select max(fechaentrada_est) where placas_veh='"+placas+"' && fechasalida_est is null group by placas_veh))";
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Estacionado modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());
				
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
		
	}
	
	public String modificarHrS(String placas, LocalDateTime fecha) {
		String sql = "update estacionamiento set fechasalida_est='"+fecha+"' where cve_est=(select cve_est where placas_veh='"+placas+"' && fechasalida_est=(select max(fcsalida_est) where placas_veh='"+placas+"' group by placas_veh))";
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Estacionado modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());
				
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
		
	}
	
	public String modificarLugar(String placas, Lugar lugar) {
		String sql = "update estacionamiento set num_lug="+Conversor.convertirDeLugar(lugar)+" where cve_est=(select cve_est where placas_veh='"+placas+"' && fechasalida_est is null && fechaentrada_est=(select max(fechaentrada_est) where placas_veh='"+placas+"' && fechasalida_est is null group by placas_veh))";
		
		System.out.println("estoy modificando lug");
		
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Estacionado modificado";
			} catch (SQLException e) {
				System.out.println(e.toString());
				
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
		
	}
	
	public String registrarSalida(String placas, LocalDateTime fechaTiempo) {
		
		String fechaConvert=Conversor.convertirFecha(fechaTiempo);
		
		String sql = "update estacionamiento set fechasalida_est='"+ fechaConvert +"' where placas_veh='"+ placas +"'";
		
		if(statement!=null) {
			try {
				statement.executeUpdate(sql);
				return "Salida registrada";
			} catch (SQLException e) {
				System.out.println(e.toString());
				
			}
		}else {
			System.out.println("eror, no hay sentencia");
		}
		return sql.toString();
		
		
	}
	
	public String obtenerImagen(Lugar lugar) {
		int lug = Conversor.convertirDeLugar(lugar);
		String imagen = null;
		int res=0;
		
		String sql = "select count(num_lug) from estacionamiento where num_lug="+lug+" && fechasalida_est is null";
		
		
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (rs!=null){
			try {
				while(rs.next()){
				try {
					res = Integer.parseInt(rs.getObject(1).toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		if(res==0) {
			imagen="/imagenes/disponible.jpg";
		}
		if(res==1) {
			imagen="/imagenes/ocupado.jpg";
		}
		
		String sqlDos = "select count(num_lug) from estacionamiento join vehiculo on estacionamiento.placas_veh=vehiculo.placas_veh join cliente on vehiculo.placas_veh=cliente.placas_veh join contrato on cliente.cve_cli=contrato.cve_cli where num_lug="+lug+" && cliente.placas_veh=estacionamiento.placas_veh && cliente.cve_per!='' && contrato.fcfin_con>=now()";
	
		ResultSet rsDos = null;
		try {
			rsDos = statement.executeQuery(sqlDos);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int resDos = 0;
		if (rsDos!=null){
			try {
				while(rsDos.next()) {
				try {
					resDos = Integer.parseInt(rsDos.getObject(1).toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		
		if(resDos==1) {
			imagen="/imagenes/reservado.jpg";
		}
		
		
		
		return imagen;
	}

}
