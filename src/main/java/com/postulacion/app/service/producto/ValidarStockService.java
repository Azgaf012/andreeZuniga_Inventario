package com.postulacion.app.service.producto;

import com.postulacion.app.config.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ValidarStockService {

    @Autowired
    private SolicitarStockService solicitarStockService;

    @Autowired
    private StockService stockService;

    public boolean validarStock(int stockProducto, int cantidadPedido, Long idProducto) {
        if(stockProducto-cantidadPedido<-10){
            return false;
        }
        if(stockProducto-cantidadPedido<-5){
            try{
                Map<String,Object> stock = solicitarStockService.solicitar("https://mocki.io/v1/26850e1f-5fc0-4205-8a27-44dbc4e27f4c");
                stockService.actualizarStock(idProducto,Integer.parseInt(stock.get("stock").toString()));
                return true;
            }catch (Exception e){
                throw new BadRequestException("No se pudo solicitar stock");
            }
        }

        if(stockProducto-cantidadPedido<0){

        }
        return true;
    }

}
