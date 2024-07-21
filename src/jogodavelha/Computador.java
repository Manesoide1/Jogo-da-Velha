package jogodavelha;

import excecoes.PosicaoInvalidaException;
import excecoes.PosicaoOcupadaException;
import java.util.Random;

/**
 * Classe Computador representando um jogador controlado pelo computador.
 */
public class Computador extends Jogador {
    private Random random = new Random();

    /**
     * Construtor do jogador Computador.
     * @param jogador Número identificador do jogador (1 ou 2).
     */
    public Computador(int jogador, String nome) {
        super(jogador, nome);
        System.out.println("Jogador 'Computador' criado!");
    }

    /**
     * Método para fazer uma jogada.
     * @param tabuleiro Tabuleiro atual do jogo.
     */
    @Override
    public void jogar(Tabuleiro tabuleiro) {
        boolean tentativaValida = false;

        // Continua tentando até que uma jogada válida seja feita.
        while (!tentativaValida) {
            try {
                Tentativa(tabuleiro);
                tabuleiro.setPosicao(tentativa, jogador);
                tentativaValida = true;
            } catch (PosicaoInvalidaException | PosicaoOcupadaException e) {
                // Trata exceções de posição inválida ou ocupada.
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
        tentativa[0] = random.nextInt(3);
        tentativa[1] = random.nextInt(3);

        if (!checaTentativa(tentativa, tabuleiro)) {
            throw new PosicaoOcupadaException("Posição ocupada! Tentando novamente.");
        }
    }
}
