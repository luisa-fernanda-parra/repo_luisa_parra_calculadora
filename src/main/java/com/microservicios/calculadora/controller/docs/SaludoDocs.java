package com.microservicios.calculadora.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Bienvenida de la aplicacion")
public interface SaludoDocs {

    @Operation(summary = "Servicio para saludar")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna un saludo dependiendo de la hora",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getSaludo(@PathVariable String hora);

    @Operation(summary = "Servicio para listar las operaciones")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna el listado de todas las operaciones que se pueden realizar en la calculadora básica y la calculadora científica",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                    }
                    )
            }
    )
    ResponseEntity getOperaciones();

}
