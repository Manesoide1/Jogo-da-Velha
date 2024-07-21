package jogodavelha;

/**
 * Classe para representar o tabuleiro do jogo da velha.
 */
public class Tabuleiro {
    private int[][] tabuleiro = new int[3][3];

    /**
     * Construtor do tabuleiro. Inicializa o tabuleiro.
     */
    public Tabuleiro() {
        zerarTabuleiro();
    }

    /**
     * Zera o tabuleiro, definindo todas as posições como 0.
     */
    public void zerarTabuleiro() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = 0;
            }
        }
    }

    /**
     * Exibe o tabuleiro no console.
     */
    public void exibeTabuleiro() {
        System.out.println();
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                switch (tabuleiro[linha][coluna]) {
                    case -1:
                        System.out.print(" X ");
                        break;
                    case 1:
                        System.out.print(" O ");
                        break;
                    default:
                        System.out.print("   ");
                        break;
                }
                if (coluna < 2) System.out.print("|");
            }
            System.out.println();
        }
    }

    /**
     * Retorna o valor na posição dada no tabuleiro.
     * @param tentativa Posição a ser verificada.
     * @return Valor na posição do tabuleiro.
     */
    public int getPosicao(int[] tentativa) {
        return tabuleiro[tentativa[0]][tentativa[1]];
    }

    /**
     * Define um valor em uma posição do tabuleiro.
     * @param tentativa Posição onde o valor deve ser definido.
     * @param jogador Número do jogador (1 ou 2).
     */
    public void setPosicao(int[] tentativa, int jogador) {
        tabuleiro[tentativa[0]][tentativa[1]] = jogador == 1 ? -1 : 1;
        exibeTabuleiro();
    }

    /**
     * Verifica se há uma linha vencedora no tabuleiro.
     * @return -1 se o jogador 1 ganhou, 1 se o jogador 2 ganhou, 0 caso contrário.
     */
    public int checaLinhas() {
        for (int linha = 0; linha < 3; linha++) {
            int soma = tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2];
            if (soma == -3) return -1;
            if (soma == 3) return 1;
        }
        return 0;
    }

    /**
     * Verifica se há uma coluna vencedora no tabuleiro.
     * @return -1 se o jogador 1 ganhou, 1 se o jogador 2 ganhou, 0 caso contrário.
     */
    public int checaColunas() {
        for (int coluna = 0; coluna < 3; coluna++) {
            int soma = tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna];
            if (soma == -3) return -1;
            if (soma == 3) return 1;
        }
        return 0;
    }

    /**
     * Verifica se há uma diagonal vencedora no tabuleiro.
     * @return -1 se o jogador 1 ganhou, 1 se o jogador 2 ganhou, 0 caso contrário.
     */
    public int checaDiagonais() {
        int diagonal1 = tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2];
        int diagonal2 = tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0];
        if (diagonal1 == -3 || diagonal2 == -3) return -1;
        if (diagonal1 == 3 || diagonal2 == 3) return 1;
        return 0;
    }

    /**
     * Verifica se o tabuleiro está completo.
     * @return true se o tabuleiro estiver completo, false caso contrário.
     */
    public boolean tabuleiroCompleto() {
        for (int[] linha : tabuleiro)
            for (int posicao : linha)
                if (posicao == 0)
                    return false;
        return true;
    }
}
