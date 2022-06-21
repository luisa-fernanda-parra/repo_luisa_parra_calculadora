package com.microservicios.calculadora.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.websocket.server.PathParam;

@Tag(name = "Calculadora básica")
public interface CalculadoraDocs {

    @Operation(summary = "Servicio para sumar")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna la suma de dos números",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getSuma(@PathParam("num1") String num1, @PathParam("num2") String num2);

    @Operation(summary = "Servicio para restar")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna la resta de dos números",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getResta(@PathParam("num1") String num1, @PathParam("num2") String num2);

    @Operation(summary = "Servicio para multiplicar")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna la multiplicación de dos números",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getMultiplicacion(@PathParam("num1") String num1, @PathParam("num2") String num2);

    @Operation(summary = "Servicio para dividir")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna la división de dos números",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getDivision(@PathParam("num1") String num1, @PathParam("num2") String num2);

}
