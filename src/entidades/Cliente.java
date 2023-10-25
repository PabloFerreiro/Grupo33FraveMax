// RAMA V2
// Actualizado dia: 25/10/23 hs: 15:38
package entidades;

public class Cliente implements Comparable<Cliente> {

    private int idCliente;
    private String apellido;
    private String nombre;
    private String domicilio;
    private String telefono;
    private int dni;
    private boolean estado;

    public Cliente() {
    }

    public Cliente(int idCliente, String apellido, String nombre, String domicilio, String telefono, int dni, boolean estado) {
        this.idCliente = idCliente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.dni = dni;
        this.estado = estado;
    }

    public Cliente(String apellido, String nombre, String domicilio, String telefono, int dni, boolean estado) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.dni = dni;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", domicilio=" + domicilio + ", telefono=" + telefono + ", dni=" + dni + ", estado=" + estado + '}';
    }

    @Override
    public int compareTo(Cliente otroApellido) {
        return this.apellido.compareTo(otroApellido.apellido);
    }

}
