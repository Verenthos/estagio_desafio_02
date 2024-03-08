import java.util.Scanner;

public class StringInverter {
    public static void main(String[] args) {
        // Lê a string do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String input = scanner.nextLine();
        
        // Chama a função para inverter a string
        String reversed = inverterString(input);
        
        // Imprime a string invertida
        System.out.println("String invertida: " + reversed);
    }
    
    public static String inverterString(String str) {
        // Cria um StringBuilder para construir a string invertida
        StringBuilder reversed = new StringBuilder();
        
        // Itera sobre a string de trás para frente
        for (int i = str.length() - 1; i >= 0; i--) {
            // Adiciona cada caractere ao StringBuilder
            reversed.append(str.charAt(i));
        }
        
        // Retorna a string invertida
        return reversed.toString();
    }
}