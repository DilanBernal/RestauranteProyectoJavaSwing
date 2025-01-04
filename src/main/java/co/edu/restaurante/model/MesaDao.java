
package co.edu.restaurante.model;

import co.edu.restaurante.entities.Mesas;
import co.edu.restaurante.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class MesaDao {
    private ConexionDB conDB;
    PreparedStatement statement;
    
    public MesaDao(){
        conDB = new ConexionDB();
        statement = null;
    }
    public Mesas addMesa(Mesas mesa){
        Connection con = this.conDB.getConexionDB();
        String query ="INSERT INTO `mesas` (`id_mesa`, `mes_capacidad`, `id_estado`) VALUES (null, ?, ?);";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setInt(1,mesa.getCapacidad());
                this.statement.setInt(2,mesa.getIdEstado());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha agregado una mesa");
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
        return mesa;
    }
    public void consultEstado(JComboBox boxEstado){
        
        
        String query = "SELECT id_estado FROM estado";
        
        
        try {
            Connection con = conDB.getConexionDB();
            statement = con.prepareStatement(query);
            
            ResultSet result = statement.executeQuery();
            
            boxEstado.addItem("Seleccione una opcion");
            
            while(result.next()){
                boxEstado.addItem(result.getString("id_estado"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void consultMesa(JComboBox boxMesas){
        
        
        String query = "SELECT id_mesa FROM mesas ORDER BY id_mesa ASC";
        
        
        try {
            Connection con = conDB.getConexionDB();
            statement = con.prepareStatement(query);
            
            ResultSet result = statement.executeQuery();
            
            boxMesas.addItem("Seleccione una opcion");
            
            while(result.next()){
                boxMesas.addItem(result.getString("id_mesa"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public Mesas editMesa(Mesas mesa){
        Connection con = this.conDB.getConexionDB();
        String query ="UPDATE `mesas` SET `mes_capacidad` = ?, `id_estado` = ? WHERE `mesas`.`id_mesa` = ?";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setInt(1,mesa.getCapacidad());
                this.statement.setInt(2,mesa.getIdEstado());
                this.statement.setInt(3,mesa.getId());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha editado la mesa");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
        return mesa;
    }
    public Mesas deletMesa(Mesas mesa){
        Connection con = this.conDB.getConexionDB();
        String query = "DELETE FROM `mesas` WHERE  `id_mesa` = ? ";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setInt(1,mesa.getId());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha eliminado una mesa");
            }
        } catch (Exception e) {
            System.out.println(""+e.toString());
        }
        return mesa;
    }
}
