package com.postulacion.app.service.tienda;

import com.postulacion.app.config.exception.BadRequestException;
import com.postulacion.app.enitity.Producto;
import com.postulacion.app.enitity.Tienda;
import com.postulacion.app.repository.ProductoRepository;
import com.postulacion.app.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionProductoServiceImpl implements AsignacionProductoService {

    @Autowired
    private TiendaRepository tiendaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void asignarProducto(Long idTienda,Long idProducto) {
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        Tienda tienda = tiendaRepository.findById(idTienda).orElse(null);

        if(tienda==null){
            throw new BadRequestException("La tienda no existe");
        }

        if(producto==null){
            throw new BadRequestException("El producto no existe");
        }

        if(tienda.getProductos().contains(producto)) {
            throw new BadRequestException("El producto ya esta asignado a la tienda");
        }
        tienda.getProductos().add(producto);
        tiendaRepository.save(tienda);

    }
}
