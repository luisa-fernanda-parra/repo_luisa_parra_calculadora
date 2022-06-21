package com.microservicios.calculadora.controller.docs;

import com.microservicios.calculadora.dto.AutorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Tag(name = "CRUD de la tabla autor")
public interface AutorDocs {

    @Operation(summary = "Servicio para insertar un autor")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Este servicio inserta un registro en la tabla autor y retorna el registro que se acabó de guardar",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity guardarAutor(@RequestBody AutorDTO autorDTO);

    @Operation(summary = "Servicio para listar los autores")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna un listado de todos los autores guardados en la base de datos",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listarAutores();

    @Operation(summary = "Servicio para listar los autores por nombre (Native Query)")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna un listado de los autores que coincidan con el nombre recibido como parámetro",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listarAutPorNombreNativeQuery(@PathVariable String nombre);

    @Operation(summary = "Servicio para listar los autores por nombre (JPQL)")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna un listado de los autores que coincidan con el nombre recibido como parámetro",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listarAutPorNombreJpql(@PathVariable String nombre);

    @Operation(summary = "Servicio para listar los autores por nombre (Jpa Repository)")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna un listado de los autores que coincidan con el nombre recibido como parámetro",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listarAutPorNombreJpaRepository(@PathVariable String nombre);

    @Operation(summary = "Servicio para listar los autores por fecha (Native Query)")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna un listado de los autores que coincidan con la fecha recibida como parámetro",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listarAutPorFechaCNativeQuery(@PathVariable String fecha);

    @Operation(summary = "Servicio para listar los autores por fecha (JPQL)")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna un listado de los autores que coincidan con la fecha recibida como parámetro",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listarAutPorFechaCJpql(@PathParam("year") String year, @PathParam("month") String month, @PathParam("day") String day);

    @Operation(summary = "Servicio para listar los autores por fecha (Jpa Repository)")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna un listado de los autores que coincidan con la fecha recibida como parámetro",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listarAutPorFechaCJpaRepository(@PathParam("year") String year, @PathParam("month") String month, @PathParam("day") String day);

    @Operation(summary = "Servicio para obtener un autor por id (Native Query)")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna un el autor que coincida con el id recibido como parámetro",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listarAutPorIdNativeQuery(@PathVariable String id);

    @Operation(summary = "Servicio para obtener un autor por id (JPQL)")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna un el autor que coincida con el id recibido como parámetro",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listarAutPorIdJpql(@PathVariable String id);

    @Operation(summary = "Servicio para obtener un autor por id (Jpa Repository)")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna un el autor que coincida con el id recibido como parámetro",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listarAutPorIdJpaRepository(@PathVariable String id);

    @Operation(summary = "Servicio para actualizar los datos de un autor")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Este servicio actualiza un autor dependeiendo de los datos recibidos como parámetro y retorna un mensaje dependiendo de si la operación fue exitosa o no",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity actualizarAutor(@PathVariable Long id, @RequestBody AutorDTO autorDTO);

    @Operation(summary = "Servicio para borrar definitivamente un autor")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Este servicio elimina un autor dependeiendo del id recibid como parámetro y retorna un mensaje dependiendo de si la operación fue exitosa o no",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity deleteHard(@PathVariable Long id);

    @Operation(summary = "Servicio para hacer borrado lógico a un autor")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Este servicio actualiza la fecha de eliminación de un autor dependeiendo del id recibid como parámetro y retorna un mensaje dependiendo de si la operación fue exitosa o no",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity deleteLogic(@PathVariable Long id);

}
