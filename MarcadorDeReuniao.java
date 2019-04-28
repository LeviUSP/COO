import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collection;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MarcadorDeReuniao
{
	private Reuniao reuniao;

	public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes){
                try{
                    HashMap<String, Participante> participantes = criarHashMapComParticipantes(listaDeParticipantes);
                    
                    verificaData(dataInicial, dataFinal);
	
                    reuniao = new Reuniao(dataInicial, dataFinal, participantes);
                }
                catch(ListaVaziaException ex)
                {
                    System.err.println(ex.getMessage());
                }
                catch(DataInvalidaException ex)
                {
                    System.err.println(ex.getMessage());
                }

	}
	public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim){
		Participante participanteAtual = reuniao.buscaParticipante(participante);
		
                if(participanteAtual == null){
                    System.err.println("Participante de nome " + participante + " nao foi chamado para a reuniao!");
                    return;
                }
		
                if(fim.isBefore(inicio) || fim.isEqual(inicio)){
                    System.err.println("O horario de disponibilidade final deve estar depois do inicial!");
                    return;
                }
		
		LocalDateTime dataInicialDaReuniao = reuniao.getDataInicial().atStartOfDay();
		LocalDateTime dataFinalDaReuniao = reuniao.getDataFinal().atTime(23, 59);		
		
		if(inicio.isAfter(dataInicialDaReuniao) && fim.isBefore(dataFinalDaReuniao))
			participanteAtual.adicionaIntervalo(inicio, fim);
		else
			System.err.println("O horario inserido nao eh compativel com o da reuniao");
	}

	public void mostraSobreposicao(){
                reuniao.imprimeDadosDaReuniao();
                
		ArrayList<Participante> participantes = new ArrayList<>(reuniao.getParticipantes().values());
                
                CalculaInterseccao sobreposicoes = new CalculaInterseccao(participantes);
                
                LocalDateTime dataInicialDaReuniao = reuniao.getDataInicial().atStartOfDay();
                LocalDateTime dataFinalDaReuniao = reuniao.getDataFinal().atTime(23, 59);
                
                sobreposicoes.calcularInterseccao(dataInicialDaReuniao, dataFinalDaReuniao, 0);   
                
                sobreposicoes.imprimeInterseccoes();			
	}
	//métodos auxiliares
	private HashMap<String, Participante> criarHashMapComParticipantes(Collection<String> listaDeParticipantes) throws ListaVaziaException{
		if(listaDeParticipantes.isEmpty())
                    throw new ListaVaziaException("A lista de participantes nao pode estar vazia!");
                HashMap<String, Participante> participantes = new HashMap<>();
		
		for (String interador : listaDeParticipantes){
			Participante atual = new Participante();
			atual.setNome(interador);
			participantes.put(interador, atual);
		}

		return participantes;
	}        
        private void verificaData(LocalDate dataInicial, LocalDate dataFinal) throws DataInvalidaException
        {
            if(dataFinal.isBefore(dataInicial) || dataFinal.isEqual(dataInicial))
                throw new DataInvalidaException("A data que delimita o prazo maximo da reuniao deve estar apos a data que delimita o prazo minimo da reuniao!");
        }
}
