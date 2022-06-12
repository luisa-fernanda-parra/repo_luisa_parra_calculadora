package com.microservicios.calculadora.services;

import org.springframework.http.ResponseEntity;

public interface InterfazCalculaCientifService {

    ResponseEntity getFactorial(String numero);

    ResponseEntity getMultiplos(String numero);

    ResponseEntity getCoseno(String numero);

    ResponseEntity getRaizCu(String numero);

    ResponseEntity getAreaCir(String radio);

    ResponseEntity getVolumenEsf(String radio);

    ResponseEntity getEcuacionCuad(String a, String b, String c);
}
