package com.microservicios.calculadora.services;

import org.springframework.http.ResponseEntity;

public interface InterfazCalculadoraService {

    ResponseEntity getSuma(String num1, String num2);
    ResponseEntity getResta(String num1, String num2);
    ResponseEntity getMultiplicacion(String num1, String num2);
    ResponseEntity getDivision(String num1, String num2);

}
