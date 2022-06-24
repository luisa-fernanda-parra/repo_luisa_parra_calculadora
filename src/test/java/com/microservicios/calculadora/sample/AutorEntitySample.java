package com.microservicios.calculadora.sample;

import com.microservicios.calculadora.model.AutorEntity;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutorEntitySample {

    public static AutorEntity getAutorEntity(){
        AutorEntity autorEntity = AutorEntity.builder()
                .id(1L)
                .nombre("Paco")
                .apellido("Perez")
                .fechaCreacion(new Date())
                .build();
        return autorEntity;
    }

    public static ResponseEntity getResponseEntityAutor(){
        AutorEntity autorEntity = new AutorEntity(1L, "Paco", "Perez", new Date(), new Date());
        return ResponseEntity.ok(autorEntity);
    }

    public static List<AutorEntity> getListaAutorEntity(){
        return (List<AutorEntity>) getResponseEntityListaAutor().getBody();
    }

    public static ResponseEntity getResponseEntityListaAutor(){
        List<AutorEntity> listaAutorEntity = new ArrayList<>();
        AutorEntity autor1 = AutorEntity.builder()
                .id(1L)
                .nombre("Paco")
                .apellido("Perez")
                .fechaCreacion(new Date())
                .build();
        AutorEntity autor2 = AutorEntity.builder()
                .id(2L)
                .nombre("Fiona")
                .apellido("Fernandez")
                .fechaCreacion(new Date())
                .build();
        listaAutorEntity.add(autor1);
        listaAutorEntity.add(autor2);
        return ResponseEntity.ok(listaAutorEntity);
    }

}
