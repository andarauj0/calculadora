package com.andrey.calculadora.enums;

public enum Operacao {
    SOMAR("+"),
    SUBTRAIR("-"),
    MULTIPLICAR("*"),
    DIVIDIR("/");

    private final String simbolo;

    Operacao (String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
