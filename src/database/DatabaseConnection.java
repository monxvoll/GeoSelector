package database;

import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) {
        String databasePath = "C:/ruta/a/tu/archivo.accdb"; // Cambia esto por tu ruta real
        String url = "jdbc:ucanaccess://" + databasePath;

        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Conexión exitosa a Access");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TuTabla");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") + ", Nombre: " + rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
