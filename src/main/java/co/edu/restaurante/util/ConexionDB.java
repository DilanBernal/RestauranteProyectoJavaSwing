
package co.edu.restaurante.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionDB {
    private String user;
    private String password;
    private String dataBase;
    private String portDataBase;
    private String server;
    private String strConexion;
    private Connection con;

    public ConexionDB() {
        this.user = "root";
        this.password = "Belateamomuchisimo050719:3";
        this.dataBase = "restaurante";
        this.portDataBase = "3306";
        this.server = "localhost";
        this.strConexion = "jdbc:mysql://"+this.server+":"+this.portDataBase+"/"+this.dataBase;
        this.con= null;
    }

    private Connection conexionDataBase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con= DriverManager.getConnection(this.strConexion,this.user,this.password);
            JOptionPane.showMessageDialog(null,"se establecio conexion");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en la conexion"+e.toString());
        }
        return this.con;
    }
    public Connection getConexionDB(){
        return this.conexionDataBase();
    }
}
