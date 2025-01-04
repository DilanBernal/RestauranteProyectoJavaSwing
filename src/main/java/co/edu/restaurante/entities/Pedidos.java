
package co.edu.restaurante.entities;


public class Pedidos {
    int idPedido;
    int idPlatos;
    int idCliente;
    int idMesa;
    int idSituacion;

    public Pedidos(int idPlatos, int idCliente, int idMesa, int idSituacion) {
        this.idPlatos = idPlatos;
        this.idCliente = idCliente;
        this.idMesa = idMesa;
        this.idSituacion = idSituacion;
    }

    public Pedidos(int idPlatos, int idCliente, int idMesa) {
        this.idPlatos = idPlatos;
        this.idCliente = idCliente;
        this.idMesa = idMesa;
    }
    

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPlatos() {
        return idPlatos;
    }

    public void setIdPlatos(int idPlatos) {
        this.idPlatos = idPlatos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }


    public int getIdSituacion() {
        return idSituacion;
    }

    public void setIdSituacion(int idSituacion) {
        this.idSituacion = idSituacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedidos{");
        sb.append("idPedido=").append(idPedido);
        sb.append(", idPlatos=").append(idPlatos);
        sb.append(", idCliente=").append(idCliente);
        sb.append(", idMesa=").append(idMesa);
        sb.append(", idSituacion=").append(idSituacion);
        sb.append('}');
        return sb.toString();
    }

    
}
