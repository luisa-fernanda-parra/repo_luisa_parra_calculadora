package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.model.AutorEntity;
import com.microservicios.calculadora.services.IAutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final IAutorService iAutorService;

    public AutorController(IAutorService iAutorService){
        this.iAutorService = iAutorService;
    }

    @PostMapping
    public ResponseEntity guardarAutor(@RequestBody AutorEntity autorEntity) {
        return iAutorService.guardarAutor(autorEntity);
    }

}
