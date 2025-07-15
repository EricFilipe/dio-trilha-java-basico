package edu.eric.model;

public class ContaCorrente extends Conta {


    public ContaCorrente(Cliente cliente, Banco banco, String senha) {
        super(cliente, banco, senha);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.informacoesConta();
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente.getNome() +
                ", banco=" + banco.getNome() +
                '}';
    }
}
