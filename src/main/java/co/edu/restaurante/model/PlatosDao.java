package co.edu.restaurante.model;

import co.edu.restaurante.util.ConexionDB;
import co.edu.restaurante.entities.Platos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class PlatosDao {
    private ConexionDB conDB;
    PreparedStatement statement;
    
    public PlatosDao(){
        conDB = new ConexionDB();
        statement = null;
    }
    public Platos addPlato(Platos plato){
        Connection con = this.conDB.getConexionDB();
        String query ="INSERT INTO `platos` (`id_plato`, `pla_nombre`, `pla_descripcion`, `pla_precio`) VALUES (null, ?, ?, ?);";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setString(1,plato.getNombre());
                this.statement.setString(2,plato.getDescripcion());
                this.statement.setInt(3,plato.getPrecio());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha agregado un plato");
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
        return plato;
    }
    
    public void consultPlato(JComboBox boxPlato){
        
        
        String query = "SELECT id_plato, pla_nombre FROM mesas ORDER BY id_plato ASC";
        
        
        try {
            Connection con = conDB.getConexionDB();
            statement = con.prepareStatement(query);
            
            ResultSet result = statement.executeQuery();
            
            boxPlato.addItem("Seleccione una opcion");
            
            while(result.next()){
                boxPlato.addItem(result.getString("pla_nombres"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public Platos editPlato(Platos plato){
        Connection con = this.conDB.getConexionDB();
        String query ="UPDATE `platos` SET `pla_nombre` = ?, `pla_descripcion` = ?, pla_precio = ? WHERE platos.`pla_nombre` = ?";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setString(1,plato.getNombre());
                this.statement.setString(2,plato.getDescripcion());
                this.statement.setInt(3,plato.getPrecio());
                this.statement.setString(4,plato.getNombre());
                
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha editado el plato");
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
        return plato;
    }
    public Platos deletPlato(Platos plato){
        Connection con = this.conDB.getConexionDB();
        String query = "DELETE FROM `platos` WHERE  `pla_nombre` = ? ";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setString(1,plato.getNombre());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha eliminado una mesa");
            }
        } catch (Exception e) {
            System.out.println(""+e.toString());
        }
        return plato;
    }
    
}
