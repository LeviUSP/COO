import java.util.Scanner;
import java.time.LocalDate;

public class Teste{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia, mes, ano;


        System.out.println("Insira aqui a data inicial da reuniao");
        int[] dataInicial = separarData(sc.nextLine());
        LocalDate inicioDaReuniao = LocalDate.of(dataInicial[0], dataInicial[1], dataInicial[0]);


        System.out.println("Insira aqui a data final da reuniao");
        int[] dataFinal = separarData(sc.nextLine());
        LocalDate fimDaReuniao = LocalDate.of(dataFinal[0], dataFinal[1], dataFinal[0]);

        System.out.println("Insira aqui a lista de participantes separados por virgula da reuniao");
        

         
    }

    static int[] separarData(String data){
        int[] dataNumerica = new int[3];
        String[] dataString = data.split("/");
        
        dataNumerica[2] = Integer.parseInt(dataString[0]);
        dataNumerica[1] = Integer.parseInt(dataString[1]);
        dataNumerica[0] = Integer.parseInt(dataString[2]);

        return dataNumerica;

    }


}