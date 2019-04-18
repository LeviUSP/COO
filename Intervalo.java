import java.time.LocalDateTime;


public class Intervalo
{
	private final LocalDateTime inicio;
	private final LocalDateTime fim;

	Intervalo(LocalDateTime inicio, LocalDateTime fim){
		this.inicio = inicio;
		this.fim = fim;
	}
	public LocalDateTime getInicio(){
		return this.inicio;
	}
	public LocalDateTime getFim(){
		return this.fim;
	}
}
