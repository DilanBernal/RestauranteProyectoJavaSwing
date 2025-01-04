package co.edu.restaurante.model;
import co.edu.restaurante.util.ConexionDB;
import co.edu.restaurante.entities.Cargos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CargoDao {
    private ConexionDB conDB;
    PreparedStatement statement;
    
    public CargoDao(){
        conDB = new ConexionDB();
        statement = null;
    }
    //Para agregar un cargo
    public Cargos addCargo(Cargos cargo){
        Connection con = this.conDB.getConexionDB();
        String query ="INSERT INTO cargos (`id_cargo`, `car_nombre`, car_descripcion, `car_salario`) VALUES (null, ?, ?, ?);";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setString(1,cargo.getNombre());
                this.statement.setString(2, cargo.getDescripcion());
                this.statement.setFloat(3, (float) cargo.getSalario());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha agregado un cargo");
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
        return cargo;
    }
    //Para consultarlo para el JComboBox
    
    public void consultCargo(JComboBox boxCargo){
        
        String query = "SELECT id_cargo, car_nombre FROM cargos";
        
        
        try {
            Connection con = conDB.getConexionDB();
            statement = con.prepareStatement(query);
            
            ResultSet result = statement.executeQuery();
            
            boxCargo.addItem("Seleccione una opcion");
            
            while(result.next()){
                boxCargo.addItem(result.getString("car_nombre"));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public Cargos editCargo(Cargos cargo){
        Connection con = this.conDB.getConexionDB();
        String query ="UPDATE `cargos` SET `car_nombre` = ?, `car_descripcion` = ?, `car_salario` = ? WHERE `cargos`.`id_cargo` = ?";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setString(1,cargo.getNombre());
                this.statement.setString(2, cargo.getDescripcion());
                this.statement.setFloat(3, (float) cargo.getSalario());
                this.statement.setInt(4,cargo.getCargoId());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha editado un cargo");
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
        return cargo;
    }
    
    
}
