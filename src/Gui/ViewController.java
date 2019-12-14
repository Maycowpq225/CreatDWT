package Gui;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import Gui.util.Alerts;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
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

public class ViewController {

	SigepTransform st = new SigepTransform();
	PostaFacilTransform pt = new PostaFacilTransform();
	DocNumTransform dt = new DocNumTransform();
	CreateDtw cd = new CreateDtw();

	List<SigepModifield> list = new ArrayList<>();
	List<PostaFacilModifield> list1 = new ArrayList<>();
	static List<DocNumModifield> list2 = new ArrayList<>();
	List<Dtw> list3 = new ArrayList<>();

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

	public void btSigepAction() {
		try {
			FileChooser fl = new FileChooser();
			fl.getExtensionFilters().addAll(new ExtensionFilter("XLS files", "*.xls"));
			File seletedFile = fl.showOpenDialog(null);
			st.readDate(list, seletedFile);
			listview.getItems().add(seletedFile.getName());
		} catch (NullPointerException e) {
			Alerts.showAlert("ERROR", null, "ERRO AO IMPORTAR PLANILHA", AlertType.ERROR);
			
		}
	}

	public void btPostaFacilAction() {
		try {
			FileChooser fl = new FileChooser();
			fl.getExtensionFilters().addAll(new ExtensionFilter("XLS files", "*.xls"));
			List<File> seletedFiles = fl.showOpenMultipleDialog(null);

			for (File file : seletedFiles) {
				pt.readDate(list1, file.getAbsoluteFile());
				listview.getItems().add(file.getName());
			}
			
		} catch (IOException | ParseException |NullPointerException | IllegalStateException e) {
			Alerts.showAlert("ERROR", null, "ERRO AO IMPORTAR PLANILHA", AlertType.ERROR);
			
		}

	}

	public void btListaNotasAction() {
		try {
			FileChooser fl = new FileChooser();
			fl.getExtensionFilters().addAll(new ExtensionFilter("XLSX files", "*.xlsx"));

			File seletedFile = fl.showOpenDialog(null);
			dt.readDate(list2, seletedFile);
			listview.getItems().add(seletedFile.getName());
			

		} catch (IOException | ParseException | NullPointerException | IllegalStateException e) {
			Alerts.showAlert("ERROR", null, "ERRO AO IMPORTAR PLANILHA", AlertType.ERROR);
		
		}
	}

	public void btPlanilhaDtwAction() {
		try {
			FileChooser fl = new FileChooser();
			fl.getExtensionFilters().addAll(new ExtensionFilter("XLSX files", "*.xlsx"));
			File seletedFile = fl.showSaveDialog(null);

			cd.createDTW(list, list1, list2, list3);

			cd.createExcelDtw(list3, seletedFile);

			Alerts.showAlert("SUCESSO", null, "PLANILHA GERADA COM SUCESSO!", AlertType.INFORMATION);
		} catch (IOException | NullPointerException e) {
			e.printStackTrace();
			list.removeAll(list);
			list1.removeAll(list1);
			list2.removeAll(list2);
			list3.removeAll(list3);	
			listview.getItems().clear();
			Alerts.showAlert("ERROR", null, "ERRO AO EXPORTAR PLANILHA, IMPORTE TODAS AS PLANILHAS NOVAMENTE!", AlertType.ERROR);
		}
	}

	@FXML
	public void btInativosAction() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/Inactive.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("inactives");
			stage.setScene(new Scene(root1));
			stage.show();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
