import java.util.HashMap;
import java.time.LocalDate;

public class Reuniao
{
	private final Pessoa organizador;
	private final HashMap<String, Participante> participantes;
	private final LocalDate dataInicial;
	private final LocalDate dataFinal;

	Reuniao(LocalDate dataInicial, LocalDate dataFinal){
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}
	
	public Participante buscaParticipante(String participante){

	}
	public Pessoa getOrganizador(){

	}
	public LocalDate getDataInicial(){

	}
	public LocalDate getDataFinal(){

	}
	public void imprimeDadosDosParticipantes(){

	}
	public void imprimeDadosDaReuniao(){

	}
}
