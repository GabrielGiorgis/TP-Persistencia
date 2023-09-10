package com.tpPersistencia.TrabajoPractico1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio extends ConfiguracionGeneral{
    private String calle;
    private String numero;
    private String localidad;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();
    @ManyToOne()
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    public void mostrarPedidos(){
        System.out.println("PEDIDOS");
        for(int i = 0; i < pedidos.size(); i++){
            System.out.println(i+"_ "+pedidos.get(i).toString());
        }
    }
}
