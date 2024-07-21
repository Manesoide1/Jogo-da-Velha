package jogodavelha;

import excecoes.PosicaoInvalidaException;
import excecoes.PosicaoOcupadaException;

/**
 * Classe abstrata Jogador, base pora criação do "Jogador Humano" e do "Jogador Computador"
 */
public abstract class Jogador {
    protected int[] tentativa = new int[2];
    protected int jogador;
    private String nome;
    private int pontos = 0;

    /**
     * Construtor do Jogador
     * @param jogador Número identificador do jogador (1 ou 2).
     * @param nome Nome do jogador.
     */
    public Jogador(int jogador, String nome) {
        this.jogador = jogador;
        this.nome = nome;
    }

    /**
     * Método retornador do número indentificador do jogador.
     * @return Retorna o número indentificador do jogador.
     */
    public int getJogador() {
        return jogador;
    }

    /**
     * Método atribuidor de um valor para pontuação do jogador.
     * @param pontos Valor a ser atribuido para pontuação do jogador.
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    /**
     * Método retornador do número de pontos do jogador.
     * @return Retorna os pontos do jogador.
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * Método retornador do nome do jogador.
     * @return Retorna o nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método abstrato da jogada do jogador e do computador.
     * @param tabuleiro Tabuleiro do jogo, levado em consideração na hora de testar se a jogada feita é possível.
     */
    public abstract void jogar(Tabuleiro tabuleiro);

    /**
     * Método abstrato para testar se a coordenada selecionada pelo Humano ou pelo Computador, se ela é possível.
     * @param tabuleiro Tabuleiro do jogo, levado em consideração na hora de testar se a jogada feita é possível.
     * @throws PosicaoInvalidaException Se a posição for inválida.
     * @throws PosicaoOcupadaException Se a posição estiver ocupada.
     */
    public abstract void Tentativa(Tabuleiro tabuleiro) throws PosicaoInvalidaException, PosicaoOcupadaException;

    /**
     * Método abstrato para testar se a coordenada selecionada pelo Humano ou pelo Computador, se ela está vazia.
     * @param tentativa Valor da coordenada a ser testada.
     * @param tabuleiro Tabuleiro do jogo, levado em consideração na hora de testar se a jogada feita é possível.
     * @return Retorna "True" caso a posição estiver vazia, do contrário, retornar "False".
     */
    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro) {
        return tabuleiro.getPosicao(tentativa) == 0;
    }
}
