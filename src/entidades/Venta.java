
package entidades;
import java.time.LocalDate;

public class Venta implements Comparable<Venta>{
    
   private int idVenta;
   private Cliente cliente;
   private LocalDate fechaVenta;
   private boolean estado;
   private double totalVenta;

    public Venta() {
    }

    public Venta(int idVenta, Cliente cliente, LocalDate fechaVenta, boolean estado) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }

    public Venta(Cliente cliente, LocalDate fechaVenta, boolean estado, double totalVenta) {
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
        this.totalVenta = totalVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
    

    

    @Override
    public String toString() {
        return "Venta: " + "idVenta= " + idVenta + ", cliente= " + cliente.toString() + ", fechaVenta= " + fechaVenta + ", estado= " + estado + ", total Venta= " + totalVenta;
    }

    @Override
    public int compareTo(Venta otroidVenta) {
        String idv1= Integer. toString(idVenta);
        String idv2= Integer. toString(otroidVenta.getIdVenta());
        return idv1.compareTo(idv2); 
    }


   
   
   
   
}
