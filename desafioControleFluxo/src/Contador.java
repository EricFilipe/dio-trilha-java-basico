import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            contador(scanner);
        } catch (ParametrosInvalidosException e) {
            System.out.println("O segundo número deve ser maior que o primeiro. Por favor tente novamente!");
        }
    }

    static void contador(Scanner scanner) throws ParametrosInvalidosException {
        boolean valido = false;
        try {
            System.out.println("Digite o primeiro número: ");
            int numero1 = scanner.nextInt();

            System.out.println("Digite o segundo número: ");
            int numero2 = scanner.nextInt();

            if (numero1 > numero2) {
                throw new ParametrosInvalidosException();
            } else {
                int ocorrencias = numero2 - numero1;
                System.out.println("Temos " + ocorrencias + " ocorrencias");
                for (int i = 1; i <= ocorrencias; i++) {
                    System.out.println("Imprimindo o número: " + i);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("O parâmetro deve ser um NÚMERO INTEIRO. Por favor tente novamente!");
        }
    }
}