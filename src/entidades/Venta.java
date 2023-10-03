
package entidades;
import java.time.LocalDate;

public class Venta {
    
   private int idVenta;
   private Cliente cliente;
   private LocalDate fechaVenta;

    public Venta() {
    }

    public Venta(int idVenta, Cliente cliente, LocalDate fechaVenta) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
    }

    public Venta(Cliente cliente, LocalDate fechaVenta) {
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", cliente=" + cliente + ", fechaVenta=" + fechaVenta + '}';
    }
   
   
   
   
}
