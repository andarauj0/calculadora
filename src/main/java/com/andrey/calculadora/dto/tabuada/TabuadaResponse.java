package com.andrey.calculadora.dto.tabuada;

import com.andrey.calculadora.dto.calculadora.CalculoResponse;

import java.util.List;

public class TabuadaResponse {
    private List<CalculoResponse> tabuadaResultado;

    public List<CalculoResponse> getTabuadaResultado(){
        return tabuadaResultado;
    }
    public void setTabuadaResultado(List<CalculoResponse> tabuadaResultado){
        this.tabuadaResultado = tabuadaResultado;
    }
}
