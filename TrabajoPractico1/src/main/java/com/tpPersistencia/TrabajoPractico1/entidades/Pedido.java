package com.tpPersistencia.TrabajoPractico1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido extends ConfiguracionGeneral{
    private String fecha;
    public enum Estado{INICIADO, PREPARACION, ENTREGADO};
    private Estado estado;
    private LocalDate horaEstimadaEntrega;
    public enum TipoEnvio{DELIVERY, RETIRA};
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoenvio;
    private Double total;
    @OneToOne( orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private Factura factura;
    @OneToMany( orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "pedido_id")
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido detallePedido){
        detallePedidos.add(detallePedido);
    }
    public void mostrarDetallePedidos(){
        System.out.println("DETALLES DE LOS PEDIDOS");
        for(int i = 0; i < detallePedidos.size(); i++){
            System.out.println(i+"_ "+ detallePedidos.get(i).toString());
        }
    }
}
