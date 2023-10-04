
package accesoADatos;
import entidades.Cliente;
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
    public static TreeSet<Venta> listaVentas=new TreeSet<>();
    public VentaData() {

        con = Conexion.getConexion();

    }

//  método guardar venta
    public int guardarVenta(Venta venta) {
        String sql = "INSERT INTO venta (idCliente, fechaVenta, estado) VALUES (?, ?, ?)";
        int exito=0; 
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  
            ps.setInt(1, venta.getCliente().getIdCliente());
            ps.setDate(2, Date.valueOf(venta.getFechaVenta()));    
            ps.setBoolean(3, venta.isEstado());       
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
        int exito=0; 
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
        int exito=0;
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
        int exito=0;
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
                venta.setEstado(rs.getBoolean("estado"));
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
    
    
    
   //Método listarVentas para buscar en un COMBOBOX
    public List<Venta> listarVentas(int bajaActivo) {
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE estado = ?"
                + " ORDER BY apellido, nombre ";
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, bajaActivo);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Alumno alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());                
                alumno.setActivo(rs.getBoolean("estado"));                
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //alumno.setActivo(rs.getBoolean("estado"));
                alumnos.add(alumno);                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo buscar el alumno");
        }        
        return alumnos;
    }
    
    //Método listarVentas para buscar en una JTABLE
      public TreeSet<Venta> listarVentasJTable(int bajaActivo){                  
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE estado = ?"
                + " ORDER BY apellido, nombre ";
        TreeSet<Alumno> alumnos=new TreeSet<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, bajaActivo);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Alumno alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());                
                alumno.setActivo(rs.getBoolean("estado"));                
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //alumno.setActivo(rs.getBoolean("estado"));
                alumnos.add(alumno);                
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo buscar el alumno");
        }        
        catch (Exception ex2) {
            JOptionPane.showMessageDialog(null, "Error 2:"+ex2);
        }
        return alumnos;        
      };
    
}
