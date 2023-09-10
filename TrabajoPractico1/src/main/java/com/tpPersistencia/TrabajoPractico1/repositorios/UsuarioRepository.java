package com.tpPersistencia.TrabajoPractico1.repositorios;

import com.tpPersistencia.TrabajoPractico1.entidades.Factura;
import com.tpPersistencia.TrabajoPractico1.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
