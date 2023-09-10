package com.tpPersistencia.TrabajoPractico1.repositorios;

import com.tpPersistencia.TrabajoPractico1.entidades.Domicilio;
import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
