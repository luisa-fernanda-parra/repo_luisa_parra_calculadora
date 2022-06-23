package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.sample.SaludoControllerSample;
import com.microservicios.calculadora.services.InterfazSaludoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SaludoController.class)
public class SaludoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    InterfazSaludoService interfazSaludoService;

    @Test
    void getSaludoOK() throws Exception{
        when(interfazSaludoService.getSaludo(anyString())).thenReturn(SaludoControllerSample.saludo());

        mvc.perform(get("/bienvenida/saludo/50")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Buenos dias"));

        verify(interfazSaludoService).getSaludo(anyString());

    }

    @Test
    void getOperacionesOK() throws Exception{
        when(interfazSaludoService.getOperaciones()).thenReturn(SaludoControllerSample.operaciones());
        mvc.perform(get("/bienvenida/operaciones")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Operaciones disponibles:\nsumar\nrestar\nmultiplicar\ndividir\nfactorial\nmultiplos\ncoseno\nraiz cuadrada\narea de un circulo\nvolumen de una esfera\necuacion cuadratica"));

        verify(interfazSaludoService).getOperaciones();

    }

}
