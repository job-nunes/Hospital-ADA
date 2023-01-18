package models;

import models.enums.Especialidade;
import models.intermediarios.Agenda;
import models.intermediarios.Fila;
import models.medicos.Cirurgiao;
import models.medicos.MedicoConsultorio;

import java.util.Scanner;

public class Menu {
    //private static Scanner scanner = new Scanner(System.in);
    public static void criarPessoa(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Você estará criando uma pessoa para dar entrada no hospital");
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite a idade: ");
        Integer idade = scanner.nextInt();
        Pessoa pessoa = new Pessoa(nome, idade);
        if(idade > 15) {
            System.out.println("Digite o CPF: (sem ponto e traços)");
            String cpf = scanner.next();
            pessoa.setCpf(cpf);
        }
        Fila.addPessoaFilaAtendimento(pessoa);
    }
    public static void menuAtendente(Atendente atendente){
        Scanner scanner = new Scanner(System.in);
        Boolean isManterMenuAtendente = true;
        System.out.println("Você está com o Atendente: "+ atendente.getNome());
        String opcaoDigitada;
        while (isManterMenuAtendente){
            System.out.println("Digite sua opção");
            System.out.println("1 - Chamar próxima pessoa da fila de atendimentos: ");
            System.out.println("2 - Visualizar fila de Atendimentos");
            System.out.println("3 - Visualizar fila de Consultas ");
            System.out.println("4 - Visualizar suas credenciais");
            System.out.println("5 - Voltar ao Menu principal");
            opcaoDigitada = scanner.nextLine();
            switch (opcaoDigitada) {
                case "1":
                    atendente.chamarProximo();
                    break;
                case "2":
                    Fila.printarFilaAtendimento();
                    break;
                case "3":
                    Fila.printarFilaConsulta();
                    break;
                case "4":
                    System.out.println(atendente);
                    break;
                case "5":
                    isManterMenuAtendente = false;
                    break;
                default:
                    System.out.println("Digite uma opção valida");
            }
        }
    }
    public static void menuMedico(MedicoConsultorio medicoConsultorio){
        Scanner scanner = new Scanner(System.in);
        Boolean isManterMenuAtendente = true;
        System.out.println("Você está com o Médico: "+ medicoConsultorio.getNome());
        String opcaoDigitada;
        while (isManterMenuAtendente){
            System.out.println("Digite sua opção");
            System.out.println("1 - Chamar próxima pessoa da fila de consulta: ");
            System.out.println("2 - Visualizar sua fila de Consultas ");
            System.out.println("3 - Visualizar suas credenciais ");
            System.out.println("4 - Visualizar sua agenda");
            System.out.println("5 - Voltar ao Menu principal");
            opcaoDigitada = scanner.nextLine();
            switch (opcaoDigitada) {
                case "1":
                    medicoConsultorio.chamarProximo();
                    break;
                case "2":
                    Fila.printarFilaConsulta(medicoConsultorio.getEspecialidade());
                    break;
                case "3":
                    System.out.println(medicoConsultorio);
                    break;
                case "4":
                    Agenda.printarAgendaPorEspecialidade(medicoConsultorio.getEspecialidade());
                    break;
                case "5":
                    isManterMenuAtendente = false;
                    break;
                default:
                    System.out.println("Digite uma opção valida");
            }
        }
    }
    public static void menuMedicoCirurgiao(Cirurgiao cirurgiao){
        Scanner scanner = new Scanner(System.in);
        Boolean isManterMenuAtendente = true;
        System.out.println("Você está com o Médico: "+ cirurgiao.getNome());
        String opcaoDigitada;
        while (isManterMenuAtendente){
            System.out.println("Digite sua opção");
            System.out.println("1 - Chamar próxima pessoa da fila de cirurgia: ");
            System.out.println("2 - Visualizar sua fila de cirurgias");
            System.out.println("3 - Visualizar suas credenciais");
            System.out.println("4 - Visualizar sua agenda");
            System.out.println("5 - Voltar ao Menu principal");
            opcaoDigitada = scanner.nextLine();
            switch (opcaoDigitada) {
                case "1":
                    cirurgiao.chamarProximo();
                    break;
                case "2":
                    Fila.printarFilaConsulta(cirurgiao.getEspecialidade());
                    break;
                case "3":
                    System.out.println(cirurgiao);
                    break;
                case "4":
                    Agenda.printarAgendaPorEspecialidade(Especialidade.Cirurgiao);
                    break;
                case "5":
                    isManterMenuAtendente = false;
                    break;
                default:
                    System.out.println("Digite uma opção valida");
            }
        }
    }
}
