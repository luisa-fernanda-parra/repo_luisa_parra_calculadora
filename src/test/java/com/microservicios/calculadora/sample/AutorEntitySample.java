package com.microservicios.calculadora.sample;

import com.microservicios.calculadora.model.AutorEntity;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutorEntitySample {

    public static ResponseEntity getAutorEntity(){
        AutorEntity autorEntity = new AutorEntity(1L, "Paco", "Perez", new Date(), new Date());
        return ResponseEntity.ok(autorEntity);
    }

    public static ResponseEntity getListaAutorEntity(){
        List<AutorEntity> listaAutorEntity = new ArrayList<>();
        listaAutorEntity.add(new AutorEntity(1L, "Paco", "Perez", new Date(), new Date()));
        listaAutorEntity.add(new AutorEntity(2L, "Fiona", "Fernandez", new Date(), new Date()));
        return ResponseEntity.ok(listaAutorEntity);
    }

}
