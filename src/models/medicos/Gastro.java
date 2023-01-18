package models.medicos;

import models.enums.Especialidade;

public final class Gastro extends MedicoConsultorio {
    public Gastro(String nome, String cpf, Integer idade) {
        super(nome, cpf, idade, Especialidade.Gastro);
    }
}
