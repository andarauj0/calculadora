package com.andrey.calculadora.service;

import com.andrey.calculadora.dto.calculadora.CalculoResponse;
import com.andrey.calculadora.dto.tabuada.TabuadaRequest;
import com.andrey.calculadora.dto.tabuada.TabuadaResponse;
import com.andrey.calculadora.enums.Operacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TabuadaService {

    private final CalculoService calcular;

    public TabuadaService(CalculoService calcular) {
        this.calcular = calcular;
    }

    public TabuadaResponse tabuada(TabuadaRequest request){
        List<CalculoResponse> tabuadaResultado = new ArrayList<>();

        for (int i = 1; i <= 10; i++){
            CalculoResponse n = calcular.calcular(request.getValor(), i, Operacao.MULTIPLICAR);
            tabuadaResultado.add(n);
        }
        TabuadaResponse response = new TabuadaResponse();
        response.setTabuadaResultado(tabuadaResultado);
        return response;
    }
}
