package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.sample.CalculadoraControllerSample;
import com.microservicios.calculadora.services.InterfazCalculadoraService;
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

@WebMvcTest(CalculadoraController.class)
public class CalculadoraControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    InterfazCalculadoraService interfazCalculadoraService;

    @Test
    void getSumaOK() throws Exception{
        when(interfazCalculadoraService.getSuma(anyString(),anyString())).thenReturn(CalculadoraControllerSample.getEntradaInvalida());

        mvc.perform(get("/calculadora/suma?num1=5&num2=6")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Entrada invalida"));

        verify(interfazCalculadoraService).getSuma(anyString(),anyString());

    }

    @Test
    void getRestaOK() throws Exception{
        when(interfazCalculadoraService.getResta(anyString(),anyString())).thenReturn(CalculadoraControllerSample.getEntradaInvalida());

        mvc.perform(get("/calculadora/resta?num1=5&num2=6")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Entrada invalida"));

        verify(interfazCalculadoraService).getResta(anyString(),anyString());

    }

    @Test
    void getMultiplicacionOK() throws Exception{
        when(interfazCalculadoraService.getMultiplicacion(anyString(),anyString())).thenReturn(CalculadoraControllerSample.getEntradaInvalida());

        mvc.perform(get("/calculadora/multiplicacion?num1=5&num2=6")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Entrada invalida"));

        verify(interfazCalculadoraService).getMultiplicacion(anyString(),anyString());

    }

    @Test
    void getDivisionOK() throws Exception{
        when(interfazCalculadoraService.getDivision(anyString(),anyString())).thenReturn(CalculadoraControllerSample.getEntradaInvalida());

        mvc.perform(get("/calculadora/division?num1=5&num2=6")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Entrada invalida"));

        verify(interfazCalculadoraService).getDivision(anyString(),anyString());

    }

}
