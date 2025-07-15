import edu.eric.model.*;
import edu.eric.service.DepositoSemValorException;
import edu.eric.service.SaldoInsuficienteException;
import edu.eric.service.SenhaInvalidaException;
import edu.eric.service.TransferenciaException;


public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Eric");
        Banco banco = new Banco("itau");

        Conta cc = new ContaCorrente(cliente, banco, "senha1");
        ContaPoupanca poupanca = new ContaPoupanca(cliente, banco, "senha2");

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        try {
            cc.depositar(100);
            cc.transferir(50, poupanca, "senha1");

            poupanca.jurosPoupanca();

            cc.imprimirExtrato();
            poupanca.imprimirExtrato();

            banco.getContas();
            banco.exibirClientes();
        } catch (TransferenciaException e) {
            System.out.println("Nao e permitido transferir para a mesma conta");
        } catch (SenhaInvalidaException e) {
            System.out.println("Senha incorreta");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Saldo insuficiente");
        } catch (DepositoSemValorException e ) {
            System.out.println("Deposito precisa ser maior que R$ 0,00");
        }

    }
}