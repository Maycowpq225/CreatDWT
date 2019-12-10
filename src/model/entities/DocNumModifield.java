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
	
	
	
	
}
