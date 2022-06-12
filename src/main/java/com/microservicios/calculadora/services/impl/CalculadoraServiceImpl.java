package com.microservicios.calculadora.services.impl;

import com.microservicios.calculadora.services.InterfazCalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements InterfazCalculadoraService {

    public ResponseEntity getSuma(String num1, String num2){
        String mensaje = "";
        if(Validacion.esNumero(num1) && Validacion.esNumero(num2)){
            double resultado = Double.parseDouble(num1) + Double.parseDouble(num2);
            mensaje = num1+" + "+num2+" = "+resultado;
        }else{
            mensaje = "Entrada no válida";
        }
        return ResponseEntity.ok(mensaje);
    }

    public ResponseEntity getResta(String num1, String num2){
        String mensaje = "";
        if(Validacion.esNumero(num1) && Validacion.esNumero(num2)){
            double resultado = Double.parseDouble(num1) - Double.parseDouble(num2);
            mensaje = num1+" - "+num2+" = "+resultado;
        }else{
            mensaje = "Entrada no válida";
        }
        return ResponseEntity.ok(mensaje);
    }

    public ResponseEntity getMultiplicacion(String num1, String num2){
        String mensaje = "";
        if(Validacion.esNumero(num1) && Validacion.esNumero(num2)){
            double resultado = Double.parseDouble(num1) * Double.parseDouble(num2);
            mensaje = num1+" * "+num2+" = "+resultado;
        }else{
            mensaje = "Entrada no válida";
        }
        return ResponseEntity.ok(mensaje);
    }

    public ResponseEntity getDivision(String num1, String num2){
        String mensaje = "";
        if(Validacion.esNumero(num1) && Validacion.esNumero(num2)){
            if(Double.parseDouble(num2)==0){
                mensaje = "ERROR! División por cero";
            }else{
                double resultado = Double.parseDouble(num1) / Double.parseDouble(num2);
                mensaje = num1+" / "+num2+" = "+resultado;
            }
        }else{
            mensaje = "Entrada no válida";
        }
        return ResponseEntity.ok(mensaje);
    }

}
