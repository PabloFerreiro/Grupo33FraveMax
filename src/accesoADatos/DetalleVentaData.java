
package accesoADatos;

import entidades.DetalleVenta;
import entidades.Venta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.TreeSet;

public class DetalleVentaData {
     private Connection con = null;
     public static TreeSet<DetalleVenta> listaDetalleVentas=new TreeSet<>();
     public DetalleVentaData() {
        con = Conexion.getConexion();
    }
    
    //  método guardar detalleVenta
    public int guardarDetalleVenta(DetalleVenta detalleventa) {
        String sql = "INSERT INTO detalleventa (cantidad, idVenta, precioVenta, idProducto, estado) VALUES (?, ?, ?, ?, ?)";
        int exito=0; 
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  
            ps.setInt(1, detalleventa.getCantidad());
            ps.setInt(2, detalleventa.getVenta().getIdVenta()); 
            ps.setDouble(3, detalleventa.getPrecioVenta());
            ps.setInt(4, detalleventa.getProducto().getIdProducto());
            ps.setBoolean(5, detalleventa.isEstado());       
            ps.executeUpdate();            
            ps.getGeneratedKeys();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                detalleventa.setIdDetalleVenta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Detalle de Venta guardada");
                exito = 1;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el guardado del detalle de venta");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalleventa (insert)");
        }
        return exito;
    }
    
    //  método modificar detalleventa
    public int modificarDetalleVenta(DetalleVenta detalleventa) {        
        String sql = "UPDATE detalleventa SET cantidad=?, idVenta=?, precioVenta=?, idProducto=?, estado=? WHERE idDetalleVenta=?";
        int exito=0; 
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, detalleventa.getCantidad());
            ps.setInt(2, detalleventa.getVenta().getIdVenta()); 
            ps.setDouble(3, detalleventa.getPrecioVenta());
            ps.setInt(4, detalleventa.getProducto().getIdProducto());
            ps.setBoolean(5, detalleventa.isEstado()); 


            exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Detalle de Venta modificada");
            } else {
                JOptionPane.showMessageDialog(null, "Detalle de Venta inexistente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalleventa. No se pudo modificar el detalle de la venta");
        }
        return exito;
    } 
}
