import java.time.LocalDateTime;
import java.util.ArrayList;


public class Participante extends Pessoa
{
	private ArrayList<Intervalo> intervalos;

	public Participante(){
		this.intervalos = new ArrayList<>();
	}
	public void adicionaIntervalo(LocalDateTime inicio, LocalDateTime fim){
		Intervalo i = new Intervalo(inicio, fim);
		intervalos.add(i);					
	}
	public Intervalo getIntervalo(int indice){
		if(indice < 0 || indice >= intervalos.size())
			return null;
		else
			return intervalos.get(indice);
	}
}
