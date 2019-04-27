import java.util.Collection;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Teste{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia, mes, ano;


        System.out.println("Insira aqui a data inicial da reuniao");
        LocalDate inicioDaReuniao = stringEmData(sc.nextLine());


        System.out.println("Insira aqui a data final da reuniao");
        LocalDate fimDaReuniao = stringEmData(sc.nextLine());

        System.out.println("Insira aqui a lista de participantes separados por virgula da reuniao");
        Collection<String> listaDeParticipantes = transformarStringEmCollection(sc.nextLine());

        MarcadorDeReuniao organizador = new MarcadorDeReuniao();
        organizador.marcarReuniaoEntre(inicioDaReuniao, fimDaReuniao, listaDeParticipantes);

         
    }

    static int[] dataEmArrayDeInteiros(String data){
        int[] dataNumerica = new int[3];
        String[] dataString = data.split("/");
        
        dataNumerica[0] = Integer.parseInt(dataString[0]);
        dataNumerica[1] = Integer.parseInt(dataString[1]);
        dataNumerica[2] = Integer.parseInt(dataString[2]);

        return dataNumerica;

    }
    static LocalDate stringEmData(String data){
        int[] dataInteira = dataEmArrayDeInteiros(data);

        //configuracao de LocalDate eh contraria
        return LocalDate.of(dataInteira[2], dataInteira[1], dataInteira[0]);
    }
    static Collection<String> transformarStringEmCollection(String lista){
        String[] listaDeParticipantes = separarAsVirgulas(lista);
        return transformarArrayEmCollection(listaDeParticipantes);
    }

    static Collection<String> transformarArrayEmCollection(String[] lista){
        Collection<String> participantes = new ArrayList<String>();
        for(String participante : lista)
            participantes.add(participante);
        return participantes;
    }

    static String[] separarAsVirgulas(String lista){
        String[] participantesSeparados = lista.split(",");
        retirarEspacos(participantesSeparados);
        return participantesSeparados;
    }

    static void retirarEspacos(String[] listaDeParticipantes){
        for(int i = 0; i < listaDeParticipantes.length; i++){
            listaDeParticipantes[i] = listaDeParticipantes[i].trim();
        }
    }

}