package com.microservicios.calculadora.sample;

import com.microservicios.calculadora.dto.AutorDTO;

public class AutorDTOSample {

    public static AutorDTO getRequestAutorDTO(){
        return new AutorDTO("Paco","Perez");
    }

}
