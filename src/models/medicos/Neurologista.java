package models.medicos;

import models.enums.Especialidade;

public final class Neurologista extends MedicoConsultorio {

    public Neurologista(String nome, String cpf, Integer idade) {
        super(nome, cpf, idade, Especialidade.Neurologista);
    }
}
