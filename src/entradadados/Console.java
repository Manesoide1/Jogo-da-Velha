package entradadados;

import java.util.Scanner;

/**
 * Classe exclusiva para realizar a leitura do teclado.
 */
public class Console {
    /**
     * Método estático exclusivo para leitura do teclado.
     * @param mensagem Mensagem digitada no teclado a ser analizada.
     * @return Retorna o valor digitado para ser utilizado em outros métodos durante a execução do código.
     */
    public static int lerInt(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. " + mensagem);
            scanner.next();
        }
        return scanner.nextInt();
    }
}
