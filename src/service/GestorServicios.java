package service;

import model.Direccion;
import model.Proveedor;
import util.Validador;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class GestorServicios: carga los proveedores desde un archivo de texto
 * Los almacena en un ArrayList y permite mostrarlos y buscarlos
 * @author Natalie Duchens
 */

public class GestorServicios {

    // Colección de proveedores
    private ArrayList<Proveedor> listaProveedores = new ArrayList<>();

    // Lee el archivo línea por línea y carga los proveedores en la lista
    public void cargarDesdeArchivo(String ruta) {
        try {
            File archivo = new File(ruta);
            Scanner lector = new Scanner(archivo, "UTF-8");

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();

                // Cada línea se valida por separado, para que un error no detenga la carga
                try {
                    // Separación de los datos con el punto y coma
                    String[] datos = linea.split(";");

                    // Validaciones básicas
                    Validador.validarCantidadCampos(datos, 6);
                    Validador.validarTexto(datos[0], "id");
                    Validador.validarTexto(datos[1], "nombre");
                    Validador.validarTexto(datos[2], "servicio");

                    // Se evita cargar proveedores duplicados
                    if (existeId(datos[0])) {
                        throw new IllegalArgumentException("El id " + datos[0] + " ya existe");
                    }

                    // Creación de los objetos (composición de Direccion)
                    Direccion direccion = new Direccion(datos[3], datos[4], datos[5]);
                    listaProveedores.add(new Proveedor(datos[0], datos[1], datos[2], direccion));

                } catch (IllegalArgumentException e) {
                    System.out.println("Línea omitida (" + e.getMessage() + "): " + linea);
                }
            }
            lector.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: no se encontró el archivo " + ruta);
        }
    }

    // Revisa si ya existe un proveedor con el mismo id
    private boolean existeId(String id) {
        for (Proveedor p : listaProveedores) {
            if (p.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Muestra todos los proveedores de la lista
    public void mostrarTodo() {
        for (Proveedor p : listaProveedores) {
            System.out.println(p.toString());
        }
    }

    // Busca los proveedores según el tipo de servicio
    public void buscarPorServicio(String servicio) {
        System.out.println("Resultados para el servicio: " + servicio);
        boolean encontrado = false;
        for (Proveedor p : listaProveedores) {
            if (p.getServicio().equalsIgnoreCase(servicio)) {
                System.out.println(p.toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron proveedores.");
        }
    }

    // Busca los proveedores según la ciudad de su dirección
    public void buscarPorCiudad(String ciudad) {
        System.out.println("Resultados para la ciudad: " + ciudad);
        boolean encontrado = false;
        for (Proveedor p : listaProveedores) {
            if (p.getDireccion().getCiudad().equalsIgnoreCase(ciudad)) {
                System.out.println(p.toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron proveedores.");
        }
    }

}