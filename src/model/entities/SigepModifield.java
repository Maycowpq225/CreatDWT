package model.entities;

public class SigepModifield {
	
	private String uField56;
	private Integer especificacao;
	private String destinatario;
	
	public SigepModifield(String uField56, Integer especificacao, String destinatario) {
		this.uField56 = uField56;
		this.especificacao = especificacao;
		this.destinatario = destinatario;
	}

	public String getuField56() {
		return uField56;
	}

	public void setuField56(String uField56) {
		this.uField56 = uField56;
	}

	public Integer getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(Integer especificacao) {
		this.especificacao = especificacao;
	}

	public String getDestinataio() {
		return destinatario;
	}

	public void setDestinataio(String destinataio) {
		this.destinatario = destinataio;
	}

	@Override
	public String toString() {
		return "uField56=" + uField56 + ", especificacao=" + especificacao + ", destinatario="
				+ destinatario ;
	}
	
	

}
