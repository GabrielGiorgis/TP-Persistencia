package com.tpPersistencia.TrabajoPractico1.repositorios;

import com.tpPersistencia.TrabajoPractico1.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
