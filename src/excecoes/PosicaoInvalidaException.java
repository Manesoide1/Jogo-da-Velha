package excecoes;

/**
 * Exceção lançada quando uma posição inválida é escolhida.
 */
public class PosicaoInvalidaException extends Exception {
    /**
     * Construtor da exceção.
     * @param message Mensagem de erro a ser exibida.
     */
    public PosicaoInvalidaException(String message) {
        super(message);
    }
}
