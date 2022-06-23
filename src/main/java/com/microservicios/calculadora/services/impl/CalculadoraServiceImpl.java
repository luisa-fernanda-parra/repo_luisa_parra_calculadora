package com.microservicios.calculadora.services.impl;

import com.microservicios.calculadora.constants.AppConstants;
import com.microservicios.calculadora.services.InterfazCalculadoraService;
import com.microservicios.calculadora.utilities.Validacion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements InterfazCalculadoraService {

    @Override
    public ResponseEntity getSuma(String num1, String num2){
        String mensaje = "";
        if(Validacion.esNumero(num1) && Validacion.esNumero(num2)){
            double resultado = Double.parseDouble(num1) + Double.parseDouble(num2);
            mensaje = num1+" + "+num2+" = "+resultado;
        }else{
            mensaje = AppConstants.ENTRADA_INVALIDA;
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity getResta(String num1, String num2){
        String mensaje = "";
        if(Validacion.esNumero(num1) && Validacion.esNumero(num2)){
            double resultado = Double.parseDouble(num1) - Double.parseDouble(num2);
            mensaje = num1+" - "+num2+" = "+resultado;
        }else{
            mensaje = AppConstants.ENTRADA_INVALIDA;
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity getMultiplicacion(String num1, String num2){
        String mensaje = "";
        if(Validacion.esNumero(num1) && Validacion.esNumero(num2)){
            double resultado = Double.parseDouble(num1) * Double.parseDouble(num2);
            mensaje = num1+" * "+num2+" = "+resultado;
        }else{
            mensaje = AppConstants.ENTRADA_INVALIDA;
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity getDivision(String num1, String num2){
        String mensaje = "";
        if(Validacion.esNumero(num1) && Validacion.esNumero(num2)){
            if(Double.parseDouble(num2)==0){
                mensaje = AppConstants.DIVISION_POR_CERO;
            }else{
                double resultado = Double.parseDouble(num1) / Double.parseDouble(num2);
                mensaje = num1+" / "+num2+" = "+resultado;
            }
        }else{
            mensaje = AppConstants.ENTRADA_INVALIDA;
        }
        return ResponseEntity.ok(mensaje);
    }

}
