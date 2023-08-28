package com.example;

public class Anotacao {

    private String descricao_anotacao;

    public Anotacao(String descricao_anotacao) {
        this.descricao_anotacao = descricao_anotacao;
    }

    public String getDescricao_anotacao() {
        return descricao_anotacao;
    }

    public void setDescricao_anotacao(String descricao_anotacao) {
        this.descricao_anotacao = descricao_anotacao;
    }

    @Override
    public String toString() {
        return descricao_anotacao;
    }
}
