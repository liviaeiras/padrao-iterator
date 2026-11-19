package iterator;

import java.util.NoSuchElementException;

public class TesteIterator {
    public static void main(String[] args) {
        testeSequencial();
        testeReverso();
        testePorArtista();
        testePorArtistaSemResultado();
        testeFimDaIteracaoLancaExcecao();
        testePlaylistVazia();
        testeIteradoresIndependentes();
        System.out.println("Todos os testes passaram");
    }

    private static Playlist montarPlaylist() {
        Playlist playlist = new Playlist();
        playlist.adicionar(new Musica("M1", "Banda A", 100));
        playlist.adicionar(new Musica("M2", "Banda B", 120));
        playlist.adicionar(new Musica("M3", "Banda A", 140));
        return playlist;
    }

    private static String percorrer(Iterador<Musica> iterador) {
        StringBuilder titulos = new StringBuilder();
        while (iterador.temProximo()) {
            titulos.append(iterador.proximo().getTitulo()).append(";");
        }
        return titulos.toString();
    }

    private static void testeSequencial() {
        verificar("M1;M2;M3;".equals(percorrer(montarPlaylist().criarIterador())), "iterador sequencial segue a ordem de insercao");
    }

    private static void testeReverso() {
        verificar("M3;M2;M1;".equals(percorrer(montarPlaylist().criarIteradorReverso())), "iterador reverso segue a ordem inversa");
    }

    private static void testePorArtista() {
        verificar("M1;M3;".equals(percorrer(montarPlaylist().criarIteradorPorArtista("banda a"))), "iterador por artista filtra ignorando maiusculas");
    }

    private static void testePorArtistaSemResultado() {
        verificar(!montarPlaylist().criarIteradorPorArtista("Banda Z").temProximo(), "iterador por artista sem resultado nao tem proximo");
    }

    private static void testeFimDaIteracaoLancaExcecao() {
        Iterador<Musica> iterador = montarPlaylist().criarIterador();
        percorrer(iterador);
        boolean lancou = false;
        try {
            iterador.proximo();
        } catch (NoSuchElementException e) {
            lancou = true;
        }
        verificar(lancou, "proximo apos o fim lanca NoSuchElementException");
    }

    private static void testePlaylistVazia() {
        verificar(!new Playlist().criarIterador().temProximo(), "playlist vazia nao tem proximo");
    }

    private static void testeIteradoresIndependentes() {
        Playlist playlist = montarPlaylist();
        Iterador<Musica> a = playlist.criarIterador();
        Iterador<Musica> b = playlist.criarIterador();
        a.proximo();
        a.proximo();
        verificar("M1".equals(b.proximo().getTitulo()), "dois iteradores mantem posicoes independentes");
    }

    private static void verificar(boolean condicao, String descricao) {
        if (!condicao) {
            throw new AssertionError("FALHOU: " + descricao);
        }
        System.out.println("OK - " + descricao);
    }

    private static boolean iguais(double a, double b) {
        return Math.abs(a - b) < 1e-6;
    }
}
