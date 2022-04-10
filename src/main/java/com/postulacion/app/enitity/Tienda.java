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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","productos","pedidoDetalle"})
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nombre;

    @NonNull
    private String codigo;

    @ManyToMany
    @JoinTable(name="tienda_producto")
    private Set<Producto> productos;

    @OneToMany(mappedBy = "producto", targetEntity = PedidoDetalle.class, fetch=FetchType.LAZY)
    private List<PedidoDetalle> pedidoDetalle;
}
