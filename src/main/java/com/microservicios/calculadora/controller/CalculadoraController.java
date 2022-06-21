package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.controller.docs.CalculadoraDocs;
import com.microservicios.calculadora.services.InterfazCalculadoraService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/calculadora")
public class CalculadoraController implements CalculadoraDocs {

    private final InterfazCalculadoraService interfazCalculadoraService;

    @Override
    @GetMapping("/suma")
    public ResponseEntity getSuma(String num1, String num2){
        return interfazCalculadoraService.getSuma(num1, num2);
    }

    @Override
    @GetMapping("/resta")
    public ResponseEntity getResta(String num1, String num2){
        return interfazCalculadoraService.getResta(num1, num2);
    }

    @Override
    @GetMapping("/multiplicacion")
    public ResponseEntity getMultiplicacion(String num1, String num2){
        return interfazCalculadoraService.getMultiplicacion(num1, num2);
    }

    @Override
    @GetMapping("/division")
    public ResponseEntity getDivision(String num1, String num2){
        return interfazCalculadoraService.getDivision(num1, num2);
    }

}
