import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    // Gera uma senha com base nos parâmetros do usuário
    public static String gerarSenha(int tamanho, boolean incluirMaiusculas, boolean incluirNumeros, boolean incluirSimbolos) {
        String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String letrasMaiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        String simbolos = "!@#$%&*?";

        String caracteres = letrasMinusculas;
        if (incluirMaiusculas) caracteres += letrasMaiusculas;
        if (incluirNumeros) caracteres += numeros;
        if (incluirSimbolos) caracteres += simbolos;

        StringBuilder senha = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Gerador de Senhas Seguras ===");
        System.out.print("Tamanho da senha: ");
        int tamanho = scanner.nextInt();

        System.out.print("Incluir letras maiúsculas? (s/n): ");
        boolean maiusculas = scanner.next().equalsIgnoreCase("s");

        System.out.print("Incluir números? (s/n): ");
        boolean numeros = scanner.next().equalsIgnoreCase("s");

        System.out.print("Incluir símbolos? (s/n): ");
        boolean simbolos = scanner.next().equalsIgnoreCase("s");

        String senha = gerarSenha(tamanho, maiusculas, numeros, simbolos);
        System.out.println("\nSenha gerada: " + senha);
    }
}
