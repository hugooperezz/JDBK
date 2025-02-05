package Tienda_Zapatillas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class main {

	private static final String URL = "jdbc:mysql://localhost:3306/TheKickHub?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "TheHuX076";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Connection conexion = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Conexión establecida con éxito");
			
			Boolean condicion = true;
			while (condicion) {
				System.out.println("\n===== Menu =====\n" + "----------------\n" + "1. Listar tablas\n" + "----------------\n" + "2. Comprar\n" + "----------------\n" + "3. Vender\n" + "----------------\n" +"4. Salir\n" + "----------------\n" + "================");
				
				System.out.print("\nSelecciona una opcion: ");
				int opcion = sc.nextInt();
				switch (opcion) {
				case 1: 
					listarTablas(conexion);
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					System.out.println("Saliendo...");
					condicion = false;
					break;
				default:
					
				}
			}
		}catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
		}
		
	}
	
	public static void listarTablas (Connection conexion) {
		Scanner sc1 = new Scanner(System.in);
		Boolean condicion = true;
		
		while (condicion) {
			System.out.println("\n===== Menu =====\n" + "----------------\n" + "1. Productos\n" + "----------------\n" + "2. Proveedores\n" + "----------------\n" + "3. Clientes\n" + "----------------\n" +"4. Compras\n" + "----------------\n" + "5. Ventas\n" + "----------------\n" + "6. Salir\n" + "----------------\n" + "================");
			System.out.print("\nSelecciona una opcion: ");
			int opcion = sc1.nextInt();
			switch (opcion) {
			case 1: 
				imprimirTablaProductos(conexion);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				
			}
		}
	}
	
	//Metodos Tabla Productos 
	
	private static void CrearTablaProductos(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS Productos (" 
				+ "id_producto INT AUTO_INCREMENT PRIMARY KEY, "
				+ "nombre VARCHAR(100) NOT NULL, " 
				+ "marca VARCHAR(50) NOT NULL, " 
				+ "talla DECIMAL(4,1) NOT NULL, "
				+ "precio DECIMAL(10,2) NOT NULL, " 
				+ "stock INT NOT NULL " 
				+ ")";
		stmt.executeUpdate(sql);
		System.out.println("Tabla departamento creada correctamente");
		stmt.close();
	}
	
	public static void imprimirTablaProductos(Connection conexion) {
        String sql = "SELECT * FROM Productos"; // Consulta para obtener todos los datos de la tabla

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Encabezados de la tabla
        	System.out.println("\n=================================== TABLA PRODUCTOS =======================================");
            System.out.println("+-------------+----------------------+----------------------+--------+------------+-------+");
            System.out.println("| ID Producto | Nombre               | Marca                | Talla  | Precio     | Stock |");
            System.out.println("+-------------+----------------------+----------------------+--------+------------+-------+");

            // Recorre los resultados y los imprime en formato tabular
            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                String marca = rs.getString("marca");
                double talla = rs.getDouble("talla");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");

                // Formatea cada fila
                System.out.printf("| %-10d | %-20s | %-20s | %-6.1f | %-10.2f | %-5d |\n",
                        idProducto, nombre, marca, talla, precio, stock);
            }

            // Pie de la tabla
            System.out.println("+-------------+----------------------+----------------------+--------+------------+-------+");
        } catch (Exception e) {
            System.err.println("Error al imprimir la tabla: " + e.getMessage());
        }
    }
	
	//Metodos tabla Proveedores
	
	private static void CrearTablaProvedores(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS Proveedores ("
		        + "id_proveedor INT AUTO_INCREMENT PRIMARY KEY, "
		        + "nombre VARCHAR(100) NOT NULL, "
		        + "empresa VARCHAR(100) NOT NULL, "
		        + "telefono VARCHAR(20), "
		        + "direccion VARCHAR(255) "
		        + ")";
		stmt.executeUpdate(sql);
		System.out.println("Tabla Provedores creada correctamente");
		stmt.close();
	}
	
	public static void imprimirTablaProveedores(Connection conexion) {
        String sql = "SELECT * FROM Proveedores"; // Consulta para obtener todos los datos de la tabla

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Encabezados de la tabla
        	System.out.println("\n=================================== TABLA PRODUCTOS ======================================");
            System.out.println("+----------------+----------------------+----------------------+--------+------------+-------+");
            System.out.println("| ID Proveedores | Nombre               | Marca                | Talla  | Precio     | Stock |");
            System.out.println("+----------------+----------------------+----------------------+--------+------------+-------+");

            // Recorre los resultados y los imprime en formato tabular
            while (rs.next()) {
                int idProveedore = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre");
                String empresa = rs.getString("empresa");
                String telefono = rs.getString("telefono");
                double precio = rs.getDouble("precio");
                String direccion = rs.getString("direccion");

                // Formatea cada fila
                System.out.printf("| %-10d | %-20s | %-20s | %-6.1f | %-10.2f | %-5d |\n",
                		idProveedore, nombre, empresa, telefono, precio, direccion);
            }

            // Pie de la tabla
            System.out.println("+------------+----------------------+----------------------+--------+------------+-------+");
        } catch (Exception e) {
            System.err.println("Error al imprimir la tabla: " + e.getMessage());
        }
    }
	
	//Metodos tabla Clientes
        

	private static void CrearTablaClientes(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS Clientes ("
	            + "id_cliente INT AUTO_INCREMENT PRIMARY KEY,"
	            + "nombre VARCHAR(30) NOT NULL,"
	            + "telefono INT,"
	            + "email VARCHAR(50)"
	            + ")";
		
		stmt.executeUpdate(sql);
		System.out.println("Tabla Clientes creada correctamente");
		stmt.close();
	}
	
	public static void imprimirTablaClientes(Connection conexion) {
        String sql = "SELECT * FROM Clientes"; // Consulta para obtener todos los datos de la tabla

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Encabezados de la tabla
        	System.out.println("\n======================= TABLA PRODUCTOS ==============================");
            System.out.println("+----------------+----------------------+----------------------+-------+");
            System.out.println("| ID Clientes    | Nombre               | telefono             | Stock |");
            System.out.println("+----------------+----------------------+----------------------+-------+");

            // Recorre los resultados y los imprime en formato tabular
            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");

                // Formatea cada fila
                System.out.printf("| %-10d | %-20s | %-20s | %-6.1f | %-10.2f | %-5d |\n",
                		idCliente, nombre, telefono, email);
            }

            // Pie de la tabla
            System.out.println("+------------+----------------------+----------------------+--------+------------+-------+");
        } catch (Exception e) {
            System.err.println("Error al imprimir la tabla: " + e.getMessage());
        }
    }
	
	//Metodos tabla Compras

	private static void CrearTablaCompras(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS Compras ("
                + "id_compra INT AUTO_INCREMENT PRIMARY KEY,"
                + "fecha DATE NOT NULL,"
                + "id_producto INT,"
                + "id_proveedor INT,"
                + "FOREIGN KEY (id_producto) REFERENCES Productos(id_producto) ON DELETE CASCADE ON UPDATE CASCADE,"
                + "FOREIGN KEY (id_proveedor) REFERENCES Proveedores(id_proveedor) ON DELETE CASCADE ON UPDATE CASCADE"
                + ")";
		stmt.executeUpdate(sql);
		System.out.println("Tabla Compras creada correctamente");
		stmt.close();
	}
	
	public static void imprimirTablaCompras(Connection conexion) {
        String sql = "SELECT * FROM Compras"; // Consulta para obtener todos los datos de la tabla

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

        	// Encabezados de la tabla
            System.out.println("\n================ TABLA COMPRAS =======================");
            System.out.println("+-------------+------------+-------------+-------------+");
            System.out.println("| ID Compra   | Fecha      | ID Producto | ID Proveedor|");
            System.out.println("+-------------+------------+-------------+-------------+");

            // Recorre los resultados y los imprime en formato tabular
            while (rs.next()) {
                int idCompra = rs.getInt("id_compra");
                Date fecha = rs.getDate("fecha");
                int idProducto = rs.getInt("id_producto");
                int idProveedor = rs.getInt("id_proveedor");

                // Formatea cada fila
                System.out.printf("| %-11d | %-10s | %-11d | %-11d |", 
                    idCompra, fecha.toString(), idProducto, idProveedor);
            }

            // Pie de la tabla
            System.out.println("+------------+----------------------+----------------------+--------+------------+-------+");
        } catch (Exception e) {
            System.err.println("Error al imprimir la tabla: " + e.getMessage());
        }
    }
	
	//Metodos tabla Ventas

	private static void CrearTablaVentas(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS Ventas ("
                + "id_venta INT AUTO_INCREMENT PRIMARY KEY,"
                + "fecha DATE NOT NULL,"
                + "id_producto INT,"
                + "id_cliente INT,"
                + "FOREIGN KEY (id_producto) REFERENCES Productos(id_producto) ON DELETE CASCADE ON UPDATE CASCADE,"
                + "FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente) ON DELETE CASCADE ON UPDATE CASCADE"
                + ")";
		stmt.executeUpdate(sql);
		System.out.println("Tabla Ventas creada correctamente");
		stmt.close();
	}
	
	public static void imprimirTablaVentas(Connection conexion) {
        String sql = "SELECT * FROM Ventas"; // Consulta para obtener todos los datos de la tabla

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

        	// Encabezados de la tabla
            System.out.println("\n================ TABLA COMPRAS =======================");
            System.out.println("+-------------+------------+-------------+-------------+");
            System.out.println("| ID Ventas   | Fecha      | ID Producto | ID Clientes |");
            System.out.println("+-------------+------------+-------------+-------------+");

            // Recorre los resultados y los imprime en formato tabular
            while (rs.next()) {
                int idCompra = rs.getInt("id_venta");
                Date fecha = rs.getDate("fecha");
                int idProducto = rs.getInt("id_producto");
                int idCliente = rs.getInt("id_cliente");

                // Formatea cada fila
                System.out.printf("| %-11d | %-10s | %-11d | %-11d |", 
                    idCompra, fecha.toString(), idProducto, idCliente);
            }

            // Pie de la tabla
            System.out.println("+------------+----------------------+----------------------+--------+------------+-------+");
        } catch (Exception e) {
            System.err.println("Error al imprimir la tabla: " + e.getMessage());
        }
    }

}