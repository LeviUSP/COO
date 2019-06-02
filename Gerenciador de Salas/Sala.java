public class Sala
{
	private final String nome;
	private final int capacidade;
	private final String descricao;

	public Sala(String nome, int capacidade, String descricao)
	{
		this.nome = nome;
		this.capacidade = capacidade;
		this.descricao = descricao;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	public int getCapacidade()
	{
		return this.capacidade;
	}
	public String getDescricao()
	{
		return this.descricao;
	}
}