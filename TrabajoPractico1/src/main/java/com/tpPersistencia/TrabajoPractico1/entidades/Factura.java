package com.tpPersistencia.TrabajoPractico1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura extends ConfiguracionGeneral{
    private LocalDate fecha;
    private int numero;
    private Double descuento;
    public enum FormaPago{EFECTIVO, CREDITO, DEBITO, MERCADOPAGO};
    @Enumerated(EnumType.STRING)
    private FormaPago formapago;
    private int total;
}
