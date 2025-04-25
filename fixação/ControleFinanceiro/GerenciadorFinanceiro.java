package fixação.ControleFinanceiro;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorFinanceiro {

    private List<Transacao> transacoes;

    public GerenciadorFinanceiro() {
        this.transacoes = new ArrayList<>(); 
    }

    public void adicionarTransacao(String tipo, double valor) {
        transacoes.add(new Transacao(tipo, valor));  
    }

    public void mostrarHistorico() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            for (Transacao t : transacoes) {
                System.out.println(t);
            }
            System.out.println("Saldo atual: R$ " + String.format("%.2f", calcularSaldo()));

        }
    }

    public double calcularSaldo() {
        double saldo = 0;
        for (Transacao t : transacoes) {
            if (t.getTipo().equalsIgnoreCase("Entrada")) {
                saldo += t.getValor();
            } else {
                saldo -= t.getValor();
            }
        }
        return saldo;
    }

    public double totalEntradas() {
        double total = 0;
        for (Transacao t : transacoes) {
            if (t.getTipo().equalsIgnoreCase("Entrada")) {
                total += t.getValor();
            }
        }
        return total;
    }

    public double totalSaidas() {
        double total = 0;
        for (Transacao t : transacoes) {
            if (t.getTipo().equalsIgnoreCase("Saída")) {
                total += t.getValor();
            }
        }
        return total;
    }
}
