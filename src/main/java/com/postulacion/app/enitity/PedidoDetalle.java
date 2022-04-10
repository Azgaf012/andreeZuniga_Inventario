package com.postulacion.app.enitity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    @NonNull
    private Producto producto;

    @OneToOne
    @JoinColumn(name = "tienda_id")
    @NonNull
    private Tienda tienda;

    @NonNull
    private int cantidad;

    @NonNull
    private double precio;

    @NonNull
    private double total;
}
