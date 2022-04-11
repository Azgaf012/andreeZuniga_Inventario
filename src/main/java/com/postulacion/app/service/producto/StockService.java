package com.postulacion.app.service.producto;

public interface StockService {
    void actualizarStock(Long idProducto, int cantidad);

    void actualizarStockAsync(Long idProducto, int cantidad);
}
