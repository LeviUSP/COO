import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class ManipuladorDeReservas
{
    public Reserva reservaSalaChamada(String nome, LocalDateTime inicioDaReserva, 
    LocalDateTime fimDaReserva, List<Sala> salas, List<Reserva> reservas)
    throws DataInvalidaException, SalaInexistenteException, SalaReservadaException
    {
        Reserva novaReserva = null;
        Sala salaParaReservar = null;

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
				throw new SalaReservadaException("A sala já está reservada no horário de " + r.getInicioDaReserva().toLocalTime().toString() + " de " + r.getInicioDaReserva().toLocalDate().toString() + " até " + r.getFimDaReserva().toLocalTime().toString() + " de " + r.getFimDaReserva().toLocalDate().toString() + "!");
		}

		novaReserva = new Reserva(inicioDaReserva, fimDaReserva, salaParaReservar);
		reservas.add(novaReserva);

        return novaReserva;
    }

    public void cancelaReserva(Reserva reserva, List<Reserva> reservas)
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
    
    public Collection<Reserva> reservaParaSala(Sala sala, List<Reserva> reservas)
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
    
    public void imprimeReservasDaSala(Sala sala, List<Reserva> reservas)
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