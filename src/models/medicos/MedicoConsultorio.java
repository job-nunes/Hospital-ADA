package models.medicos;

import models.intermediarios.Fila;
import models.Paciente;
import models.Sala;
import models.enums.Especialidade;

public class MedicoConsultorio extends Medico{
    private Sala sala;
    public MedicoConsultorio(String nome, String cpf, Integer idade, Especialidade especialidade) {
        super(nome, cpf, idade, especialidade);
        this.sala = new Sala();
    }
    @Override
    public void chamarProximo() {
        if(Fila.getFilaConsulta(this.getEspecialidade()).size() > 0){
            Paciente paciente = Fila.getFilaConsulta(this.getEspecialidade()).get(0);
            System.out.println(this.getEspecialidade()+": " + this.getNome() +
                    " chamando paciente: " + paciente.getNome() + " para a sala: " + this.sala);
            Fila.removePacienteFilaConsulta(paciente);
            comecarConsulta(paciente);
        } else {
            System.out.println("A Fila está vazia! Bom Trabalho!");
        }
    }
    private void comecarConsulta(Paciente paciente) {
        this.sala.setMedico(this);
        this.sala.setPaciente(paciente);
        this.sala.realizarAtendimento();
    }
    @Override
    public void darDiagnostico(Paciente paciente) {
        System.out.println("Segundo seus sintomas de: ");
        paciente.listaSintomas();
        System.out.println("e minha especialidade "+this.getEspecialidade() +".");
        System.out.println("A solução para você é uma cervejinha");
        concluirPaciente(paciente);
    }
    @Override
    public void concluirPaciente(Paciente paciente) {
        System.out.println("Melhoras "+ paciente.getNome() + "!");
    }


}
