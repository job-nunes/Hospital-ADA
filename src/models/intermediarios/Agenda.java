package models.intermediarios;

import models.Paciente;
import models.enums.Especialidade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {
    private static List<DataEspecialidade> agendaList = new ArrayList<>();

    public static void addConsultaAgenda(DataEspecialidade dataEspecialidade){
        if(agendaList.contains(dataEspecialidade)){
            System.out.println("Essa data já está ocupada");
        } else {
            agendaList.add(dataEspecialidade);
        }
    }

    public static void printarAgendaPorEspecialidade(Especialidade especialidade){
        List<DataEspecialidade> listaFiltrada = agendaList.stream().filter(dataEspecialidade -> dataEspecialidade.getEspecialidade().equals(especialidade)).collect(Collectors.toList());
        if(listaFiltrada.size() > 0){
            for(DataEspecialidade dataEspecialidade : listaFiltrada){
                System.out.println("Data: "+dataEspecialidade.getDia()+"/"+dataEspecialidade.getMes()+"/"+dataEspecialidade.getAno()+ " Necessidade: "+ dataEspecialidade.getEspecialidade());
            }
        } else {
            System.out.println("Fila Vazia");
        }
    }
}
