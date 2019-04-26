import java.util.HashMap;
import java.util.Iterator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

public class CalculaInterseccao
{
	private ArrayList<Intervalo> interseccoes;

	private ArrayList<Participante> listaDeParticipantes;

	CalculaInterseccao(ArrayList <Participante> listaDeParticipantes){
		this.listaDeParticipantes = listaDeParticipantes;
	}

	public void imprimeInterseccoes(){

	}

	public void calcularInterseccao(Participante participante, LocalDateTime inicio, LocalDateTime fim, int contador){
		if(contador <= listaDeParticipantes.size()){
			//se ele chegar no final e inicio < fim
			if(contador == listaDeParticipantes.size() && inicio.isBefore(fim)) 
				interseccoes.add(new Intervalo(inicio, fim)); // adicionar na Lista Ligada de interseccoes
			
			for(Intervalo i : participante.getIntervalos()){
				//se estiver dentro do intervalo
				if(!(i.getInicio().isAfter(fim) || i.getFim().isBefore(inicio))){
					//se o final do intervalo do participante for menor que o intervalo da interseccao
					if(i.getFim().isBefore(fim) || i.getFim().isEqual(fim)) 
						fim = i.getFim();
					//se o inicio do intervalo do participante for maior que o intervalo da interseccao
					if(i.getInicio().isAfter(inicio) || i.getInicio().isEqual(fim)) 
						inicio = i.getInicio();
					
					//chama esse método novamente para a o próximo elemento
					calcularInterseccao(listaDeParticipantes.get(contador+1), inicio, fim, contador+1);
					
				}
			}
			
		}
	}
}
