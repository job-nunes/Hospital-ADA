package models.intermediarios;

import models.Paciente;
import models.Pessoa;
import models.enums.Especialidade;

import java.util.*;
import java.util.stream.Collectors;

public class Fila {
    private static List<Pessoa> filaAtendimento = new ArrayList<>();
    private static List<Paciente> filaConsulta = new ArrayList<>();
    public static void printarFilaAtendimento() {
        if(filaAtendimento.size()>0){
            for(Pessoa pessoa : filaAtendimento){
                System.out.println("Nome: "+ pessoa.getNome()+".");
            }
        } else {
            System.out.println("Fila Vazia");
        }
    }
    public static List<Pessoa> getFilaAtendimento() {
        return filaAtendimento;
    }
    public static void addPessoaFilaAtendimento(Pessoa pessoa){
        filaAtendimento.add(pessoa);
        System.out.println(pessoa.getNome()+ " está na fila de atendimento");
    }
    public static void removePessoaFilaAtendimento(Pessoa pessoa){
        filaAtendimento.remove(pessoa);
    }

    public static void addPacienteFilaConsulta(Paciente paciente){
        filaConsulta.add(paciente);
        System.out.println(paciente.getNome()+ " está na fila de consultas para a especialidade: "+ paciente.getNecessidadeMedica());
    }
    public static void removePacienteFilaConsulta(Paciente paciente){
        filaConsulta.remove(paciente);
    }

    public static List<Paciente> getFilaConsulta() {
        return filaConsulta;
    }
    public static List<Paciente> getFilaConsulta(Especialidade especialidade) {
        return filaConsulta.stream().filter(paciente -> paciente.getNecessidadeMedica().equals(especialidade)).collect(Collectors.toList());
    }
    public static void printarFilaConsulta(Especialidade especialidade) {
        List<Paciente> listaFiltrada = filaConsulta.stream().filter(paciente -> paciente.getNecessidadeMedica().equals(especialidade)).collect(Collectors.toList());
        if(listaFiltrada.size() > 0){
            for(Paciente paciente : listaFiltrada){
                System.out.println("Nome: "+ paciente.getNome()+ " Necessidade: "+ paciente.getNecessidadeMedica());
            }
        } else {
            System.out.println("Fila Vazia");
        }

    }
    public static void printarFilaConsulta() {
        if(filaConsulta.size()>0){
            for(Paciente paciente : filaConsulta){
                System.out.println("Nome: "+ paciente.getNome()+ " Necessidade: "+ paciente.getNecessidadeMedica());
            }
        } else {
            System.out.println("Fila Vazia");
        }
    }
}
