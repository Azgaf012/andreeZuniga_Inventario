package com.postulacion.app.repository;

import com.postulacion.app.dto.tienda.ReporteTransaccionesTienda;
import com.postulacion.app.dto.tienda.ReporteVentasProductoTienda;
import com.postulacion.app.enitity.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Long> {

    @Query(value = "select t.nombre as tienda, DATE_FORMAT(p.fecha,'%d-%m-%Y') as fecha, count(*) as cantidad\n" +
            "from pedido_detalle pd \n" +
            "join tienda t on t.id=pd.tienda_id \n" +
            "join pedido p on p.id=pd.pedido_id \n" +
            "group by tienda, fecha", nativeQuery = true)
    List<ReporteTransaccionesTienda> reporteTransaccionesTienda();


    @Query(value = "select t.nombre as tienda, p.nombre as producto, sum(pd.total) as monto\n" +
            "from pedido_detalle pd\n" +
            "join tienda t on t.id=pd.tienda_id\n" +
            "join producto p on p.id=pd.producto_id\n" +
            "group by tienda, producto", nativeQuery = true)
    List<ReporteVentasProductoTienda> reporteVentasTiendaProducto();


}
