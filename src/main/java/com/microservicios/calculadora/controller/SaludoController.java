package com.microservicios.calculadora.controller;


import com.microservicios.calculadora.controller.docs.SaludoDocs;
import com.microservicios.calculadora.services.InterfazSaludoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/bienvenida")
public class SaludoController implements SaludoDocs {

    private final InterfazSaludoService interfazSaludoService;

    @Override
    @GetMapping("/saludo/{hora}")
    public ResponseEntity getSaludo(String hora){
        return interfazSaludoService.getSaludo(hora);
    }

    @Override
    @GetMapping("/operaciones")
    public ResponseEntity getOperaciones(){
        return interfazSaludoService.getOperaciones();
    }

}
