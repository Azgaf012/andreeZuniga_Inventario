package com.postulacion.app.service.producto;

import com.postulacion.app.enitity.Producto;
import com.postulacion.app.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarProductoServiceImpl implements ListarProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarProductoCodigo(String codigo) {
        Producto producto = productoRepository.findByCodigo(codigo);
        return producto;
    }

    public Producto buscarProductoId(Long id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        return producto;
    }
}
