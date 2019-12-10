package model.entities;

public class Dtw {

		private Integer docNum;
		private Integer uField57;
		private String uField56;
		private Integer especificacao;
		private String destinatario;
		
		public Dtw(Integer docNum, Integer uField57, String uField56, Integer especificacao, String destinatario) {
			this.docNum = docNum;
			this.uField57 = uField57;
			this.uField56 = uField56;
			this.especificacao = especificacao;
			this.destinatario = destinatario;
		}

		public Integer getDocNum() {
			return docNum;
		}

		public void setDocNum(Integer docNum) {
			this.docNum = docNum;
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

		public String getDestinatario() {
			return destinatario;
		}

		public void setDestinatario(String destinatario) {
			this.destinatario = destinatario;
		}

		@Override
		public String toString() {
			return "docNum=" + docNum + ", uField57=" + uField57 + ", uField56=" + uField56 + ", especificacao="
					+ especificacao + ", destinatario=" + destinatario ;
		}
		
		
		
}
