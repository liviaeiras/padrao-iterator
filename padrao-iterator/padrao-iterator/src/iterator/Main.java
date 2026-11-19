package iterator;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.adicionar(new Musica("Cidade Maravilhosa", "Banda A", 210));
        playlist.adicionar(new Musica("Noite Clara", "Banda B", 185));
        playlist.adicionar(new Musica("Ventos do Sul", "Banda A", 240));
        playlist.adicionar(new Musica("Estrada", "Banda C", 200));

        System.out.println("Sequencial:");
        Iterador<Musica> sequencial = playlist.criarIterador();
        while (sequencial.temProximo()) {
            System.out.println("- " + sequencial.proximo().getTitulo());
        }

        System.out.println("Reverso:");
        Iterador<Musica> reverso = playlist.criarIteradorReverso();
        while (reverso.temProximo()) {
            System.out.println("- " + reverso.proximo().getTitulo());
        }

        System.out.println("Somente Banda A:");
        Iterador<Musica> porArtista = playlist.criarIteradorPorArtista("Banda A");
        while (porArtista.temProximo()) {
            System.out.println("- " + porArtista.proximo().getTitulo());
        }
    }
}
