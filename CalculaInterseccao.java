import java.util.HashMap;
import java.time.LocalDateTime;

public abstract class CalculaInterseccao
{
	private HashMap<String, Participante> participantes;
	private LocalDateTime inicio;
	private LocalDateTime fim;

	public abstract void imprimeInterseccao();
}
