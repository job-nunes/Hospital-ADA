package models.medicos;

import models.intermediarios.Cirurgia;
import models.intermediarios.Fila;
import models.enums.Especialidade;
import models.Paciente;

public final class Cirurgiao extends Medico {
    private Cirurgia salaDeCirurgia;
    public Cirurgiao(String nome, String cpf, Integer idade) {
        super(nome, cpf, idade, Especialidade.Cirurgiao);
        this.salaDeCirurgia = new Cirurgia();
    }

    @Override
    public void chamarProximo() {
        if(Fila.getFilaConsulta(this.getEspecialidade()).size() > 0){
            Paciente paciente = Fila.getFilaConsulta(this.getEspecialidade()).get(0);
            System.out.println(this.getEspecialidade()+": " + this.getNome() +
                    " chamando paciente: " + paciente.getNome() + " para a sala de cirurgia: ");
            Fila.removePacienteFilaConsulta(paciente);
            comecarCirurgia(paciente);
        } else {
            System.out.println("A Fila está vazia! Bom Trabalho!");
        }
    }

    private void comecarCirurgia(Paciente paciente) {
        salaDeCirurgia.setCirurgiao(this);
        salaDeCirurgia.setPaciente(paciente);
    }


    @Override
    public void darDiagnostico(Paciente paciente) {
        System.out.println("Olá, "+ paciente.getNome());
        System.out.println("Sua Cirurgia foi um sucesso e conseguimos corrigir seus sintomas");
        paciente.listaSintomas();
        concluirPaciente(paciente);
    }

    @Override
    public void concluirPaciente(Paciente paciente) {
        System.out.println("Melhoras "+ paciente.getNome() + "!");
    }
}
