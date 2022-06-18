package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.services.InterfazCalculaCientifService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@AllArgsConstructor
@RestController
@RequestMapping("/calculadora-cientifica")
public class CalculadoraCientifController {

    private final InterfazCalculaCientifService interfazCalculaCientifService;

    @GetMapping("/factorial/{numero}")
    public ResponseEntity getFactorial(@PathVariable String numero){
        return interfazCalculaCientifService.getFactorial(numero);
    }

    @GetMapping("/multiplos/{numero}")
    public ResponseEntity getMultiplos(@PathVariable String numero){
        return interfazCalculaCientifService.getMultiplos(numero);
    }

    /*
     * @return El coseno de un ángulo medido en grados
     */
    @GetMapping("/coseno/{numero}")
    public ResponseEntity getCoseno(@PathVariable String numero){
        return interfazCalculaCientifService.getCoseno(numero);
    }

    @GetMapping("/raiz-cuadrada/{numero}")
    public ResponseEntity getRaizCu(@PathVariable String numero){
        return interfazCalculaCientifService.getRaizCu(numero);
    }

    @GetMapping("/area-circulo/{radio}")
    public ResponseEntity getAreaCir(@PathVariable String radio){
        return interfazCalculaCientifService.getAreaCir(radio);
    }

    @GetMapping("/volumen-esfera/{radio}")
    public ResponseEntity getVolumenEsf(@PathVariable String radio){
        return interfazCalculaCientifService.getVolumenEsf(radio);
    }

    @GetMapping("/ecuacion-cuadratica")
    public ResponseEntity getEcuacionCuad(@PathParam("a") String a, @PathParam("b") String b, @PathParam("c") String c){
        return interfazCalculaCientifService.getEcuacionCuad(a,b,c);
    }

}
