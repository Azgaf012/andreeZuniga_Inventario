package com.postulacion.app.service.producto;

import com.postulacion.app.enitity.Producto;
import com.postulacion.app.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrarProductoServiceImpl implements RegistrarProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ListarProductoService listarProductoService;

    @Override
    public Producto registrarProducto(Producto producto){
        Producto productoBuscado = listarProductoService.buscarProductoCodigo(producto.getCodigo());
        if(productoBuscado == null) {
            return productoRepository.save(producto);
        }
        return productoBuscado;
    }
}
