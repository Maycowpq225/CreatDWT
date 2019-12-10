package application;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.entities.DocNumModifield;
import model.entities.Dtw;
import model.entities.PostaFacilModifield;
import model.entities.SigepModifield;
import model.services.CreateDtw;
import model.services.DocNumTransform;
import model.services.PostaFacilTransform;
import model.services.SigepTransform;

public class main2 {

	public static void main(String[] args) throws IOException, ParseException {
		
		
		SigepTransform st = new SigepTransform();
		PostaFacilTransform pt = new PostaFacilTransform();
		DocNumTransform dt = new DocNumTransform();
		CreateDtw cd = new CreateDtw();
		
		List<SigepModifield> list = new ArrayList<>();
		List<PostaFacilModifield> list1 = new ArrayList<>();
		List<DocNumModifield> list2 = new ArrayList<>();
		List<Dtw> list3 = new ArrayList<>();
		
		st.readDate(list, new File("C:\\\\Users\\\\mayco\\\\Desktop\\\\Nova pasta\\\\SIGEP 05.12.2019.xls"));
		st.printList(list);
		System.out.println("----------------");
		System.out.println();
		pt.readDate(list1, new File("C:\\Users\\mayco\\Desktop\\Projects\\POSTA 05.12.19.xls"));
		pt.printList(list1);
		System.out.println("----------------");
		System.out.println();
		dt.readDate(list2, new File("C:\\Users\\mayco\\Desktop\\Nova pasta\\ListaNotasFiscaisSaída 05.12.19.xlsx"));
		dt.printList(list2);
		System.out.println("----------------");
		System.out.println();
		cd.createDTW(list, list1, list2, list3);
		dt.printList(list3);
	}

}
