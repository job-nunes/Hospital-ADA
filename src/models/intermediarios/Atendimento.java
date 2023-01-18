package models.intermediarios;
import models.Atendente;
import models.Paciente;
import models.Pessoa;
import models.enums.Especialidade;
import models.enums.Sintoma;
import java.util.Collections;
import java.util.Scanner;

public class Atendimento {
    private Paciente paciente;
    private Pessoa pessoa;
    private Atendente atendente;
    private static Scanner scanner = new Scanner(System.in);
    public Atendimento(Pessoa pessoa, Atendente atendente) {
        this.pessoa = pessoa;
        this.atendente = atendente;
    }
    public void realizarAtendimento(){
        System.out.println("Olá,"+pessoa.getNome()+" Bom dia! Me chamo "+atendente.getNome()+" e vou realizar seu primeiro atendimento hoje");
        solicitarInfomacoes();
    }
    private void solicitarInfomacoes(){
        Boolean isDigitouErrado = true;
        System.out.println("Você deseja realizar uma consulta agora ou agendar uma consulta? (Digite o número, um de cada vez)");
        System.out.println("1 - Realizar agora e aguardar na fila");
        System.out.println("2 - Agendar a consulta");
        String opcaoDigitada = scanner.next();
        while(isDigitouErrado){
            switch (opcaoDigitada){
                case "1":
                    System.out.println("agora");
                    isDigitouErrado = false;
                    break;
                case "2":
                    System.out.println("agendar");
                    isDigitouErrado = false;
                    break;
                default:
                    System.out.println("digite alguma das opções");
                    break;
            }
        }
        solicitarMassa();
        encaminharAgendaOuConsulta(opcaoDigitada);
    }
    private void solicitarMassa() {
        System.out.println("Quanto voce pesa?");
        int massa = scanner.nextInt();
        criarPaciente(massa);
    }
    private void criarPaciente(int massa) {
        if(pessoa.getCPF() != null){
            this.paciente = new Paciente(this.pessoa.getNome(), this.pessoa.getCPF(), this.pessoa.getIdade(), massa);
        } else {
            this.paciente = new Paciente(this.pessoa.getNome(), this.pessoa.getIdade(), massa);
        }
        solicitarSintomas();
    }
    private void solicitarSintomas() {
        Boolean isAindaPossuiSintomas = true;
        System.out.println("O que você está sentindo, " + this.pessoa.getNome() + "? (Digite o número, um de cada vez)");
        Sintoma.mostraTodosSintomas();
        System.out.println("9 - Informei tudo que estava sentindo.");
        while (isAindaPossuiSintomas) {
            System.out.println("Digite o número: (um de cada vez)");
            String opcaoDigitada = scanner.next();
            switch (opcaoDigitada) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                    try {
                        this.paciente.addSintoma(Sintoma.buscaSintomaPeloId(opcaoDigitada));
                    } catch (Exception exception) {
                        exception.getMessage();
                    }
                    break;
                case "9":
                    isAindaPossuiSintomas = false;
                    break;
                default:
                    System.out.println("digite alguma das opções");
                    break;
            }
        }
        verificaNecessidadeDoPaciente();
    }
    private void verificaNecessidadeDoPaciente() {
        if(!Collections.disjoint(this.paciente.getSintomas(), Sintoma.getSintomaListCirurgiao())){
            paciente.setNecessidadeMedica(Especialidade.Cirurgiao);
        } else if (!Collections.disjoint(this.paciente.getSintomas(), Sintoma.getSintomaListGastro())){
            paciente.setNecessidadeMedica(Especialidade.Gastro);
        } else if (!Collections.disjoint(this.paciente.getSintomas(), Sintoma.getSintomaListNeurologista())) {
            paciente.setNecessidadeMedica(Especialidade.Neurologista);
        } else {
            paciente.setNecessidadeMedica(Especialidade.Clinico_Geral);
        }
    }
    private void encaminharAgendaOuConsulta(String opcaoDigitada) {
        if(opcaoDigitada.equals("1")){
            Fila.addPacienteFilaConsulta(this.paciente);
        } else {
            solicitarAgenda();
        }
    }
    private void solicitarAgenda() {
        System.out.println("Informe o dia:");
        Integer dia = scanner.nextInt();
        System.out.println("Informe o mês:");
        Integer mes = scanner.nextInt();
        System.out.println("Informe o ano:");
        Integer ano = scanner.nextInt();
        DataEspecialidade dataEspecialidade = new DataEspecialidade(dia,mes,ano,paciente.getNecessidadeMedica());
        Agenda.addConsultaAgenda(dataEspecialidade);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public Atendente getAtendente() {
        return this.atendente;
    }
}
