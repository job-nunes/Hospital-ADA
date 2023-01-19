import menu.Menu;
import models.*;
import models.medicos.*;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        MedicoConsultorio medicoGastro = new Gastro("job medicoGastro","15215106797",22);
        MedicoConsultorio medicoNeuro = new Neurologista("job medicoNeuro","15215106797",22);
        MedicoConsultorio medicoClinico = new ClinicoGeral("job medicoClinico","15215106797",22);
        Cirurgiao medicoCirurgiao = new Cirurgiao("job medicoCirurgiao","15215106797",22);
        Atendente atendente = new Atendente("job atendente","15215106797",22);
        System.out.println("# HOSPITAL ADA #");
        Boolean continuarHospital = true;
        String opcaoDigitada;
        while(continuarHospital){
            System.out.println("Digite a opção que deseja");
            System.out.println("1 - Nova Pessoa no hospital");
            System.out.println("2 - Acessar com Atendente");
            System.out.println("3 - Acessar Médico Gastro");
            System.out.println("4 - Acessar Médico Neuro");
            System.out.println("5 - Acessar Médico Clinico");
            System.out.println("6 - Acessar Médico Cirurgiao");
            System.out.println("7 - Sair do Hospital");
            opcaoDigitada = scanner.next();
            switch (opcaoDigitada){
                case "1":
                    Menu.criarPessoa();
                    break;
                case "2":
                    Menu.menuAtendente(atendente);
                    break;
                case "3":
                    Menu.menuMedico(medicoGastro);
                    break;
                case "4":
                    Menu.menuMedico(medicoNeuro);
                    break;
                case "5":
                    Menu.menuMedico(medicoClinico);
                    break;
                case "6":
                    Menu.menuMedicoCirurgiao(medicoCirurgiao);
                    break;
                case "7":
                    continuarHospital = false;
                    break;
                default:
                    System.out.println("Digite alguma das informações solicitadas");
            }
        }
        System.out.println("Obrigado por participar! Volte Sempre!");
    }
}