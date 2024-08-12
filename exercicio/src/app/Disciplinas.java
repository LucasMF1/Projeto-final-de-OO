package app;

public class Disciplinas {
	String nome,
		   codigoD;
	
	public Disciplinas(String nome, String codigoD ) {
		this.nome = nome;;
		this.codigoD = codigoD;
		
	}
	public final String getNome() {
		return nome;
	}
	public final String getCodigoD() {
		return codigoD;
	}
	protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}

	public String toString() {
		String resposta = super.toString() + '\n';
		resposta += "NOME DISCIPLINA: " + nome + '\n';
		resposta += "CODIGO DISCIPLINA: " + codigoD + '\n';
		return resposta;
	}
	

}
