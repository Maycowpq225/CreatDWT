package Gui;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import model.entities.DocNumModifield;
import model.entities.Dtw;
import model.entities.PostaFacilModifield;
import model.entities.SigepModifield;
import model.services.CreateDtw;
import model.services.DocNumTransform;
import model.services.PostaFacilTransform;
import model.services.SigepTransform;

public class ViewController  {
	
	SigepTransform st = new SigepTransform();
	PostaFacilTransform pt = new PostaFacilTransform();
	DocNumTransform dt = new DocNumTransform();
	CreateDtw cd = new CreateDtw();
	
	List<SigepModifield> list = new ArrayList<>();
	List<PostaFacilModifield> list1 = new ArrayList<>();
	static List<DocNumModifield> list2 = new ArrayList<>();
	List<Dtw> list3 = new ArrayList<>();
	Vector<DocNumModifield> vetor;
	
	@FXML
	private Button btSigep;
	@FXML
	private Button btPostaFacil;
	@FXML
	private Button btListaNotas;
	@FXML
	private Button btPlanilhaDtw;
	@FXML
	private Button btInativos;
	@FXML
	private ListView<String> listview;
	
	public ViewController() {
	}
	
	public void btSigepAction() throws IOException {
		FileChooser fl = new FileChooser();
		fl.getExtensionFilters().addAll(new ExtensionFilter("XLS files","*.xls"));
		File seletedFile = fl.showOpenDialog(null);
		listview.getItems().add(seletedFile.getName());
		
		st.readDate(list, seletedFile);
	}
	public void btPostaFacilAction() throws IOException, ParseException {
		FileChooser fl = new FileChooser();
		fl.getExtensionFilters().addAll(new ExtensionFilter("XLS files","*.xls"));
		File seletedFile = fl.showOpenDialog(null);
		listview.getItems().add(seletedFile.getName());
		
		pt.readDate(list1, seletedFile);
	}
	public void btListaNotasAction() throws IOException, ParseException {
		FileChooser fl = new FileChooser();
		fl.getExtensionFilters().addAll(new ExtensionFilter("XLSX files","*.xlsx"));
		File seletedFile = fl.showOpenDialog(null);
		listview.getItems().add(seletedFile.getName());
		
		dt.readDate(list2, seletedFile);
	}
	public void btPlanilhaDtwAction() throws IOException {
		FileChooser fl = new FileChooser();
		fl.getExtensionFilters().addAll(new ExtensionFilter("XLSX files","*.xlsx"));
		File seletedFile = fl.showSaveDialog(null);
		
		cd.createDTW(list, list1, list2, list3);		
		cd.createExcelDtw(list3, seletedFile);
	}
	@FXML
	public void btInativosAction() throws Exception  {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/Inactive.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("inactives");
			stage.setScene(new Scene(root1));
			stage.show();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 
		
	}


}
