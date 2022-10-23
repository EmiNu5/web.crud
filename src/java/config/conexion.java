package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    private static Connection con = null;
    private static final String  URL = "jdbc:mysql://localhost:3306/";
    private static final String  DATABASE = "crud";
    private static final String  USER= "root";
    private static final String  PASS = ""; 
    public static Connection Conectar(){
        //control de exception
        try{
            Class.forName("com.mysql.jdbc.Driver");//ruta del driver
            con = DriverManager.getConnection(URL+DATABASE,USER,PASS);
        }catch (Exception e){
            System.err.println("Error: "+e);
        }
        return con;
    }
}
