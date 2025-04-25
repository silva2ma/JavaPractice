package fixação.ControleFinanceiro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GerenciadorFinanceiro controle = new GerenciadorFinanceiro();
        boolean executando = true;

        while (executando) {
            System.out.println("\n---- Menu de opções ----");
            System.out.println("[C] Consultar informações");
            System.out.println("[E] Realizar uma entrada");
            System.out.println("[S] Realizar uma saída");
            System.out.println("[X] Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scan.nextLine().toUpperCase();

            switch (opcao) {
                case "C":
                    System.out.println("\n--- Consultar Informações ---");
                    System.out.println("[1] Histórico");
                    System.out.println("[2] Saldo");
                    System.out.print("Escolha uma opção: ");
                    String subOpcao = scan.nextLine();

                    switch (subOpcao) {
                        case "1":
                            controle.mostrarHistorico();
                            break;
                        case "2":
                            System.out.printf("Saldo Atual: R$ %.2f\n", controle.calcularSaldo());
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;

                case "E":
                    System.out.print("Digite o valor da entrada: R$ ");
                    double entrada = Double.parseDouble(scan.nextLine());
                    controle.adicionarTransacao("Entrada", entrada);
                    System.out.println("Entrada registrada com sucesso!");
                    break;

                case "S":
                    System.out.print("Digite o valor da saída: R$ ");
                    double saida = Double.parseDouble(scan.nextLine());
                    controle.adicionarTransacao("Saída", saida);
                    System.out.println("Saída registrada com sucesso!");
                    break;

                case "X":
                    executando = false;
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scan.close();
    }
}
