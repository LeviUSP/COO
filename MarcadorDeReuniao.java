import java.util.LinkedList;
import java.util.Collection;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MarcadorDeReuniao
{
	private Reuniao reuniao;

	public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes){
		HashMap<String, Participante> participantes = new HashMap<>();
		
		for (String interador : listaDeParticipantes){
			Participante atual = new Participante();
			atual.setNome(interador);
			participantes.put(interador, atual);
		}
	
	
		reuniao = new Reuniao(dataInicial, dataFinal);

	}
	public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim){

	}
	public void mostraSobreposicao(){

	}
}
