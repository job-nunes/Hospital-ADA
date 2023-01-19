package models.intermediarios;

import models.enums.Especialidade;

import java.util.Objects;

public class DataXEspecialidade {
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

    public DataXEspecialidade(Integer dia, Integer mes, Integer ano, Especialidade especialidade) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.especialidade = especialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataXEspecialidade dataXEspecialidade = (DataXEspecialidade) o;
        return Objects.equals(dia, dataXEspecialidade.dia) && Objects.equals(mes, dataXEspecialidade.mes) && Objects.equals(ano, dataXEspecialidade.ano);
    }
}
