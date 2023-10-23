package accesoADatos;


import entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vistas.JIFProducto;

public class ProductoData {

    private Connection con = null;
    public static ArrayList<Producto> listaProductos=new ArrayList<>();
    
    public ProductoData() {

        con = Conexion.getConexion();

    }

//  método guardar producto
    public int guardarProducto(Producto producto) {
    String sql = "INSERT INTO `producto`(`nombreProducto`, `descripcion`, `precioActual`, `stock`, estado) "
            + "VALUES (?,?,?,?,?)";
    int exito = 0;
    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, producto.getNombreProducto());
        ps.setString(2, producto.getDescripcion());
        ps.setDouble(3, producto.getPrecioActual());
        ps.setInt(4, producto.getStock());
        ps.setBoolean(5, producto.isEstado());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            producto.setIdProducto(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "Producto guardado");
            exito = 1;
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el guardado del producto");
        }
        ps.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto (insert)");
    }
    return exito;
}


//  método modificar producto
    public int modificarProducto(Producto producto) {
    String sql = "UPDATE producto SET descripcion=?, precioActual=?, stock=? WHERE idProducto=?";
    int exito = 0;
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, producto.getDescripcion());
        ps.setDouble(2, producto.getPrecioActual());
        ps.setInt(3, producto.getStock());
        ps.setInt(4, producto.getIdProducto());
        exito = ps.executeUpdate();
        
        if (exito >= 1) {
            
            
            JOptionPane.showMessageDialog(null, "Producto modificado");
          
        } else {
            JOptionPane.showMessageDialog(null, "Producto inexistente");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto. No se pudo modificar el producto");
    }
    
    return exito;
}

    //  método modificar producto
    public int modificarProducto2(int id, String nuevaDescripcion, double nuevoPrecio, int nuevoStock) {
    String sql = "UPDATE producto SET descripcion=?, precioActual=?, stock=? WHERE idProducto=?";
    int exito = 0;
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nuevaDescripcion);
        ps.setDouble(2, nuevoPrecio);
        ps.setInt(3, nuevoStock);
        ps.setInt(4, id);
        
        exito = ps.executeUpdate();
        
        if (exito >= 1) {
            // se deja de mostrar este manseje para que no sea muy lento la registracion de los productos vendidos
            //JOptionPane.showMessageDialog(null, "Producto modificado");            
        } else {
            JOptionPane.showMessageDialog(null, "Producto inexistente");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto. No se pudo modificar el producto");
    }
    
    return exito;
}
    
    
    
    
    

//  método eliminar producto
    public int eliminarProducto(int id) {
        String sql = "UPDATE producto SET estado = 0 WHERE idProducto=?";        
        //System.out.println("id=" + id);
        int exito=0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate();
            //System.out.println("variable exito=" + exito);
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Producto inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto. No se pudo eliminar el producto" + ex.getMessage());
        }
        return exito;
    }
    
//  método Recuperar un producto eliminado logicamente
    public int recuperarProducto(int id) {
        String sql = "UPDATE producto SET estado = 1 WHERE idProducto=?";        
        int exito=0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto Recuperado");
            } else {
                JOptionPane.showMessageDialog(null, "Producto inexistente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto. No se pudo Recuperar el producto" + ex.getMessage());
        }
        return exito;
    }
    
//  método buscar producto
    public Producto buscarProducto(int id, int bajaActivo) {
        String sql = "SELECT nombreProducto, descripcion, precioActual, stock, estado FROM producto WHERE idProducto=? AND estado=?";
        Producto producto = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, bajaActivo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(id);           
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //alumno.setActivo(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese producto");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto. No se pudo buscar el producto");
        }
        return producto;
    }
       
//  Método listarProductos para buscar en un COMBOBOX
//    public List<Producto> listarProductos(int bajaActivo) {
//        String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock, estado FROM producto WHERE estado=?"
//                + " ORDER BY nombreProducto ";
//        ArrayList<Producto> productos = new ArrayList<>();
//        try {
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setInt(1, bajaActivo);
//            ResultSet rs=ps.executeQuery();
//            while (rs.next()) {
//                Producto producto=new Producto();
//                producto.setIdProducto(rs.getInt("idProducto"));              
//                producto.setNombreProducto(rs.getString("nombreProducto"));
//                producto.setDescripcion(rs.getString("descripcion"));
//                producto.setPrecioActual(rs.getDouble("precioActual"));
//                producto.setStock(rs.getInt("stock"));
//                producto.setEstado(rs.getBoolean("estado"));
//                
//                // no se hace esta asignacion porque se entiende por defecto de que lo que 
//                // esta trayendo del sql son registros activos-true-
//                //producto.setEstado(rs.getBoolean("estado"));
//                productos.add(producto);                
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto. No se pudo buscar el producto");
//        }        
//        return productos;
//    }
    
//  Método listarProductosJTable para buscar en una JTABLE
//    public TreeSet<Producto> listarProductosJTable(int bajaActivo){
    public ArrayList<Producto> listarProductosJTable(int bajaActivo){
        String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock, estado FROM producto WHERE estado=? "
                + " ORDER BY nombreProducto, descripcion ";
        //TreeSet<Producto> productos=new TreeSet<>();
        ArrayList<Producto> productos=new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, bajaActivo);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Producto producto=new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));              
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));              
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                productos.add(producto);                
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto. No se pudo buscar el producto");
        } catch (Exception ex2) {
            JOptionPane.showMessageDialog(null, "Error 2:"+ex2);
            System.out.println(ex2+"jtable");
        }
        return productos;        
      };
    
    public ArrayList<Producto> listarProductosJTableParaGestionProducto(){                  
        String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock, estado "
                + "FROM producto "
                + "ORDER BY nombreProducto, descripcion";
        ArrayList<Producto> productos=new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setInt(1, bajaActivo);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Producto producto=new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));    
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));             
                producto.setEstado(rs.getBoolean("estado"));      
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //alumno.setActivo(rs.getBoolean("estado"));
                productos.add(producto);                
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto. No se pudo buscar el producto");
        }        
        catch (Exception ex2) {
            JOptionPane.showMessageDialog(null, "Error 2:"+ex2);
        }
        return productos;        
      };
    
}
