package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.services.InterfazCalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    private final InterfazCalculadoraService interfazCalculadoraService;

    public CalculadoraController(InterfazCalculadoraService interfazCalculadoraService){
        this.interfazCalculadoraService = interfazCalculadoraService;
    }

    @GetMapping("/suma/{num1}/{num2}")
    public ResponseEntity getSuma(@PathVariable String num1, @PathVariable String num2){
        return interfazCalculadoraService.getSuma(num1, num2);
    }

    @GetMapping("/resta/{num1}/{num2}")
    public ResponseEntity getResta(@PathVariable String num1, @PathVariable String num2){
        return interfazCalculadoraService.getResta(num1, num2);
    }

    @GetMapping("/multiplicacion/{num1}/{num2}")
    public ResponseEntity getMultiplicacion(@PathVariable String num1, @PathVariable String num2){
        return interfazCalculadoraService.getMultiplicacion(num1, num2);
    }

    @GetMapping("/division/{num1}/{num2}")
    public ResponseEntity getDivision(@PathVariable String num1, @PathVariable String num2){
        return interfazCalculadoraService.getDivision(num1, num2);
    }
}
