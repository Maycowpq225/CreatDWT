package model.entities;

public class DocNumModifield {
	
	private Integer docNum;
	private Integer especificacao;
	private String cod;
	
	public DocNumModifield(Integer docNum, Integer especificacao, String cod) {
		this.docNum = docNum;
		this.especificacao = especificacao;
		this.cod = cod;
	}

	public Integer getDocNum() {
		return docNum;
	}

	public void setDocNum(Integer docNum) {
		this.docNum = docNum;
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
		return "docNum=" + docNum + ", especificacao=" + especificacao + ", cod=" + cod ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((especificacao == null) ? 0 : especificacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocNumModifield other = (DocNumModifield) obj;
		if (especificacao == null) {
			if (other.especificacao != null)
				return false;
		} else if (!especificacao.equals(other.especificacao))
			return false;
		return true;
	}
	
	
	
	
}
