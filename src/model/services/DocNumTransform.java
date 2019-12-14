package model.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.entities.DocNumModifield;

public class DocNumTransform {
	
	public void readDate(List<DocNumModifield> list, File file) throws IOException, ParseException {

		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);

		sheet.removeRow(sheet.getRow(0));
		
		for (Row row : sheet) {
			int docNum = (int) row.getCell(1).getNumericCellValue();
			int especificacao = (int)row.getCell(10).getNumericCellValue();
			String cod = row.getCell(14).getStringCellValue();
			list.add(new DocNumModifield(docNum, especificacao, cod));
		}

	}
	
	public static String findCodByDocNum(int docnum, List<DocNumModifield> list) {
		
		for (DocNumModifield doc : list) {
			Boolean bo = doc.getDocNum().equals(docnum);
			if (bo == true) {
				return doc.getCod();
			}
		}
		return (String) null;
	}

	public void printList(List<?> list) {
		list.forEach(System.out::println);
	}

}
