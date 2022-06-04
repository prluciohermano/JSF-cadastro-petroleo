package br.com.adsdswpetro.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.jdbc.Work;
import org.primefaces.component.export.Exporter;

import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.PdfExporterConfiguration;
import net.sf.jasperreports.export.PdfReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class ProcessadorRelatorios implements Work {
	private String pathRelatorio;
	private HttpServletResponse response;
	private Map<String, Object> parametros;
	private String arquivoPdf;
	private boolean relatorioVazio;
	
	public ProcessadorRelatorios(String pathRelatorio, HttpServletResponse response, 
			                     Map<String, Object> parametros, String arquivoPdf) {
		this.pathRelatorio = pathRelatorio;
		this.response = response;
		this.parametros = parametros;
		this.arquivoPdf = arquivoPdf;
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
// para gravar relatório na pasta /temp do servidor, se desejado. Útil numa app desktop.
//
// O cabeçalho Content-Disposition força o browser a fazer download do arquivo pdf gerado
// ao invés de abrir o pdf no browser.
