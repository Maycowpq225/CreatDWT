package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.entities.SigepModifield;
import model.services.SigepTransform;

public class main2 {

	public static void main(String[] args) throws IOException {
		
		
		SigepTransform st = new SigepTransform();
		
		List<SigepModifield> list = new ArrayList<>();
		
		st.readDate(list, new File("C:\\\\Users\\\\mayco\\\\Desktop\\\\Nova pasta\\\\SIGEP 05.12.2019.xls"));
		st.printList(list);
	}

}
