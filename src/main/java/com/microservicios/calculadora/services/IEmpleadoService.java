package com.microservicios.calculadora.services;

import org.springframework.http.ResponseEntity;

public interface IEmpleadoService {

    ResponseEntity listarEmpleados();

    ResponseEntity listarEmpleadosMayores30();

    ResponseEntity getEmpleado(Long id);

    ResponseEntity listarEmpleadosSueldo();

}
