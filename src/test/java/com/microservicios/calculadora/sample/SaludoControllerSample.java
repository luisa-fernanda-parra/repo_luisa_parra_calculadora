package com.microservicios.calculadora.sample;

import org.springframework.http.ResponseEntity;

public class SaludoControllerSample {

    public static ResponseEntity saludo(){
        return ResponseEntity.ok("Buenos dias");
    }

    public static ResponseEntity operaciones(){
        String mensaje = "Operaciones disponibles:\nsumar\nrestar\nmultiplicar\ndividir\nfactorial\nmultiplos\ncoseno\nraiz cuadrada\narea de un circulo\nvolumen de una esfera\necuacion cuadratica";
        return ResponseEntity.ok(mensaje);
    }

}
