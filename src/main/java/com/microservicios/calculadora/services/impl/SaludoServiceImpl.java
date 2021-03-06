package com.microservicios.calculadora.services.impl;

import com.microservicios.calculadora.config.ConfigCalculadora;
import com.microservicios.calculadora.constants.AppConstants;
import com.microservicios.calculadora.services.InterfazSaludoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@AllArgsConstructor
@Service
public class SaludoServiceImpl implements InterfazSaludoService {

    private final ConfigCalculadora configCalculadora;

    @Override
    public ResponseEntity getSaludo(String hora) {
        int horaNum = Integer.parseInt(hora);
        String mensaje;
        if(horaNum >= 6 && horaNum < 12){
            mensaje = configCalculadora.getValorSaludo(ConfigCalculadora.MANANA);
        }else if(horaNum >= 12 && horaNum < 19){
            mensaje = configCalculadora.getValorSaludo(ConfigCalculadora.TARDE);
        }else if(horaNum >= 19 && horaNum <= 23 || horaNum >= 0 && horaNum < 6){
            mensaje = configCalculadora.getValorSaludo(ConfigCalculadora.NOCHE);
        }else{
            mensaje = AppConstants.ENTRADA_INVALIDA;
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity getOperaciones() {
        String mensaje = "Operaciones disponibles:";
        ArrayList<String> listaOperaciones = new ArrayList<>(configCalculadora.getCalculadora().values());
        for (String i : listaOperaciones) {
            mensaje += "\n" + i;
        }
        return ResponseEntity.ok(mensaje);
    }

}
