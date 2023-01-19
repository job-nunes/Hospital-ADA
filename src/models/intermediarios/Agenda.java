package models.intermediarios;

import models.enums.Especialidade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {
    private static List<DataXEspecialidade> agendaList = new ArrayList<>();

    public static void addConsultaAgenda(DataXEspecialidade dataXEspecialidade){
        if(agendaList.contains(dataXEspecialidade)){
            System.out.println("Essa data já está ocupada");
        } else {
            System.out.println("Adicionou: " + dataXEspecialidade.getEspecialidade()+" "+ dataXEspecialidade.getDia());
            agendaList.add(dataXEspecialidade);
        }
    }

    public static void printarAgendaPorEspecialidade(Especialidade especialidade){
        List<DataXEspecialidade> listaFiltrada = agendaList.stream().
                filter(dataXEspecialidade -> dataXEspecialidade.getEspecialidade().equals(especialidade)).
                collect(Collectors.toList());
        if(listaFiltrada.size() > 0){
            for(DataXEspecialidade dataXEspecialidade : listaFiltrada){
                System.out.println("Data: "+ dataXEspecialidade.getDia()+"/"+ dataXEspecialidade.getMes()+"/"+ dataXEspecialidade.getAno()+ " Necessidade: "+ dataXEspecialidade.getEspecialidade());
            }
        } else {
            System.out.println("Fila Vazia");
        }
    }
}
