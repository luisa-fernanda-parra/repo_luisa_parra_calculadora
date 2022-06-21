package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.controller.docs.CalculadoraCientifDocs;
import com.microservicios.calculadora.services.InterfazCalculaCientifService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/calculadora-cientifica")
public class CalculadoraCientifController implements CalculadoraCientifDocs {

    private final InterfazCalculaCientifService interfazCalculaCientifService;

    @Override
    @GetMapping("/factorial/{numero}")
    public ResponseEntity getFactorial(String numero){
        return interfazCalculaCientifService.getFactorial(numero);
    }

    @Override
    @GetMapping("/multiplos/{numero}")
    public ResponseEntity getMultiplos(String numero){
        return interfazCalculaCientifService.getMultiplos(numero);
    }

    /*
     * @return El coseno de un ángulo medido en grados
     */
    @Override
    @GetMapping("/coseno/{numero}")
    public ResponseEntity getCoseno(String numero){
        return interfazCalculaCientifService.getCoseno(numero);
    }

    @Override
    @GetMapping("/raiz-cuadrada/{numero}")
    public ResponseEntity getRaizCu(String numero){
        return interfazCalculaCientifService.getRaizCu(numero);
    }

    @Override
    @GetMapping("/area-circulo/{radio}")
    public ResponseEntity getAreaCir(String radio){
        return interfazCalculaCientifService.getAreaCir(radio);
    }

    @Override
    @GetMapping("/volumen-esfera/{radio}")
    public ResponseEntity getVolumenEsf(String radio){
        return interfazCalculaCientifService.getVolumenEsf(radio);
    }

    @Override
    @GetMapping("/ecuacion-cuadratica")
    public ResponseEntity getEcuacionCuad(String a, String b, String c){
        return interfazCalculaCientifService.getEcuacionCuad(a,b,c);
    }

}
