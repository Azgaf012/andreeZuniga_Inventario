package com.postulacion.app.enitity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","tiendas","pedidoDetalle"})
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String codigo;

    @NonNull
    private String nombre;

    @NonNull
    private Double precio;

    @NonNull
    private int stock;

    @ManyToMany(mappedBy="productos" , targetEntity = Tienda.class, fetch=FetchType.LAZY)
    private Set<Tienda> tiendas;

    @OneToMany(mappedBy = "producto", targetEntity = PedidoDetalle.class, fetch=FetchType.LAZY)
    private List<PedidoDetalle> pedidoDetalle;

}
