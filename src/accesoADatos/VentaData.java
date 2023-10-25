// RAMA V2
// Actualizado dia: 25/10/23 hs: 15:38
package accesoADatos;

import entidades.Cliente;
import entidades.DetalleVenta;
import entidades.Producto;
import entidades.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class VentaData {

    private Connection con = null;
    public static TreeSet<Venta> listaVentas = new TreeSet<>();

    public VentaData() {

        con = Conexion.getConexion();

    }

//  método guardar venta
    public int guardarVenta(Venta venta) {
        String sql = "INSERT INTO venta (idCliente, fechaVenta, estado, totalVenta) VALUES (?, ?, ?, ?)";
        int exito = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getCliente().getIdCliente());
            ps.setDate(2, Date.valueOf(venta.getFechaVenta()));
            ps.setBoolean(3, venta.isEstado());
            ps.setDouble(4, venta.getTotalVenta());
            ps.executeUpdate();
            ps.getGeneratedKeys();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                venta.setIdVenta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Venta guardada");
                exito = 1;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el guardado de la venta");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta (insert)");
        }
        return exito;
    }

//  método modificar venta
    public int modificarVenta(Venta venta) {
        String sql = "UPDATE venta SET idCliente=?, fechaVenta=?, estado=? WHERE idVenta=?";
        int exito = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, venta.getCliente().getIdCliente());
            ps.setDate(2, Date.valueOf(venta.getFechaVenta()));
            ps.setBoolean(3, venta.isEstado());
            ps.setInt(4, venta.getIdVenta());

            //System.out.println("idAlumno en modificar="+alumno.getIdAlumno());
            exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Venta modificada");
            } else {
                JOptionPane.showMessageDialog(null, "Venta inexistente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta. No se pudo modificar la venta");
        }
        return exito;
    }

//  método eliminar venta
    public int eliminarVenta(int id) {
        String sql = "UPDATE venta SET estado = 0 WHERE idVenta=?";
        System.out.println("id=" + id);
        int exito = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Venta eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "Venta inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta. No se pudo eliminar la venta" + ex.getMessage());
        }
        return exito;
    }

//  método recuperar una venta eliminada logicamente
    public int recuperarVenta(int id) {
        String sql = "UPDATE venta SET estado = 1 WHERE idVenta=?";
        int exito = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Venta Recuperada");
            } else {
                JOptionPane.showMessageDialog(null, "Venta inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta. No se pudo Recuperar la venta" + ex.getMessage());
        }
        return exito;
    }

//  método buscar venta
    public Venta buscarVenta(int id, int bajaActivo) {
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

//  Método listarVentas para buscar en un COMBOBOX
    public List<Venta> listarVentas(int bajaActivo) {
        String sql = "SELECT idVenta, venta.idCliente, fechaVenta, venta.estado, cliente.* "
                + "FROM venta, cliente WHERE venta.estado=? AND venta.idCliente = cliente.idCliente"
                + " ORDER BY idVenta ";
        ArrayList<Venta> ventas = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bajaActivo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("cliente.idCliente"));
                cliente.setApellido(rs.getString("cliente.apellido"));
                cliente.setNombre(rs.getString("cliente.nombre"));
                cliente.setDomicilio(rs.getString("cliente.domicilio"));
                cliente.setTelefono(rs.getString("cliente.telefono"));
                cliente.setDni(rs.getInt("cliente.dni"));
                cliente.setEstado(rs.getBoolean("cliente.estado"));
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setCliente(cliente);
                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                venta.setEstado(rs.getBoolean("venta.estado"));
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //venta.setEstado(rs.getBoolean("venta.estado"));
                ventas.add(venta);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta. No se pudo buscar la venta");
        }
        return ventas;
    }

//  Método listarVentas para buscar en una JTABLE
    public TreeSet<Venta> listarVentasJTable(int bajaActivo) {
        String sql = "SELECT idVenta, venta.idCliente, fechaVenta, venta.estado, cliente.* "
                + "FROM venta, cliente WHERE venta.estado=? AND venta.idCliente = cliente.idCliente"
                + " ORDER BY idVenta ";
        TreeSet<Venta> ventas = new TreeSet<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bajaActivo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("cliente.idCliente"));
                cliente.setApellido(rs.getString("cliente.apellido"));
                cliente.setNombre(rs.getString("cliente.nombre"));
                cliente.setDomicilio(rs.getString("cliente.domicilio"));
                cliente.setTelefono(rs.getString("cliente.telefono"));
                cliente.setDni(rs.getInt("cliente.dni"));
                cliente.setEstado(rs.getBoolean("cliente.estado"));
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setCliente(cliente);
                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                venta.setEstado(rs.getBoolean("venta.estado"));
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //venta.setEstado(rs.getBoolean("venta.estado"));
                ventas.add(venta);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta. No se pudo buscar la venta");
        } catch (Exception ex2) {
            JOptionPane.showMessageDialog(null, "Error 2:" + ex2);
        }
        return ventas;
    }

    ;
 
      
      
//  Método listarVentasConProducto para buscar en un COMBOBOX
    public List<DetalleVenta> listarVentasConProducto(int buscarIdVenta, int bajaActivo) {
        String sql = "SELECT venta.idVenta, venta.idCliente, fechaVenta, venta.estado, cliente.*,detalleventa.*, producto.* "
                + "FROM venta, cliente, detalleventa, producto WHERE venta.idVenta=? AND venta.estado=? "
                + "AND venta.idCliente = cliente.idCliente AND detalleventa.idVenta = venta.idVenta AND detalleventa.idProducto = producto.idProducto"
                + " ORDER BY venta.idVenta ";
        ArrayList<DetalleVenta> detalleventas = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, buscarIdVenta);
            ps.setInt(2, bajaActivo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                Venta venta = new Venta();
                DetalleVenta detalleventa = new DetalleVenta();
                Producto producto = new Producto();

                cliente.setIdCliente(rs.getInt("cliente.idCliente"));
                cliente.setApellido(rs.getString("cliente.apellido"));
                cliente.setNombre(rs.getString("cliente.nombre"));
                cliente.setDomicilio(rs.getString("cliente.domicilio"));
                cliente.setTelefono(rs.getString("cliente.telefono"));
                cliente.setDni(rs.getInt("cliente.dni"));
                cliente.setEstado(rs.getBoolean("cliente.estado"));

                venta.setIdVenta(rs.getInt("venta.idVenta"));
                venta.setCliente(cliente);
                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                venta.setEstado(rs.getBoolean("venta.estado"));

                producto.setIdProducto(rs.getInt("producto.idProducto"));
                producto.setNombreProducto(rs.getString("producto.nombreProducto"));
                producto.setDescripcion(rs.getString("producto.descripcion"));
                producto.setPrecioActual(rs.getDouble("producto.precioActual"));
                producto.setStock(rs.getInt("producto.stock"));
                producto.setEstado(rs.getBoolean("producto.estado"));

                detalleventa.setIdDetalleVenta(rs.getInt("detalleventa.idDetalleVenta"));
                detalleventa.setCantidad(rs.getInt("detalleventa.cantidad"));
                detalleventa.setPrecioVenta(rs.getDouble("detalleventa.precioVenta"));
                detalleventa.setEstado(rs.getBoolean("detalleventa.estado"));
                detalleventa.setVenta(venta);
                detalleventa.setProducto(producto);

                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //venta.setEstado(rs.getBoolean("venta.estado"));
                detalleventas.add(detalleventa);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta. No se pudo buscar la venta");
        }
        return detalleventas;
    }

}
