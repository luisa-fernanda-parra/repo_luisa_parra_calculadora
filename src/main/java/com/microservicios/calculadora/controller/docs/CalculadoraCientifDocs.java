package com.microservicios.calculadora.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

@Tag(name = "Calculadora científica")
public interface CalculadoraCientifDocs {

    @Operation(summary = "Servicio para obtener el factorial")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna el factorial de un número",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getFactorial(@PathVariable String numero);

    @Operation(summary = "Servicio para obtener los múltiplos")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna los múltiplos de un número hasta el número especificado en el properties",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getMultiplos(@PathVariable String numero);

    @Operation(summary = "Servicio para obtener el coseno")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna el coseno de un número medido en grados",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getCoseno(@PathVariable String numero);

    @Operation(summary = "Servicio para obtener la raiz cuadrada")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna la raiz cuadrada de un número",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getRaizCu(@PathVariable String numero);

    @Operation(summary = "Servicio para obtener el area de un círculo")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna el área de un círculo recibiendo como parámetro su radio",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getAreaCir(@PathVariable String radio);

    @Operation(summary = "Servicio para obtener el volumen de una esfera")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna el volumen de una esfera recibiendo como parámetro su radio",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getVolumenEsf(@PathVariable String radio);

    @Operation(summary = "Servicio para obtener los resultados de una ecuación cuadrática")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna los valores que satisfacen una ecuación cuadrática recibiendo como parámetro sus coeficientes",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getEcuacionCuad(@PathParam("a") String a, @PathParam("b") String b, @PathParam("c") String c);

}
