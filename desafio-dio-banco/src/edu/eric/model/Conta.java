package edu.eric.model;

import edu.eric.service.DepositoSemValorException;
import edu.eric.service.SaldoInsuficienteException;
import edu.eric.service.SenhaInvalidaException;
import edu.eric.service.TransferenciaException;
import edu.eric.util.IConta;

public abstract class Conta implements IConta {
    private static final int AGENCIA = 1;
    private static int sequencial = 1;

    protected int agencia;
    protected int numero = 1;
    protected double saldo;
    protected String senha;
    protected Cliente cliente;
    protected Banco banco;

    public Conta(Cliente cliente, Banco banco, String senha) {
        this.cliente = cliente;
        this.banco = banco;
        this.agencia = AGENCIA;
        this.numero = sequencial++;
        this.senha = senha;
    }

    public Conta() {}

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void depositar(double valor) throws DepositoSemValorException {
        if(valor <= 0) {
            throw new DepositoSemValorException();
        } else {
            this.saldo += valor;
        }
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if(valor > saldo) {
            throw new SaldoInsuficienteException();
        } else {
            this.saldo -= valor;
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino, String senha) throws TransferenciaException, SenhaInvalidaException, SaldoInsuficienteException {
        int contaOringem = this.numero;
        if(valor > saldo) {
            throw new SaldoInsuficienteException();
        } else if (contaDestino.numero == contaOringem) {
            throw new TransferenciaException();
        } else if (!senha.equals(this.senha)) {
            throw new SenhaInvalidaException();
        } else {
            sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    public void informacoesConta() {
        System.out.println("Banco: " + this.banco.getNome());
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Numero: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
    }
}
