package com.motorstock;

import com.motorstock.conexion.ConexionBD;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Probando la conexión a la base de datos...");
        Connection conexion = ConexionBD.obtenerConexion();
        
        if (conexion != null) {
            System.out.println("¡Todo funciona perfectamente!");
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
}
