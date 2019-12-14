package Gui;

import java.util.Vector;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import model.entities.DocNumModifield;
import model.services.DocNumTransform;

public class InactiveController {
	
	@FXML
	private TextArea txInativos;
	@FXML
	private Button btGerarCod;
	@FXML
	private TextArea txCods;

	public void btGerarCodAction(){	
		
		String[] list = txInativos.getText().split("\n");
		
		for(String row:list) {
			String cod = DocNumTransform.findCodByDocNum(Integer.parseInt(row.substring(0,6)),ViewController.list2);
			txCods.setText(txCods.getText()+cod+"\n");
		
			
		}
		
		
		
	
	}
	
}
