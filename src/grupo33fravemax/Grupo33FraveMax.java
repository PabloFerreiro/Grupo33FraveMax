// Actualizado dia: 03/10/23 hs: 15:26
package grupo33fravemax;

import accesoADatos.ClienteData;
import accesoADatos.Conexion;
import entidades.Cliente;


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
        

    //Método buscar Alumno por Id 
//        ClienteData cli=new ClienteData();
//        Cliente clienteEncontrado=cli.buscarCliente(2,0);
//        System.out.println(clienteEncontrado.toString());

    //Método buscar Cliente por Dni 
        ClienteData cli=new ClienteData();
        Cliente clienteEncontrado=cli.buscarClientePorDni(23345678);
        if (clienteEncontrado!=null){
        System.out.println(clienteEncontrado.toString());
        }
        
    //Método listar alumno
//        AlumnoData alu=new AlumnoData();
//        for(Alumno alumno:alu.listarAlumnos()){
//            System.out.println(alumno.getDni());
//            System.out.println(alumno.getApellido());
//            System.out.println(alumno.getNombre());
//            System.out.println(alumno.getFechaNac());
//            System.out.println("");  
//            }

            
//#########################################################################
// CONEXIONES A MATERIADATA
//#########################################################################   
    //Metodo guardar materia
//        Materia materia1= new Materia ("Biología", 2023, true);
//        MateriaData mat=new MateriaData();
//        mat.guardarMateria(materia1);
          

    //Método buscar Materia
//        MateriaData mat=new MateriaData();
//        Materia materiaEncontrada=mat.buscarMateria(2);
//        System.out.println("Nombre " + materiaEncontrada.getNombre());
//        System.out.println("Año " + materiaEncontrada.getAño());
        
    //Método modificar Materia
//          Materia materia1= new Materia (2,"Matemática", 2022, true);
//          MateriaData mat=new MateriaData();
//          mat.modificarMateria(materia1);

    //Método eliminar Materia
//        MateriaData mat=new MateriaData();
//        mat.eliminarMateria(2);

    //Método listar materia
//        MateriaData mat=new MateriaData();
//        for(Materia materia:mat.listarMaterias()){
//            System.out.println(materia.getNombre());
//            System.out.println(materia.getAño());
//            System.out.println("");  
//            }

//#########################################################################
// CONEXIONES A INSCRIPCIONDATA
//#########################################################################  
       
           
    //Metodo guardar inscripcion    
//        Alumno alu = new Alumno (1);        
//        Materia mat = new Materia (1);            
//        Inscripcion inscripcion1 = new Inscripcion (alu, mat, 8);        
//        InscripcionData insc1 = new InscripcionData();
//        insc1.guardarInscripcion(inscripcion1);
       

    //Metodo actualizar nota
//          InscripcionData insc1 = new InscripcionData();
//          insc1.actualizarNota(3, 3, 10);

      
    //Método borrar inscripcion materia alumno
//            InscripcionData insc1 = new InscripcionData();
//            insc1.borrarInscripcionMateriaAlumno(3, 3);

    //Método obtener inscripciones
//        InscripcionData insc=new InscripcionData();
//        for(String inscripcion:insc.obtenerInscripciones())
//        {
//            System.out.println(inscripcion);            
//        }
      
    //Método obtener inscripciones por alumno
//        InscripcionData insc=new InscripcionData();
//        Alumno alu= new Alumno (1);        
//        for(String inscripcion:insc.obtenerInscripcionesPorAlumno(alu.getIdAlumno()))
//        {
//            System.out.println(inscripcion);            
//        }

    //Método obtener alumnos por materia
//        InscripcionData insc=new InscripcionData();        
//        Materia mat= new Materia (2);            
//        for(String inscripcion:insc.obtenerAlumnosXMateria(mat.getIdMateria()))        
//        {
//            System.out.println(inscripcion);            
//        }
        
    //Método obtener materias cursadas
//        InscripcionData insc=new InscripcionData();
//        Alumno alu= new Alumno (1);        
//        for(Materia materias:insc.obtenerMateriasCursadas(alu.getIdAlumno()))
//        {
//            System.out.println(materias.getNombre());            
//        }
        
    //Método obtener materias no cursadas
//        InscripcionData insc=new InscripcionData();
//        Alumno alu= new Alumno (1);        
//        for(Materia materias:insc.obtenerMateriasNoCursadas(alu.getIdAlumno()))
//        {
//            System.out.println(materias.getNombre());            
//        }
    
    
        
    }
    
}
