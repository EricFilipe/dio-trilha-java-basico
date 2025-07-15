package edu.eric.model;

public class ContaPoupanca extends Conta{

    public ContaPoupanca() {}

    public ContaPoupanca(Cliente cliente, Banco banco, String senha) {
        super(cliente, banco, senha);
    }

    public void jurosPoupanca() {
        double juros = 0;

        if(ContaPoupanca.super.saldo >= 0 && ContaPoupanca.super.saldo < 100) {
            juros = 5 * ContaPoupanca.super.getSaldo() / 100;
            ContaPoupanca.super.saldo += juros;
        } else {
            juros = 10 * ContaPoupanca.super.getSaldo() / 100;
            ContaPoupanca.super.saldo += juros;
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupanca ===");
        super.informacoesConta();
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "numero=" + numero +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", cliente=" + cliente.getNome() +
                ", banco=" + banco.getNome() +
                '}';
    }
}
