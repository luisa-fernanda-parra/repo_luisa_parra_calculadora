package com.microservicios.calculadora.services.impl;

import com.microservicios.calculadora.model.AutorEntity;
import com.microservicios.calculadora.repository.AutorRepository;
import com.microservicios.calculadora.services.IAutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AutorServiceImpl implements IAutorService {

    private AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    @Override
    public ResponseEntity guardarAutor(AutorEntity autorEntity){
        autorEntity.setFechaCreacion(new Date());
        AutorEntity autor = autorRepository.save(autorEntity);
        return ResponseEntity.ok(autor);
    }
}
