package com.motorstock.vista;

import com.motorstock.dao.PiezaDAO;
import com.motorstock.modelo.Pieza;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {

    private JTable tablaPiezas;
    private DefaultTableModel modeloTabla;
    private JTextField txtBuscar;
    private PiezaDAO piezaDAO;

    public VentanaPrincipal() {
        piezaDAO = new PiezaDAO();

        setTitle("MotorStockManager - Gestión de Inventario");
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- PANEL SUPERIOR (Buscador y Título) ---
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        panelSuperior.setBackground(new Color(45, 45, 45));

        JLabel lblTitulo = new JLabel("Inventario de Piezas");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));

        txtBuscar = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        JButton btnRecargar = new JButton("Mostrar Todas");

        btnBuscar.setBackground(new Color(0, 122, 204));
        btnBuscar.setForeground(Color.WHITE);
        btnRecargar.setBackground(new Color(60, 60, 60));
        btnRecargar.setForeground(Color.WHITE);

        panelSuperior.add(lblTitulo);
        panelSuperior.add(new JLabel("   Filtrar:"));
        panelSuperior.add(txtBuscar);
        panelSuperior.add(btnBuscar);
        panelSuperior.add(btnRecargar);

        add(panelSuperior, BorderLayout.NORTH);

        // --- TABLA CENTRAL ---
        String[] columnas = {"ID", "Nombre", "Categoría", "Precio Coste", "Precio Venta", "Stock", "Stock Mín."};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaPiezas = new JTable(modeloTabla);
        
        JScrollPane scrollPane = new JScrollPane(tablaPiezas);
        add(scrollPane, BorderLayout.CENTER);

        // Cargar datos iniciales
        cargarTabla(piezaDAO.listarPiezas());

        // --- ACCIONES DE LOS BOTONES ---
        btnRecargar.addActionListener(e -> cargarTabla(piezaDAO.listarPiezas()));
        btnBuscar.addActionListener(e -> filtrarPiezas());
        txtBuscar.addActionListener(e -> filtrarPiezas());
    }

    private void cargarTabla(List<Pieza> lista) {
        modeloTabla.setRowCount(0);
        for (Pieza p : lista) {
            Object[] fila = {
                p.getIdPieza(),
                p.getNombre(),
                p.getCategoria(),
                p.getPrecioCoste() + " €",
                p.getPrecioVenta() + " €",
                p.getStock(),
                p.getStockMinimo()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void filtrarPiezas() {
        String texto = txtBuscar.getText().toLowerCase();
        List<Pieza> todas = piezaDAO.listarPiezas();
        List<Pieza> filtradas = new java.util.ArrayList<>();

        for (Pieza p : todas) {
            if (p.getNombre().toLowerCase().contains(texto) || p.getCategoria().toLowerCase().contains(texto)) {
                filtradas.add(p);
            }
        }
        cargarTabla(filtradas);
    }
}