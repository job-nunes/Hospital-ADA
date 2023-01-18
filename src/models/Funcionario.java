package models;

import models.enums.Funcao;

public abstract class Funcionario extends Pessoa {
    private Funcao funcao;
    private String cracha;
    public Funcionario(String nome, String cpf, Integer idade, Funcao funcao) {
        super(nome, cpf, idade);
        this.funcao = funcao;
        this.cracha = funcao.getSigla() + "_" + cpf.substring(0,3) + "_" + nome.split(" ")[0];
    }
    public abstract void chamarProximo();

    public Funcao getFuncao() {
        return funcao;
    }
    @Override
    public String toString(){
        return super.toString() +
                "\nCrachá: " + this.cracha +
                "\nFunção: " + this.funcao;

    }

}
