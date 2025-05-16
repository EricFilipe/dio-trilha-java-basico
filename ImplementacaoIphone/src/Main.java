import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        int opcao2 = 0;
        do {
            System.out.println("ESCOLHA UMA OPCAO");
            System.out.println("1- Reprodutor Musical");
            System.out.println("2- Aparelho Telefônico");
            System.out.println("3- Navegador na Internet");
            System.out.println("0- sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("O QUE QUER FAZER?");
                    System.out.println("1- Tocar");
                    System.out.println("2- Pausar");
                    System.out.println("3- Selecionar musica");
                    opcao2 = scanner.nextInt();

                    switch (opcao2) {
                        case 1: iphone.tocar(); break;
                        case 2: iphone.pausar(); break;
                        case 3:
                            System.out.println("INFORME A MÚSICA");
                            String musica = scanner.next();
                            iphone.selecionarMusica(musica);
                            break;
                        default:
                            System.out.println("opcao invalida");
                    }
                    break;

                case 2:
                    System.out.println("O QUE QUER FAZER?");
                    System.out.println("1- Ligar");
                    System.out.println("2- Atender");
                    System.out.println("3- Iniciar correio de voz");
                    System.out.println("0- Sair");
                    opcao2 = scanner.nextInt();

                    switch (opcao2) {
                        case 1:
                            System.out.println("INFORME O NÚMERO");
                            String numero = scanner.next();
                            iphone.ligar(numero);
                            break;
                        case 2: iphone.atender(); break;
                        case 3: iphone.iniciarCorreioVoz(); break;
                        default:
                            System.out.println("opcao invalida");
                    }
                    break;

                case 3:
                    System.out.println("O QUE QUER FAZER?");
                    System.out.println("1- Exibir pagina");
                    System.out.println("2- Adicionar nova aba");
                    System.out.println("3- Atualizar pagina");
                    opcao2 = scanner.nextInt();

                    switch (opcao2) {
                        case 1:
                            System.out.println("INFORME A URL");
                            String url = scanner.next();
                            iphone.exibirPagina(url);
                            break;
                        case 2: iphone.adicionarNovaAba(); break;
                        case 3: iphone.atualizarPagina(); break;
                        default:
                            System.out.println("opcao invalida");
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("opcao invalida");
            }
        } while (opcao != 0);

    }
}