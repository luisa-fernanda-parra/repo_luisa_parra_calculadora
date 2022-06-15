package com.microservicios.calculadora.services;

import com.microservicios.calculadora.dto.AutorDTO;
import com.microservicios.calculadora.model.AutorEntity;
import org.springframework.http.ResponseEntity;

public interface IAutorService {

    ResponseEntity guardarAutor(AutorEntity autorEntity);

    ResponseEntity listarAutores();

    ResponseEntity listarAutPorNombreNativeQuery(String nombre);

    ResponseEntity listarAutPorNombreJpql(String nombre);

    ResponseEntity listarAutPorNombreJpaRepository(String nombre);

    ResponseEntity listarAutPorFechaCNativeQuery(String fecha);

    ResponseEntity listarAutPorFechaCJpql(String a, String m, String d);

    ResponseEntity listarAutPorFechaCJpaRepository(String a, String m, String d);

    ResponseEntity listarAutPorIdNativeQuery(String id);

    ResponseEntity listarAutPorIdJpql(String id);

    ResponseEntity listarAutPorIdJpaRepository(String id);

    ResponseEntity actualizarAutor(Long id, AutorDTO autorDTO);

}
