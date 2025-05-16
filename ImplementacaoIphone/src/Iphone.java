public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet{
    @Override
    public void ligar(String numero) {
        System.out.println("LIGANDO PARA O NUMERO " + numero);
    }

    @Override
    public void atender() {
        System.out.println("ATENDENDO TELEFONE");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("INICIANDO CORREIO DE VOZ");
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("EXIBINDO PÁGINA " + url);
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("NOVA ABA ADICIONADA");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("ATUALIZANDO PAGINA");
    }

    @Override
    public void tocar() {
        System.out.println("TOCANDO MUSICA");
    }

    @Override
    public void pausar() {
        System.out.println("MÚSICA PAUSADA");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("SELECIONANDO MÚSICA " + musica);
    }
}
