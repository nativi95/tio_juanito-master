/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author juan.ruizusam
 */
public class Conexion {
    
    static String db="tio_juanito";
    static String usr="root";
    static String pass="root";
    static String url="jdbc:mysql://localhost:3306/"+db+"?useSSL=false";
    
    Connection conn= null;

    public Conexion() {
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, usr, pass);
            
            if(conn!=null){
                System.out.println("Conexion exitosa");
            }
            
        } catch (Exception e) {
            
            System.out.println("No se conectó" + e);
        }
    }
    
    public Connection conectar(){
    return conn;
    }
    
    public void desconectar()throws Exception{
    conn.close();
    }
    
//    public static void main(String[] args) {
//        Conexion conn= new Conexion();
//    }
    
}
