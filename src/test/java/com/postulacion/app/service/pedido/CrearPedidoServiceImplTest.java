package com.postulacion.app.service.pedido;

import com.postulacion.app.enitity.*;
import com.postulacion.app.repository.PedidoRepository;
import com.postulacion.app.service.cliente.ListarClienteService;
import com.postulacion.app.service.producto.ListarProductoService;
import com.postulacion.app.service.producto.StockService;
import com.postulacion.app.service.producto.ValidarStockService;
import com.postulacion.app.service.tienda.ListarTiendaService;
import com.postulacion.app.service.tienda.ValidarExistenciaProducto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class CrearPedidoServiceImplTest {

    @InjectMocks
    private CrearPedidoService crearPedidoService;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ListarClienteService listarClienteService;

    @Mock
    private ListarTiendaService listarTiendaService;

    @Mock
    private ListarProductoService listarProductoService;

    @Mock
    private ValidarStockService validarStockService;

    @Mock
    private ValidarExistenciaProducto validarExistenciaProducto;

    @Mock
    private StockService stockService;


    private Pedido pedido=new Pedido();


    @BeforeEach
    void setUp() {
        pedido = Pedido.builder()
                .cliente(new Cliente("Pedro","123456",""))
                .fecha(new Date())
                .detalle(Set.of(
                        new PedidoDetalle(
                                new Producto("p-1","prod1",3.2,10),
                                new Tienda("tienda1","t-1"),
                                10,
                                3.2,
                                32),
                        new PedidoDetalle(
                                new Producto("p-2","prod2",4.0,10),
                                new Tienda("tienda2","t-2"),
                                10,
                                4.0,
                                32))
                )
                .build();
    }

    @Test
    void testRegistrarPedido() {
        assertNotNull(pedido);

    }
}