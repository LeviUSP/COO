import java.util.HashMap;
import java.util.Iterator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

public class Interseccoes
{
	private ArrayList<Intervalo> interseccoes;
  
	private ArrayList<Participante> listaDeParticipantes;

	Interseccoes(HashMap <String, Participante> listaDeParticipantes){
		this.listaDeParticipantes = new ArrayList<>(listaDeParticipantes.values());
    this.interseccoes = new ArrayList<>();
	}

	public void imprimeInterseccoes(){
            int contador = 0;
		
            if(interseccoes.isEmpty()){
                System.out.println("Nao ha horarios compativeis!");
                System.out.println("Verifique se todos os participantes inseriram pelo menos um intervalo de disponibilidade!");
                return;
            }
		
            System.out.println("HORARIOS DISPONIVEIS PARA A REUNIAO:");
		
            for(Intervalo i: interseccoes){
                contador++;
                System.out.println("Intervalo " + contador + ":");
                System.out.println("   De " + i.getInicio().toLocalDate().toString() + " - " + i.getInicio().toLocalTime().toString());
                System.out.println("   Ate " + i.getFim().toLocalDate().toString() + " - " + i.getFim().toLocalTime().toString());
            }
	}

	public void calcularInterseccoes(LocalDateTime inicio, LocalDateTime fim, int indice){
            LocalDateTime inicioTemp = inicio;
            LocalDateTime fimTemp = fim;
            
            Participante participante = listaDeParticipantes.get(indice);
			
            for(Intervalo i : participante.getIntervalos()){
            	//se estiver dentro do intervalo
	        	if(i.getInicio().isBefore(fim) && i.getFim().isAfter(inicio)){
                    //se o final do intervalo do participante for menor que o intervalo da interseccao
                    if(i.getFim().isBefore(fim) || i.getFim().isEqual(fim)) 
                        fim = i.getFim();
                    //se o inicio do intervalo do participante for maior que o intervalo da interseccao
                    if(i.getInicio().isAfter(inicio) || i.getInicio().isEqual(fim)) 
			            inicio = i.getInicio();
                    //se for o último participante
                    if(indice == listaDeParticipantes.size()-1)
                        interseccoes.add(new Intervalo(inicio, fim));//insere intersecção na lista
                    else                    
                        calcularInterseccoes(inicio, fim, indice+1);//caso contrário, chama esse método novamente para a o próximo elemento					
		        }
		    
                inicio = inicioTemp;
                fim = fimTemp;
            }		

    }
}
