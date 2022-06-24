package com.microservicios.calculadora.services.impl;

import com.microservicios.calculadora.constants.AppConstants;
import com.microservicios.calculadora.dto.AutorDTO;
import com.microservicios.calculadora.model.AutorEntity;
import com.microservicios.calculadora.repository.AutorRepository;
import com.microservicios.calculadora.services.IAutorService;
import com.microservicios.calculadora.utilities.Validacion;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

@AllArgsConstructor
@Service
public class AutorServiceImpl implements IAutorService {

    private AutorRepository autorRepository;

    @Override
    public ResponseEntity guardarAutor(AutorDTO autorDTO){
        var autorEntity = AutorEntity.builder()
                .nombre(autorDTO.getNombre())
                .apellido(autorDTO.getApellido())
                .fechaCreacion(new Date())
                .build();
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
    public ResponseEntity listarAutPorFechaCJpql(String year, String month, String day){
        ResponseEntity response;
        if(Validacion.esNumero(year) && Validacion.esNumero(month) && Validacion.esNumero(day)){
            GregorianCalendar fechaCalendar = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
            Date fecha = fechaCalendar.getTime();
            response = ResponseEntity.ok(autorRepository.buscarPorFechaCJpql(fecha));
        }else{
            response = ResponseEntity.ok(AppConstants.ENTRADA_INVALIDA);
        }
        return response;
    }

    @Override
    public ResponseEntity listarAutPorFechaCJpaRepository(String year, String month, String day){
        ResponseEntity response;
        if(Validacion.esNumero(year) && Validacion.esNumero(month) && Validacion.esNumero(day)){
            GregorianCalendar fechaCalendar = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
            Date fecha = fechaCalendar.getTime();
            response = ResponseEntity.ok(autorRepository.findByFechaCreacion(fecha));
        }else{
            response = ResponseEntity.ok(AppConstants.ENTRADA_INVALIDA);
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
            response = ResponseEntity.ok(AppConstants.ENTRADA_INVALIDA);
        }
        return response;
    }

    @Override
    public ResponseEntity listarAutPorIdJpaRepository(String id){
        ResponseEntity response;
        if(Validacion.esNumero(id)){
            response = ResponseEntity.ok(autorRepository.findById(Long.parseLong(id)));
        }else{
            response = ResponseEntity.ok(AppConstants.ENTRADA_INVALIDA);
        }
        return response;
    }

    @Override
    public ResponseEntity actualizarAutor(Long id, AutorDTO autorDTO){
        String mensaje;
        var autorOptional = autorRepository.findById(id);
        if(autorOptional.isPresent()){
            AutorEntity autorEntity = autorOptional.get();
            autorEntity.setNombre(autorDTO.getNombre());
            autorEntity.setApellido(autorDTO.getApellido());
            autorRepository.save(autorEntity);
            mensaje = AppConstants.ACTUALIZACION_EXITOSA;
        }else {
            mensaje = AppConstants.ACTUALIZACION_FALLIDA;
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override
    public ResponseEntity deleteHard(Long id) {
        String mensaje;
        var autorOptional = autorRepository.findById(id);
        if(autorOptional.isPresent()){
            autorRepository.delete(autorOptional.get());
            mensaje = AppConstants.BORRADO_EXITOSO;
        }else{
            mensaje = AppConstants.BORRADO_FALLIDO;
        }
        return ResponseEntity.ok(mensaje);
    }

    @Override//ACTUAL
    public ResponseEntity deleteLogic(Long id) {
        String mensaje;
        AutorEntity autorEntity = autorRepository.findByIdAndFechaEliminacionIsNull(id);
        if(Objects.isNull(autorEntity)){
            mensaje = AppConstants.BORRADO_LOGICO_FALLIDO;
        }else{
            autorEntity.setFechaEliminacion(new Date());
            autorRepository.save(autorEntity);
            mensaje = AppConstants.BORRADO_LOGICO_EXITOSO;
        }
        return ResponseEntity.ok(mensaje);
    }

}
