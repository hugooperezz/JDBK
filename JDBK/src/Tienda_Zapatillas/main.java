package Tienda_Zapatillas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class main {

	private static final String URL = "jdbc:mysql://localhost:3306/thekickhub?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "Gordo2005.";

	public static void main(String[] args) {
		try {
			Connection conexion = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Conexión establecida con éxito");
		}catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
		}
		
	}

	private static void CrearTablaProductos(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS Productos (" 
				+ "id_producto INT AUTO_INCREMENT PRIMARY KEY, "
				+ "nombre VARCHAR(100) NOT NULL, " 
				+ "marca VARCHAR(50) NOT NULL, " 
				+ "talla DECIMAL(4,1) NOT NULL, "
				+ "precio DECIMAL(10,2) NOT NULL, " 
				+ "stock INT NOT NULL, " 
				+ "FOREIGN KEY (id_proveedor) REFERENCES Proveedores(id_proveedor) ON DELETE SET NULL" + ")";
		stmt.executeUpdate(sql);
		System.out.println("Tabla departamento creada correctamente");
		stmt.close();
	}

	private static void CrearTablaProvedores(Connection conexion) throws SQLException {
		Statement stmt = conexion.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS Proveedores ("
		        + "id_proveedor INT AUTO_INCREMENT PRIMARY KEY, "
		        + "nombre VARCHAR(100) NOT NULL, "
		        + "empresa VARCHAR(100) NOT NULL, "
		        + "telefono VARCHAR(20), "
		        + "direccion VARCHAR(255), "
		        + ")";
		stmt.executeUpdate(sql);
		System.out.println("Tabla Provedores creada correctamente");
		stmt.close();
	}

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

}
