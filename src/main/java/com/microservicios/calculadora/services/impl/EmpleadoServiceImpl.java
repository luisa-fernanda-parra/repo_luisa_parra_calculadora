package com.microservicios.calculadora.services.impl;

import com.microservicios.calculadora.dto.api.dummy.ResponseBodyDTO;
import com.microservicios.calculadora.dto.api.dummy.ResponseDTO;
import com.microservicios.calculadora.dto.api.dummy.ResponseEmployeeDTO;
import com.microservicios.calculadora.providers.EmployeeProvider;
import com.microservicios.calculadora.services.IEmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    private final EmployeeProvider employeeProvider;

    @Override
    public ResponseEntity listarEmpleados() {
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity response;
        try {
            responseBodyDTO = employeeProvider.getListEmployee();
            response = ResponseEntity.ok(responseBodyDTO);
        }catch (Exception e) {
            response = ResponseEntity.ok(e.getCause());
        }
        return response;
    }

    @Override
    public ResponseEntity listarEmpleadosMayores30() {
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity response;
        try {
            responseBodyDTO = employeeProvider.getListEmployee();
            List<ResponseEmployeeDTO> listaEmpleados = responseBodyDTO.getData();
            List<ResponseEmployeeDTO> listaMayores30 = new ArrayList<>();
            for (ResponseEmployeeDTO i:listaEmpleados) {
                if(i.getEmployeeAge() > 30L){
                    listaMayores30.add(i);
                }
            }
            response = ResponseEntity.ok(listaMayores30);
        }catch (Exception e) {
            response = ResponseEntity.ok(e.getCause());
        }
        return response;
    }

    @Override
    public ResponseEntity getEmpleado(Long id) {
        ResponseDTO responseDTO;
        ResponseEntity response;
        try {
            responseDTO = employeeProvider.getEmployee(id);
            response = ResponseEntity.ok(responseDTO);
        }catch (Exception e) {
            response = ResponseEntity.ok(e.getCause());
        }
        return response;
    }

    @Override
    public ResponseEntity listarEmpleadosSueldo() {
        ResponseBodyDTO responseBodyDTO;
        ResponseEntity response;
        try {
            responseBodyDTO = employeeProvider.getListEmployee();
            List<ResponseEmployeeDTO> listaEmpleados = responseBodyDTO
                    .getData()
                    .stream()
                    .filter(i->i.getEmployeeSalary()>100000)
                    .collect(Collectors.toList());
            response = ResponseEntity.ok(listaEmpleados);
        }catch (Exception e) {
            response = ResponseEntity.ok(e.getCause());
        }
        return response;
    }

}
