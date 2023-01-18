package models;

import models.enums.Especialidade;
import models.enums.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {

    private List<Sintoma> sintomas;
    private Integer massa;
    private Especialidade necessidadeMedica;

    public Paciente(String nome,String cpf, Integer idade, Integer massa) {
        super(nome, cpf, idade);
        this.massa = massa;
        sintomas = new ArrayList<>();
    }

    public Paciente(String nome, Integer idade, Integer massa) {
        super(nome, idade);
        this.massa = massa;
        sintomas = new ArrayList<>();
    }

    public Paciente(Pessoa pessoa, Integer massa) {
        super(pessoa.getNome(),pessoa.getCPF(),pessoa.getIdade());
        this.massa = massa;
        sintomas = new ArrayList<>();
    }
    public void fichaCompletaPaciente(){
        System.out.println(this);
        listaSintomas();
    }
    public void listaSintomas(){
        System.out.println("SINTOMAS INFOMADOS:");
        for (Sintoma sintoma: sintomas) {
            System.out.println(sintoma);
        }
    }
    public void addSintoma(Sintoma sintoma){
        if(!this.sintomas.contains(sintoma)) {
            this.sintomas.add(sintoma);
            System.out.println("Sintoma Adicionado");
        } else {
            System.out.println("O sintoma já está marcado");
        }
    }
    public List<Sintoma> getSintomas() {
        return sintomas;
    }
    public Especialidade getNecessidadeMedica() {
        return this.necessidadeMedica;
    }
    public void setNecessidadeMedica(Especialidade necessidadeMedica) {
        this.necessidadeMedica = necessidadeMedica;
    }

    public Integer getMassa() {
        return massa;
    }
    public String toString(){
        return super.toString() + "Massa: " + this.massa + ", Necessidade: "+ this.getNecessidadeMedica()+ "\n";
    }

}
