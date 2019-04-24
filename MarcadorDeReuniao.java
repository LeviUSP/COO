import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collection;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MarcadorDeReuniao
{
	private Reuniao reuniao;

	public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes){
		HashMap<String, Participante> participantes = criarHashMapComParticipantes(listaDeParticipantes);
		

		Scanner sc = new Scanner(System.in);
		
		//repensar o organizador
		Pessoa organizador = new Pessoa();
		organizador.setNome(sc.next());
	
		reuniao = new Reuniao(dataInicial, dataFinal, participantes, organizador);

	}
	public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim){
		Participante participanteAtual = reuniao.buscaParticipante(participante);


	}
	public void mostraSobreposicao(){

	}


	//métodos para auxiliares
	HashMap<String, Participante> criarHashMapComParticipantes(Collection<String> listaDeParticipantes){
		HashMap<String, Participante> participantes = new HashMap<>();
		
		for (String interador : listaDeParticipantes){
			Participante atual = new Participante();
			atual.setNome(interador);
			participantes.put(interador, atual);
		}

		return participantes;
	}

}
