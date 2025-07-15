package edu.eric.util;

import edu.eric.model.Conta;
import edu.eric.service.DepositoSemValorException;
import edu.eric.service.SaldoInsuficienteException;
import edu.eric.service.SenhaInvalidaException;
import edu.eric.service.TransferenciaException;

public interface IConta {
    void depositar(double valor) throws DepositoSemValorException;

    void sacar(double valor) throws SaldoInsuficienteException;

    void transferir(double valor, Conta contaDestino, String senha) throws TransferenciaException, SenhaInvalidaException, SaldoInsuficienteException;

    void imprimirExtrato();
}
