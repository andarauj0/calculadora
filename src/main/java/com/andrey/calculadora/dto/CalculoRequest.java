package com.andrey.calculadora.dto;

import com.andrey.calculadora.enums.Operacao;
import jakarta.validation.constraints.NotNull;

public class CalculoRequest {

    @NotNull(message = "Valor 1 é obrigatório!")
    private Double valor1;
    @NotNull(message = "Valor 2 é obrigatório!")
    private Double valor2;
    @NotNull(message = "Operação é obrigatório e deve estar em maiúsculo! Operações disponíveis: SOMAR, SUBTRAIR, MULTIPLICAR e DIVIDIR")
    private Operacao operacao;



    public Double getValor1() {
        return valor1;
    }
    public Double getValor2() {
        return valor2;
    }
    public Operacao getOperacao() {
        return operacao;
    }


    public void setValor1(Double valor1){
        this.valor1 = valor1;
    }
    public void setValor2(Double valor2){
        this.valor2 = valor2;
    }
    public void setOperacao(Operacao operacao){
        this.operacao = operacao;
    }

}
