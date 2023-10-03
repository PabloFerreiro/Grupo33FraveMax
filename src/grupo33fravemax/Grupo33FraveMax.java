// Actualizado dia: 03/10/23 hs: 17:48
package grupo33fravemax;

import accesoADatos.ClienteData;
import accesoADatos.Conexion;
import accesoADatos.ProductoData;
import entidades.Cliente;
import entidades.Producto;


public class Grupo33FraveMax {

    public static void main(String[] args) {

        
        //Llamamos a la conexion
        Conexion.getConexion();

        // PERMITE LA EJECUCION DEL SISTEMAS DESDE EL JFRAME PRINCIPAL
        //MenuPrincipal.main(args);
        
        
//#########################################################################
// CONEXIONES A CLIENTEDATA
//#########################################################################

 
////    Método guardar Cliente
//        Cliente juan= new Cliente("Perez", "Juan", "Av Belgrano 3233", "1598752345", 21234623, true);
//        Cliente romina= new Cliente("Fernandez", "Romina", "Av Sarmiento 4532", "1556832387", 272765123, true);
//        Cliente julian= new Cliente("Estevez", "Julian", "Av Mitre 3456", "1534821234", 25768643, true);
//        Cliente mariana= new Cliente("Basualdo", "Mariana", "Av Quiroga 4532", "1567923434", 30543678, true);
//        ClienteData cli=new ClienteData();
//        cli.guardarCliente(juan);
//        cli.guardarCliente(romina);
//        cli.guardarCliente(julian);
//        cli.guardarCliente(mariana);


//    //Método modificar Cliente
//        ClienteData cli=new ClienteData();
//        Cliente juan= new Cliente(2, "Perez", "Juana", "Av Belgrano 4444", "1598752345", 21234623, true);
//        cli.modificarCliente(juan);

//    //Método eliminar Cliente
//        ClienteData cli=new ClienteData();
//        cli.eliminarCliente(2);
        

      //Método buscar cliente por Id 
//        ClienteData cli=new ClienteData();
//        Cliente clienteEncontrado=cli.buscarCliente(2,0);
//        System.out.println(clienteEncontrado.toString());


    //Método buscar Cliente por Dni 
//        ClienteData cli=new ClienteData();
//        Cliente clienteEncontrado=cli.buscarClientePorDni(21234623);
//        if (clienteEncontrado!=null){
//        System.out.println(clienteEncontrado.toString());
//        }
 

    //Método listar cliente (combobox)
//        ClienteData cli=new ClienteData();
//        for(Cliente cliente:cli.listarClientes(0)){
//            System.out.println(cliente.toString() + "/n");
//            }

//    //Método recuperar Cliente
//        ClienteData cli=new ClienteData();
//        cli.recuperarCliente(2);
  
//#########################################################################
// CONEXIONES A PRODUCTODATA
//#########################################################################

////    Método guardar Producto
//        Producto p1= new Producto("Jabón", "en polvo 800gr",450.00, 50, true);
//        Producto p2= new Producto("Jabón", "de tocador 100gr",250.00, 100, true);
//        Producto p3= new Producto("Arroz", "blanco doble carolina",550.00, 80, true);
//        Producto p4= new Producto("Papel Higiénico", "Higienol 50mt x 4",720.00, 70, true);
//        Producto p5= new Producto("Shampoo", "Sedal con ceramidas x 500cm3",970.00, 120, true);
//        Producto p6= new Producto("Leche en polvo", "Nido x 500gr",1800.00, 200, true);
//       
//        ProductoData pro=new ProductoData();
//        pro.guardarProducto(p1);
//        pro.guardarProducto(p2);
//        pro.guardarProducto(p3);
//        pro.guardarProducto(p4);
//        pro.guardarProducto(p5);
//        pro.guardarProducto(p6);


//    //Método modificar Producto
//        ProductoData pro=new ProductoData();
//        Producto p1= new Producto(1,"Jabón", "en polvo 500gr",450.00, 50, true);
//        pro.modificarProducto(p1);

//    //Método eliminar Producto
//        ProductoData pro=new ProductoData();
//        pro.eliminarProducto(2);
        
      //Método buscar producto por Id 
//        ProductoData pro=new ProductoData();
//        Producto productoEncontrado=pro.buscarProducto(2,0);
//        System.out.println(productoEncontrado.toString());
    
    //Método listar producto (combobox)
//        ProductoData pro=new ProductoData();
//        for(Producto producto:pro.listarProductos(0)){
//            System.out.println(producto.toString() + "/n");
//            }

//    //Método recuperar Producto
//        ProductoData pro=new ProductoData();
//        pro.recuperarProducto(2);

//#########################################################################
// CONEXIONES A VENTADATA
//#########################################################################  

//#########################################################################
// CONEXIONES A DETALLEVENTAADATA
//######################################################################### 
    
    }
    
}
