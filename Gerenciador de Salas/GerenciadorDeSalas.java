import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class GerenciadorDeSalas
{
	private static GerenciadorDeSalas instance;

	private final List<Sala> salas;
	private final List<Reserva> reservas;

	private GerenciadorDeSalas()
	{
		this.salas = new ArrayList<>();
		this.reservas = new ArrayList<>();
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


	public void adicionaSalaChamada(String nome, int capacidade, String descricao)
	{

		for(Sala s: salas)
		{
			if(s.getNome().equals(nome))
			{
				System.err.println("Sala já existe!");
				return;
			}
		}
		
		Sala novaSala = new Sala(nome, local, capacidade, descricao);
		salas.add(novaSala);
	}
	public void removeSalaChamada(String nome)
	{
		Iterator<Sala> itSala = salas.iterator();
		Iterator<Reserva> itReserva = reservas.iterator();
		Sala temp;

		while(itSala.hasNext())
		{
		    temp = itSala.next();
			if(temp.getNome().equals(nome))
			{
				itSala.remove();
				
				while(itReserva.hasNext())
				{
				    if(itReserva.next().getSala() == temp)
				        itReserva.remove();
				}
				return;
			}
		}

		System.err.println("Não existe sala com nome " + nome);
	}
	public List<Sala> listaDeSalas()
	{
		return new ArrayList<>(salas);
	}
	public void adicionaSala(Sala sala)
	{
		for(Sala s: salas)
		{
			if(s.getNome().equals(sala.getNome()))
			{
				System.err.println("A sala já existe!");
				return;
			}
		}

		salas.add(sala);
	}
	public Reserva reservaSalaChamada(String nome, LocalDateTime inicioDaReserva, LocalDateTime fimDaReserva)
	{
		Reserva novaReserva = null;
		Sala salaParaReservar = null;

		try
		{
			if(inicioDaReserva.isAfter(fimDaReserva)||inicioDaReserva.isEqual(fimDaReserva))
				throw new DataInvalidaException("O inicio da reserva deve ser antes do fim!");

			for(Sala s: salas)
			{
				if(s.getNome().equals(nome))
				{
					salaParaReservar = s;
					break;
				}
			}

			if(salaParaReservar == null)
				throw new SalaInexistenteException("Sala não existe!");
			
			for(Reserva r: reservas)
			{
				if((r.getSala() == salaParaReservar) && (!(fimDaReserva.isBefore(r.getInicioDaReserva())||inicioDaReserva.isAfter(r.getFimDaReserva()))))
					throw new SalaReservadaException("A sala já está reservada no horário de " + r.getInicioDaReserva().toString() + " até " + r.getFimDaReserva().toString() + "!");
			}

			novaReserva = new Reserva(inicioDaReserva, fimDaReserva, salaParaReservar);
			reservas.add(novaReserva);
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
		Iterator<Reserva> it = reservas.iterator();

		while(it.hasNext())
		{
			if(it.next() == reserva)
			{
				it.remove();
				return;
			}
		}

		System.err.println("A reserva não existe!");
	}
	public Collection<Reserva> reservaParaSala(Sala sala)
	{
		Collection<Reserva> resposta = new ArrayList<>();

		for(Reserva r: reservas)
		{
			if(r.getSala() == sala)
			{
				resposta.add(r);
			}
		}

		return resposta;
	}
	public void imprimeReservasDaSala(Sala sala)
	{
		int i = 0;

		for(Reserva r: reservas)
		{
			if(r.getSala() == sala)
			{
				i++;
				System.out.println("Reserva " + i + ":\n");
				System.out.print("De " + r.getInicioDaReserva().toLocalDate().toString());
				System.out.println(" às " + r.getInicioDaReserva().toLocalTime().toString());
				System.out.print("Até " + r.getFimDaReserva().toLocalDate().toString());
				System.out.println(" às " + r.getFimDaReserva().toLocalTime().toString() + "\n");
			}
		}

		if(i == 0)
			System.out.println("Não há reservas para esta sala");
	}
}
