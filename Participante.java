import java.time.LocalDateTime;
import java.util.ArrayList;


public class Participante extends Pessoa
{
	private ArrayList<Horario> horarios;

	Participante(){
		this.horarios = new ArrayList<>();
	}
	public void adicionaHorario(LocalDateTime inicio, LocalDateTime fim){
		Horario h = new Horario(inicio, fim);
		horarios.add(h);					
	}
	public Horario getHorario(int indice){
		if(indice < 0 || indice >= horarios.size())
			return null;
		else
			return horarios.get(indice);
	}
}
