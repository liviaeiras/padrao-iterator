# Padrao Iterator - Playlist de musicas

Playlist expoe tres formas de percorrer as musicas (sequencial, reversa e por artista) sem revelar sua lista interna.

## Estrutura

- `src/iterator/` codigo-fonte
- `test/iterator/TesteIterator.java` casos de teste
- `diagrama-de-classes.png` diagrama de classes
- `executar.bat` compila e executa (Windows)

## Como executar

```
javac -encoding UTF-8 -d out src/iterator/*.java test/iterator/*.java
java -cp out iterator.Main
java -cp out iterator.TesteIterator
```
