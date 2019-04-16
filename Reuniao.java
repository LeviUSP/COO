import java.util.HashMap;
import java.time.LocalDate;

public abstract class Reuniao
{
	private final Pessoa organizador;
	private final HashMap<String, Participante> participantes;
	private final LocalDate dataInicial;
	private final LocalDate dataFinal;

	public abstract Participante buscaParticipante(String participante);
	public abstract Pessoa getOrganizador();
	public abstract LocalDate getDataInicial();
	public abstract LocalDate getDataFinal();
	public abstract void imprimeDadosDosParticipantes();
	public abstract void imprimeDadosDaReuniao();
}
