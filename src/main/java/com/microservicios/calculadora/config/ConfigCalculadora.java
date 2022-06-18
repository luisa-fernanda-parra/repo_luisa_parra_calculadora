package com.microservicios.calculadora.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "semillero")
public class ConfigCalculadora {

    public static final String MANANA = "manana";

    public static final String TARDE = "tarde";

    public static final String NOCHE = "noche";

    public static final String SUMA = "suma";

    public static final String RESTA = "resta";

    public static final String MULTIPLICACION = "multiplicacion";

    public static final String DIVISION = "division";

    public static final String FACTORIAL = "factorial";

    public static final String MULTIPLOS = "multiplos";

    public static final String COSENO = "coseno";

    public static final String RAIZ_CUADRADA = "raizCuadrada";

    public static final String AREA_CIRCULO = "areaCirculo";

    public static final String VOLUMEN_ESFERA = "volumenEsfera";

    public static final String ECUACION_CUADRATICA = "ecuacionCuadratica";

    private Map<String,String> saludo;

    private Map<String,String> calculadora;

    public String getValorSaludo(String hora){
        return saludo.get(hora);
    }

    public String getValorOperacion(String op){
        return calculadora.get(op);
    }

}
