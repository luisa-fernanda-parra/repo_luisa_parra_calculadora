package com.microservicios.calculadora.services.impl;

public class Validacion {

    public static boolean esNumero(String num){
        boolean esNumero = true;
        int contadorPunto = 0;
        int contadorGuion = 0;
        char[] numArreglo = num.toCharArray();
        for(char c:numArreglo){
            if(Character.isDigit(c)){
                continue;
            }else if(c == '.'){
                contadorPunto++;
            }else if(c == '-'){
                contadorGuion++;
            }else{
                esNumero = false;
                break;
            }
        }
        if(contadorPunto > 1 || contadorGuion > 1){
            esNumero = false;
        }
        if(num.startsWith(".")||num.endsWith(".")){
            esNumero = false;
        }
        if(contadorGuion == 1){
            if(!num.startsWith("-")){
                esNumero = false;
            }
        }
        return esNumero;
    }

}
