package com.postulacion.app.service.tienda;

import com.postulacion.app.enitity.Producto;
import com.postulacion.app.enitity.Tienda;
import com.postulacion.app.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarExistenciaProducto {

    @Autowired
    private TiendaRepository   tiendaRepository;

    public boolean existeProducto(Long idTienda, Producto producto) {
        Tienda tienda = tiendaRepository.findById(idTienda).orElse(null);

        if(tienda.getProductos().contains(producto)){
            return true;
        }
        return false;
    }
}
