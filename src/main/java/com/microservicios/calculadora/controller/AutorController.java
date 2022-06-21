package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.controller.docs.AutorDocs;
import com.microservicios.calculadora.dto.AutorDTO;
import com.microservicios.calculadora.services.IAutorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/autor")
public class AutorController implements AutorDocs {

    private final IAutorService iAutorService;

    @Override
    @PostMapping
    public ResponseEntity guardarAutor(AutorDTO autorDTO) {
        return iAutorService.guardarAutor(autorDTO);
    }

    @Override
    @GetMapping("/listar-autores")
    public ResponseEntity listarAutores(){
        return iAutorService.listarAutores();
     }

    @Override
    @GetMapping("/listar-autores-por-nombre/native-query/{nombre}")
    public ResponseEntity listarAutPorNombreNativeQuery(String nombre){
        return iAutorService.listarAutPorNombreNativeQuery(nombre);
    }

    @Override
    @GetMapping("/listar-autores-por-nombre/jpql/{nombre}")
    public ResponseEntity listarAutPorNombreJpql(String nombre){
        return iAutorService.listarAutPorNombreJpql(nombre);
    }

    @Override
    @GetMapping("/listar-autores-por-nombre/jpa-repository/{nombre}")
    public ResponseEntity listarAutPorNombreJpaRepository(String nombre){
        return iAutorService.listarAutPorNombreJpaRepository(nombre);
    }

    @Override
    @GetMapping("/listar-autores-por-fecha-creacion/native-query/{fecha}")
    public ResponseEntity listarAutPorFechaCNativeQuery(String fecha){
        return iAutorService.listarAutPorFechaCNativeQuery(fecha);
    }

    @Override
    @GetMapping("/listar-autores-por-fecha-creacion/jpql")
    public ResponseEntity listarAutPorFechaCJpql(String year, String month, String day){
        return iAutorService.listarAutPorFechaCJpql(year, month, day);
    }

    @Override
    @GetMapping("/listar-autores-por-fecha-creacion/jpa-repository")
    public ResponseEntity listarAutPorFechaCJpaRepository(String year, String month, String day){
        return iAutorService.listarAutPorFechaCJpaRepository(year, month, day);
    }

    @Override
    @GetMapping("/listar-autor-por-id/native-query/{id}")
    public ResponseEntity listarAutPorIdNativeQuery(String id){
        return iAutorService.listarAutPorIdNativeQuery(id);
    }

    @Override
    @GetMapping("/listar-autor-por-id/jpql/{id}")
    public ResponseEntity listarAutPorIdJpql(String id){
        return iAutorService.listarAutPorIdJpql(id);
    }

    @Override
    @GetMapping("/listar-autor-por-id/jpa-repository/{id}")
    public ResponseEntity listarAutPorIdJpaRepository(String id){
        return iAutorService.listarAutPorIdJpaRepository(id);
    }

    @Override
    @PutMapping("/actualizar-nombre-apellido/{id}")
    public ResponseEntity actualizarAutor(Long id, AutorDTO autorDTO){
        return iAutorService.actualizarAutor(id, autorDTO);
    }

    @Override
    @DeleteMapping("/borrar-autor/{id}")
    public ResponseEntity deleteHard(Long id){
        return iAutorService.deleteHard(id);
    }

    @Override
    @PutMapping("/borrar-autor-logico/{id}")
    public ResponseEntity deleteLogic(Long id){
        return iAutorService.deleteLogic(id);
    }

}
