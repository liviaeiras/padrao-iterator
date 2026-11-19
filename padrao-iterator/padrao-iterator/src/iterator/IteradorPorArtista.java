package iterator;

import java.util.List;
import java.util.NoSuchElementException;

public class IteradorPorArtista implements Iterador<Musica> {
    private final List<Musica> musicas;
    private final String artista;
    private int posicao;

    public IteradorPorArtista(List<Musica> musicas, String artista) {
        this.musicas = musicas;
        this.artista = artista;
        this.posicao = buscarIndice(0);
    }

    private int buscarIndice(int inicio) {
        for (int i = inicio; i < musicas.size(); i++) {
            if (musicas.get(i).getArtista().equalsIgnoreCase(artista)) {
                return i;
            }
        }
        return musicas.size();
    }

    @Override
    public boolean temProximo() {
        return posicao < musicas.size();
    }

    @Override
    public Musica proximo() {
        if (!temProximo()) {
            throw new NoSuchElementException();
        }
        Musica atual = musicas.get(posicao);
        posicao = buscarIndice(posicao + 1);
        return atual;
    }
}
