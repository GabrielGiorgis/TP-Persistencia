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
public class Usuario extends ConfiguracionGeneral{
    private String nombre;
    private String password;
    private String rol;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "Usuario_id")
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    public void mostrarPedidos(){
        System.out.println("PEDIDOS CARGADOS:");
        for (int i = 0; i < pedidos.size(); i++){
            System.out.println(i+"_ "+pedidos.get(i).toString());
        }
    }
}
