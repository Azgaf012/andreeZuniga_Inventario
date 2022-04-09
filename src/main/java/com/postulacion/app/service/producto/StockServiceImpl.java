package com.postulacion.app.service.producto;

import com.postulacion.app.config.exception.BadRequestException;
import com.postulacion.app.enitity.Producto;
import com.postulacion.app.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void actualizarStock(Long idProducto, int cantidad) {
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        if (producto == null) {
            throw new BadRequestException("El producto no existe");
        }

        int nuevoStock = producto.getStock() + cantidad;
        if(nuevoStock <= 0){
            throw new BadRequestException("No hay stock suficiente");
        }
        producto.setStock(nuevoStock);
        productoRepository.save(producto);
    }
}
