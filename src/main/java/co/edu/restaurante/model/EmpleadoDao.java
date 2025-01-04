
package co.edu.restaurante.model;

import co.edu.restaurante.entities.Empleados;
import co.edu.restaurante.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import co.edu.restaurante.model.CargoDao;
import java.sql.ResultSet;


public class EmpleadoDao {
    
    private ConexionDB conDB;
    PreparedStatement statement;
    private CargoDao cargo ;
    
    public EmpleadoDao(){
        conDB = new ConexionDB();
        statement = null;
        cargo = new CargoDao();
    }
    public Empleados addEmpleado(Empleados empleado){
        Connection con = this.conDB.getConexionDB();
        String query ="INSERT INTO `empleados` (`id_empleado`, `emp_nombres`, `emp_apellidos`, `emp_telefono`, `id_cargo`) VALUES (NULL, ?, ?, ?, ?);";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setString(1,empleado.getNombres());
                this.statement.setString(2, empleado.getApellidos());
                this.statement.setString(3,  empleado.getTelefono());
                this.statement.setInt(4,empleado.getCargoId());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha agregado un empleado");
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
        return empleado;
    }
    public void consultEmpleado(JComboBox boxEmpleado){
        
        
        String query = "SELECT emp_nombres FROM empleados ";
        
        
        try {
            Connection con = conDB.getConexionDB();
            statement = con.prepareStatement(query);
            
            ResultSet result = statement.executeQuery();
            
            boxEmpleado.addItem("Seleccione una opcion");
            
            while(result.next()){
                boxEmpleado.addItem(result.getString("emp_nombres"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public Empleados editEmpleado(Empleados empleado){
        Connection con = this.conDB.getConexionDB();
        String query ="UPDATE `empleados` SET  `emp_apellidos` = ?, `emp_telefono` = ?, `id_cargo` = ? WHERE `empleados`.`emp_nombres` = ?";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setString(1,empleado.getApellidos());
                this.statement.setString(2,empleado.getTelefono());
                this.statement.setInt(3, empleado.getCargoId());
                this.statement.setString(4,empleado.getNombres());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha editado el empleado");
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
        return empleado;
    }
    public Empleados deletEmpleados(Empleados empleado){
        Connection con = this.conDB.getConexionDB();
        String query = "DELETE FROM `empleados` WHERE  `emp_nombres` = ? ";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query);
                this.statement.setString(1,empleado.getNombres());
                int response = this.statement.executeUpdate();
                if(response>0) JOptionPane.showMessageDialog(null, "Se ha eliminado un empleado");
            }
        } catch (Exception e) {
            System.out.println(""+e.toString());
        }
        return empleado;
    }
    
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
    
    
}
