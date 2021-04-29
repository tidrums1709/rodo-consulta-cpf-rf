package br.com.partnergroup.robo.test.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.h2.tools.Server;

public class H2Server extends Thread implements AutoCloseable {

	private Server server;
	
	public H2Server() throws SQLException {
		super();
		
	}

	@Override
	public void run() {
		super.run();
		try {
			server=Server.createWebServer("-webDaemon","-webPort","9099");
			server.start();
			criarTabelas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void criarTabelas() throws SQLException {
		String url="jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
		try(Connection con = DriverManager.getConnection(url,"sa","")){
			try(PreparedStatement ps = con.prepareStatement("CREATE TABLE  if not exists tb_html(id INT PRIMARY KEY auto_increment, html varchar);")){
				ps.execute();
			}		
		}
		
	}
	

	public void close() throws Exception {
		server.stop();
		interrupt();
	}

	
	
	
}
