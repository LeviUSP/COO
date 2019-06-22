import java.util.List;
import java.util.Iterator;

public class ManipuladorDeSalas
{
    public void adicionaSalaChamada(String nome, String local, int capacidade, String descricao, List<Sala> salas)
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

    public void removeSalaChamada(String nome, List<Sala> salas, List<Reserva> reservas)
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
    
    public void adicionaSala(Sala sala, List<Sala> salas)
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
}