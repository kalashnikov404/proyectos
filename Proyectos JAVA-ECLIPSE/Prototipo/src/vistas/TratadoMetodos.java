package vistas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.mysql.fabric.Response;

public class TratadoMetodos {

	  private Connection connect = null;
	  PreparedStatement preparedStatement = null;
	
	public void ConseguirCsv() {
		
		 String jdbcURL = "jdbc:mysql://localhost:3306/tenergy";
	        String username = "root";
	        String password = "root";
	 
	        
	        String csvFilePath = "C:\\Users\\Grudges\\Desktop\\Casos_Diarios.csv";
	 
	        int batchSize = 10;
	 
	        Connection connection = null;
	 
	        try {
	 
	            connection = DriverManager.getConnection(jdbcURL, username, password);
	            connection.setAutoCommit(false);
	 
	          // "INSERT INTO review (course_name, student_name, timestamp, rating, comment) VALUES (?, ?, ?, ?, ?)";
	          
	           String sql =" INSERT INTO csv(cve_ent ,poblacion, nombre, f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	            
	            
	            
	            PreparedStatement statement = connection.prepareStatement(sql);
	 
	            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
	            String lineText = null;
	 
	            int count = 0;
	 
	            lineReader.readLine(); // skip header line
	 
	            while ((lineText = lineReader.readLine()) != null) {
	            	
	                String[] data = lineText.replaceAll("[-+/><^?$%&/#()=¡¿?!*|°-]", "").split(",");
	             
	                
	                String cve = data[0];
	                String poblacion = data[1];
	                String nombre = data[2];

	                String f1 = data[3];
	                String f2 = data[4];
	                String f3 = data[5];
	                String f4 = data[6];
	                String f5 = data[7];
	                String f6 = data[8];
	                String f7 = data[9];
	                String f8 = data[10];
	                String f9 = data[11];
	                String f10 = data[12];
	                String f11= data[13];
	                String f12 = data[14];
	                String f13 = data[15];
	                String f14 = data[16];
	                String f15 = data[17];

	                
	                
	                
	                statement.setString(1, cve);
	                statement.setString(2, poblacion);
	                statement.setString(3, nombre);
	                statement.setString(4, f1);
	                statement.setString(5, f2);
	                statement.setString(6, f3);
	                statement.setString(7, f4);
	                statement.setString(8, f5);
	                statement.setString(9, f6);
	                statement.setString(10, f7);
	                statement.setString(11, f8);
	                statement.setString(12, f9);
	                statement.setString(13, f10);
	                statement.setString(14, f11);
	                statement.setString(15, f12);
	                statement.setString(16, f13);
	                statement.setString(17, f14);
	                statement.setString(18, f15);

	               
	                statement.addBatch();
	 
	                if (count % batchSize == 0) {
	                    statement.executeBatch();
	                }
	            }
	 
	            lineReader.close();
	 
	            // execute the remaining queries
	            statement.executeBatch();
	 
	            connection.commit();
	            connection.close();
	        JOptionPane.showMessageDialog(null, "Datos csv insertados con exito en la base de datos");
	        
	    
	        } catch (IOException ex) {
	        	
	        	  JOptionPane.showMessageDialog(null,"Ocurrio un error, verifica e intentalo de nuevo" + ex);
	        } catch (SQLException ex) {
	        	  JOptionPane.showMessageDialog(null,"Ocurrio un error , verifica e intentalo de nuevo" + ex);
	 
	            try {
	                connection.rollback();
	            } catch (SQLException e) {
		        	  JOptionPane.showMessageDialog(null,"Ocurrio un error, verifica e intentalo de nuevo" + e);
	                
	                
	            }
	        }
	 
	    }
	
	
	public void ConseguirJson() throws SQLException {
		
		  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	      //Getting the connection
	      String mysqlUrl = "jdbc:mysql://localhost:3306/tenergy";
	      Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");


	        
	        
	        
		    try {
		    	
	          
		        JSONParser parser = new JSONParser();
		        //Use JSONObject for simple JSON and JSONArray for array of JSON.
		        JSONObject data = (JSONObject) parser.parse(
		              new FileReader("C:\\Users\\Grudges\\Desktop\\paises.json"));//path to the JSON file.

		        String j = data.toString();
		       		        
		        
		        JSONParser p = new JSONParser();
		        JSONObject json = (JSONObject) p.parse(j);
		        
//		       
		        JSONArray jsonArray = (JSONArray) json.get("countries");
		         
		        PreparedStatement pstmt = con.prepareStatement("INSERT INTO json values (?, ?, ?, ?, ?)");
		        
		        for(Object object : jsonArray) {
		            JSONObject record = (JSONObject) object;
		        
		            
		            String nombre = (String) record.get("name_es");
		            String nombreEs = (String) record.get("code");
		            String codigo = (String) record.get("dial_code");
		            String siglas = (String) record.get("name_en");
		          
		            pstmt.setInt(1, 0);
		            pstmt.setString(2, nombre);
		            pstmt.setString(3, nombreEs);
		            pstmt.setString(4, codigo);
		            pstmt.setString(5, siglas);

		            
		            
		            pstmt.executeUpdate();
		         }  
		        JOptionPane.showMessageDialog(null, "Datos json insertados con exito en la base de datos");


		    } catch (FileNotFoundException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (ParseException e) {
		         e.printStackTrace();
		      } catch (Exception e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		   
	}
		    
}
	
