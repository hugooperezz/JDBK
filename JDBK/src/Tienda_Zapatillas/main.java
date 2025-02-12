package Tienda_Zapatillas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
				System.out.println("\n===== Menu Principal =====\n" + "----------------\n" + "1. Listar tablas\n"
						+ "----------------\n" + "2. Comprar\n" + "----------------\n" + "3. Vender\n"
						+ "----------------\n" + "4. Actualizar tablas\n" + "----------------\n" + "5. Salir\n"
						+ "----------------\n" + "================");

				System.out.print("\nSelecciona una opcion: ");
				int opcion = sc.nextInt();
				switch (opcion) {
				case 1:
					listarTablas(conexion);
					break;
				case 2:
					Comprar(conexion);
					break;
				case 3:
					break;
				case 4:
					AñadirDatosTablas(conexion);
					break;
				case 5:
					System.out.println("Saliendo...");
					condicion = false;
					break;
				default:

				}
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}
	
	/**
	 * Muestra un submenú para listar diferentes tablas de la base de datos y
	 * permite al usuario seleccionar qué tabla ver.
	 * 
	 * @param conexion Conexión activa a la base de datos
	 */
	public static void listarTablas(Connection conexion) {
		Scanner sc1 = new Scanner(System.in);
		Boolean condicion = true;

		while (condicion) {
			System.out.println("\n===== Menu Listar =====\n" + "----------------\n" + "1. Productos\n"
					+ "----------------\n" + "2. Proveedores\n" + "----------------\n" + "3. Clientes\n"
					+ "----------------\n" + "4. Compras\n" + "----------------\n" + "5. Ventas\n"
					+ "----------------\n" + "6. Salir\n" + "----------------\n" + "================");
			System.out.print("\nSelecciona una opcion: ");
			int opcion = sc1.nextInt();
			switch (opcion) {
			case 1:
				imprimirTablaProductos(conexion);
				break;
			case 2:
				imprimirTablaProveedores(conexion);
				break;
			case 3:
				imprimirTablaClientes(conexion);
				break;
			case 4:
				imprimirTablaCompras(conexion);
				break;
			case 5:
				imprimirTablaVentas(conexion);
				break;
			case 6:
				condicion = false;
				break;
			default:

			}
		}
	}
	
	/**
	 * Proporciona funcionalidad para añadir nuevos registros a las tablas de
	 * Productos, Proveedores o Clientes.
	 * 
	 * @param conexion Conexión activa a la base de datos
	 * @throws SQLException Si ocurre un error de acceso a la base de datos
	 */
	public static void AñadirDatosTablas(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();
		Scanner sc1 = new Scanner(System.in);
		Scanner scT = new Scanner(System.in);
		Boolean condicio = true;

		while (condicio) {
			System.out.println("\n===== Menu Añadir =====\n" + "----------------\n" + "1. Productos\n"
					+ "----------------\n" + "2. Proveedores\n" + "----------------\n" + "3. Clientes\n"
					+ "----------------\n" + "4. Salir\n" + "----------------\n" + "================");
			System.out.print("\nSelecciona una opcion: ");
			int opcion = sc1.nextInt();
			switch (opcion) {
			// Insertar en tabla productos
			case 1:
				System.out.println("\nIntroduce el nombre del producto:");
				String nombreProducto = scT.nextLine();

				System.out.println("\nIntroduce la marca del producto:");
				String marca = scT.nextLine();

				System.out.println("\nIntroduce la talla del producto:");
				Double talla = scT.nextDouble();

				System.out.println("\nIntroduce el precio del producto:");
				Double precio = scT.nextDouble();

				System.out.println("\nIntroduce el stock del producto:");
				int stock = scT.nextInt();

				String sqlProducto = "INSERT INTO Productos(nombre, precio, marca, talla, stock) VALUES ('"
						+ nombreProducto + "', " + precio + ", '" + marca + "', " + talla + ", " + stock + ")";

				stmt.executeUpdate(sqlProducto);
				System.out.println("\nProducto añadido correctamente.");
				break;
			// Insertar en tabla proveedores
			case 2:

				System.out.println("Introduce el nombre del proveedor:");
				String nombreProveedor = scT.nextLine();

				System.out.println("Introduce la empresa del proveedor");
				String empresaProveedor = scT.nextLine();

				System.out.println("Introduce la direccion del proveedor");
				String direccionProveedor = scT.nextLine();

				System.out.println("Introduce el telefono del proveedor:");
				String telefonoProveedor = scT.nextLine();

				String sqlProveedor = "INSERT INTO Proveedores(nombre, empresa, direccion, telefono) VALUES ('"
						+ nombreProveedor + "', '" + empresaProveedor + "', '" + direccionProveedor + "', '"
						+ telefonoProveedor + "')";

				stmt.executeUpdate(sqlProveedor);
				System.out.println("Producto añadido correctamente.");
				break;
			// Insertar en tabla clientes
			case 3:
				System.out.println("Introduce el nombre del cliente:");
				String nombreCliente = scT.nextLine();

				System.out.println("Introduce el telefono del cliente:");
				String telefonoCliente = scT.nextLine();

				System.out.println("Introduce el email del cliente:");
				String emailCliente = scT.nextLine();

				String sqlClientes = "INSERT INTO Clientes(nombre, telefono, email) VALUES ('" + nombreCliente + "', '"
						+ telefonoCliente + "', '" + emailCliente + "')";

				stmt.executeUpdate(sqlClientes);
				System.out.println("Producto añadido correctamente.");
				break;
			case 4:
				System.out.println("Saliendo...");
				condicio = false;

			default:
				System.out.println("Opcion Invalida.");
			}
		}

		stmt.close();

	}

	// Metodos Tabla Productos
	
	
	/**
	 * Metodo para crear la tabla productos
	 * 
	 * @param conexion
	 * @throws SQLException
	 */
	public static void CrearTablaProductos(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS Productos (" + "id_producto INT AUTO_INCREMENT PRIMARY KEY, "
				+ "nombre VARCHAR(100) NOT NULL, " + "marca VARCHAR(50) NOT NULL, " + "talla DECIMAL(4,1) NOT NULL, "
				+ "precio DECIMAL(10,2) NOT NULL, " + "stock INT NOT NULL " + ")";
		stmt.executeUpdate(sql);
		System.out.println("Tabla departamento creada correctamente");
		stmt.close();
	}
	
	/**
	 * Imprime todos los registros de la tabla Productos en un formato de tabla.
	 * 
	 * @param conexion Conexión activa a la base de datos
	 */
	public static void imprimirTablaProductos(Connection conexion) {
		String sql = "SELECT * FROM Productos"; // Consulta para obtener todos los datos de la tabla

		try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			// Encabezados de la tabla
			System.out.println(
					"\n=================================== TABLA PRODUCTOS =======================================");
			System.out.println(
					"+-------------+----------------------+----------------------+--------+------------+-------+");
			System.out.println(
					"| ID Producto | Nombre               | Marca                | Talla  | Precio     | Stock |");
			System.out.println(
					"+-------------+----------------------+----------------------+--------+------------+-------+");

			// Recorre los resultados y los imprime en formato tabular
			while (rs.next()) {
				int idProducto = rs.getInt("id_producto");
				String nombre = rs.getString("nombre");
				String marca = rs.getString("marca");
				double talla = rs.getDouble("talla");
				double precio = rs.getDouble("precio");
				int stock = rs.getInt("stock");

				// Formatea cada fila
				System.out.printf("| %-10d | %-20s | %-20s | %-6.1f | %-10.2f | %-5d |\n", idProducto, nombre, marca,
						talla, precio, stock);
			}

			// Pie de la tabla
			System.out.println(
					"+-------------+----------------------+----------------------+--------+------------+-------+");
		} catch (Exception e) {
			System.err.println("Error al imprimir la tabla: " + e.getMessage());
		}
	}

	// Metodos tabla Proveedores
	
	/**
	 * Metodo para crear la tabla provedores
	 * 
	 * @param conexion
	 * @throws SQLException
	 */
	public static void CrearTablaProvedores(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS Proveedores (" + "id_proveedor INT AUTO_INCREMENT PRIMARY KEY, "
				+ "nombre VARCHAR(100) NOT NULL, " + "empresa VARCHAR(100) NOT NULL, " + "telefono VARCHAR(20), "
				+ "direccion VARCHAR(255) " + ")";
		stmt.executeUpdate(sql);
		System.out.println("Tabla Provedores creada correctamente");
		stmt.close();
	}
	
	/**
	 * Imprime todos los registros de la tabla Proveedores en un formato de tabla.
	 * 
	 * @param conexion Conexión activa a la base de datos
	 */
	public static void imprimirTablaProveedores(Connection conexion) {
		String sql = "SELECT * FROM Proveedores"; // Consulta para obtener todos los datos de la tabla

		try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			// Encabezados de la tabla
			System.out.println(
					"\n=================================== TABLA PRODUCTOS ======================================");
			System.out.println(
					"+----------------+----------------------+----------------------+-----------+------------+");
			System.out.println(
					"| ID Proveedores | Nombre               | Empresa              | Telefono  | Direccion  |");
			System.out.println(
					"+----------------+----------------------+----------------------+-----------+------------+");

			// Recorre los resultados y los imprime en formato tabular
			while (rs.next()) {
				int idProveedor = rs.getInt("id_proveedor");
				String nombre = rs.getString("nombre");
				String empresa = rs.getString("empresa");
				String telefono = rs.getString("telefono");
				String direccion = rs.getString("direccion");

				// Formatea cada fila
				System.out.printf("| %-14d | %-20s | %-20s | %-12s | %-16s |\n", idProveedor, nombre, empresa, telefono,
						direccion);
			}

			// Pie de la tabla
			System.out.println(
					"+------------+----------------------+----------------------+--------+------------+-------+");
		} catch (Exception e) {
			System.err.println("Error al imprimir la tabla: " + e.getMessage());
		}
	}

	// Metodos tabla Clientes

	/**
	 * Crea la tabla clientes
	 * @param conexion
	 * @throws SQLException
	 */
	private static void CrearTablaClientes(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS Clientes (" + "id_cliente INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nombre VARCHAR(30) NOT NULL," + "telefono INT," + "email VARCHAR(50)" + ")";

		stmt.executeUpdate(sql);
		System.out.println("Tabla Clientes creada correctamente");
		stmt.close();
	}
	
	/**
	 * Imprime todos los registros de la tabla Proveedores en un formato de tabla.
	 * 
	 * @param conexion Conexión activa a la base de datos
	 */
	public static void imprimirTablaClientes(Connection conexion) {
		String sql = "SELECT * FROM Clientes"; // Consulta para obtener todos los datos de la tabla

		try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			// Encabezados de la tabla
			System.out.println("\n======================= TABLA CLIENTES ==============================");
			System.out.println(
					"+----------------+----------------------+----------------------+-----------------------+");
			System.out.println(
					"| ID Cliente     | Nombre               | Teléfono             | Email                 |");
			System.out.println(
					"+----------------+----------------------+----------------------+-----------------------+");

			// Recorre los resultados y los imprime en formato tabular
			while (rs.next()) {
				int idCliente = rs.getInt("id_cliente");
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String email = rs.getString("email");

				// Formatea cada fila
				System.out.printf("| %-14d | %-20s | %-20s | %-20s |\n", idCliente, nombre, telefono, email);
			}

			// Pie de la tabla
			System.out.println(
					"+----------------+----------------------+----------------------+-----------------------+");
		} catch (Exception e) {
			System.err.println("Error al imprimir la tabla: " + e.getMessage());
		}
	}

	// Metodos tabla Compras
	
	/**
	 * Crea la tabla compras
	 * 
	 * @param conexion
	 * @throws SQLException
	 */
	private static void CrearTablaCompras(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS Compras (" + "id_compra INT AUTO_INCREMENT PRIMARY KEY,"
				+ "fecha DATE NOT NULL," + "id_producto INT," + "id_proveedor INT,"
				+ "FOREIGN KEY (id_producto) REFERENCES Productos(id_producto) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (id_proveedor) REFERENCES Proveedores(id_proveedor) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ")";
		stmt.executeUpdate(sql);
		System.out.println("Tabla Compras creada correctamente");
		stmt.close();
	}
	
	/**
	 * Imprime todos los registros de la tabla Compras en un formato de tabla.
	 * 
	 * @param conexion Conexión activa a la base de datos
	 */
	public static void imprimirTablaCompras(Connection conexion) {
		String sql = "SELECT * FROM Compras"; // Consulta para obtener todos los datos de la tabla

		try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

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
				System.out.printf("| %-11d | %-10s | %-11d | %-11d |", idCompra, fecha.toString(), idProducto,
						idProveedor);
			}

			// Pie de la tabla
			System.out.println(
					"\n+-------------+------------+-------------+-------------+");
		} catch (Exception e) {
			System.err.println("Error al imprimir la tabla: " + e.getMessage());
		}
	}
	
	/**
	 * Gestiona el proceso de compra permitiendo al usuario añadir una compra de
	 * producto, actualizando el stock y registrando la compra en la base de datos.
	 * 
	 * @param conexion Conexión activa a la base de datos
	 * @throws SQLException Si ocurre un error de acceso a la base de datos
	 */
	public static void Comprar(Connection conexion)throws SQLException {
		try (Statement stmt = conexion.createStatement(); Scanner sc = new Scanner(System.in)) {

	        System.out.print("Introduce el nombre del producto comprado: ");
	        String nombreProducto = sc.nextLine();

	        int idProducto = obtenerId(stmt, "Productos", "id_producto", nombreProducto);
	        
	        //Si el producto existe devolvera su ID y si no la variable valdra -1
	        if (idProducto == -1) {
	            System.out.println("Producto no encontrado, introduce los datos:");
	            AñadirDatosTablas(conexion);
	            idProducto = obtenerId(stmt, "Productos", "id_producto", nombreProducto);
	        }

	        System.out.print("Introduce el nombre del proveedor: ");
	        String nombreProveedor = sc.nextLine();

	        int idProveedor = obtenerId(stmt, "Proveedores", "id_proveedor", nombreProveedor);
	        
	        //Si el proveedor existe devolvera su ID y si no la variable valdra -1
	        if (idProveedor == -1) {
	            System.out.println("Proveedor no encontrado, introduce los datos:");
	            AñadirDatosTablas(conexion);
	            idProveedor = obtenerId(stmt, "Proveedores", "id_proveedor", nombreProveedor);
	        }

	        System.out.print("Introduce la fecha de la compra (YYYY-MM-DD): ");
	        String fechaCompra = sc.nextLine();

	        if (idProducto != -1 && idProveedor != -1) {
	            stmt.executeUpdate("UPDATE Productos SET stock = stock + 1 WHERE id_producto = " + idProducto + " AND stock > 0");
	            stmt.executeUpdate("INSERT INTO Compras (fecha, id_producto, id_proveedor) VALUES ('" + fechaCompra + "', " + idProducto + ", " + idProveedor + ")");

	            System.out.println("Compra registrada correctamente.");
	        } else {
	            System.out.println("No se pudo registrar la compra debido a datos incompletos.");
	        }
	    }
	}
	
	/**
	 * Recupera el ID de un registro en una tabla específica basándose en su nombre.
	 * 
	 * @param stmt    Declaración de statement para ejecutar la consulta
	 * @param tabla   Nombre de la tabla donde buscar
	 * @param idCampo Nombre del campo ID
	 * @param nombre  Nombre del registro a buscar
	 * @return ID del registro encontrado o -1 si no se encuentra
	 * @throws SQLException Si ocurre un error de acceso a la base de datos
	 */
	private static int obtenerId(Statement stmt, String tabla, String idCampo, String nombre) throws SQLException {
	    String sql = "SELECT " + idCampo + " FROM " + tabla + " WHERE nombre = '" + nombre + "'";
	    try (ResultSet rs = stmt.executeQuery(sql)) {
	        return rs.next() ? rs.getInt(idCampo) : -1;
	    }
	}
	

	// Metodos tabla Ventas
	
	/**
	 * Crea la tabla ventas
	 * 
	 * @param conexion
	 * @throws SQLException
	 */
	private static void CrearTablaVentas(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS Ventas (" + "id_venta INT AUTO_INCREMENT PRIMARY KEY,"
				+ "fecha DATE NOT NULL," + "id_producto INT," + "id_cliente INT,"
				+ "FOREIGN KEY (id_producto) REFERENCES Productos(id_producto) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente) ON DELETE CASCADE ON UPDATE CASCADE" + ")";
		stmt.executeUpdate(sql);
		System.out.println("Tabla Ventas creada correctamente");
		stmt.close();
	}
	
	/**
	 * Imprime todos los registros de la tabla Ventas en un formato de tabla.
	 * 
	 * @param conexion Conexión activa a la base de datos
	 */
	public static void imprimirTablaVentas(Connection conexion) {
		String sql = "SELECT * FROM Ventas"; // Consulta para obtener todos los datos de la tabla

		try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			// Encabezados de la tabla
			System.out.println("\n================ TABLA VENTAS  =======================");
			System.out.println("+-------------+------------+-------------+-------------+");
			System.out.println("| ID Ventas   | Fecha      | ID Producto | ID Clientes |");
			System.out.println("+-------------+------------+-------------+-------------+");

			while (rs.next()) {
				int idVenta = rs.getInt("id_venta");
				Date fecha = rs.getDate("fecha");
				int idProducto = rs.getInt("id_producto");
				int idCliente = rs.getInt("id_cliente");

				System.out.printf("| %-11d | %-10s | %-11d | %-11d |\n", idVenta, fecha.toString(), idProducto,
						idCliente);
			}

			System.out.println("+-------------+------------+-------------+-------------+");
		} catch (Exception e) {
			System.err.println("Error al imprimir la tabla: " + e.getMessage());
		}
	}
	
	/**
	 * Gestiona el proceso de venta permitiendo al usuario registrar una venta,
	 * añadiendo un cliente si es necesario y actualizando el stock del producto.
	 * 
	 * @param conexion Conexión activa a la base de datos
	 */
	public static void Vender(Connection conexion) {
		try (Statement stmt = conexion.createStatement(); Scanner sc = new Scanner(System.in)) {

			System.out.println("Introduce el nombre del producto vendido:");
			String productoVendido = sc.nextLine();

			System.out.println("Introduce el nombre del cliente:");
			String clienteVenta = sc.nextLine();

			// Buscar el cliente por nombre
			int idCliente = -1;
			String buscarCliente = "SELECT id_cliente FROM Clientes WHERE nombre = '" + clienteVenta + "'";

			try (ResultSet rsCliente = stmt.executeQuery(buscarCliente)) {
				if (rsCliente.next()) {
					idCliente = rsCliente.getInt("id_cliente");
				}
			}

			// Si el cliente no existe, agregarlo
			if (idCliente == -1) {
				System.out.println("Cliente no encontrado. Introduce el email del cliente:");
				String emailCliente = sc.nextLine();

				System.out.println("Introduce el teléfono del cliente:");
				String telefonoCliente = sc.nextLine();

				String insertarCliente = "INSERT INTO Clientes (nombre, email, telefono) VALUES ('" + clienteVenta
						+ "', '" + emailCliente + "', '" + telefonoCliente + "')";
				stmt.executeUpdate(insertarCliente);

				// Recuperar el ID del cliente recién insertado
				try (ResultSet rsNuevoCliente = stmt.executeQuery(buscarCliente)) {
					if (rsNuevoCliente.next()) {
						idCliente = rsNuevoCliente.getInt("id_cliente");
					}
				}
			}

			// Buscar el producto por nombre
			int idProducto = -1;
			String buscarProducto = "SELECT id_producto FROM Productos WHERE nombre = '" + productoVendido + "'";

			try (ResultSet rsProducto = stmt.executeQuery(buscarProducto)) {
				if (rsProducto.next()) {
					idProducto = rsProducto.getInt("id_producto");
				}
			}

			System.out.println("Introduce la fecha de la venta (YYYY-MM-DD):");
			String fechaVenta = sc.nextLine();

			// Si el producto y el cliente existen, registrar la venta
			if (idProducto != -1 && idCliente != -1) {
				String sqlVender = "INSERT INTO Ventas (fecha, id_producto, id_cliente) VALUES ('" + fechaVenta + "', "
						+ idProducto + ", " + idCliente + ")";
				String sqlStock = "UPDATE Productos SET stock = stock - 1 WHERE nombre = '" + productoVendido
						+ "' AND stock > 0";

				stmt.executeUpdate(sqlVender);
				stmt.executeUpdate(sqlStock);
				System.out.println("Venta registrada correctamente.");
			} else {
				System.out.println("Error: Producto no encontrado.");
			}
		} catch (Exception e) {
			System.err.println("Error en la venta: " + e.getMessage());
		}
	}
	
	/**
	 * Realiza una consulta de unión (join) entre las tablas Compras y Ventas,
	 * mostrando información relacionada de productos comprados y vendidos.
	 * 
	 * @param conexion Conexión activa a la base de datos
	 */
	public static void joinComprasYVentas(Connection conexion) {
		String sql = "SELECT c.id_compra, c.fecha AS fecha_compra, v.id_venta, v.fecha AS fecha_venta, p.nombre AS producto "
				+ "FROM Compras c " + "INNER JOIN Ventas v ON c.id_producto = v.id_producto "
				+ "INNER JOIN Productos p ON c.id_producto = p.id_producto";

		try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			System.out.println("\n========= COMPRAS Y VENTAS =========");
			System.out.println("+-----------+-------------+-----------+-------------+----------------+");
			System.out.println("| ID Compra | Fecha Compra| ID Venta  | Fecha Venta | Nombre Producto|");
			System.out.println("+-----------+-------------+-----------+-------------+----------------+");

			while (rs.next()) {
				int idCompra = rs.getInt("id_compra");
				String fechaCompra = rs.getString("fecha_compra");
				int idVenta = rs.getInt("id_venta");
				String fechaVenta = rs.getString("fecha_venta");
				String nombreProducto = rs.getString("producto");

				System.out.printf("| %-9d | %-11s | %-9d | %-11s | %-14s |\n", idCompra, fechaCompra, idVenta,
						fechaVenta, nombreProducto);
			}

			System.out.println("+-----------+-------------+-----------+-------------+----------------+");
		} catch (SQLException e) {
			System.err.println("Error en JOIN de Compras y Ventas: " + e.getMessage());
		}
	}

}