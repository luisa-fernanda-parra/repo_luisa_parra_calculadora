package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.services.InterfazCalculaCientifService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora-cientifica")
public class CalculadoraCientifController {

    private final InterfazCalculaCientifService interfazCalculaCientifService;

    public CalculadoraCientifController(InterfazCalculaCientifService interfazCalculaCientifService){
        this.interfazCalculaCientifService = interfazCalculaCientifService;
    }

    @GetMapping("/factorial/{numero}")
    public ResponseEntity getFactorial(@PathVariable String numero){
        return interfazCalculaCientifService.getFactorial(numero);
    }

    @GetMapping("/multiplos/{numero}")
    public ResponseEntity getMultiplos(@PathVariable String numero){
        return interfazCalculaCientifService.getMultiplos(numero);
    }

    //coseno de un ángulo en grados
    @GetMapping("/coseno/{numero}")
    public ResponseEntity getCoseno(@PathVariable String numero){
        return interfazCalculaCientifService.getCoseno(numero);
    }

    @GetMapping("/raiz-cuadrada/{numero}")
    public ResponseEntity getRaizCu(@PathVariable String numero){
        return interfazCalculaCientifService.getRaizCu(numero);
    }

    @GetMapping("/area-circulo/{radio}")
    public ResponseEntity getAreaCir(@PathVariable String radio){
        return interfazCalculaCientifService.getAreaCir(radio);
    }

    //EXTRA 1: volumen de una esfera
    @GetMapping("/volumen-esfera/{radio}")
    public ResponseEntity getVolumenEsf(@PathVariable String radio){
        return interfazCalculaCientifService.getVolumenEsf(radio);
    }

    //EXTRA 2: ecuación cuadrática
    @GetMapping("/ecuacion-cuadratica/{a}/{b}/{c}")
    public ResponseEntity getEcuacionCuad(@PathVariable String a, @PathVariable String b, @PathVariable String c){
        return interfazCalculaCientifService.getEcuacionCuad(a,b,c);
    }
}
