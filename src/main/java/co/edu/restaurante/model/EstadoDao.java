
package co.edu.restaurante.model;

import co.edu.restaurante.entities.Estados;
import java.sql.Connection;
import co.edu.restaurante.util.ConexionDB;
import java.sql.PreparedStatement;

public class EstadoDao {
    private ConexionDB conDB;
    PreparedStatement statement;
    
    public EstadoDao(){
        conDB = new ConexionDB();
        statement = null;
    }
}
