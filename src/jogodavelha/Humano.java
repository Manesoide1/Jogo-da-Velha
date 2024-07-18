package jogodavelha;

import entradadados.Console;
import excecoes.PosicaoInvalidaException;
import excecoes.PosicaoOcupadaException;

public class Humano extends Jogador {
    public Humano(int jogador) {
        super(jogador);
        System.out.println("Jogador 'Humano' criado!");
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
                System.out.println(e.getMessage());
            }
        }
    }

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
