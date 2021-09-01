package cursojava.javaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\carlo\\git\\JDevTreinamentos\\treinamentojava\\src\\cursojava\\javaIO\\fileUsandoApachePoi.xls");

		FileInputStream entrada = new FileInputStream(file);

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); /* PREPARA A ENTRADA DO ARQUIVO XLS */

		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /* PEGANDO A PLANILHA */

		Iterator<Row> linhaIterator = planilha.iterator();

		while (linhaIterator.hasNext()) { /* ENQUANTO TIVE LINHA */
			Row linha = linhaIterator.next(); /* DADOS DA PESSOA NA LINHA */

			int qtdcelulas = linha.getPhysicalNumberOfCells(); /* SABENDO QUANTAS CELULAS EXISTE NA LINHA */

			Cell cell = linha.createCell(qtdcelulas); /* CRIANDO CELULA NESTA LINHA */
			cell.setCellValue("5.400,00"); /* SUPONDO QUE O SALARIO DE TODO MUNDO SEJA ESSE */

		}

		entrada.close();

		FileOutputStream saida = new FileOutputStream(file); /* DANDO A SAIDA PARA AO MESMO ARQUIVO, OU SEJA, EDITANDO; */

		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		hssfWorkbook.close();

		System.out.println("PLANILHA ATUALIZADA");

	}

}
