package com.postulacion.app.dto.tienda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public interface ReporteTransaccionesTienda {

    String getTienda();
    String getFecha();
    int getCantidad();

}
