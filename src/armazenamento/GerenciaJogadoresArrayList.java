package armazenamento;

import jogodavelha.Jogador;
import java.util.ArrayList;

/**
 * Classe responsável por Criar, escrever e ler o ArrayList de Jogadores.
 */
public class GerenciaJogadoresArrayList implements GerenciaJogadores{
    private ArrayList<Jogador> jogadores;

    /**
     * Construtor da Classe GerenciaJogadoresArrayList.
     */
    public GerenciaJogadoresArrayList(){
        jogadores = new ArrayList<>();
    }

    /**
     * Método para adicionar os jogadores no ArrayList
     * @param jogador Jogador a ser adicionado no Array.
     */
    @Override
    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
        System.out.println("Jogador de nome: " + jogador.getNome() + "\n Pontuação: " + jogador.getPontos());
    }

    /**
     * Método para imprimir todos os jogadores e suas pontuações que estiverem armazenadas no ArrayList.
     */
    @Override
    public void listarJogadores() {
        System.out.println("Lista de jogadores: ");
        for (Jogador jogador : jogadores) {
            System.out.println("Jogador " +jogador.getJogador() + "\nNome: " + jogador.getNome() + "\nPontos: " + jogador.getPontos() + "\n");
        }
    }
}