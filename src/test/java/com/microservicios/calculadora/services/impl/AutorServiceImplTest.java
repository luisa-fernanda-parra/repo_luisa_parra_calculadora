package com.microservicios.calculadora.services.impl;

import com.microservicios.calculadora.model.AutorEntity;
import com.microservicios.calculadora.repository.AutorRepository;
import com.microservicios.calculadora.sample.AutorDTOSample;
import com.microservicios.calculadora.sample.AutorEntitySample;
import com.microservicios.calculadora.services.IAutorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AutorServiceImplTest {

    @MockBean
    AutorRepository autorRepository;

    @Autowired
    IAutorService iAutorService;

    @Test
    void guardarAutorOK(){
        when(autorRepository.save(any())).thenReturn(AutorEntitySample.getAutorEntity());
        var responseEntity = iAutorService.guardarAutor(AutorDTOSample.getRequestAutorDTO());
        AutorEntity autorEntity = (AutorEntity) responseEntity.getBody();

        verify(autorRepository, times(1)).save(any());
        assertNotNull(autorEntity);
        assertEquals("Paco", autorEntity.getNombre());
        assertInstanceOf(AutorEntity.class, autorEntity);
        assertEquals(200,responseEntity.getStatusCodeValue());

    }

    @Test
    void listarAutoresOK(){
        when(autorRepository.findAll()).thenReturn(AutorEntitySample.getListaAutorEntity());
        var responseEntity = iAutorService.listarAutores();
        List<AutorEntity> listaAutores = (List<AutorEntity>) responseEntity.getBody();

        verify(autorRepository,times(1)).findAll();
        assertNotNull(listaAutores);
        assertEquals(2,listaAutores.size());
        assertEquals("Paco",listaAutores.get(0).getNombre());
        assertEquals(200,responseEntity.getStatusCodeValue());

    }

    @Test
    void listarAutPorNombreNativeQueryOK(){
        when(autorRepository.buscarPorNombreNativeQuery(anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());
        var responseEntity = iAutorService.listarAutPorNombreNativeQuery("Paco");
        List<AutorEntity> listaAutores = (List<AutorEntity>) responseEntity.getBody();

        verify(autorRepository,times(1)).buscarPorNombreNativeQuery(anyString());
        assertNotNull(listaAutores);
        assertEquals(2,listaAutores.size());
        assertEquals("Paco",listaAutores.get(0).getNombre());
        assertEquals(200,responseEntity.getStatusCodeValue());

    }

    @Test
    void listarAutPorNombreJpqlOK(){
        when(autorRepository.buscarPorNombreJpql(anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());
        var responseEntity = iAutorService.listarAutPorNombreJpql("Paco");
        List<AutorEntity> listaAutores = (List<AutorEntity>) responseEntity.getBody();

        verify(autorRepository,times(1)).buscarPorNombreJpql(anyString());
        assertNotNull(listaAutores);
        assertEquals(2,listaAutores.size());
        assertEquals("Paco",listaAutores.get(0).getNombre());
        assertEquals(200,responseEntity.getStatusCodeValue());

    }

    @Test
    void listarAutPorNombreJpaRepositoryOK(){
        when(autorRepository.findByNombre(anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());
        var responseEntity = iAutorService.listarAutPorNombreJpaRepository("Paco");
        List<AutorEntity> listaAutores = (List<AutorEntity>) responseEntity.getBody();

        verify(autorRepository,times(1)).findByNombre(anyString());
        assertNotNull(listaAutores);
        assertEquals(2,listaAutores.size());
        assertEquals("Paco",listaAutores.get(0).getNombre());
        assertEquals(200,responseEntity.getStatusCodeValue());

    }

    @Test
    void listarAutPorFechaCNativeQueryOK(){
        when(autorRepository.buscarPorFechaCNativeQuery(anyString())).thenReturn(AutorEntitySample.getListaAutorEntity());
        var responseEntity = iAutorService.listarAutPorFechaCNativeQuery("2022/06/23");
        List<AutorEntity> listaAutores = (List<AutorEntity>) responseEntity.getBody();

        verify(autorRepository,times(1)).buscarPorFechaCNativeQuery(anyString());
        assertNotNull(listaAutores);
        assertEquals(2,listaAutores.size());
        assertEquals("Paco",listaAutores.get(0).getNombre());
        assertEquals(200,responseEntity.getStatusCodeValue());

    }

    @Test
    void listarAutPorFechaCJpqlOK(){
        when(autorRepository.buscarPorFechaCJpql(any())).thenReturn(AutorEntitySample.getListaAutorEntity());
        var responseEntity = iAutorService.listarAutPorFechaCJpql("2022","06","23");
        List<AutorEntity> listaAutores = (List<AutorEntity>) responseEntity.getBody();

        verify(autorRepository,times(1)).buscarPorFechaCJpql(any());
        assertNotNull(listaAutores);
        assertEquals(2,listaAutores.size());
        assertEquals("Paco",listaAutores.get(0).getNombre());
        assertEquals(200,responseEntity.getStatusCodeValue());

    }

    @Test
    void listarAutPorFechaCJpaRepositoryOK(){
        when(autorRepository.findByFechaCreacion(any())).thenReturn(AutorEntitySample.getListaAutorEntity());
        var responseEntity = iAutorService.listarAutPorFechaCJpaRepository("2022","06","23");
        List<AutorEntity> listaAutores = (List<AutorEntity>) responseEntity.getBody();

        verify(autorRepository,times(1)).findByFechaCreacion(any());
        assertNotNull(listaAutores);
        assertEquals(2,listaAutores.size());
        assertEquals("Paco",listaAutores.get(0).getNombre());
        assertEquals(200,responseEntity.getStatusCodeValue());

    }

    @Test
    void listarAutPorIdNativeQueryOK(){
        when(autorRepository.buscarPorIdNativeQuery(anyString())).thenReturn(AutorEntitySample.getAutorEntity());
        var responseEntity = iAutorService.listarAutPorIdNativeQuery("1");
        AutorEntity autorEntity = (AutorEntity) responseEntity.getBody();

        verify(autorRepository, times(1)).buscarPorIdNativeQuery(anyString());
        assertNotNull(autorEntity);
        assertEquals("Paco", autorEntity.getNombre());
        assertInstanceOf(AutorEntity.class, autorEntity);
        assertEquals(200,responseEntity.getStatusCodeValue());

    }

    @Test
    void listarAutPorIdJpqlOK(){
        when(autorRepository.buscarPorIdJpql(anyLong())).thenReturn(AutorEntitySample.getAutorEntity());
        var responseEntity = iAutorService.listarAutPorIdJpql("1");
        AutorEntity autorEntity = (AutorEntity) responseEntity.getBody();

        verify(autorRepository, times(1)).buscarPorIdJpql(anyLong());
        assertNotNull(autorEntity);
        assertEquals("Paco", autorEntity.getNombre());
        assertInstanceOf(AutorEntity.class, autorEntity);
        assertEquals(200,responseEntity.getStatusCodeValue());

    }

    @Test
    void listarAutPorIdJpaRepositoryOK(){
        when(autorRepository.findById(anyLong())).thenReturn(AutorEntitySample.getAutorEntity());
        var responseEntity = iAutorService.listarAutPorIdJpaRepository("1");
        AutorEntity autorEntity = (AutorEntity) responseEntity.getBody();

        verify(autorRepository, times(1)).findById(anyLong());
        assertNotNull(autorEntity);
        assertEquals("Paco", autorEntity.getNombre());
        assertInstanceOf(AutorEntity.class, autorEntity);
        assertEquals(200,responseEntity.getStatusCodeValue());

    }

    @Test
    void actualizarAutorOK(){
        when(autorRepository.findById(anyLong())).thenReturn(AutorEntitySample.getAutorEntity());
        AutorEntity autorEntity = autorRepository.findById(1L);

        verify(autorRepository, times(1)).findById(anyLong());
        assertNotNull(autorEntity);
        assertEquals("Paco", autorEntity.getNombre());
        assertInstanceOf(AutorEntity.class, autorEntity);

        when(autorRepository.save(any())).thenReturn(AutorEntitySample.getAutorEntity());
        AutorEntity autorEntity2 = autorRepository.save(AutorEntitySample.getAutorEntity());

        verify(autorRepository, times(1)).save(any());
        assertNotNull(autorEntity2);
        assertEquals("Paco", autorEntity2.getNombre());
        assertInstanceOf(AutorEntity.class, autorEntity2);

    }

    @Test
    void deleteHardOK(){
        when(autorRepository.findById(anyLong())).thenReturn(AutorEntitySample.getAutorEntity());
        AutorEntity autorEntity = autorRepository.findById(1L);

        verify(autorRepository, times(1)).findById(anyLong());
        assertNotNull(autorEntity);
        assertEquals("Paco", autorEntity.getNombre());
        assertInstanceOf(AutorEntity.class, autorEntity);

    }

    @Test
    void deleteLogicOk(){
        when(autorRepository.findByIdAndFechaEliminacionIsNull(anyLong())).thenReturn(AutorEntitySample.getAutorEntity());
        ResponseEntity responseEntity = iAutorService.deleteLogic(1L);
        String mensaje = (String) responseEntity.getBody();

        verify(autorRepository, times(1)).findByIdAndFechaEliminacionIsNull(anyLong());
        assertNotNull(mensaje);
        assertInstanceOf(String.class, mensaje);

    }

}
