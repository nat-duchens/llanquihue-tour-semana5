
package model;

/**
 * Class Proveedor: representa a un proveedor de servicios de Llanquihue Tour
 * Permite implementar la relación de composición entre Proveedor y Direccion
 * @author Natalie Duchens
 */

public class Proveedor {

    // Atributos privados
    private String id;
    private String nombre;
    private String servicio;
    private Direccion direccion; // Composición con la clase Direccion

    // Constructor vacío
    public Proveedor() {
        this.id = "P000";
        this.nombre = "Sin Nombre";
        this.servicio = "Sin Servicio";
        this.direccion = new Direccion();
    }

    // Constructor con parámetros
    public Proveedor(String id, String nombre, String servicio, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.servicio = servicio;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    // Override del método toString() para mostrar la información del proveedor
    @Override
    public String toString() {
        return "ID: " + id
                + " | Proveedor: " + nombre
                + " | Servicio: " + servicio
                + " | Dirección: [" + direccion.toString() + "]";
    }
}
