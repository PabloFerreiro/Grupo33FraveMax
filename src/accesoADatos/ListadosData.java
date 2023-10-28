package accesoADatos;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import entidades.Cliente;
import entidades.DetalleVenta;
import entidades.Producto;
import entidades.Venta;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListadosData {

    private Connection con = null;
    public static ArrayList<Venta> ventaYclientes = new ArrayList<>();

    public ListadosData() {
        con = Conexion.getConexion();
    }

    //  método buscar detalle de venta con datos de clientes
    public List<Venta> buscarDetalleVenta(String fechaAbuscar, int bajaActivo) {
        String sql = "SELECT idVenta, venta.idCliente, fechaVenta, venta.estado, venta.totalVenta, cliente.* "
                + "FROM venta, cliente WHERE fechaVenta=? AND venta.estado=? AND venta.idCliente = cliente.idCliente"
                + " ORDER BY idVenta ";
        ArrayList<Venta> ventas = new ArrayList<>();
        Venta venta = null;
        Cliente cliente = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setDate(1, (java.sql.Date) fechaab);
            ps.setString(1, fechaAbuscar);
            ps.setInt(2, bajaActivo);
            ResultSet rs = ps.executeQuery();
            int canRegistros = 0;
            while (rs.next()) {
                canRegistros++;
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("cliente.idCliente"));
                cliente.setApellido(rs.getString("cliente.apellido"));
                cliente.setNombre(rs.getString("cliente.nombre"));
                cliente.setDomicilio(rs.getString("cliente.domicilio"));
                cliente.setTelefono(rs.getString("cliente.telefono"));
                cliente.setDni(rs.getInt("cliente.dni"));
                cliente.setEstado(rs.getBoolean("cliente.estado"));

                venta = new Venta();
                venta.setIdVenta(rs.getInt("venta.Idventa"));
                venta.setCliente(cliente);
                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                venta.setEstado(rs.getBoolean("venta.estado"));
                venta.setTotalVenta(rs.getDouble("venta.totalVenta"));
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //venta.setEstado(rs.getBoolean("estado"));
                ventas.add(venta);
            }
            if (canRegistros == 0) {
                JOptionPane.showMessageDialog(null, "No existen registros de ventas para la fecha ingresada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta. No se pudo buscar la venta");
        }
        return ventas;
    }

    //  método buscar detalle de venta con datos de clientes
    public List<DetalleVenta> buscarDetalleProducto(int idVtaAbuscar, int bajaActivo) {
        String sql = "SELECT detalleVenta.*, producto.* FROM detalleVenta, producto WHERE detalleVenta.idVenta=? AND "
                + "detalleVenta.estado=? AND detalleVenta.idProducto = producto.idProducto ORDER BY detalleVenta.idDetalleVenta";
        ArrayList<DetalleVenta> detVentas = new ArrayList<>();
        Producto producto = null;
        Cliente clie = null;
        Venta venta = null;
        DetalleVenta detaVenta = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVtaAbuscar);
            ps.setInt(2, bajaActivo);
            ResultSet rs = ps.executeQuery();
            int canRegistros = 0;
            int canleidos = rs.getRow();
            //System.out.println("Lineas: "+canleidos);
            while (rs.next()) {
                canRegistros++;
                //System.out.println("leidos: "+canRegistros);
                producto = new Producto();
                producto.setIdProducto(rs.getInt("producto.idProducto"));
                producto.setNombreProducto(rs.getString("producto.nombreProducto"));
                producto.setDescripcion(rs.getString("producto.descripcion"));
                producto.setPrecioActual(rs.getDouble("producto.precioActual"));
                producto.setStock(rs.getInt("producto.stock"));
                producto.setEstado(rs.getBoolean("producto.estado"));

                clie = new Cliente();
                clie.setIdCliente(1);
                clie.setApellido("");
                clie.setNombre("");
                clie.setDomicilio("");
                clie.setDomicilio("");
                clie.setDni(0);
                clie.setEstado(true);
//                clie.setIdCliente(rs.getInt("cliente.IdCliente"));
//                clie.setApellido(rs.getString("cliente.apellido"));
//                clie.setNombre(rs.getString("cliente.nombre"));
//                clie.setDomicilio(rs.getString("cliente.domicilio"));                
//                clie.setDomicilio(rs.getString("cliente.telefono"));                
//                clie.setDni(rs.getInt("cliente.dni"));
//                clie.setEstado(rs.getBoolean("cliente.estado"));

                venta = new Venta();
                venta.setIdVenta(0);
                venta.setCliente(clie);
                venta.setFechaVenta(null);
                venta.setEstado(true);
                venta.setTotalVenta(0);
//                venta.setIdVenta(rs.getInt("venta.Idventa"));
//                venta.setCliente(clie);
//                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
//                venta.setEstado(rs.getBoolean("venta.estado"));
//                venta.setTotalVenta(rs.getDouble("venta.totalVenta"));                

                detaVenta = new DetalleVenta();
                detaVenta.setIdDetalleVenta(rs.getInt("detalleVenta.IdDetalleVenta"));
                detaVenta.setCantidad(rs.getInt("detalleVenta.cantidad"));
                detaVenta.setVenta(venta);
                detaVenta.setPrecioVenta(rs.getDouble("detalleVenta.precioVenta"));
                detaVenta.setProducto(producto);
                detaVenta.setEstado(rs.getBoolean("detalleVenta.estado"));
                detVentas.add(detaVenta);
            }
            if (canRegistros == 0) {
                JOptionPane.showMessageDialog(null, "No existen registros del Detalle de ventas para la Venta elegida");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalleVenta. No se pudo buscar la venta");
        }        
        return detVentas;
    }

    //  Método listarClientes NUEVA para buscar en una JTABLE
    public ArrayList<Cliente> listarClientesListado3() {
        String sql = "SELECT * FROM cliente"
                + " ORDER by cliente.apellido, cliente.nombre";
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, bajaActivo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEstado(rs.getBoolean("estado"));
                cliente.setDni(rs.getInt("dni"));
                clientes.add(cliente);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente. No se pudo buscar el cliente");
        } catch (Exception ex2) {
            JOptionPane.showMessageDialog(null, "Error 2:" + ex2);
        }
        return clientes;
    }

    ;
    
    //  método buscar detalle de venta con datos de clientes
    public List<Venta> buscarVentasListado3(int idCliAbuscar, int bajaActivo) {
        String sql = "SELECT venta.*, cliente.* FROM venta, cliente WHERE venta.idCliente=? AND "
                + "venta.estado=? AND venta.idCliente = cliente.idCliente "
                + "ORDER BY venta.fechaVenta";
        ArrayList<Venta> ventas = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCliAbuscar);
            ps.setInt(2, bajaActivo);
            ResultSet rs = ps.executeQuery();
            int canRegistros = 0;
            int canleidos = rs.getRow();
            //System.out.println("Lineas: "+canleidos);
            Cliente clie = null;
            Venta venta = null;
            while (rs.next()) {
                canRegistros++;
                clie = new Cliente();
                clie.setIdCliente(1);
                clie.setApellido("");
                clie.setNombre("");
                clie.setDomicilio("");
                clie.setDomicilio("");
                clie.setDni(0);
                clie.setEstado(true);
//                clie.setIdCliente(rs.getInt("cliente.IdCliente"));
//                clie.setApellido(rs.getString("cliente.apellido"));
//                clie.setNombre(rs.getString("cliente.nombre"));
//                clie.setDomicilio(rs.getString("cliente.domicilio"));                
//                clie.setDomicilio(rs.getString("cliente.telefono"));                
//                clie.setDni(rs.getInt("cliente.dni"));
//                clie.setEstado(rs.getBoolean("cliente.estado"));

                venta = new Venta();
//                venta.setIdVenta(0);
//                venta.setCliente(clie);
//                venta.setFechaVenta(null);
//                venta.setEstado(true);
//                venta.setTotalVenta(0);                
                venta.setIdVenta(rs.getInt("venta.Idventa"));
                venta.setCliente(clie);
                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                venta.setEstado(rs.getBoolean("venta.estado"));
                venta.setTotalVenta(rs.getDouble("venta.totalVenta"));
                ventas.add(venta);
            }
            if (canRegistros == 0) {
                JOptionPane.showMessageDialog(null, "No existen registros de ventas para el cliente elegido");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta. No se pudo buscar la venta");
        }
        return ventas;
    }

    //  Método listarProductos NUEVA para buscar en una JTABLE
    public ArrayList<Producto> listarProductosListado4() {
        String sql = "SELECT * FROM Producto"
                + " ORDER by nombreProducto, descripcion";
        ArrayList<Producto> producto = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, bajaActivo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto produ = new Producto();
                produ.setIdProducto(rs.getInt("idProducto"));
                produ.setNombreProducto(rs.getString("nombreProducto"));
                produ.setDescripcion(rs.getString("Descripcion"));
                producto.add(produ);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 4A: al acceder a la tabla Producto. No se pudo buscar el producto");
        } catch (Exception ex2) {
            JOptionPane.showMessageDialog(null, "Error 4A:" + ex2);
        }
        return producto;
    }

    ;
    
    //  método buscar detalle de venta con datos de producto
     public List<DetalleVenta> buscarDetalleProductoListado4(int idProAbuscar, int bajaActivo) {
        String sql = "SELECT detalleVenta.*, cliente.*, venta.*, producto.* FROM detalleVenta, cliente, venta, producto "
                + "WHERE detalleVenta.idProducto=? AND detalleVenta.estado=? "
                + "AND detalleVenta.idVenta = venta.idVenta "
                + "AND venta.idCliente = cliente.idCliente "
                + "AND detalleVenta.idProducto = producto.idProducto "
                + "ORDER BY cliente.apellido, cliente.nombre, venta.idVenta";
        ArrayList<DetalleVenta> detVentas = new ArrayList<>();
        Producto producto = null;
        Cliente clie = null;
        Venta venta = null;
        DetalleVenta detaVenta = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProAbuscar);
            ps.setInt(2, bajaActivo);
            ResultSet rs = ps.executeQuery();
            int canRegistros = 0;
            int canleidos = rs.getRow();
            //System.out.println("Lineas: "+canleidos);
            while (rs.next()) {
                canRegistros++;
                //System.out.println("leidos: "+canRegistros);
                producto = new Producto();
                producto.setIdProducto(rs.getInt("producto.idProducto"));
                producto.setNombreProducto(rs.getString("producto.nombreProducto"));
                producto.setDescripcion(rs.getString("producto.descripcion"));
                producto.setPrecioActual(rs.getDouble("producto.precioActual"));
                producto.setStock(rs.getInt("producto.stock"));
                producto.setEstado(rs.getBoolean("producto.estado"));

                clie = new Cliente();
                clie.setIdCliente(rs.getInt("cliente.IdCliente"));
                clie.setApellido(rs.getString("cliente.apellido"));
                clie.setNombre(rs.getString("cliente.nombre"));
                clie.setDomicilio(rs.getString("cliente.domicilio"));
                clie.setDomicilio(rs.getString("cliente.telefono"));
                clie.setDni(rs.getInt("cliente.dni"));
                clie.setEstado(rs.getBoolean("cliente.estado"));

                venta = new Venta();
                venta.setIdVenta(rs.getInt("venta.Idventa"));
                venta.setCliente(clie);
                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                venta.setEstado(rs.getBoolean("venta.estado"));
                venta.setTotalVenta(rs.getDouble("venta.totalVenta"));

                detaVenta = new DetalleVenta();
                detaVenta.setIdDetalleVenta(rs.getInt("detalleVenta.IdDetalleVenta"));
                detaVenta.setCantidad(rs.getInt("detalleVenta.cantidad"));
                detaVenta.setVenta(venta);
                detaVenta.setPrecioVenta(rs.getDouble("detalleVenta.precioVenta"));
                detaVenta.setProducto(producto);
                detaVenta.setEstado(rs.getBoolean("detalleVenta.estado"));
                detVentas.add(detaVenta);
            }
            if (canRegistros == 0) {
                JOptionPane.showMessageDialog(null, "No existen registros del Detalle de ventas para el producto elegido");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalleVenta. No se pudo buscar la venta");
        }
        return detVentas;
    }
}
