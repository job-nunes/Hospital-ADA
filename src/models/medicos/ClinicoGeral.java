package models.medicos;

import models.enums.Especialidade;

public final class ClinicoGeral extends MedicoConsultorio {

    public ClinicoGeral(String nome, String cpf, Integer idade) {
        super(nome, cpf, idade, Especialidade.Clinico_Geral);
    }

}
