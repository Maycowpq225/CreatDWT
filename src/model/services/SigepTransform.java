package model.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.entities.SigepModifield;

public class SigepTransform {

	public void readDate(List<SigepModifield> list, File file) {
		try {
		
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);

		sheet.removeRow(sheet.getRow(0));


		for (Row row : sheet) {

			if (row.getCell(9).getStringCellValue().length() <= 21) {
				String uField56 = row.getCell(8).getStringCellValue();
				int especificacao = Integer.parseInt(row.getCell(9).getStringCellValue().substring(3, 9));
				String destinatario = row.getCell(11).getStringCellValue();
				list.add(new SigepModifield(uField56, especificacao, destinatario));
			} else if (row.getCell(9).getStringCellValue().length() > 21
					&& row.getCell(9).getStringCellValue().length() <= 30) {
				String uField56 = row.getCell(8).getStringCellValue();
				int especificacao = Integer.parseInt(row.getCell(9).getStringCellValue().substring(3, 9));
				String destinatario = row.getCell(11).getStringCellValue();
				list.add(new SigepModifield(uField56, especificacao, destinatario));
				uField56 = row.getCell(8).getStringCellValue();
				especificacao = Integer.parseInt(row.getCell(9).getStringCellValue().substring(12, 18));
				destinatario = row.getCell(11).getStringCellValue();
				list.add(new SigepModifield(uField56, especificacao, destinatario));
			} else {
				String uField56 = row.getCell(8).getStringCellValue();
				int especificacao = Integer.parseInt(row.getCell(9).getStringCellValue().substring(3, 9));
				String destinatario = row.getCell(11).getStringCellValue();
				list.add(new SigepModifield(uField56, especificacao, destinatario));
				uField56 = row.getCell(8).getStringCellValue();
				especificacao = Integer.parseInt(row.getCell(9).getStringCellValue().substring(11, 17));
				destinatario = row.getCell(11).getStringCellValue();
				list.add(new SigepModifield(uField56, especificacao, destinatario));
				uField56 = row.getCell(8).getStringCellValue();
				especificacao = Integer.parseInt(row.getCell(9).getStringCellValue().substring(20, 26));
				destinatario = row.getCell(11).getStringCellValue();
				list.add(new SigepModifield(uField56, especificacao, destinatario));
			}

		}
	  }catch(IOException e) {
		  e.printStackTrace();
	  }
	}

	public void printList(List<?> list) {
		list.forEach(System.out::println);
	}

}
