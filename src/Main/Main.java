package Main;
// Main.java
import java.util.Scanner;
import entities.*;

public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Gerenciamento de Estacionamento ---");
            System.out.println("1. Registrar Entrada");
            System.out.println("2. Registrar Saída");
            System.out.println("3. Exibir Vagas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    registrarEntrada(estacionamento, scanner);
                    break;
                case 2:
                    registrarSaida(estacionamento, scanner);
                    break;
                case 3:
                    estacionamento.exibirVagas();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void registrarEntrada(Estacionamento estacionamento, Scanner scanner) {
        System.out.println("Tipos de Veículo:");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        System.out.println("3. Caminhao");
        System.out.print("Escolha o tipo de veículo: ");
        int tipoVeiculo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Cor: ");
        String cor = scanner.nextLine();

        Veiculo veiculo;
        switch (tipoVeiculo) {
            case 1:
                veiculo = new Carro(placa, modelo, cor);
                break;
            case 2:
                veiculo = new Moto(placa, modelo, cor);
                break;
            case 3:
                veiculo = new Caminhao(placa, modelo, cor);
                break;
            default:
                System.out.println("Tipo de veículo inválido!");
                return;
        }

        estacionamento.registrarEntrada(veiculo);
    }

    private static void registrarSaida(Estacionamento estacionamento, Scanner scanner) {
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        estacionamento.registrarSaida(placa);
    }
}
