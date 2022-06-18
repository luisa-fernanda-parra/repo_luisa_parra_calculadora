package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.dto.AutorDTO;
import com.microservicios.calculadora.services.IAutorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@AllArgsConstructor
@RestController
@RequestMapping("/autor")
public class AutorController {

    private final IAutorService iAutorService;

    @PostMapping
    public ResponseEntity guardarAutor(@RequestBody AutorDTO autorDTO) {
        return iAutorService.guardarAutor(autorDTO);
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

    @GetMapping("/listar-autores-por-fecha-creacion/jpql")
    public ResponseEntity listarAutPorFechaCJpql(@PathParam("year") String year, @PathParam("month") String month, @PathParam("day") String day){
        return iAutorService.listarAutPorFechaCJpql(year, month, day);
    }

    @GetMapping("/listar-autores-por-fecha-creacion/jpa-repository")
    public ResponseEntity listarAutPorFechaCJpaRepository(@PathParam("year") String year, @PathParam("month") String month, @PathParam("day") String day){
        return iAutorService.listarAutPorFechaCJpaRepository(year, month, day);
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

    @DeleteMapping("/borrar-autor/{id}")
    public ResponseEntity deleteHard(@PathVariable Long id){
        return iAutorService.deleteHard(id);
    }

    @PutMapping("/borrar-autor-logico/{id}")
    public ResponseEntity deleteLogic(@PathVariable Long id){
        return iAutorService.deleteLogic(id);
    }

}
