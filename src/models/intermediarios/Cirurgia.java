package models.intermediarios;

import models.Paciente;
import models.medicos.Cirurgiao;
import models.medicos.Medico;
import models.medicos.MedicoConsultorio;

import java.util.Scanner;

public class Cirurgia {
    private Cirurgiao cirugiao;
    private Paciente paciente;
    private Integer salaDeCirurgia;
    private static Integer contadorSalasDeCirurgia = 1000;

    public Cirurgiao getCirurgiao() {
        return cirugiao;
    }

    public void setCirurgiao(Cirurgiao cirugiao) {
        this.cirugiao = cirugiao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


    public Integer getSalaDeCirurgia() {
        return this.salaDeCirurgia;
    }

    public Cirurgia(){
        this.salaDeCirurgia = contadorSalasDeCirurgia;
        contadorSalasDeCirurgia++;
    }


    @Override
    public String toString() {
        return "Sala: "+ this.salaDeCirurgia;
    }

    public void realizarAtendimento(){
        paciente.fichaCompletaPaciente();
        System.out.println("Olá,"+ paciente.getNome()+" Bom dia! Me chamo "+ cirugiao.getNome()+" e vou realizar sua CIRURGIA hoje");
        analisarSintomas();
    }

    private void analisarSintomas() {
        System.out.println("Analisando sintomas do Paciente para realização da cirurgia");
        aplicarAnestesia();
    }

    private void aplicarAnestesia() {
        System.out.println("Aplicar anestesia com base no peso do paciente. Massa: "+this.paciente.getMassa());
        realizarCirurgia();
    }

    private void realizarCirurgia() {
        System.out.println("Realizando Cirurgia");
        cirugiao.darDiagnostico(this.paciente);
    }

}
