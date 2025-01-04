
package co.edu.restaurante.entities;

public class Cargos {
    private int cargoId;
    private String nombre;
    private String descripcion;
    private float salario;

    public Cargos(String nombre, String descripcion, float salario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.salario = salario;
    }

    public Cargos(int cargoId, String nombre, String descripcion, float salario) {
        this.cargoId = cargoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.salario = salario;
    }
    


    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cargos{");
        sb.append("cargoId=").append(cargoId);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", salario=").append(salario);
        sb.append('}');
        return sb.toString();
    }

    
    
    
}
