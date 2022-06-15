package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.dto.AutorDTO;
import com.microservicios.calculadora.model.AutorEntity;
import com.microservicios.calculadora.services.IAutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final IAutorService iAutorService;

    public AutorController(IAutorService iAutorService){
        this.iAutorService = iAutorService;
    }

    @PostMapping
    public ResponseEntity guardarAutor(@RequestBody AutorEntity autorEntity) {
        return iAutorService.guardarAutor(autorEntity);
    }

    @GetMapping("/listar-autores")
    public ResponseEntity listarAutores(){
        return iAutorService.listarAutores();
     }

    @GetMapping("/listar-autores-por-nombre/native-query/{nombre}")
    public ResponseEntity listarAutPorNombreNativeQuery(@PathVariable String nombre){
        return iAutorService.listarAutPorNombreNativeQuery(nombre);
    }

    @GetMapping("/listar-autores-por-nombre/jpql/{nombre}")
    public ResponseEntity listarAutPorNombreJpql(@PathVariable String nombre){
        return iAutorService.listarAutPorNombreJpql(nombre);
    }

    @GetMapping("/listar-autores-por-nombre/jpa-repository/{nombre}")
    public ResponseEntity listarAutPorNombreJpaRepository(@PathVariable String nombre){
        return iAutorService.listarAutPorNombreJpaRepository(nombre);
    }

    @GetMapping("/listar-autores-por-fecha-creacion/native-query/{fecha}")
    public ResponseEntity listarAutPorFechaCNativeQuery(@PathVariable String fecha){
        return iAutorService.listarAutPorFechaCNativeQuery(fecha);
    }

    @GetMapping("/listar-autores-por-fecha-creacion/jpql/{a}/{m}/{d}")
    public ResponseEntity listarAutPorFechaCJpql(@PathVariable String a, @PathVariable String m, @PathVariable String d){
        return iAutorService.listarAutPorFechaCJpql(a, m, d);
    }

    @GetMapping("/listar-autores-por-fecha-creacion/jpa-repository/{a}/{m}/{d}")
    public ResponseEntity listarAutPorFechaCJpaRepository(@PathVariable String a, @PathVariable String m, @PathVariable String d){
        return iAutorService.listarAutPorFechaCJpaRepository(a, m, d);
    }

    @GetMapping("/listar-autor-por-id/native-query/{id}")
    public ResponseEntity listarAutPorIdNativeQuery(@PathVariable String id){
        return iAutorService.listarAutPorIdNativeQuery(id);
    }

    @GetMapping("/listar-autor-por-id/jpql/{id}")
    public ResponseEntity listarAutPorIdJpql(@PathVariable String id){
        return iAutorService.listarAutPorIdJpql(id);
    }

    @GetMapping("/listar-autor-por-id/jpa-repository/{id}")
    public ResponseEntity listarAutPorIdJpaRepository(@PathVariable String id){
        return iAutorService.listarAutPorIdJpaRepository(id);
    }

    @PutMapping("/actualizar-nombre-apellido/{id}")
    public ResponseEntity actualizarAutor(@PathVariable Long id, @RequestBody AutorDTO autorDTO){
        return iAutorService.actualizarAutor(id, autorDTO);
    }

}
