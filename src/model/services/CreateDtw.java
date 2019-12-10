package model.services;

import java.util.List;

import model.entities.DocNumModifield;
import model.entities.Dtw;
import model.entities.PostaFacilModifield;
import model.entities.SigepModifield;

public class CreateDtw {

	public void createDTW(List<SigepModifield> list, List<PostaFacilModifield> list1, List<DocNumModifield> list2, List<Dtw> list3) {

				for (SigepModifield sigep:list) {
						String uField56 = sigep.getuField56();
						int especificacao = sigep.getEspecificacao();
						String destinatario = sigep.getDestinataio();
						int docNum =findDocNum(list2, especificacao);
						int uField57 = catchUfield57(list1);
						list3.add(new Dtw(docNum, uField57, uField56, especificacao, destinatario));
				}
				
				for (PostaFacilModifield posta:list1) {
					int uField57 = posta.getuField57();
					String uField56 = posta.getuField56();
					int especificacao = posta.getEspecificacao();
					String destinatario = posta.getCod();
					int docNum =findDocNum(list2, especificacao);
					list3.add(new Dtw(docNum, uField57, uField56, especificacao, destinatario));
				}
	}
	
	public void printList(List<?> list) {
		list.forEach(System.out::println);
	}
	
	public int findDocNum(List<DocNumModifield> list, int especificacao) {
		for(DocNumModifield doc: list) {
			Boolean bo =  doc.getEspecificacao().equals(especificacao);
			
			if (bo == true) {
				return doc.getDocNum();
			}
		}return (Integer) null;
	}
	public int catchUfield57(List<PostaFacilModifield> list1) {
		int uField57= 0;
		for (PostaFacilModifield posta : list1) {
			uField57 = posta.getuField57();
		}
		return uField57;
	}
	
}
