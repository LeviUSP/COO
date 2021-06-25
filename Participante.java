import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Participante
{
	private String nome;
	private String email;
	private ArrayList<Intervalo> intervalos;

	public Participante(){
		this.intervalos = new ArrayList<>();
	}
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		if(validarEmail(email))
			this.email = email;
		else
			System.err.println("O email " + email +" nao eh valido");
	}
	public void adicionaIntervalo(LocalDateTime inicio, LocalDateTime fim){
		Intervalo i = new Intervalo(inicio, fim);
		intervalos.add(i);					
	}
	public ArrayList<Intervalo> getIntervalos(){
		return this.intervalos;
	}
	public void imprimeDadosDoParticipante(){
            System.out.println("Email: " + getEmail());
	    
            if(intervalos.isEmpty()){
                System.out.println("Nao ha horarios de disponibilidade declarados por esse usuario!");
                return;
            }
            
            int contador = 0;
            
            System.out.println("Horarios declarados:");
            
            for(Intervalo i: intervalos)
            {
                contador++;
                System.out.println("   Intervalo " + contador + ":");
                System.out.println("     De " + i.getInicio().toLocalDate().toString() + " - " + i.getInicio().toLocalTime().toString());
                System.out.println("     Ate " + i.getFim().toLocalDate().toString() + " - " + i.getFim().toLocalTime().toString());
            }

			System.out.println("");
	}
	private boolean validarEmail(String email){
		Pattern padraoDeEmail = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
		Matcher padraoDaString = padraoDeEmail.matcher(email);

		return padraoDaString.matches();
	}
}
