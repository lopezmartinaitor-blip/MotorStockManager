package com.motorstock.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // URL modificada para conectar a la base de datos pluggable XEPDB1
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String USUARIO = "motorstock";
    private static final String PASSWORD = "admin123";

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("¡Conexión exitosa con la base de datos motorstock!");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}