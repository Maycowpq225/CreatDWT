package model.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.entities.DocNumModifield;
import model.entities.Dtw;
import model.entities.PostaFacilModifield;
import model.entities.SigepModifield;

public class CreateDtw {

	public void createDTW(List<SigepModifield> list, List<PostaFacilModifield> list1, List<DocNumModifield> list2,
			List<Dtw> list3) {

		for (SigepModifield sigep : list) {
			String uField56 = sigep.getuField56();
			int especificacao = sigep.getEspecificacao();
			String destinatario = sigep.getDestinataio();
			int docNum = findDocNum(list2, especificacao);
			int uField57 = catchUfield57(list1);
			list3.add(new Dtw(docNum, uField57, uField56, especificacao, destinatario));
		}

		for (PostaFacilModifield posta : list1) {
			int uField57 = posta.getuField57();
			String uField56 = posta.getuField56();
			int especificacao = posta.getEspecificacao();
			String destinatario = posta.getCod();
			int docNum = findDocNum(list2, especificacao);
			list3.add(new Dtw(docNum, uField57, uField56, especificacao, destinatario));
		}
	}

	public void printList(List<?> list) {
		list.forEach(System.out::println);
	}

	public int findDocNum(List<DocNumModifield> list, int especificacao) {
		for (DocNumModifield doc : list) {
			Boolean bo = doc.getEspecificacao().equals(especificacao);

			if (bo == true) {
				return doc.getDocNum();
			}
		}
		return (Integer) null;
	}

	public int catchUfield57(List<PostaFacilModifield> list1) {
		int uField57 = 0;
		for (PostaFacilModifield posta : list1) {
			uField57 = posta.getuField57();
		}
		return uField57;
	}

	public void createExcelDtw(List<Dtw> list, File file) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(file);
		XSSFSheet sheet = workbook.createSheet("dtw");

		sheet.createRow(0).createCell(0).setCellValue("DocNum");
		sheet.getRow(0).createCell(1).setCellValue("U_Field57");
		sheet.getRow(0).createCell(2).setCellValue("U_Field56");
		sheet.getRow(0).createCell(3).setCellValue("Especificação");
		sheet.getRow(0).createCell(4).setCellValue("Destinatário");
		sheet.createRow(1).createCell(0).setCellValue("DocNum");
		sheet.getRow(1).createCell(1).setCellValue("U_Field57");
		sheet.getRow(1).createCell(2).setCellValue("U_Field56");
		sheet.getRow(1).createCell(3).setCellValue("Especificação");
		sheet.getRow(1).createCell(4).setCellValue("Destinatário");
		int index = 0;
		for(int i = 2; i<(list.size()+2);i++) {
			
			sheet.createRow(i).createCell(0).setCellValue(list.get(index).getDocNum());
			sheet.getRow(i).createCell(1).setCellValue(list.get(index).getuField57());
			sheet.getRow(i).createCell(2).setCellValue(list.get(index).getuField56());
			sheet.getRow(i).createCell(3).setCellValue(list.get(index).getEspecificacao());
			sheet.getRow(i).createCell(4).setCellValue(list.get(index).getDestinatario());
			index+=1;
		}
		workbook.write(out);
		
		out.close();
	}
}
