package com.microservicios.calculadora.sample;

import org.springframework.http.ResponseEntity;

public class CalculadoraControllerSample {

    public static ResponseEntity getEntradaInvalida(){
        return ResponseEntity.ok("Entrada invalida");
    }

}
