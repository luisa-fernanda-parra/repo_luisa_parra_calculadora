package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.services.InterfazCalculadoraService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@AllArgsConstructor
@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    private final InterfazCalculadoraService interfazCalculadoraService;

    @GetMapping("/suma")
    public ResponseEntity getSuma(@PathParam("num1") String num1, @PathParam("num2") String num2){
        return interfazCalculadoraService.getSuma(num1, num2);
    }

    @GetMapping("/resta")
    public ResponseEntity getResta(@PathParam("num1") String num1, @PathParam("num2") String num2){
        return interfazCalculadoraService.getResta(num1, num2);
    }

    @GetMapping("/multiplicacion")
    public ResponseEntity getMultiplicacion(@PathParam("num1") String num1, @PathParam("num2") String num2){
        return interfazCalculadoraService.getMultiplicacion(num1, num2);
    }

    @GetMapping("/division")
    public ResponseEntity getDivision(@PathParam("num1") String num1, @PathParam("num2") String num2){
        return interfazCalculadoraService.getDivision(num1, num2);
    }

}
