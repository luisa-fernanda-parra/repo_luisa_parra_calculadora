package com.microservicios.calculadora.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicios.calculadora.sample.AutorDTOSample;
import com.microservicios.calculadora.sample.AutorEntitySample;
import com.microservicios.calculadora.services.IAutorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AutorController.class)
public class AutorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    IAutorService iAutorService;

    @Test
    void guardarAutorOK() throws Exception{
        when(iAutorService.guardarAutor(any())).thenReturn(AutorEntitySample.getAutorEntity()); //lo que le estoy pasando

        mvc.perform(post("/autor")
                        .content(objectToJson(AutorDTOSample.getRequestAutorDTO()))//tiene que ver con lo que le pasamos como parámetro
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L)) //lo que espera
                .andExpect(jsonPath("$.nombre").value("Paco"))//lo que espera
                .andExpect(jsonPath("$.apellido").value("Perez"));//lo que espera

        verify(iAutorService).guardarAutor(any());
    }

    @Test
    void listarAutoresOK() throws Exception{
        when(iAutorService.listarAutores()).thenReturn(AutorEntitySample.getListaAutorEntity());

        mvc.perform(get("/autor/listar-autores")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Paco"))
                .andExpect(jsonPath("$[0].apellido").value("Perez"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nombre").value("Fiona"))
                .andExpect(jsonPath("$[1].apellido").value("Fernandez"));

        verify(iAutorService).listarAutores();
    }

    @Test
    void listarAutPorNombreNativeQueryOK() throws Exception{
        when(iAutorService.listarAutPorNombreNativeQuery(anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());

        mvc.perform(get("/autor/listar-autores-por-nombre/native-query/Paco")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Paco"))
                .andExpect(jsonPath("$[0].apellido").value("Perez"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nombre").value("Fiona"))
                .andExpect(jsonPath("$[1].apellido").value("Fernandez"));

        verify(iAutorService).listarAutPorNombreNativeQuery(anyString());
    }

    @Test
    void listarAutPorNombreJpqlOK() throws Exception{
        when(iAutorService.listarAutPorNombreJpql(anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());

        mvc.perform(get("/autor/listar-autores-por-nombre/jpql/Paco")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Paco"))
                .andExpect(jsonPath("$[0].apellido").value("Perez"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nombre").value("Fiona"))
                .andExpect(jsonPath("$[1].apellido").value("Fernandez"));

        verify(iAutorService).listarAutPorNombreJpql(anyString());
    }

    @Test
    void listarAutPorNombreJpaRepositoryOK() throws Exception{
        when(iAutorService.listarAutPorNombreJpaRepository(anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());

        mvc.perform(get("/autor/listar-autores-por-nombre/jpa-repository/Paco")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Paco"))
                .andExpect(jsonPath("$[0].apellido").value("Perez"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nombre").value("Fiona"))
                .andExpect(jsonPath("$[1].apellido").value("Fernandez"));

        verify(iAutorService).listarAutPorNombreJpaRepository(anyString());
    }

    @Test
    void listarAutPorFechaCNativeQueryOK() throws Exception{
        when(iAutorService.listarAutPorFechaCNativeQuery(anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());

        mvc.perform(get("/autor/listar-autores-por-fecha-creacion/native-query/fecha")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Paco"))
                .andExpect(jsonPath("$[0].apellido").value("Perez"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nombre").value("Fiona"))
                .andExpect(jsonPath("$[1].apellido").value("Fernandez"));

        verify(iAutorService).listarAutPorFechaCNativeQuery(anyString());
    }

    @Test
    void listarAutPorFechaCJpqlOK() throws Exception{
        when(iAutorService.listarAutPorFechaCJpql(anyString(),anyString(),anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());

        mvc.perform(get("/autor/listar-autores-por-fecha-creacion/jpql?year=2022&month=3&day=4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Paco"))
                .andExpect(jsonPath("$[0].apellido").value("Perez"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nombre").value("Fiona"))
                .andExpect(jsonPath("$[1].apellido").value("Fernandez"));

        verify(iAutorService).listarAutPorFechaCJpql(anyString(),anyString(),anyString());
    }

    @Test
    void listarAutPorFechaCJpaRepositoryOK() throws Exception{
        when(iAutorService.listarAutPorFechaCJpaRepository(anyString(),anyString(),anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());

        mvc.perform(get("/autor/listar-autores-por-fecha-creacion/jpa-repository?year=2022&month=3&day=4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Paco"))
                .andExpect(jsonPath("$[0].apellido").value("Perez"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nombre").value("Fiona"))
                .andExpect(jsonPath("$[1].apellido").value("Fernandez"));

        verify(iAutorService).listarAutPorFechaCJpaRepository(anyString(),anyString(),anyString());
    }

    @Test
    void listarAutPorIdNativeQueryOK() throws Exception{
        when(iAutorService.listarAutPorIdNativeQuery(anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());

        mvc.perform(get("/autor/listar-autor-por-id/native-query/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Paco"))
                .andExpect(jsonPath("$[0].apellido").value("Perez"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nombre").value("Fiona"))
                .andExpect(jsonPath("$[1].apellido").value("Fernandez"));

        verify(iAutorService).listarAutPorIdNativeQuery(anyString());
    }

    @Test
    void listarAutPorIdJpqlOK() throws Exception{
        when(iAutorService.listarAutPorIdJpql(anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());

        mvc.perform(get("/autor/listar-autor-por-id/jpql/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Paco"))
                .andExpect(jsonPath("$[0].apellido").value("Perez"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nombre").value("Fiona"))
                .andExpect(jsonPath("$[1].apellido").value("Fernandez"));

        verify(iAutorService).listarAutPorIdJpql(anyString());
    }

    @Test
    void listarAutPorIdJpaRepositoryOK() throws Exception{
        when(iAutorService.listarAutPorIdJpaRepository(anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());

        mvc.perform(get("/autor/listar-autor-por-id/jpa-repository/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Paco"))
                .andExpect(jsonPath("$[0].apellido").value("Perez"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nombre").value("Fiona"))
                .andExpect(jsonPath("$[1].apellido").value("Fernandez"));

        verify(iAutorService).listarAutPorIdJpaRepository(anyString());
    }

    @Test
    void actualizarAutorOK() throws Exception{
        when(iAutorService.actualizarAutor(anyLong(),any())).thenReturn(ResponseEntity.ok("Actualizacion exitosa"));

        mvc.perform(put("/autor/actualizar-nombre-apellido/1")
                        .content(objectToJson(AutorDTOSample.getRequestAutorDTO()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Actualizacion exitosa"));

        verify(iAutorService).actualizarAutor(anyLong(),any());
    }

    @Test
    void deleteHardOK() throws Exception{
        when(iAutorService.deleteHard(anyLong())).thenReturn(ResponseEntity.ok("Borrado exitoso"));

        mvc.perform(delete("/autor/borrar-autor/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Borrado exitoso"));

        verify(iAutorService).deleteHard(anyLong());
    }

    @Test
    void deleteLogicOK() throws Exception{
        when(iAutorService.deleteLogic(anyLong())).thenReturn(ResponseEntity.ok("Borrado exitoso"));

        mvc.perform(put("/autor/borrar-autor-logico/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("Borrado exitoso"));

        verify(iAutorService).deleteLogic(anyLong());
    }

    public static String objectToJson(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
