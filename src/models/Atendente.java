package models;

import models.enums.Funcao;
import models.intermediarios.Atendimento;
import models.intermediarios.Fila;

public final class Atendente extends Funcionario{
    public Atendente(String nome, String cpf, Integer idade) {
        super(nome, cpf, idade, Funcao.Atendente);
    }
    @Override
    public void chamarProximo() {
        if(Fila.getFilaAtendimento().size() > 0){
            Pessoa pessoa = Fila.getFilaAtendimento().get(0);
            System.out.println("Atendente: " + this.getNome() + " chamando paciente: " + pessoa.getNome());
            Fila.removePessoaFilaAtendimento(pessoa);
            comecarAtendimento(pessoa);
        } else {
            System.out.println("A Fila está vazia! Bom Trabalho!");
        }
    }
    private void comecarAtendimento(Pessoa pessoa) {
        Atendimento atendimento = new Atendimento(pessoa, this);
        atendimento.realizarAtendimento();
    }
}
