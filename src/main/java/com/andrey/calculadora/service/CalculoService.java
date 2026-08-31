package com.andrey.calculadora.service;


import com.andrey.calculadora.dto.calculadora.CalculoResponse;
import com.andrey.calculadora.enums.Operacao;
import org.springframework.stereotype.Service;

@Service
public class CalculoService {




    public CalculoResponse calcular(double valor1, double valor2, Operacao operacao){
        double resultado = switch (operacao) {

            case SOMAR -> (valor1 + valor2);
            case DIVIDIR -> (valor1 / valor2);
            case SUBTRAIR -> (valor1 - valor2);
            case MULTIPLICAR -> (valor1 * valor2);
        };
        CalculoResponse response = new CalculoResponse();
        response.setResultado(resultado);
        return response;
    }

}
