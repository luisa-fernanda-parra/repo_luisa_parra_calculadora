package com.microservicios.calculadora.providers;

import com.microservicios.calculadora.dto.api.dummy.ResponseBodyDTO;
import com.microservicios.calculadora.dto.api.dummy.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "restapiexample",
        url = "${restapiexample.url}"
)
public interface EmployeeProvider {

    @GetMapping("/employees")
    ResponseBodyDTO getListEmployee();

    @GetMapping("/employee/{id}")
    ResponseDTO getEmployee(@PathVariable Long id);

}
