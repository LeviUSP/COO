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

	public ArrayList<Intervalo> getIntervalos(){
		return this.intervalos;
	}
	public void imprimeDadosDoParticipante(){
            System.out.println("Nome: " + super.getNome());
	    
            if(intervalos.isEmpty()){
                System.out.println("Nao ha horarios de disponibilidade declarados por esse usuario!");
                return;
            }
            
            int contador = 0;
            
            System.out.println("Horarios declarados:");
            
            for(Intervalo i: intervalos)
            {
                contador++;
                System.out.println("Intervalo " + contador + ":");
                System.out.println("De " + i.getInicio().toLocalDate().toString() + " - " + i.getInicio().toLocalTime().toString());
                System.out.println("Ate " + i.getFim().toLocalDate().toString() + " - " + i.getFim().toLocalTime().toString());
            }

	}
}
