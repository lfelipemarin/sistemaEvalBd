/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursosTecnicos.dbUtilConeccionDB;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*; 
import java.util.Properties;


public class ConexionDb { 


   Connection conn = null; 
    
   public ConexionDb() throws IOException { 
    
       
	Properties prop = new Properties();
	String propFileName = "RecursosTecnicos/configuracion/configuracion.properties";
 
	InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
	if (inputStream != null) {
		prop.load(inputStream);
	} else {
		throw new FileNotFoundException("el achivo de configuracion '" + propFileName + "' no se encuentra");
		}
 
	Date time = new Date(System.currentTimeMillis());
 
//       String alogin = "root"; 
//       String apassword = "clbgkkkp"; 
//       String aurl = "jdbc:mysql://localhost/mydb"; 

       String login = prop.getProperty("login");
       String password = prop.getProperty("password");
       String url = prop.getProperty("url");
       
       
       
       try{     
          
         Class.forName("com.mysql.jdbc.Driver");          
       System.out.println("11ccomo esta la conexion: "+conn);
//       System.out.println("llaaaaaaegue: "+ alogin +" "+apassword+" "+aurl);
       System.out.println("llaaaaaaegue: "+ login +" "+password+" "+url);
       conn = DriverManager.getConnection(url, login, password); 
         System.out.println("como esta la conexion: "+conn);
         if (conn!=null){ 
            System.out.println("conecte  "+url+". listo"); 
         } 
      }catch(SQLException e){ 
         System.out.println(e); 
      }catch(ClassNotFoundException e){ 
         System.out.println(e); 
      } 
   } 
    
   public Connection getConnection(){ 
      return conn; 
   } 
 
   public void desconectar(){ 
      conn = null; 
   } 
   public static void main (String[] args) throws IOException 
  {
   ConexionDb conecta = new ConexionDb();
   
   System.out.println("joder");
   
   }
    
}

