import java.util.HashMap;
import java.time.LocalDate;

public class Reuniao
{
	private final HashMap<String, Participante> participantes;
	private final LocalDate dataInicial;
	private final LocalDate dataFinal;

	public Reuniao(LocalDate dataInicial, LocalDate dataFinal, HashMap<String,Participante> participantes){
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.participantes = participantes;
	}
	
	public Participante buscaParticipante(String participante){
		return participantes.get(participante);
	}

	public LocalDate getDataInicial(){
		return this.dataInicial;
	}
	public LocalDate getDataFinal(){
		return this.dataFinal;
	}

	public void imprimeDadosDaReuniao(){
		
	}
}
