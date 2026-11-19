package iterator;

import java.util.List;
import java.util.NoSuchElementException;

public class IteradorSequencial implements Iterador<Musica> {
    private final List<Musica> musicas;
    private int posicao;

    public IteradorSequencial(List<Musica> musicas) {
        this.musicas = musicas;
        this.posicao = 0;
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
        return musicas.get(posicao++);
    }
}
