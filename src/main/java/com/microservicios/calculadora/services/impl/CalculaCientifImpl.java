package com.microservicios.calculadora.services.impl;

import com.microservicios.calculadora.services.InterfazCalculaCientifService;
import com.microservicios.calculadora.utilities.Validacion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculaCientifImpl implements InterfazCalculaCientifService {

    @Value("${multiplos.numero}")
    private int valorMaximo;

    @Override
    public ResponseEntity getFactorial(String numero1){
        String mensaje = "";
        if(Validacion.esNumero(numero1)){
            int num1 = Integer.parseInt(numero1);
            int resultado = 1;
            for(int i=num1; i >= 2; i--){
                resultado *= i;
            }
            mensaje = numero1 + "!= " + resultado;
        }else {
            mensaje = "Entrada no válida";
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity getMultiplos(String numero){
        String mensaje = "";
        if(Validacion.esNumero(numero)){
            double num1 = Double.parseDouble(numero);
            for(double i = 1.0; i <= valorMaximo; i++){
                double resultado = num1 * i;
                mensaje += num1 + " * " + i + " = " + resultado + "\n";
            }
        }else{
            mensaje = "Entrada no válida";
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity getCoseno(String numero){
        String mensaje = "";
        if(Validacion.esNumero(numero)){
            double num1 = Math.toRadians(Double.parseDouble(numero));
            double resultado = Math.cos(num1);
            mensaje = "cos("+numero+") = "+ String.format("%.2f",resultado);
        }else{
            mensaje = "Entrada no válida";
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity getRaizCu(String numero){
        String mensaje = "";
        if(Validacion.esNumero(numero)){
            if(Double.parseDouble(numero) < 0.0){
                mensaje = "Número complejo";
            }else {
                double num1 = Math.sqrt(Double.parseDouble(numero));
                mensaje = '\u221A'+numero+" = "+num1;
            }
        }else {
            mensaje = "Entrada no válida";
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity getAreaCir(String radio){
        String mensaje = "";
        if(Validacion.esNumero(radio)){
            if(Double.parseDouble(radio) < 0.0){
                mensaje = "El radio debe ser positivo";
            }else {
                double area = Math.PI * (Math.pow(Double.parseDouble(radio),2));
                mensaje = "Area = "+area;
            }
        }else {
            mensaje = "Entrada no válida";
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity getVolumenEsf(String radio){
        String mensaje = "";
        if(Validacion.esNumero(radio)){
            if(Double.parseDouble(radio) < 0.0){
                mensaje = "El radio debe ser positivo";
            }else {
                double volumen = (4.0/3.0)*Math.PI*(Math.pow(Double.parseDouble(radio),3));
                mensaje = "Area = "+volumen;
            }
        }else {
            mensaje = "Entrada no válida";
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity getEcuacionCuad(String a, String b, String c){
        String mensaje = "";
        if(Validacion.esNumero(a) && Validacion.esNumero(b) && Validacion.esNumero(c)){
            double numA = Double.parseDouble(a);
            double numB = Double.parseDouble(b);
            double numC = Double.parseDouble(c);
            if(numA==0.0){
                mensaje = "ERROR! el parámetro 'a' debe ser diferente de cero";
            }else{
                double determinante = Math.pow(numB, 2) - 4.0 * numA * numC;
                if(determinante < 0.0){
                    mensaje = "La ecuación no tiene solución en los números reales";
                } else{
                    double resultado1 = (-(numB) + Math.sqrt(determinante)) / (2*numA);
                    double resultado2 = (-(numB) - Math.sqrt(determinante)) / (2*numA);
                    mensaje = "Resultado 1 = " + resultado1 +
                            "\nResultado 2 = " + resultado2;
                }
            }
        }else{
            mensaje = "Entrada no válida";
        }
        return ResponseEntity.ok(mensaje);
    }

}
