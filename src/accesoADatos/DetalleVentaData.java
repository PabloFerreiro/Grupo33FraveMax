
package accesoADatos;

import entidades.Cliente;
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
            ps.setInt(6, detalleventa.getIdDetalleVenta());


            exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Detalle de Venta modificada");
            } else {
                JOptionPane.showMessageDialog(null, "Detalle de Venta inexistente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalleventa. No se pudo modificar el detalle de la venta" + ex);
        }
        return exito;
    } 
       
//  método eliminar detalleventa
    public int eliminarDetalleVenta(int id) {
        String sql = "UPDATE detalleventa SET estado = 0 WHERE idDetalleVenta=?";        
        System.out.println("id=" + id);
        int exito=0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Detalle de Venta eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "Detalle de Venta inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalleventa. No se pudo eliminar el detalle de venta" + ex.getMessage());
        }
        return exito;
    }  
    
//  método recuperar un detalle de venta eliminado logicamente
    public int recuperarDetalleVenta(int id) {
        String sql = "UPDATE detalleventa SET estado = 1 WHERE idDetalleVenta=?";        
        int exito=0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Detalle de Venta Recuperada");
            } else {
                JOptionPane.showMessageDialog(null, "Detalle de Venta inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalleventa. No se pudo Recuperar el detalle de venta" + ex.getMessage());
        }
        return exito;
    }  
    
//  método buscar detalle de venta
    public Venta buscarDetalleVenta(int id, int bajaActivo) {
        String sql = "SELECT venta.idCliente, fechaVenta, venta.estado, cliente.* FROM venta, cliente WHERE venta.idVenta=? AND venta.estado=?";
        Venta venta = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, bajaActivo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("cliente.idCliente"));
                cliente.setApellido(rs.getString("cliente.apellido"));
                cliente.setNombre(rs.getString("cliente.nombre"));
                cliente.setDomicilio(rs.getString("cliente.domicilio"));
                cliente.setTelefono(rs.getString("cliente.telefono"));
                cliente.setDni(rs.getInt("cliente.dni"));
                cliente.setEstado(rs.getBoolean("cliente.estado"));
              
                venta = new Venta();
                venta.setIdVenta(id);
                venta.setCliente(cliente);
                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                venta.setEstado(rs.getBoolean("venta.estado"));
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //venta.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe esa venta");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta. No se pudo buscar la venta");
        }
        return venta;
    }
    
    
    
    
    
    
}
