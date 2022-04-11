package com.postulacion.app.service.producto;

import com.postulacion.app.config.exception.BadRequestException;
import com.postulacion.app.enitity.Producto;
import com.postulacion.app.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SolicitarStockService solicitarStockService;

    @Override
    public void actualizarStock(Long idProducto, int cantidad) {
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        if (producto == null) {
            throw new BadRequestException("El producto no existe");
        }

        int nuevoStock = producto.getStock() + cantidad;
        if(nuevoStock < 0){
            throw new BadRequestException("No hay stock suficiente");
        }
        producto.setStock(nuevoStock);
        productoRepository.save(producto);
    }

    @Override
    @Async("asyncExecutor")
    public void actualizarStockAsync(Long idProducto, int cantidad) {
        Producto producto = productoRepository.findById(idProducto).orElse(null);


        int nuevoStock = producto.getStock() + cantidad;
        if(nuevoStock >= -5 && nuevoStock <= 0){
            try {
                Map<String, Object> stock = solicitarStockService.solicitar("https://mocki.io/v1/aa7b91c2-8111-448e-b87b-1073d00abd35");
                nuevoStock += Integer.parseInt(stock.get("stock").toString());
            } catch (Exception e) {

            }
        }

        producto.setStock(nuevoStock);
        productoRepository.save(producto);
    }
}
