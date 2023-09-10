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
public class Rubro extends ConfiguracionGeneral{
    private String denominacion;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "Rubro_id")
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public void mostrarProductos(){
        System.out.println("PRODUCTOS:");
        for(int i = 0; i < productos.size();i++){
            System.out.println(i+"_ "+productos.get(i).toString());
        }
    }
}
