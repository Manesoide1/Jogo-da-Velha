package jogodavelha;

import entradadados.Console;
import excecoes.PosicaoInvalidaException;
import excecoes.PosicaoOcupadaException;

/**
 * Classe Humano representando um jogador controlado por um humano.
 */
public class Humano extends Jogador {

    /**
     * Construtor do jogador Humano.
     * @param jogador Número identificador do jogador (1 ou 2).
     */
    public Humano(int jogador, String nome) {
        super(jogador, nome);
        System.out.println("Jogador 'Humano' criado!");
    }

    /**
     * Método para fazer uma jogada.
     * @param tabuleiro Tabuleiro atual do jogo.
     */
    @Override
    public void jogar(Tabuleiro tabuleiro) {
        boolean tentativaValida = false;
        while (!tentativaValida) {
            try {
                Tentativa(tabuleiro);
                tabuleiro.setPosicao(tentativa, jogador);
                tentativaValida = true;
            } catch (PosicaoInvalidaException | PosicaoOcupadaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Gera uma tentativa de jogada.
     * @param tabuleiro Tabuleiro atual do jogo.
     * @throws PosicaoInvalidaException Se a posição for inválida.
     * @throws PosicaoOcupadaException Se a posição estiver ocupada.
     */
    @Override
    public void Tentativa(Tabuleiro tabuleiro) throws PosicaoInvalidaException, PosicaoOcupadaException {
        tentativa[0] = Console.lerInt("Linha (1-3): ") - 1;
        tentativa[1] = Console.lerInt("Coluna (1-3): ") - 1;

        if (tentativa[0] < 0 || tentativa[0] > 2 || tentativa[1] < 0 || tentativa[1] > 2) {
            throw new PosicaoInvalidaException("Posição inválida! Tente novamente.");
        }

        if (!checaTentativa(tentativa, tabuleiro)) {
            throw new PosicaoOcupadaException("Posição ocupada! Tente novamente.");
        }
    }
}
