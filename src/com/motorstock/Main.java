package com.motorstock;

import com.motorstock.dao.PiezaDAO;
import com.motorstock.modelo.Pieza;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Probando el sistema MotorStockManager...");

        PiezaDAO piezaDAO = new PiezaDAO();

        // 1. Creamos una pieza nueva sin indicar ID (lo genera Oracle solo)
        // Pasamos: nombre, categoria, precio_coste, precio_venta, stock, stock_minimo, id_proveedor
        Pieza nuevaPieza = new Pieza("Filtro de aceite deportivo", "Filtros", 12.00, 24.50, 20, 5, 1);
        piezaDAO.insertarPieza(nuevaPieza);

        // 2. Listamos todas las piezas de la base de datos
        System.out.println("\n--- LISTADO DE PIEZAS EN STOCK ---");
        List<Pieza> lista = piezaDAO.listarPiezas();
        for (Pieza p : lista) {
            System.out.println(p);
        }
    }
}