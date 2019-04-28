import java.util.Collection;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Teste{
    static MarcadorDeReuniao organizador = new MarcadorDeReuniao();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia, mes, ano;

        System.out.println("");
        System.out.println("Todos os dias serao inseridos como 2019-04-30 e os horarios como 2019-04-30T23:59:59");
        System.out.println("....o horário de entrega");
        System.out.println("");

        System.out.println("Insira aqui a data inicial da reuniao");
        LocalDate inicioDaReuniao = LocalDate.parse(sc.nextLine());

        System.out.println("Insira aqui a data final da reuniao");
        LocalDate fimDaReuniao = LocalDate.parse(sc.nextLine());

        System.out.println("Insira aqui a lista de participantes separados por virgula da reuniao");
        Collection<String> listaDeParticipantes = transformarStringEmCollection(sc.nextLine());
    
        organizador.marcarReuniaoEntre(inicioDaReuniao, fimDaReuniao, listaDeParticipantes);

        indicarDisponibilidadeDosParticipantes(listaDeParticipantes, sc);

        organizador.mostraSobreposicao();
       
        
         
    }

    static void indicarDisponibilidadeDosParticipantes(Collection<String> listaDeParticipantes, Scanner sc){
        for (String participante : listaDeParticipantes) {
            System.out.println();
            System.out.println(participante + ", reponda os seus horarios disponiveis");
            while(true){
                System.out.println("Qual o horário inicial?");
                LocalDateTime horarioInicial = LocalDateTime.parse(sc.nextLine());

                System.out.println("Qual o horário final?");
                LocalDateTime horarioFinal = LocalDateTime.parse(sc.nextLine());

                organizador.indicaDisponibilidadeDe(participante, horarioInicial, horarioFinal);

               
                System.out.println("Tem mais algum horario disponivel?");
                String resp = sc.nextLine();
                if(resp.equals("nao"))
                    break;
                System.out.println("Entao nos informe:");
             }            
        }
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