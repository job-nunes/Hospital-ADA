package models.medicos;

import models.*;
import models.enums.Especialidade;
import models.enums.Funcao;
import models.intermediarios.Agenda;

import java.util.ArrayList;
import java.util.List;

public abstract class Medico extends Funcionario {
    private Especialidade especialidade;
    public Medico(String nome, String cpf, Integer idade, Especialidade especialidade) {
        super(nome, cpf, idade, Funcao.Medico);
        this.especialidade = especialidade;
    }

    public Especialidade getEspecialidade() {
        return this.especialidade;
    }
    public abstract void concluirPaciente(Paciente paciente);
    public abstract void darDiagnostico(Paciente paciente);

    @Override
    public String toString(){
        return super.toString() +
                "\nEspecialidade: " + this.especialidade;
    }
}
