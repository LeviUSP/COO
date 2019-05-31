import java.time.LocalDateTime;

public class Reserva
{
	private final LocalDateTime inicioDaReserva;
	private final LocalDateTime fimDaReserva;
	private final Sala sala;

	public Reserva(LocalDateTime inicioDaReserva, LocalDateTime fimDaReserva, Sala sala)
	{
		this.inicioDaReserva = inicioDaReserva;
		this.fimDaReserva = fimDaReserva;
		this.sala = sala;
	}

	public LocalDateTime getInicioDaReserva()
	{
		return this.inicioDaReserva;
	}
	public LocalDateTime getFimDaReserva()
	{
		return this.fimDaReserva;
	}
	public Sala getSala()
	{
		return this.sala;
	}
}