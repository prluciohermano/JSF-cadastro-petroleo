package br.com.adsdswpetro.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.jdbc.Work;
import net.sf.jasperreports.engine.JRParameter;

public class ProcessadorRelatorios implements Work {
	private Map<String, Object> parametros;
	private boolean relatorioVazio;
	
	public ProcessadorRelatorios(String pathRelatorio, HttpServletResponse response, 
			                     Map<String, Object> parametros, String arquivoPdf) {


		this.parametros = parametros;

		this.parametros.put(JRParameter.REPORT_LOCALE, new Locale("pt", "BR"));
	}

	public boolean isRelatorioVazio() {
		return relatorioVazio;
	}

	@Override
	public void execute(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}

// Troque response.getOutputStream() por new FileOutputStream("/temp/relatorio.pdf") 
// para gravar relatorio na pasta /temp do servidor, se desejado. Util numa app desktop.
//
// O cabeçalho Content-Disposition força o browser a fazer download do arquivo pdf gerado
// ao invés de abrir o pdf no browser.
