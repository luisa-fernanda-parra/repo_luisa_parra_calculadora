package com.microservicios.calculadora.services;

import com.microservicios.calculadora.model.AutorEntity;
import org.springframework.http.ResponseEntity;

public interface IAutorService {

    ResponseEntity guardarAutor(AutorEntity autorEntity);

}
