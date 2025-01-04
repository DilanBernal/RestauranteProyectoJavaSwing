
package co.edu.restaurante.entities;

public class Empleados {
    private int empleadoId;
    private String nombres;
    private String apellidos;
    private String telefono;
    private int cargoId;

    public Empleados(String nombres, String apellidos, String telefono, int cargoId) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.cargoId = cargoId;
    }

    public Empleados(String nombres) {
        this.nombres = nombres;
    }
    

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleados{");
        sb.append(", nombres=").append(nombres);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", telefono=").append(telefono);
        sb.append(", cargoId=").append(cargoId);
        sb.append('}');
        return sb.toString();
    }
    
    
}
