package cursojava.javaIO;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {

	public static void main(String[] args) throws Exception {

		FileInputStream entrada = new FileInputStream(new File(
				"C:\\Users\\carlo\\git\\JDevTreinamentos\\treinamentojava\\src\\cursojava\\javaIO\\fileUsandoApachePoi.xls")); /*
																																 * DEFININDO
																																 * O
																																 * ARQUIVO
																																 * DE
																																 * ENTRADA
																																 */

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); /* PREPARA A ENTRADA DO ARQUIVO */

		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /* PEGA A PRIMEIRA PLANILHA DO ARQUIVO EXCEL */

		Iterator<Row> linhaIterator = planilha.iterator();
		/*
		 * PERCORRENDO A PLANILHA "fileUsandoApachePoi" E COLOCANDO EM UMA LISTA DE
		 * PESSOAS;
		 */
		List<Pessoa> pessoas = new ArrayList<>();

		/* ENQUANTO TIVER LINHAS NO ARQUIVO DO EXCEL */
		while (linhaIterator.hasNext()) {
			Row linha = linhaIterator.next(); /* DADOS DA PESSOA NA LINHA */

			Iterator<Cell> celulas = linha.iterator();

			Pessoa pessoa = new Pessoa(); /* PARA CADA LINHA, DEVO INSTACIAR UMA PESSOA */

			while (celulas.hasNext()) { /* PERCORRENDO AS CÉLULAS */

				Cell cell = celulas.next();

				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(
							cell.getStringCellValue()); /* PEGA O VALOR DA CELULA 0 E SETA O NOME COM O VALOR DELA; */
					break;
				case 1:
					pessoa.setIdade(Double.valueOf(cell.getStringCellValue()).intValue()); /* PEGA O VALOR DA CELULA 1 E SETA O NOME COM O VALOR DELA; */
					break;
				case 2:
					pessoa.setEmail(cell.getStringCellValue()); /* PEGA O VALOR DA CELULA 2 E SETA O NOME COM O VALOR DELA; */
					break;

				}

			} /* FIM DAS CÉLULAS DA LINHA */
			
			pessoas.add(pessoa);

		}
		
		entrada.close(); /* TERMINOU DE LER O ARQUIVO EXCEL */
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}

	}

}
