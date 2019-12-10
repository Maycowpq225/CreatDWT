package model.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import model.entities.PostaFacilModifield;

public class PostaFacilTransform {
	

	public void readDate(List<PostaFacilModifield> list, File file) throws IOException, ParseException {

		FileInputStream fis = new FileInputStream(file);

		HSSFWorkbook wb = new HSSFWorkbook(fis);

		HSSFSheet sheet = wb.getSheetAt(0);

		sheet.removeRow(sheet.getRow(0));
		
		for (Row row : sheet) {

			if (row.getCell(2).getStringCellValue().length() == 6 && !row.getCell(2).getStringCellValue().isEmpty()) {
				int uField57 = Integer.parseInt(row.getCell(0).getStringCellValue());
				String uField56 = row.getCell(1).getStringCellValue();
				int especificacao = Integer.parseInt(row.getCell(2).getStringCellValue());
				String cod = row.getCell(3).getStringCellValue();
				list.add(new PostaFacilModifield(uField57, uField56, especificacao, cod));
			} 

		}

	}

	public void printList(List<?> list) {
		list.forEach(System.out::println);
	}

}
