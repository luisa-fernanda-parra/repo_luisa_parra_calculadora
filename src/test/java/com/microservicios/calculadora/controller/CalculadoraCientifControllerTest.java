package com.microservicios.calculadora.controller;

import com.microservicios.calculadora.sample.CalculadoraControllerSample;
import com.microservicios.calculadora.services.InterfazCalculaCientifService;
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

@WebMvcTest(CalculadoraCientifController.class)
public class CalculadoraCientifControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    InterfazCalculaCientifService interfazCalculaCientifService;

    @Test
    void getFactorialOK() throws Exception{
        when(interfazCalculaCientifService.getFactorial(anyString())).thenReturn(CalculadoraControllerSample.getEntradaInvalida());

        mvc.perform(get("/calculadora-cientifica/factorial/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Entrada invalida"));

        verify(interfazCalculaCientifService).getFactorial(anyString());

    }

    @Test
    void getMultiplosOK() throws Exception{
        when(interfazCalculaCientifService.getMultiplos(anyString())).thenReturn(CalculadoraControllerSample.getEntradaInvalida());

        mvc.perform(get("/calculadora-cientifica/multiplos/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Entrada invalida"));

        verify(interfazCalculaCientifService).getMultiplos(anyString());

    }

    @Test
    void getCosenoOK() throws Exception{
        when(interfazCalculaCientifService.getCoseno(anyString())).thenReturn(CalculadoraControllerSample.getEntradaInvalida());

        mvc.perform(get("/calculadora-cientifica/coseno/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Entrada invalida"));

        verify(interfazCalculaCientifService).getCoseno(anyString());

    }

    @Test
    void getRaizCuOK() throws Exception{
        when(interfazCalculaCientifService.getRaizCu(anyString())).thenReturn(CalculadoraControllerSample.getEntradaInvalida());

        mvc.perform(get("/calculadora-cientifica/raiz-cuadrada/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Entrada invalida"));

        verify(interfazCalculaCientifService).getRaizCu(anyString());

    }

    @Test
    void getAreaCirOK() throws Exception{
        when(interfazCalculaCientifService.getAreaCir(anyString())).thenReturn(CalculadoraControllerSample.getEntradaInvalida());

        mvc.perform(get("/calculadora-cientifica/area-circulo/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Entrada invalida"));

        verify(interfazCalculaCientifService).getAreaCir(anyString());

    }

    @Test
    void getVolumenEsfOK() throws Exception{
        when(interfazCalculaCientifService.getVolumenEsf(anyString())).thenReturn(CalculadoraControllerSample.getEntradaInvalida());

        mvc.perform(get("/calculadora-cientifica/volumen-esfera/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Entrada invalida"));

        verify(interfazCalculaCientifService).getVolumenEsf(anyString());

    }

    @Test
    void getEcuacionCuadOK() throws Exception{
        when(interfazCalculaCientifService.getEcuacionCuad(anyString(),anyString(),anyString())).thenReturn(CalculadoraControllerSample.getEntradaInvalida());

        mvc.perform(get("/calculadora-cientifica/ecuacion-cuadratica?a=1&b=2&c=3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Entrada invalida"));

        verify(interfazCalculaCientifService).getEcuacionCuad(anyString(),anyString(),anyString());

    }

}
