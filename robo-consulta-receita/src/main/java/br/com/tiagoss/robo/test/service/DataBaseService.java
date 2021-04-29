package br.com.tiagoss.robo.test.service;

import br.com.tiagoss.robo.test.model.Formulario;

import java.sql.*;

public class DataBaseService {

    private Statement st;
    private Connection conn;

    public DataBaseService(String url, String user, String senha) {
        try {
            Class.forName ("org.h2.Driver");
            conn = DriverManager.getConnection (url, user,senha);
            st = conn.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertFormulario(Formulario formulario) throws SQLException {

        String dados = formulario.toString().replace("'","");
        String sql = "insert into tb_html (html) values ('" + dados + "');";
        st.execute(sql);
        String sqlS = "select * from tb_html";
        ResultSet rs = st.executeQuery(sqlS);
        while(rs.next()) {
            int id  = rs.getInt("id");
            String html = rs.getString("html");

            // Display values
            System.out.print("ID: " + id);
            System.out.println(", HMTL: " + html);
        }
        rs.close();
        conn.close();

    }
}
