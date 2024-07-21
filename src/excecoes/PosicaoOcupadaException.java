package excecoes;

/**
 * Exceção lançada quando uma posição já está ocupada.
 */
public class PosicaoOcupadaException extends Exception {
    /**
     * Construtor da exceção.
     * @param message Mensagem de erro a ser exibida.
     */
    public PosicaoOcupadaException(String message) {
        super(message);
    }
}
