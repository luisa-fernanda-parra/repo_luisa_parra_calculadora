package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.controller.docs.EmpleadoDocs;
import com.microservicios.calculadora.services.IEmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/empleado")
public class EmpleadoController implements EmpleadoDocs {

    private final IEmpleadoService iEmpleadoService;

    @Override
    @GetMapping("/lista-empleados")
    public ResponseEntity getListaEmpleados() {
        return iEmpleadoService.listarEmpleados();
    }

    @Override
    @GetMapping("/mayores-de-30")
    public ResponseEntity getListaEmpleadosMayores30() {
        return iEmpleadoService.listarEmpleadosMayores30();
    }

    @Override
    @GetMapping("/obtener-empleado/{id}")
    public ResponseEntity getEmpleado(Long id) {
        return iEmpleadoService.getEmpleado(id);
    }

    @Override
    @GetMapping("/sueldo-mayor-100000")
    public ResponseEntity getListaEmpleadosSueldo() {
        return iEmpleadoService.listarEmpleadosSueldo();
    }

}
