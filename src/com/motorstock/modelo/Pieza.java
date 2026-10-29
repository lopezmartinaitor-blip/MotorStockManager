package com.motorstock.modelo;

public class Pieza {
    private int idPieza;
    private String nombre;
    private String categoria;
    private double precioCoste;
    private double precioVenta;
    private int stock;
    private int stockMinimo;
    private int idProveedor;

    public Pieza() {
    }

    // Constructor sin ID (ideal para inserciones, ya que Oracle lo genera solo)
    public Pieza(String nombre, String categoria, double precioCoste, double precioVenta, int stock, int stockMinimo, int idProveedor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioCoste = precioCoste;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.idProveedor = idProveedor;
    }

    // Constructor completo (por si recuperamos de la BDD con su ID real)
    public Pieza(int idPieza, String nombre, String categoria, double precioCoste, double precioVenta, int stock, int stockMinimo, int idProveedor) {
        this.idPieza = idPieza;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioCoste = precioCoste;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.idProveedor = idProveedor;
    }

    // Getters y Setters
    public int getIdPieza() { return idPieza; }
    public void setIdPieza(int idPieza) { this.idPieza = idPieza; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public double getPrecioCoste() { return precioCoste; }
    public void setPrecioCoste(double precioCoste) { this.precioCoste = precioCoste; }

    public double getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    @Override
    public String toString() {
        return "Pieza [ID=" + idPieza + ", Nombre=" + nombre + ", Categoría=" + categoria + 
               ", Venta=" + precioVenta + "€, Stock=" + stock + "]";
    }
}