package co.edu.restaurante.model;

import co.edu.restaurante.util.ConexionDB;
import co.edu.restaurante.entities.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ClienteDao {
    private ConexionDB conDB;
    PreparedStatement statement;
    
    public ClienteDao(){
        conDB = new ConexionDB();
        statement = null;
    }
    
    public Clientes addCliente(Clientes cliente){
        Connection con = this.conDB.getConexionDB();
        String query ="INSERT INTO clientes VALUES(null,?,?,?,?)";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setString(1,cliente.getNombres());
                this.statement.setString(2,cliente.getApellidos());
                this.statement.setString(3,cliente.getTelefono());
                this.statement.setString(4,cliente.getDireccion());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "se ha agregado un cliente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.toString());
        }finally{
            if(con!=null){
                try {
                    this.statement.close();
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,""+e.toString());
                }
            }
        }
        return cliente;
    }
    public void consultCliente(JComboBox boxNombreCli){
        
        
        String query = "SELECT cli_nombres FROM clientes";
        
        
        try {
            Connection con = conDB.getConexionDB();
            statement = con.prepareStatement(query);
            
            ResultSet result = statement.executeQuery();
            
            boxNombreCli.addItem("Seleccione una opcion");
            
            while(result.next()){
                boxNombreCli.addItem(result.getString("cli_nombres"));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public Clientes editCliente(Clientes cliente){
        Connection con = this.conDB.getConexionDB();
        String query ="UPDATE `clientes` SET `cli_nombres` = ?, `cli_apellidos` = ?, `cli_telefono` = ?, `cli_direccion` = ? WHERE `clientes`.`cli_nombres` = ?";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setString(1,cliente.getNombres());
                this.statement.setString(2,cliente.getApellidos());
                this.statement.setString(3,cliente.getTelefono());
                this.statement.setString(4,cliente.getDireccion());
                this.statement.setString(5,cliente.getNombres());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha editado el cliente");
            }
        } catch (Exception e) {
            System.out.println(""+e.toString());
        }finally{
            if(con!=null){
                try {
                    this.statement.close();
                    con.close();
                } catch (Exception e) {
                    System.out.println(""+e.toString());
                }
            }
        }
        return cliente;
    }
    public Clientes deletCliente(Clientes cliente){
        Connection con = this.conDB.getConexionDB();
        String query = "DELETE FROM `clientes` WHERE  `cli_nombres` = ? ";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setString(1,cliente.getNombres());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha eliminado el cliente");
            }
        } catch (Exception e) {
            System.out.println(""+e.toString());
        }
        return cliente;
    }
    
}
