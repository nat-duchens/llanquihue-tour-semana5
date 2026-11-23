# Llanquihue Tour - Gestión de Proveedores

## Descripción

Sistema básico de gestión de proveedores para la agencia de turismo Llanquihue Tour (Región de Los Lagos), desarrollado en Java. Su propósito es organizar la información de los proveedores mediante un programa que lee los datos desde un archivo de texto, los almacena en una colección y permite recorrerlos y filtrarlos, aplicando programación orientada a objetos, encapsulamiento, composición y validaciones.

## Estructura del proyecto

```text
LlanquihueTourApp/
├── src/
│   ├── model/
│   │   ├── Direccion.java
│   │   └── Proveedor.java
│   ├── util/
│   │   └── Validador.java
│   ├── service/
│   │   └── GestorServicios.java
│   └── app/
│       └── Main.java
├── resources/
│   └── proveedores.txt
└── README.md
```

## Clases implementadas

| Paquete | Clase | Descripción |
|---|---|---|
| `model` | `Proveedor` | Representa un proveedor. Contiene id, nombre, servicio y una dirección. |
| `model` | `Direccion` | Representa la calle, ciudad y región del proveedor. |
| `util` | `Validador` | Contiene métodos para validar los datos y la cantidad de campos del archivo. |
| `service` | `GestorServicios` | Lee el archivo `proveedores.txt`, valida los registros, evita duplicados y administra un `ArrayList<Proveedor>`. También permite buscar por servicio y ciudad. |
| `app` | `Main` | Ejecuta el sistema, muestra el catálogo general y realiza búsquedas de proveedores. |

## Relaciones entre clases

**Composición:** `Proveedor` tiene un atributo de tipo `Direccion`, que permite asociar los datos de ubicación a cada proveedor.

## Archivo de datos

El archivo `resources/proveedores.txt` contiene un proveedor por línea, utilizando el siguiente formato:

`id;nombre;servicio;calle;ciudad;region`

Los campos se separan mediante punto y coma (`;`), sin espacios alrededor del separador.

## Funcionamiento

- **Lectura:** `GestorServicios` lee el archivo y convierte cada línea válida en un objeto `Proveedor`.
- **Validación:** `Validador` comprueba que los registros tengan la cantidad de campos esperada y que los datos obligatorios no estén vacíos.
- **Colección:** los proveedores se almacenan en un `ArrayList`.
- **Control de duplicados:** se verifica que no existan proveedores con el mismo identificador.
- **Recorrido y filtrado:** el sistema muestra el catálogo completo y permite buscar proveedores por tipo de servicio y ciudad.

## Cómo compilar y ejecutar

Desde la carpeta raíz del proyecto:

```bash
javac -d out src/model/*.java src/util/*.java src/service/*.java src/app/*.java
java -cp out app.Main
```

Para generar y ejecutar la versión de distribución `.jar`:

```bash
jar cfe LlanquihueTour.jar app.Main -C out .
java -jar LlanquihueTour.jar
```

Requiere tener instalado JDK 17 o superior.

## Autora

Natalie Duchens - Desarrollo Orientado a Objetos I, Duoc UC