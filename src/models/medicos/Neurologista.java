package models.medicos;

import models.Sala;
import models.enums.Especialidade;
import models.Paciente;

public final class Neurologista extends MedicoConsultorio {

    public Neurologista(String nome, String cpf, Integer idade) {
        super(nome, cpf, idade, Especialidade.Neurologista);
    }
}
