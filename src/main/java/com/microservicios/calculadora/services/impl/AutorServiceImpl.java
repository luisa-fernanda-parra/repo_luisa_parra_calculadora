package com.microservicios.calculadora.services.impl;

import com.microservicios.calculadora.model.AutorEntity;
import com.microservicios.calculadora.repository.AutorRepository;
import com.microservicios.calculadora.services.IAutorService;
import com.microservicios.calculadora.utilities.Validacion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.GregorianCalendar;

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

    @Override
    public ResponseEntity listarAutores(){
        return ResponseEntity.ok(autorRepository.findAll());
    }

    @Override
    public ResponseEntity listarAutPorNombreNativeQuery(String nombre){
        return ResponseEntity.ok(autorRepository.buscarPorNombreNativeQuery(nombre));
    }

    @Override
    public ResponseEntity listarAutPorNombreJpql(String nombre){
        return ResponseEntity.ok(autorRepository.buscarPorNombreJpql(nombre));
    }

    @Override
    public ResponseEntity listarAutPorNombreJpaRepository(String nombre){
        return ResponseEntity.ok(autorRepository.findByNombre(nombre));
    }

    @Override
    public ResponseEntity listarAutPorFechaCNativeQuery(String fecha){
        return ResponseEntity.ok(autorRepository.buscarPorFechaCNativeQuery(fecha));
    }

    @Override
    public ResponseEntity listarAutPorFechaCJpql(String a, String m, String d){
        ResponseEntity response;
        if(Validacion.esNumero(a) && Validacion.esNumero(m) && Validacion.esNumero(d)){
            GregorianCalendar fechaCalendar = new GregorianCalendar(Integer.parseInt(a), Integer.parseInt(m)-1, Integer.parseInt(d));
            Date fecha = fechaCalendar.getTime();
            response = ResponseEntity.ok(autorRepository.buscarPorFechaCJpql(fecha));
        }else{
            response = ResponseEntity.ok("Entrada no valida");
        }
        return response;
    }

    @Override
    public ResponseEntity listarAutPorFechaCJpaRepository(String a, String m, String d){
        ResponseEntity response;
        if(Validacion.esNumero(a) && Validacion.esNumero(m) && Validacion.esNumero(d)){
            GregorianCalendar fechaCalendar = new GregorianCalendar(Integer.parseInt(a), Integer.parseInt(m)-1, Integer.parseInt(d));
            Date fecha = fechaCalendar.getTime();
            response = ResponseEntity.ok(autorRepository.findByFechaCreacion(fecha));
        }else{
            response = ResponseEntity.ok("Entrada no valida");
        }
        return response;
    }

    @Override
    public ResponseEntity listarAutPorIdNativeQuery(String id){
        return ResponseEntity.ok(autorRepository.buscarPorIdNativeQuery(id));
    }

    @Override
    public ResponseEntity listarAutPorIdJpql(String id){
        ResponseEntity response;
        if(Validacion.esNumero(id)){
            response = ResponseEntity.ok(autorRepository.buscarPorIdJpql(Long.parseLong(id)));
        }else{
            response = ResponseEntity.ok("Entrada no válida");
        }
        return response;
    }

    @Override
    public ResponseEntity listarAutPorIdJpaRepository(String id){
        ResponseEntity response;
        if(Validacion.esNumero(id)){
            response = ResponseEntity.ok(autorRepository.findById(Long.parseLong(id)));
        }else{
            response = ResponseEntity.ok("Entrada no válida");
        }
        return response;
    }

}