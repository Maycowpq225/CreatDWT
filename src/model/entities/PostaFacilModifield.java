package model.entities;

import java.util.Date;

public class PostaFacilModifield {
	
	private Integer uField57;
	private String uField56;
	private Integer especificacao;
	private String cod;
	
	public PostaFacilModifield(Integer uField57, String uField56, Integer especificacao, String cod) {
		this.uField57 = uField57;
		this.uField56 = uField56;
		this.especificacao = especificacao;
		this.cod = cod;
	}

	public Integer getuField57() {
		return uField57;
	}

	public void setuField57(Integer uField57) {
		this.uField57 = uField57;
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

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	@Override
	public String toString() {
		return "uField57=" + uField57 + ", uField56=" + uField56 + ", especificacao="
				+ especificacao + ", cod=" + cod;
	}
	
	

}
