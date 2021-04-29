package br.com.partnergroup.robo.test.app;

import br.com.partnergroup.robo.test.bd.H2Server;
import br.com.partnergroup.robo.test.model.Consulta;
import br.com.partnergroup.robo.test.model.Formulario;
import br.com.partnergroup.robo.test.model.TipoConsulta;
import br.com.partnergroup.robo.test.service.DataBaseService;
import br.com.partnergroup.robo.test.service.GetService;
import br.com.partnergroup.robo.test.service.ImagemService;
import br.com.partnergroup.robo.test.service.PostService;
import br.com.partnergroup.robo.test.validador.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) throws SQLException, Exception {
		try(H2Server server=new H2Server()){
			server.start();
			/*
			 * String de conexão com o banco de dados: jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1
			 * (Usuário 'sa' sem senha 
			 */
			
			/*
			 * 
			 * Implementar a partir daqui!
			 * 
			 */
			//Dados Requisicao

			String cpf = JOptionPane.showInputDialog("digite o cpf");
			if(!cpf.matches("[0-9]{3}+.{0,1}[0-9]{3}+.{0,1}[0-9]{3}+-{0,1}[0-9]{2}")){
				throw new RuntimeException("Valor de CPF invalido");
			}
			String dtnascimento = JOptionPane.showInputDialog("digite a data de nascimento no formato dd/mm/aaaa");
			if(!dtnascimento.matches("[0-9]{2}+\\/[0-9]{2}+\\/[0-9]{4}")){
				throw new RuntimeException("Valor da data invalido");
			}
			String urlGet = "https://servicos.receita.fazenda.gov.br/servicos/cpf/consultasituacao/ConsultaPublicaSonoro.asp?CPF="+cpf+"&NASCIMENTO="+dtnascimento;
			String urlPost = "https://servicos.receita.fazenda.gov.br/servicos/cpf/consultasituacao/ConsultaPublicaExibir.asp";
			CloseableHttpClient httpclient = HttpClients.createDefault();

			String img64 = new GetService().criaConexao(urlGet, httpclient);

			ImageIcon imageIcon = getImageIcon(img64);

			String captha = (String) JOptionPane.showInputDialog(null, "resolva a captha", "Aviso", JOptionPane.QUESTION_MESSAGE, imageIcon, null, null);

			Consulta parametros = geraListaDeParametrosPost(cpf, dtnascimento, captha);

			String texto = new PostService().criaconexao(urlPost, parametros, httpclient);
			Formulario formulario = new Formulario();
			List<ValidaTexto> validaTextoList = Arrays.asList(
					new ValidaCodComprovante(),
					new ValidaCpfTexto(),
					new ValidaDataInscricao(),
					new ValidaDataNascimento(),
					new ValidaNomeTexto(),
					new ValidaSituacaoTexto());

			validaTextoList.forEach(v -> v.validarTexto(texto, formulario));


			DataBaseService dbs = new DataBaseService("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
			dbs.insertFormulario(formulario);


			JOptionPane.showMessageDialog(null, "Situacao Cadastral: " + formulario.getSituacao());
		}

	}

	private static ImageIcon getImageIcon(String img64) {
		String path = new ImagemService().convertImagem64EmImagemPng(img64);
		ImageIcon imageIcon = new ImageIcon(path);
		return imageIcon;
	}

	private static Consulta geraListaDeParametrosPost(String cpf, String dtnascimento, String captha) {
		return new Consulta(Boolean.FALSE, cpf, dtnascimento, captha, TipoConsulta.CONSULTAR);
	}

}
