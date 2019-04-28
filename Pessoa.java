import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Pessoa
{
	private String nome;
	private String email;

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
			System.err.println("Esse email nao eh valido");
	}

	private boolean validarEmail(String email){
		Pattern padraoDeEmail = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
		Matcher padraoDaString = padraoDeEmail.matcher(email);

		return padraoDaString.matches();
	} 
}
