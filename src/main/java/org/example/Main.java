package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        String sql = "SELECT COUNT(*) AS total " +
                "FROM EMPLEADO " +
                "WHERE SALARIO > 3000";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            if (rs.next()) {
                int cantidad = rs.getInt("total");

                System.out.println("Número de empleados con salario > 3000: " + cantidad);
            }

        } catch (SQLException e) {
            System.out.println("Error al realizar el conteo: " + e.getMessage());
        }
    }
}
