import java.util.HashMap;
import java.time.LocalDate;

public class Reuniao
{
	private final Pessoa organizador;
	private final HashMap<String, Participante> participantes;
	private final LocalDate dataInicial;
	private final LocalDate dataFinal;

	public Reuniao(LocalDate dataInicial, LocalDate dataFinal, HashMap<String,Participante> participantes, Pessoa organizador){
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.participantes = participantes;
		this.organizador = organizador;
	}
	
	public Participante buscaParticipante(String participante){
		return participantes.get(participante);
	}
	public Pessoa getOrganizador(){
		return 
	}
	public LocalDate getDataInicial(){

	}
	public LocalDate getDataFinal(){

	}

	public void imprimeDadosDaReuniao(){
		
	}
}
