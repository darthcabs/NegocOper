package br.com.valemobi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.valemobi.db.Conexao;
import br.com.valemobi.model.Mercadoria;

public class MercadoriaDAO {
	public Connection conn;

	public MercadoriaDAO() throws Exception {
		this.conn = new Conexao().getConnection();
	}

	public int create(Mercadoria merc) throws Exception {
		PreparedStatement statement = conn
				.prepareStatement("INSERT INTO NEGOCMERC.MERCADORIA (nm_mercadoria, tp_mercadoria) VALUES (?, ?)");
		statement.setString(1, merc.getNome());
		statement.setString(2, merc.getTipo());
		int resp = statement.executeUpdate();
		statement.close();
		
		return resp;
	}

	public int update(Mercadoria merc) throws Exception {
		PreparedStatement statement = conn.prepareStatement(
				"UPDATE NEGOCMERC.MERCADORIA SET nm_mercadoria=?, tp_mercadoria=? WHERE cd_mercadoria=?");
		statement.setString(1, merc.getNome());
		statement.setString(2, merc.getTipo());
		statement.setInt(3, merc.getCodigo());
		int resp = statement.executeUpdate();
		statement.close();

		return resp;
	}

	public List<Mercadoria> getAll() throws Exception {
		List<Mercadoria> mercadorias = new ArrayList<Mercadoria>();
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM NEGOCMERC.MERCADORIA");
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			Mercadoria merc = new Mercadoria(result.getInt("cd_mercadoria"), result.getString("nm_mercadoria"),
					result.getString("tp_mercadoria"));
			mercadorias.add(merc);
		}
		result.close();
		statement.close();

		return mercadorias;
	}

	public Mercadoria getById(int id) throws Exception {
		Mercadoria merc = null;
		PreparedStatement statement = conn
				.prepareStatement("SELECT * FROM NEGOCMERC.MERCADORIA WHERE cd_mercadoria = ?");
		statement.setFloat(1, id);
		ResultSet result = statement.executeQuery();

		if (result.next()) {
			merc = new Mercadoria(result.getInt("cd_mercadoria"), result.getString("nm_mercadoria"),
					result.getString("tp_mercadoria"));
		}
		result.close();
		statement.close();

		return merc;
	}
	
	public int delete(int id) throws Exception {
		PreparedStatement statement = conn.prepareStatement("DELETE FROM NEGOCMERC.MERCADORIA WHERE cd_mercadoria = ?");
		statement.setLong(1, id);
		int resp = statement.executeUpdate();
		statement.close();
		
		return resp;
	}
}