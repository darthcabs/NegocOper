package br.com.valemobi.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	public Connection getConnection() throws Exception {
		FileReader file = new FileReader("/Users/David/Desktop/conn_strings.txt");
		BufferedReader dados = new BufferedReader(file);
		String db = dados.readLine();
		String url = dados.readLine();
		String dbName = dados.readLine();
		String user = dados.readLine();
		String passwd = dados.readLine();
		dados.close();
		
		if (db.equals("mysql")) {
			Class.forName("com.mysql.jdbc.Driver");
		}
		
		Connection conn = DriverManager.getConnection("jdbc:" + db + "://" + url + "/" + dbName, user, passwd);
		
		return conn;
	}
}