package com.tpPersistencia.TrabajoPractico1.repositorios;

import com.tpPersistencia.TrabajoPractico1.entidades.Factura;
import com.tpPersistencia.TrabajoPractico1.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends JpaRepository<Rubro, Long> {
}
