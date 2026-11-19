package iterator;

import java.util.List;
import java.util.NoSuchElementException;

public class IteradorReverso implements Iterador<Musica> {
    private final List<Musica> musicas;
    private int posicao;

    public IteradorReverso(List<Musica> musicas) {
        this.musicas = musicas;
        this.posicao = musicas.size() - 1;
    }

    @Override
    public boolean temProximo() {
        return posicao >= 0;
    }

    @Override
    public Musica proximo() {
        if (!temProximo()) {
            throw new NoSuchElementException();
        }
        return musicas.get(posicao--);
    }
}
