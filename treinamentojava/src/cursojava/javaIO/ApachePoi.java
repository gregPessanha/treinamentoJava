package cursojava.javaIO;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws Exception {

		File file = new File(
				"C:\\Users\\carlo\\git\\JDevTreinamentos\\treinamentojava\\src\\cursojava\\javaIO\\fileUsandoApachePoi.xls");

		if (!file.exists()) {
			file.createNewFile();
		}

		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("José Maria da Silva Santos");
		pessoa1.setIdade(67);
		pessoa1.setEmail("josemariasantos@gmail.com");

		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Álvaro Aranha Arantes");
		pessoa2.setIdade(75);
		pessoa2.setEmail("alvaroarantes@yahoo.com");

		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Marina Ruy Barbosa");
		pessoa3.setIdade(27);
		pessoa3.setEmail("marinaruybarbosa@live.com");

		Pessoa pessoa4 = new Pessoa();
		pessoa4.setNome("Carlos Antônio Henrique Gonçalves");
		pessoa4.setIdade(50);
		pessoa4.setEmail("carlosgoncalves@gmail.com");

		List<Pessoa> pessoas = new ArrayList<>();

		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); /* USADO PARA ESCREVER A PLANILHA */
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas"); /* CRIAR A PLANILHA */

		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha++); /* CRIANDO A LINHA NA PLANILHA */

			int celula = 0;

			Cell celNome = linha.createCell(celula++); /* CÉLULA 1 */
			celNome.setCellValue(p.getNome());

			Cell celIdade = linha.createCell(celula++); /* CÉLULA 2 */
			celIdade.setCellValue(p.getIdade());

			Cell celEmail = linha.createCell(celula++); /* CÉLULA 3 */
			celEmail.setCellValue(p.getEmail());

		}

		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida); /* ESCREVE A PLANILHA */

		saida.flush();
		saida.close();
		
		System.out.println("Planilha CRIADA.");

	}

}
