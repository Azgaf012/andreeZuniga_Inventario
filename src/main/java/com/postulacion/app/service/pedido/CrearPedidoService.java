package com.postulacion.app.service.pedido;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.enitity.Pedido;
import com.postulacion.app.enitity.PedidoDetalle;

import java.util.Set;

public interface CrearPedidoService {

    void registrarPedido(Pedido pedido);

}
