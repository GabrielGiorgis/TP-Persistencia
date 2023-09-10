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
public class Cliente extends ConfiguracionGeneral{
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "cliente_id")
    private List<Pedido> pedidos = new ArrayList<>();

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
