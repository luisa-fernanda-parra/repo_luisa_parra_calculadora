package com.microservicios.calculadora.controller;


import com.microservicios.calculadora.services.InterfazSaludoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bienvenida")
public class SaludoController {

    private final InterfazSaludoService interfazSaludoService;

    public SaludoController(InterfazSaludoService interfazSaludoService){

        this.interfazSaludoService = interfazSaludoService;

    }

    @GetMapping("/saludo/{hora}")
    public ResponseEntity getSaludo(@PathVariable String hora){

        return interfazSaludoService.getSaludo(hora);

    }

    @GetMapping("/operaciones")
    public ResponseEntity getOperaciones(){

        return interfazSaludoService.getOperaciones();

    }

}
