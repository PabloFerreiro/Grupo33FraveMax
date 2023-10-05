
package entidades;

public class DetalleVenta {
    
    private int idDetalleVenta;
    private int cantidad;
    private Venta venta;
    private double precioVenta;
    private Producto producto;
    private boolean estado;

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVenta, int cantidad, Venta venta, double precioVenta, Producto producto, boolean estado) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.venta = venta;
        this.precioVenta = precioVenta;
        this.producto = producto;
        this.estado = estado;
    }

    public DetalleVenta(int cantidad, Venta venta, double precioVenta, Producto producto, boolean estado) {
        this.cantidad = cantidad;
        this.venta = venta;
        this.precioVenta = precioVenta;
        this.producto = producto;
        this.estado = estado;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", cantidad=" + cantidad + ", venta=" + venta + ", precioVenta=" + precioVenta + ", producto=" + producto + ", estado=" + estado + '}';
    }

    
    
    
    
}
