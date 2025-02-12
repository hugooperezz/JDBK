# Tienda de Zapatillas - The Kick Hub

Este proyecto es una aplicación de consola en Java que gestiona una tienda de zapatillas. Permite realizar operaciones básicas como listar productos, comprar, vender, y actualizar tablas en una base de datos MySQL.

## Requisitos Previos

- **Java Development Kit (JDK)**: Asegúrate de tener instalado JDK 8 o superior.
- **MySQL Server**: Necesitas tener MySQL instalado y en ejecución.
- **MySQL Connector/J**: Asegúrate de tener el conector de MySQL para Java en tu classpath.

## Configuración

1. **Base de Datos**:
   - Crea una base de datos llamada `TheKickHub` en tu servidor MySQL.
   - Ejecuta los scripts SQL proporcionados para crear las tablas necesarias.

2. **Configuración de la Conexión**:
   - Abre el archivo `main.java` y actualiza las siguientes variables con tus credenciales de MySQL:
     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/TheKickHub?serverTimezone=UTC";
     private static final String USER = "root";
     private static final String PASS = "tu_contraseña";
     ```

## Ejecución

1. **Compilación**:
   - Navega hasta el directorio del proyecto y compila el código:
     ```bash
     javac -cp .:mysql-connector-java-8.0.23.jar Tienda_Zapatillas/main.java
     ```

2. **Ejecución**:
   - Ejecuta el programa:
     ```bash
     java -cp .:mysql-connector-java-8.0.23.jar Tienda_Zapatillas.main
     ```

## Funcionalidades

- **Listar Tablas**: Muestra las tablas de productos, proveedores, clientes, compras y ventas.
- **Comprar**: Permite registrar una compra de productos, actualizando el stock y registrando la compra en la base de datos.
- **Vender**: Permite registrar una venta de productos, actualizando el stock y registrando la venta en la base de datos.
- **Añadir Datos**: Permite añadir nuevos registros a las tablas de productos, proveedores y clientes.

## Estructura del Proyecto

- **Tienda_Zapatillas/main.java**: Contiene la lógica principal del programa.
- **Tablas SQL**: Las tablas se crean automáticamente al ejecutar el programa si no existen.

## Contribuciones

Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añade nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

## Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactarme en [tu_email@example.com](mailto:tu_email@example.com).
