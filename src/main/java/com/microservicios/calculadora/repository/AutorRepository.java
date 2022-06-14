package com.microservicios.calculadora.repository;

import com.microservicios.calculadora.model.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorEntity,Long> {

}
