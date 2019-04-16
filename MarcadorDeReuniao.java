import java.util.LinkedList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class MarcadorDeReuniao
{
	private Reuniao reuniao;

	public abstract void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, LinkedList<String> listaDeParticipantes);
	public abstract void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim);
	public abstract void mostraSobreposicao();
}
