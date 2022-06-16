package com.microservicios.calculadora.repository;

import com.microservicios.calculadora.model.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface AutorRepository extends JpaRepository<AutorEntity,Long> {

    @Query(value = "select u.* from autor u where u.nombre=:nombre", nativeQuery = true)
    List<AutorEntity> buscarPorNombreNativeQuery(String nombre);

    @Query("select u from AutorEntity u where u.nombre=:nombre")
    List<AutorEntity> buscarPorNombreJpql(String nombre);

    List<AutorEntity> findByNombre(String nombre);

    @Query(value = "select u.* from autor u where u.fecha_creacion=:fecha", nativeQuery = true)
    List<AutorEntity> buscarPorFechaCNativeQuery(String fecha);

    @Query("select u from AutorEntity u where u.fechaCreacion=:fecha")
    List<AutorEntity> buscarPorFechaCJpql(Date fecha);

    List<AutorEntity> findByFechaCreacion(Date fecha);

    @Query(value = "select u.* from autor u where u.id_autor=:id", nativeQuery = true)
    AutorEntity buscarPorIdNativeQuery(String id);

    @Query("select u from AutorEntity u where u.id=:id")
    AutorEntity buscarPorIdJpql(long id);

    AutorEntity findById(long id);

}
