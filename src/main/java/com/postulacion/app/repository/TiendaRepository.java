package com.postulacion.app.repository;

import com.postulacion.app.enitity.Producto;
import com.postulacion.app.enitity.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Long> {
    Producto findByProductos(Producto producto);
}
