package util;

/**
 * Class Validador: contiene validaciones básicas para los datos del archivo
 * Lanza una excepción cuando un dato no es válido
 * @author Natalie Duchens
 */

public class Validador {

    // Valida que un texto no sea nulo ni esté vacío
    public static void validarTexto(String texto, String campo) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + campo + " no puede estar vacío");
        }
    }

    // Valida que la línea del archivo tenga la cantidad de campos esperada
    public static void validarCantidadCampos(String[] datos, int cantidadEsperada) {
        if (datos.length != cantidadEsperada) {
            throw new IllegalArgumentException("La línea tiene " + datos.length + " campos y se esperaban " + cantidadEsperada);
        }
    }

}