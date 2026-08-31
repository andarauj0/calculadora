package com.andrey.calculadora.controller;


import com.andrey.calculadora.dto.tabuada.TabuadaRequest;
import com.andrey.calculadora.service.TabuadaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TabuadaController {

    private final TabuadaService service;

    public TabuadaController(TabuadaService service) {
        this.service = service;
    }

    @GetMapping("/tabuada")
    public ResponseEntity<?> tabuada(
            @Valid @ModelAttribute TabuadaRequest calculo)
    {
        return ResponseEntity.ok(service.tabuada(calculo));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> errorTreatment(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> jsonErrorTreatment(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Operação inválida! Operações disponíveis: SOMAR, SUBTRAIR, MULTIPLICAR e DIVIDIR");
    }

}