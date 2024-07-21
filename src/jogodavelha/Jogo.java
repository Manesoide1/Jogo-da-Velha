package jogodavelha;

import armazenamento.GerenciaJogadoresArquivo;
import armazenamento.GerenciaJogadoresArrayList;
import java.util.Scanner;

/**
 * Classe principal para gerenciar o jogo da velha.
 */
public class Jogo {
    private Tabuleiro tabuleiro;
    private int rodada = 1, vez = 1;
    private Jogador jogador1;
    private Jogador jogador2;
    GerenciaJogadoresArrayList listaJogadores = new GerenciaJogadoresArrayList();
    GerenciaJogadoresArquivo arquivoJogadores = new GerenciaJogadoresArquivo("arquivo");
    private Scanner entrada = new Scanner(System.in);

    /**
     * Construtor do jogo. Inicializa o tabuleiro e os jogadores, e inicia o jogo.
     */
    public Jogo() {
        tabuleiro = new Tabuleiro();
        iniciarJogadores();
        tabuleiro.exibeTabuleiro();
        while (jogar());
        listaJogadores.listarJogadores();
        System.out.println();
        arquivoJogadores.listarJogadores();
    }

    /**
     * Inicializa os jogadores do jogo.
     */
    public void iniciarJogadores() {
        System.out.println("Quem vai ser o Jogador 1?");
        jogador1 = escolherJogador(1);
        System.out.println("----------------------");
        System.out.println("Quem vai ser o Jogador 2?");
        jogador2 = escolherJogador(2);
        listaJogadores.adicionarJogador(jogador1);
        listaJogadores.adicionarJogador(jogador2);
        if(arquivoJogadores.existeJogador(jogador1)){arquivoJogadores.adicionarJogador(jogador1);}
        if(arquivoJogadores.existeJogador(jogador2)){arquivoJogadores.adicionarJogador(jogador2);}
    }

    /**
     * Escolhe o tipo de jogador (humano ou computador).
     * @param numero Número identificador do jogador.
     * @return Instância de Jogador correspondente à escolha.
     */
    public Jogador escolherJogador(int numero) {
        int opcao;
        String nomeJogador;
        do {
            System.out.println("1. Humano");
            System.out.println("2. Computador\n");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            System.out.println("Nome do Jogador? ");
            nomeJogador = entrada.next();
            if (opcao != 1 && opcao != 2) {
                System.out.println("Opção inválida! Tente novamente");
            }

        } while (opcao != 1 && opcao != 2);

        return opcao == 1 ? new Humano(numero, nomeJogador) : new Computador(numero, nomeJogador);
    }

    /**
     * Realiza uma jogada e verifica o estado do jogo.
     * @return true se o jogo deve continuar, false caso contrário.
     */
    public boolean jogar() {
        if (ganhou() == 0) {
            System.out.println("----------------------");
            System.out.println("\nRodada " + rodada);
            System.out.println("É a vez do jogador " + vez());

            if (vez() == 1) {
                jogador1.jogar(tabuleiro);
            } else {
                jogador2.jogar(tabuleiro);
            }

            if (tabuleiro.tabuleiroCompleto()) {
                if (ganhou() == -1) {
                    System.out.println("Jogador 1 ganhou!");
                    jogador1.setPontos(jogador1.getPontos() + 1);
                    arquivoJogadores.atualizarPontuacao(jogador1.getNome(), arquivoJogadores.lerPontuacaoJogador(jogador1) + 1);
                    return false;
                }
                System.out.println("Tabuleiro Completo. Jogo empatado");
                return false;
            }
            vez++;
            rodada++;
            return true;
        } else {
            if (ganhou() == -1) {
                System.out.println("Jogador 1 ganhou!");
                jogador1.setPontos(jogador1.getPontos() + 1);
                arquivoJogadores.atualizarPontuacao(jogador1.getNome(), arquivoJogadores.lerPontuacaoJogador(jogador1) + 1);
            } else {
                System.out.println("Jogador 2 ganhou!");
                jogador2.setPontos(jogador2.getPontos() + 1);
                arquivoJogadores.atualizarPontuacao(jogador2.getNome(), arquivoJogadores.lerPontuacaoJogador(jogador2) + 1);
            }
            return false;
        }
    }

    /**
     * Retorna a vez do jogador atual.
     * @return 1 se for a vez do jogador 1, 2 se for a vez do jogador 2.
     */
    public int vez() {
        return vez % 2 == 1 ? 1 : 2;
    }

    /**
     * Verifica se algum jogador ganhou o jogo.
     * @return -1 se o jogador 1 ganhou, 1 se o jogador 2 ganhou, 0 se ninguém ganhou ainda.
     */
    public int ganhou() {
        if (tabuleiro.checaLinhas() == 1 || tabuleiro.checaColunas() == 1 || tabuleiro.checaDiagonais() == 1) {
            return 1;
        }
        if (tabuleiro.checaLinhas() == -1 || tabuleiro.checaColunas() == -1 || tabuleiro.checaDiagonais() == -1) {
            return -1;
        }
        return 0;
    }
}
