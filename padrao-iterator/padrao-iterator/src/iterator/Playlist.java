package iterator;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements Colecao<Musica> {
    private final List<Musica> musicas = new ArrayList<>();

    public void adicionar(Musica musica) {
        musicas.add(musica);
    }

    public int tamanho() {
        return musicas.size();
    }

    @Override
    public Iterador<Musica> criarIterador() {
        return new IteradorSequencial(musicas);
    }

    public Iterador<Musica> criarIteradorReverso() {
        return new IteradorReverso(musicas);
    }

    public Iterador<Musica> criarIteradorPorArtista(String artista) {
        return new IteradorPorArtista(musicas, artista);
    }
}
