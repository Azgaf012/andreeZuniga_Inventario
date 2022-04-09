package com.postulacion.app.service.producto;

import com.postulacion.app.enitity.Producto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ListarProductoService {
    List<Producto> listarProductos();
    Producto buscarProductoCodigo(String codigo);
    Producto buscarProductoId(Long id);

}
