package com.postulacion.app.service.pedido;

import com.postulacion.app.config.exception.BadRequestException;
import com.postulacion.app.enitity.*;
import com.postulacion.app.repository.PedidoRepository;
import com.postulacion.app.service.cliente.ListarClienteService;
import com.postulacion.app.service.producto.ListarProductoService;
import com.postulacion.app.service.producto.StockService;
import com.postulacion.app.service.producto.ValidarStockService;
import com.postulacion.app.service.tienda.ListarTiendaService;
import com.postulacion.app.service.tienda.ValidarExistenciaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CrearPedidoServiceImpl implements CrearPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ListarClienteService listarClienteService;

    @Autowired
    private ListarTiendaService listarTiendaService;

    @Autowired
    private ListarProductoService listarProductoService;

    @Autowired
    private ValidarStockService validarStockService;

    @Autowired
    private ValidarExistenciaProducto validarExistenciaProducto;

    @Autowired
    private StockService stockService;

    @Override
    public void registrarPedido(Pedido pedido) {
        List<String> errores = new ArrayList<String>();

        if(pedido.getCliente() == null || pedido.getCliente().getId() == null){
            errores.add("No ingreso el cliente");
        }

        Cliente cliente = listarClienteService.obtenerCliente(pedido.getCliente().getId());
        if(cliente == null){
            errores.add("El cliente no existe");
        }



        Set<PedidoDetalle> detalles= this.validarPedidoDetalle(pedido.getDetalle(),errores);

        if(errores.size() > 0){
            throw new BadRequestException(errores.stream().collect(Collectors.joining("\n")));
        }

        detalles.stream().forEach(detalle -> {
            stockService.actualizarStock(detalle.getProducto().getId(), -detalle.getCantidad());
        });

        double total = detalles.stream().mapToDouble(detalle -> detalle.getTotal()).sum();

        Pedido pedidoNuevo = new Pedido();
        pedidoNuevo.setCliente(cliente);
        //pedidoNuevo.setDetalle(detalles);
        pedidoNuevo.setTotal(total);
        Pedido predidoCreado = pedidoRepository.save(pedidoNuevo);
        detalles = detalles.stream().map(detalle -> {
            detalle.setPedido(predidoCreado);
            return detalle;
        }).collect(Collectors.toSet());
        predidoCreado.setDetalle(detalles);
        pedidoRepository.save(predidoCreado);
    }

    private Set<PedidoDetalle> validarPedidoDetalle(Set<PedidoDetalle> detalles, List<String> errores){

        return detalles.stream().map(detalle -> {
            if(detalle.getCantidad() <= 0){
                errores.add("La cantidad debe ser mayor a 0");
            }

            if(detalle.getProducto()== null || detalle.getProducto().getId() == null || detalle.getTienda()== null || detalle.getTienda().getId() == null){
                errores.add("No ingreso el producto o tienda en todos los detalles del pedido");
                return null;
            }

            Producto producto = listarProductoService.buscarProductoId(detalle.getProducto().getId());
            if(producto == null){
                errores.add("El producto con id " + detalle.getProducto().getId() +" no existe");
            }

            Tienda tienda = listarTiendaService.listarTienda(detalle.getTienda().getId());

            if(tienda == null){
                errores.add("La tienda con id " + detalle.getTienda().getId() +" no existe");
            }

            if(producto==null || tienda==null || detalle.getCantidad() <= 0){
                return null;
            }

            if(!validarExistenciaProducto.existeProducto(tienda.getId(), producto)){
                errores.add("El producto " + producto.getNombre() + " no existe en la tienda " + tienda.getNombre());
                return null;
            }

            if(!validarStockService.validarStock(producto.getStock(), detalle.getCantidad(),producto.getId())){
                errores.add("El producto con id " + detalle.getProducto().getId() +" no tiene stock suficiente");
            }



            PedidoDetalle pedidoDetalle = new PedidoDetalle();

            pedidoDetalle.setCantidad(detalle.getCantidad());
            pedidoDetalle.setProducto(producto);
            pedidoDetalle.setTienda(tienda);
            pedidoDetalle.setCantidad(detalle.getCantidad());
            pedidoDetalle.setPrecio(producto.getPrecio());

            pedidoDetalle.setTotal(detalle.getCantidad()*producto.getPrecio());

            return pedidoDetalle;

        }).collect(Collectors.toSet());

    }


}
