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
		 
	
		reuniao = new Reuniao(dataInicial, dataFinal, participantes);

	}
	public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim){
		Participante participanteAtual = reuniao.buscaParticipante(participante);
		LocalDateTime dataInicialDaReuniao = LocalDateTime.from(reuniao.getDataInicial());
		LocalDateTime dataFinalDaReuniao = LocalDateTime.from(reuniao.getDataFinal());
		
		
		if(inicio.isAfter(dataInicialDaReuniao) && fim.isBefore(dataFinalDaReuniao))
			participanteAtual.adicionaIntervalo(inicio, fim);
		else
			System.err.println("O horario inserido nao eh compativel com o da reuniao");
	}

	public void mostraSobreposicao(){
		HashMap<String, Participante> listaDeParticipantes;
	}
	


	//métodos auxiliares
	private HashMap<String, Participante> criarHashMapComParticipantes(Collection<String> listaDeParticipantes){
		HashMap<String, Participante> participantes = new HashMap<>();
		
		for (String interador : listaDeParticipantes){
			Participante atual = new Participante();
			atual.setNome(interador);
			participantes.put(interador, atual);
		}

		return participantes;
	}

}
