import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            contador2(scanner);
        } catch (ParametrosInvalidosException e) {
            System.out.println("O segundo número deve ser maior que o primeiro. Por favor tente novamente!");
        }
    }

    static void contador(Scanner scanner) throws ParametrosInvalidosException {
        try {
            System.out.println("Digite o primeiro número: ");
            int numero1 = scanner.nextInt();

            System.out.println("Digite o segundo número: ");
            int numero2 = scanner.nextInt();

            System.out.println("Imprimir numeros pares ou impares do intervalo?");
            String parOuImpar = scanner.next();

            if (numero1 > numero2) {
                throw new ParametrosInvalidosException();
            } else {

                if(parOuImpar.equals("par")) {
                    for (int i = numero2; i >= numero1; i--) {
                        if(i % 2 == 0)
                            System.out.println("Imprimindo o número: " + i);
                    }
                } else if(parOuImpar.equals("impar")) {
                    for (int i = numero2; i >= numero1; i--) {
                        if(i % 2 != 0)
                            System.out.println("Imprimindo o número: " + i);
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("O parâmetro deve ser um NÚMERO INTEIRO. Por favor tente novamente!");
        } finally {
            scanner.close();
        }
    }

    static void contador2(Scanner scanner) throws ParametrosInvalidosException {

        System.out.println("Imforme o primeiro numero: ");
        double n1 = scanner.nextInt();

        double n = 0;

        double resto = 0;

        do {
            System.out.println("Informe os demais numeros:");
            n = scanner.nextInt();
            if(n < n1) {
                continue;
            }
            double resltadoDivisao = n / n1;
            int convertido = (int)resltadoDivisao;
            resto = (resltadoDivisao - convertido) * n1;
        } while (resto == 0);


    }
}