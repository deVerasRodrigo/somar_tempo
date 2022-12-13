import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int ano = receberInt("Informe o ano: ", scanner);
        int mes = receberInt("Informe o mes: ", scanner);
        int dia = receberInt("Informe o dia: ", scanner);
        int hora = receberInt("Informe o hora: ", scanner);
        int minuto = receberInt("Informe o minuto: ", scanner);
        int segundo = receberInt("Informe o segundo: ", scanner);


        Tempo tempo = new Tempo (ano, mes, dia, hora, minuto, segundo);

        System.out.println("Data e hora informadas: " + tempo);

        int add = receberInt("Informe o valor a adicionar: ", scanner);

        System.out.print("Informe o parâmetro a ser adicionado [a, m, d, h, M, s]: ");
        char parametro = scanner.next().charAt(0);

        tempo.escolherParametro(parametro, add);

        System.out.println("Nova data e hora: " + tempo);
    }
    public static int receberInt(String mensagem, Scanner scanner){
        System.out.print(mensagem);
        return scanner.nextInt();
    }
}