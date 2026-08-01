package com.andrey.calculadora.dto.tabuada;

import jakarta.validation.constraints.NotNull;

public class TabuadaRequest {
    @NotNull(message = "Informe o valor no parâmetro!")
    private Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
