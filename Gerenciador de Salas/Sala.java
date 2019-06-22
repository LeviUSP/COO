public class Sala
{
	private final String nome;
	private final String local;
	private final int capacidade;
	private final String descricao;

	public Sala(String nome, String local, int capacidade, String descricao)
	{
		this.nome = nome;
		this.local = local;
		this.capacidade = capacidade;
		this.descricao = descricao;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	public String getLocal()
	{
		return this.local;
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
