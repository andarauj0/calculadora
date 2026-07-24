package com.andrey.calculadora.service;


import com.andrey.calculadora.dto.CalculoRequest;
import com.andrey.calculadora.dto.CalculoResponse;
import org.springframework.stereotype.Service;

@Service
public class CalculoService {




    public CalculoResponse calcular( CalculoRequest calculo) {
        double resultado = switch (calculo.getOperacao()) {

            case SOMAR -> (calculo.getValor1() + calculo.getValor2());
            case DIVIDIR -> (calculo.getValor1() / calculo.getValor2());
            case SUBTRAIR -> (calculo.getValor1() - calculo.getValor2());
            case MULTIPLICAR -> (calculo.getValor1() * calculo.getValor2());
        };
        CalculoResponse response = new CalculoResponse();
        response.setResultado(resultado);
        return response;
    }

}
