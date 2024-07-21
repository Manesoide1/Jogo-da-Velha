package armazenamento;
import jogodavelha.Jogador;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe responsável por criar, escrever e ler o arquivo.
 */
public class GerenciaJogadoresArquivo implements GerenciaJogadores{
    private String nomeArquivo;

    /**
     * Construtor da Classe GerenciaJogadoresArquivo.
     * @param nomeArquivo Nome do arquivo a ser criado pelo construtor.
     */
    public GerenciaJogadoresArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    /**
     * Método para adicionar os jogadores no Arquivo.
     * @param jogador Jogador a ser adicionado no Arquivo.
     */
    @Override
    public void adicionarJogador(Jogador jogador) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            writer.println(jogador.getNome() + ";" + jogador.getPontos());
            System.out.println("Jogador adicionado ao arquivo: " + jogador.getNome() + " - Pontuação: " + jogador.getPontos());
        } catch (IOException e) {
            System.err.println("Erro ao adicionar jogador no arquivo: " + e.getMessage());
        }
    }

    /**
     * Método para imprimir todos os jogadores e pontuações que estiverem armazenadas no Arquivo.
     */
    @Override
    public void listarJogadores(){
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            System.out.println("Arquivo de jogadores:");
            while ((linha = reader.readLine()) != null) {
                // Supondo que os dados estejam separados por ponto-e-vírgula (;)
                String[] dadosJogador = linha.split(";");
                if (dadosJogador.length == 2) {
                    String nome = dadosJogador[0];
                    int pontuacao = Integer.parseInt(dadosJogador[1]);
                    System.out.println("Nome: " + nome + ", Pontuação: " + pontuacao);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao listar jogadores: " + e.getMessage());
        }
    }

    /**
     * Método para poder alterar a pontuação de algum jogador que já exista no Arquivo.
     * @param nome Nome do jogador que precisa ter sua pontuação alterada.
     * @param novaPontuacao Nova pontuação que deve ser armazenada no Arquivo.
     */
    public void atualizarPontuacao(String nome, int novaPontuacao) {
        // Lista para armazenar os jogadores lidos do arquivo
        ArrayList<String> linhas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha); // Adiciona cada linha do arquivo à lista
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        // Procurar e atualizar a pontuação do jogador
        boolean jogadorEncontrado = false;
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (String linha : linhas) {
                String[] dadosJogador = linha.split(";");
                if (dadosJogador.length == 2 && dadosJogador[0].equals(nome)) {
                    // Atualiza a pontuação do jogador
                    writer.println(nome + ";" + novaPontuacao);
                    jogadorEncontrado = true;
                } else {
                    writer.println(linha); // Mantém as outras linhas como estavam
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao atualizar a pontuação do jogador: " + e.getMessage());
        }

        if (!jogadorEncontrado) {
            System.out.println("Jogador não encontrado no arquivo: " + nome);
        }
    }

    /**
     * Método para verificar se o nome do jogador já existe no Arquivo evitando jogadores (nomes) duplicados.
     * @param jogador Jogador a ser analizado para saber se seu nome já existe no Arquivo.
     * @return Retorna false, caso o nome daquele jogador já exista no Arquivo. Caso não exista, então retorna True.
     */
    public boolean existeJogador(Jogador jogador) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dadosJogador = linha.split(";");
                if (dadosJogador.length == 2 && dadosJogador[0].equals(jogador.getNome())) {
                    return false; // Jogador encontrado
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao verificar a existência do jogador: " + e.getMessage());
        }
        return true; // Jogador não encontrado
    }

    /**
     * Método para ler a pontuação de algum jogador específico no Arquivo.
     * @param jogador Jogador a ser procurado no Arquivo.
     * @return Retorna a pontuação do jogador armazenada no arquivo, caso não seja encontrado o jogador retorna -1.
     */
    public int lerPontuacaoJogador(Jogador jogador) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dadosJogador = linha.split(";");
                if (dadosJogador.length == 2 && dadosJogador[0].equals(jogador.getNome())) {
                    return Integer.parseInt(dadosJogador[1]); // Retorna a pontuação do jogador
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler a pontuação do jogador: " + e.getMessage());
        }
        return -1; // Retorna -1 se o jogador não for encontrado
    }
}