
package co.edu.restaurante.entities;

public class Situacion {
    int idSituacion;
    String descripcion;

    public Situacion(int idSituacion, String descripcion) {
        this.idSituacion = idSituacion;
        this.descripcion = descripcion;
    }

    public int getIdSituacion() {
        return idSituacion;
    }

    public void setIdSituacion(int idSituacion) {
        this.idSituacion = idSituacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Situacion{");
        sb.append("idSituacion=").append(idSituacion);
        sb.append(", descripcion=").append(descripcion);
        sb.append('}');
        return sb.toString();
    }

    
    
}
