
package accesoADatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import entidades.Cliente;

public class ClienteData {

    private Connection con = null;
    public static TreeSet<Cliente> listaClientes=new TreeSet<>();

    public ClienteData() {

        con = Conexion.getConexion();

    }

    //método guardar cliente
//    public int guardarCliente(Cliente cliente) {
//        String sql = "INSERT INTO cliente (apellido, nombre, domicilio, telefono, estado, dni) VALUES (?, ?, ?, ?, ?, ?)";
//        int exito=0; 
//        try {
//            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            
//            ps.setString(1, cliente.getApellido());
//            ps.setString(2, cliente.getNombre());
//            ps.setString(3, cliente.getDomicilio());
//            ps.setString(4, cliente.getTelefono());
//            ps.setBoolean(5, cliente.isEstado());
//            ps.setInt(6, cliente.getDni());
//            ps.executeUpdate();            
//            ps.getGeneratedKeys();
//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                cliente.setIdCliente(rs.getInt(1));
//                JOptionPane.showMessageDialog(null, "Cliente guardado");
//                exito = 1;
//            } else {
//                JOptionPane.showMessageDialog(null, "No se pudo realizar el guardado del cliente");
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente (insert)");
//        }
//        return exito;
//    }

//    método modificar cliente
//    public int modificarCliente(Cliente cliente) {        
//        String sql = "UPDATE cliente SET apellido=?, nombre=?, domicilio=?, telefono=?, estado=?, dni=? WHERE idCliente=?";
//        int exito=0; 
//        try {
//            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            
//            ps.setString(1, cliente.getApellido());
//            ps.setString(2, cliente.getNombre());
//            ps.setString(3, cliente.getDomicilio());
//            ps.setString(4, cliente.getTelefono());
//            ps.setBoolean(5, cliente.isEstado());           
//            ps.setInt(6, cliente.getDni());
//            ps.setInt(7, cliente.getIdCliente());
//           
//            //System.out.println("idAlumno en modificar="+alumno.getIdAlumno());
//            exito = ps.executeUpdate();
//            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Cliente modificado");
//            } else {
//                JOptionPane.showMessageDialog(null, "Cliente inexistente");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente. No se pudo modificar el cliente");
//        }
//        return exito;
//    }

//    //método eliminar cliente
//    public int eliminarCliente(int id) {
//        String sql = "UPDATE cliente SET estado = 0 WHERE idCliente=?";        
//        System.out.println("id=" + id);
//        int exito=0;
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            exito = ps.executeUpdate();
//            //System.out.println("variable exito=" + exito);
//            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Cliente eliminado");
//            } else {
//                JOptionPane.showMessageDialog(null, "Cliente inexistente");
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente. No se pudo eliminar el cliente" + ex.getMessage());
//        }
//        return exito;
//    }
    
//    //método Recuperar un alumno eliminado logicamente
//    public int recuperarAlumno(int id) {
//        String sql = "UPDATE alumno SET estado = 1 WHERE idAlumno=?";        
//        int exito=0;
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            exito = ps.executeUpdate();
//            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Alumno Recuperado");
//            } else {
//                JOptionPane.showMessageDialog(null, "Alumno inexistente");
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo Recuperar al alumno" + ex.getMessage());
//        }
//        return exito;
//    }
    
//    //método buscar cliente
//    public Cliente buscarCliente(int id, int bajaActivo) {
//        String sql = "SELECT apellido, nombre, domicilio, telefono, estado, dni FROM cliente WHERE idCliente=? AND estado=?";
//        Cliente cliente = null;
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.setInt(2, bajaActivo);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                cliente = new Cliente();
//                cliente.setIdCliente(id);           
//                cliente.setApellido(rs.getString("apellido"));
//                cliente.setNombre(rs.getString("nombre"));
//                cliente.setDomicilio(rs.getString("domicilio"));
//                cliente.setTelefono(rs.getString("telefono"));
//                cliente.setEstado(rs.getBoolean("estado"));
//                cliente.setDni(rs.getInt("dni"));
//                // no se hace esta asignacion porque se entiende por defecto de que lo que 
//                // esta trayendo del sql son registros activos-true-
//                //alumno.setActivo(rs.getBoolean("estado"));
//            } else {
//                JOptionPane.showMessageDialog(null, "No existe ese cliente");
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente. No se pudo buscar el cliente");
//        }
//        return cliente;
//    }
        
//    //método buscar alumno por dni
    public Cliente buscarClientePorDni(int dni) {
        //String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE dni = ? AND estado = ?";
        String sql = "SELECT idCliente, apellido, nombre, domicilio, telefono, estado, dni FROM cliente WHERE dni=?";
        Cliente cliente = null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                cliente=new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));           
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEstado(rs.getBoolean("estado"));
                cliente.setDni(rs.getInt("dni"));
                
                // no se hace esta asignacion porque se entiende por defecto de que lo que 
                // esta trayendo del sql son registros activos-true-
                //alumno.setActivo(rs.getBoolean("estado"));
                JOptionPane.showMessageDialog(null, "ALUMNO ENCONTRADO");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo buscar el alumno");
        }
        return cliente;
    }
        
//    //Método listarAlumnos ANTERIOR para buscar en un COMBOBOX
//    public List<Alumno> listarAlumnos(int bajaActivo) {
//        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE estado = ?"
//                + " ORDER BY apellido, nombre ";
//        ArrayList<Alumno> alumnos = new ArrayList<>();
//        try {
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setInt(1, bajaActivo);
//            ResultSet rs=ps.executeQuery();
//            while (rs.next()) {
//                Alumno alumno=new Alumno();
//                alumno.setIdAlumno(rs.getInt("idAlumno"));
//                alumno.setDni(rs.getInt("dni"));
//                alumno.setApellido(rs.getString("apellido"));
//                alumno.setNombre(rs.getString("nombre"));
//                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());                
//                alumno.setActivo(rs.getBoolean("estado"));                
//                // no se hace esta asignacion porque se entiende por defecto de que lo que 
//                // esta trayendo del sql son registros activos-true-
//                //alumno.setActivo(rs.getBoolean("estado"));
//                alumnos.add(alumno);                
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo buscar el alumno");
//        }        
//        return alumnos;
//    }
    
//    //Método listarAlumnos NUEVA para buscar en una JTABLE
//      public TreeSet<Alumno> listarAlumnosJTable(int bajaActivo){                  
//        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE estado = ?"
//                + " ORDER BY apellido, nombre ";
//        TreeSet<Alumno> alumnos=new TreeSet<>();
//        try {
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setInt(1, bajaActivo);
//            ResultSet rs=ps.executeQuery();
//            while (rs.next()) {
//                Alumno alumno=new Alumno();
//                alumno.setIdAlumno(rs.getInt("idAlumno"));
//                alumno.setDni(rs.getInt("dni"));
//                alumno.setApellido(rs.getString("apellido"));
//                alumno.setNombre(rs.getString("nombre"));
//                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());                
//                alumno.setActivo(rs.getBoolean("estado"));                
//                // no se hace esta asignacion porque se entiende por defecto de que lo que 
//                // esta trayendo del sql son registros activos-true-
//                //alumno.setActivo(rs.getBoolean("estado"));
//                alumnos.add(alumno);                
//            }            
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. No se pudo buscar el alumno");
//        }        
//        catch (Exception ex2) {
//            JOptionPane.showMessageDialog(null, "Error 2:"+ex2);
//        }
//        return alumnos;        
//      };
    
    
    
    
    
    
}
