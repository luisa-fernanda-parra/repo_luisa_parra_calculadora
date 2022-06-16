package com.microservicios.calculadora.services;

import org.springframework.http.ResponseEntity;

public interface InterfazSaludoService {

    ResponseEntity getSaludo(String hora);

    ResponseEntity getOperaciones();

}
