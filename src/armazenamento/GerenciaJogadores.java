package armazenamento;

import jogodavelha.Jogador;

/**
 * Interface com os métodos comuns a serem implementados nas Classes GerenciaJogadoresArquivo e GerenciaJogadoresArrayList.
 */
public interface GerenciaJogadores {

    /**
     * Método para adicionar um jogador no Arquivo ou no Array.
     * @param jogador Jogador a ser adicionado no Arquivo ou no Array.
     */
    void adicionarJogador(Jogador jogador);

    /**
     * Método para imprimir os nomes e pontuações dos jogadores armazenados no Arquivo ou no Array.
     */
    void listarJogadores();
}