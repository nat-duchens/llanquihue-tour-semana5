package app;

// Importación de la clase del paquete service
import service.GestorServicios;

/**
 * Class Main: clase principal que contiene el método main
 * Carga los proveedores desde el archivo y aplica búsquedas
 * @author Natalie Duchens
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("AGENCIA DE TURISMO LLANQUIHUE TOUR - GESTIÓN DE PROVEEDORES");
        System.out.println("---------------------------------------------------------------------------------");

        // Carga de los datos desde el archivo ubicado en resources
        GestorServicios gestor = new GestorServicios();
        gestor.cargarDesdeArchivo("resources/proveedores.txt");

        // Recorrido de la colección
        System.out.println("\n~~ CATÁLOGO DE PROVEEDORES ~~");
        gestor.mostrarTodo();

        // Búsqueda por servicio
        System.out.println("\n~~ BÚSQUEDA POR SERVICIO ~~");
        gestor.buscarPorServicio("Gastronomía");

        // Búsqueda por ciudad
        System.out.println("\n~~ BÚSQUEDA POR CIUDAD ~~");
        gestor.buscarPorCiudad("Puerto Varas");

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("¡Consulta finalizada!");
    }
}