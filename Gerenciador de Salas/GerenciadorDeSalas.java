import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class GerenciadorDeSalas
{
	private static GerenciadorDeSalas instance = null;

	private final List<Sala> salas;
	private final List<Reserva> reservas;
	private final ManipuladorDeSalas manipuladorDeSalas;
	private final ManipuladorDeReservas manipuladorDeReservas;

	private GerenciadorDeSalas()
	{
		this.salas = new ArrayList<>();
		this.reservas = new ArrayList<>();
		this.manipuladorDeSalas = new ManipuladorDeSalas();
		this.manipuladorDeReservas = new ManipuladorDeReservas();
	}

	public static GerenciadorDeSalas getGerenciadorDeSalas(){
		if(instance == null)
		{
			synchronized (GerenciadorDeSalas.class)
			{
				instance = new GerenciadorDeSalas();
			}
		}
		return instance;
	}

	public void adicionaSalaChamada(String nome, String local, int capacidade, String descricao)
	{
		manipuladorDeSalas.adicionaSalaChamada(nome, local, capacidade, descricao, this.salas);		
	}

	public void removeSalaChamada(String nome)
	{
		manipuladorDeSalas.removeSalaChamada(nome, this.salas, this.reservas);
	}

	public List<Sala> listaDeSalas()
	{
		return new ArrayList<>(salas);
	}

	public void adicionaSala(Sala sala)
	{
		manipuladorDeSalas.adicionaSala(sala, this.salas);
	}

	public Reserva reservaSalaChamada(String nome, LocalDateTime inicioDaReserva, LocalDateTime fimDaReserva)
	{
		Reserva novaReserva = null;

		try
		{
			novaReserva = manipuladorDeReservas.reservaSalaChamada(nome, inicioDaReserva, fimDaReserva, this.salas, this.reservas);
		}
		catch(DataInvalidaException ex)
		{
			System.err.println(ex.getMessage());
		}
		catch(SalaInexistenteException ex)
		{
			System.err.println(ex.getMessage());
		}
		catch(SalaReservadaException ex)
		{
			System.err.println(ex.getMessage());
		}
		finally
		{
			return novaReserva;
		}
	}

	public void cancelaReserva(Reserva reserva)
	{
		manipuladorDeReservas.cancelaReserva(reserva, reservas);
	}

	public Collection<Reserva> reservaParaSala(Sala sala)
	{
		return manipuladorDeReservas.reservaParaSala(sala, reservas);
	}
	
	public void imprimeReservasDaSala(Sala sala)
	{
		manipuladorDeReservas.imprimeReservasDaSala(sala, reservas);
	}
}
