
package co.edu.restaurante.entities;

public class Mesas {
    int id;
    int capacidad;
    int idEstado;

    public Mesas(int id, int capacidad, int idEstado) {
        this.id = id;
        this.capacidad = capacidad;
        this.idEstado = idEstado;
    }

    public Mesas( int capacidad, int idEstado) {
        this.capacidad = capacidad;
        this.idEstado = idEstado;
    }

    public Mesas(int id) {
        this.id = id;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mesas{");
        sb.append("id=").append(id);
        sb.append(", capacidad=").append(capacidad);
        sb.append(", idEstado=").append(idEstado);
        sb.append('}');
        return sb.toString();
    }
    
}
