package com.postulacion.app.repository;

import com.postulacion.app.enitity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Producto findByCodigo(String codigo);
}
