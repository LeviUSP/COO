import java.time.LocalDateTime;

public abstract class Participante extends Pessoa
{
	String nome;
	LocalDateTime inicio;
	LocalDateTime fim;

	public abstract LocalDateTime getInicio();
	public abstract void setInicio(String inicio);
	public abstract LocalDateTime getFim();
	public abstract void setFim(String fim);
}
