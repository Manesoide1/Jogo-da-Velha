package jogodavelha;

import excecoes.PosicaoInvalidaException;
import excecoes.PosicaoOcupadaException;

public abstract class Jogador {
    protected int[] tentativa = new int[2];
    protected int jogador;

    public Jogador(int jogador) {
        this.jogador = jogador;
    }

    public abstract void jogar(Tabuleiro tabuleiro);

    public abstract void Tentativa(Tabuleiro tabuleiro) throws PosicaoInvalidaException, PosicaoOcupadaException;

    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro) {
        return tabuleiro.getPosicao(tentativa) == 0;
    }
}
