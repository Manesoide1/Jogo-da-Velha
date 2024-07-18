package jogodavelha;

import excecoes.PosicaoInvalidaException;
import excecoes.PosicaoOcupadaException;
import java.util.Random;

public class Computador extends Jogador {
    private Random random = new Random();

    public Computador(int jogador) {
        super(jogador);
        System.out.println("Jogador 'Computador' criado!");
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        boolean tentativaValida = false;

        while (!tentativaValida) {
            try {
                Tentativa(tabuleiro);
                tabuleiro.setPosicao(tentativa, jogador);
                tentativaValida = true;
            } catch (PosicaoInvalidaException | PosicaoOcupadaException e) {

            }
        }
    }

    @Override
    public void Tentativa(Tabuleiro tabuleiro) throws PosicaoInvalidaException, PosicaoOcupadaException {
        tentativa[0] = random.nextInt(3);
        tentativa[1] = random.nextInt(3);

        if (!checaTentativa(tentativa, tabuleiro)) {
            throw new PosicaoOcupadaException("Posição ocupada! Tentando novamente.");
        }
    }
}
