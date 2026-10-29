package com.motorstock.dao;

import com.motorstock.conexion.ConexionBD;
import com.motorstock.modelo.Pieza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PiezaDAO {

    // Insertar sin pasar el id_pieza, dejando que Oracle lo autogenere
    public boolean insertarPieza(Pieza pieza) {
        String sql = "INSERT INTO pieza (nombre, categoria, precio_coste, precio_venta, stock, stock_minimo, id_proveedor) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pieza.getNombre());
            pstmt.setString(2, pieza.getCategoria());
            pstmt.setDouble(3, pieza.getPrecioCoste());
            pstmt.setDouble(4, pieza.getPrecioVenta());
            pstmt.setInt(5, pieza.getStock());
            pstmt.setInt(6, pieza.getStockMinimo());
            pstmt.setInt(7, pieza.getIdProveedor());

            pstmt.executeUpdate();
            System.out.println("¡Pieza insertada correctamente en la base de datos!");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar la pieza: " + e.getMessage());
            return false;
        }
    }

    public List<Pieza> listarPiezas() {
        List<Pieza> lista = new ArrayList<>();
        String sql = "SELECT id_pieza, nombre, categoria, precio_coste, precio_venta, stock, stock_minimo, id_proveedor FROM pieza";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Pieza pieza = new Pieza(
                    rs.getInt("id_pieza"),
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getDouble("precio_coste"),
                    rs.getDouble("precio_venta"),
                    rs.getInt("stock"),
                    rs.getInt("stock_minimo"),
                    rs.getInt("id_proveedor")
                );
                lista.add(pieza);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar las piezas: " + e.getMessage());
        }
        return lista;
    }
}