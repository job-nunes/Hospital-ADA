package models.intermediarios;

import models.enums.Especialidade;

import java.util.Objects;

public class DataEspecialidade {
    private Integer dia;
    private Integer mes;
    private Integer ano;
    private Especialidade especialidade;

    public Integer getDia() {
        return dia;
    }

    public Integer getMes() {
        return mes;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public Integer getAno() {
        return ano;
    }

    public DataEspecialidade(Integer dia, Integer mes, Integer ano, Especialidade especialidade) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.especialidade = especialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataEspecialidade dataEspecialidade = (DataEspecialidade) o;
        return Objects.equals(dia, dataEspecialidade.dia) && Objects.equals(mes, dataEspecialidade.mes) && Objects.equals(ano, dataEspecialidade.ano);
    }
}
