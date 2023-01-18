package models;

import models.medicos.Medico;
import models.medicos.MedicoConsultorio;

import java.util.Scanner;

public class Sala {
    private MedicoConsultorio medicoConsultorio;
    private Paciente paciente;
    private Integer sala;
    private static Integer contadorSalas = 100;

    public Medico getMedicoConsultorio() {
        return medicoConsultorio;
    }

    public void setMedico(MedicoConsultorio medicoConsultorio) {
        this.medicoConsultorio = medicoConsultorio;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


    public Integer getSala() {
        return sala;
    }

    public Sala(){
        this.sala = contadorSalas;
        contadorSalas++;
    }


    @Override
    public String toString() {
        return "Sala: "+ this.sala;
    }

    public void realizarAtendimento(){
        paciente.fichaCompletaPaciente();
        System.out.println("Olá,"+paciente.getNome()+" Bom dia! Me chamo "+medicoConsultorio.getNome()+" e vou realizar sua consulta hoje");
        realizarPerguntas();
    }

    private void realizarPerguntas() {
        Scanner scanner = new Scanner(System.in);
        Boolean continuarPeruntando = true;
        while (continuarPeruntando) {
            System.out.printf("Médico Perguntando: (0 para parar)");
            String digitado = scanner.nextLine();
            if (digitado.equals("0")) {
                break;
            }
            System.out.println("");
            System.out.println("Paciente Respondendo: ");
            scanner.nextLine();
        }

        this.medicoConsultorio.darDiagnostico(paciente);
    }


}
