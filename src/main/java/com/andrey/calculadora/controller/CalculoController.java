package com.andrey.calculadora.controller;

import com.andrey.calculadora.dto.CalculoRequest;
import com.andrey.calculadora.service.CalculoService;
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
public class CalculoController {

    private final CalculoService service;

    public CalculoController(CalculoService service) {
        this.service = service;
    }

    @PostMapping("/calculo")
    public ResponseEntity<?> calcular(
            @Valid @RequestBody CalculoRequest calculo)
    {
        return ResponseEntity.ok(service.calcular(calculo));
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
