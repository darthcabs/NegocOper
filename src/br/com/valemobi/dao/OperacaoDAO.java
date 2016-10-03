package br.com.valemobi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.valemobi.db.Conexao;
import br.com.valemobi.model.Mercadoria;
import br.com.valemobi.model.Operacao;

public class OperacaoDAO {
	public Connection conn;

	public OperacaoDAO() throws Exception {
		this.conn = new Conexao().getConnection();
	}

	public int create(Operacao op) throws Exception {
		PreparedStatement statement = conn.prepareStatement(
				"INSERT INTO NEGOCMERC.OPERACAO (vl_preco, vl_quantidade, tp_operacao, cd_mercadoria) VALUES (?, ?, ?, ?)");
		statement.setDouble(1, op.getPreco());
		statement.setInt(2, op.getQuantidade());
		statement.setString(3, op.getTipo().toUpperCase());
		statement.setInt(4, op.getMercadoria().getCodigo());
		int resp = statement.executeUpdate();
		statement.close();

		return resp;
	}

	public int update(Operacao op) throws Exception {
		PreparedStatement statement = conn.prepareStatement(
				"UPDATE NEGOCMERC.OPERACAO SET vl_preco=?, vl_quantidade=?, tp_operacao=?, cd_mercadoria=? WHERE cd_operacao=?");
		statement.setDouble(1, op.getPreco());
		statement.setInt(2, op.getQuantidade());
		statement.setString(3, op.getTipo().toUpperCase());
		statement.setInt(4, op.getMercadoria().getCodigo());
		statement.setInt(5, op.getCodigo());
		int resp = statement.executeUpdate();
		statement.close();

		return resp;
	}

	public List<Operacao> getAll() throws Exception {
		List<Operacao> operacoes = new ArrayList<Operacao>();
		PreparedStatement statement = conn.prepareStatement(
				"SELECT O.cd_operacao, M.nm_mercadoria, M.tp_mercadoria, O.vl_preco, O.vl_quantidade, O.tp_operacao "
						+ "FROM negocmerc.OPERACAO O INNER JOIN negocmerc.MERCADORIA M "
						+ "ON (O.cd_mercadoria = M.cd_mercadoria)");
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			Operacao op = new Operacao(result.getInt("cd_operacao"),
					new Mercadoria(result.getString("nm_mercadoria"), result.getString("tp_mercadoria")),
					result.getInt("vl_quantidade"), result.getDouble("vl_preco"),
					result.getString("tp_operacao").toLowerCase());
			operacoes.add(op);
		}
		result.close();
		statement.close();

		return operacoes;
	}

	public Operacao getById(int id) throws Exception {
		Operacao op = null;
		PreparedStatement statement = conn.prepareStatement(
				"SELECT O.cd_operacao, M.cd_mercadoria, M.nm_mercadoria, M.tp_mercadoria, O.vl_preco, O.vl_quantidade, O.tp_operacao "
						+ "FROM negocmerc.OPERACAO O INNER JOIN negocmerc.MERCADORIA M "
						+ "ON (O.cd_mercadoria = M.cd_mercadoria)" + "WHERE O.cd_operacao=?");
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();

		if (result.next()) {
			op = new Operacao(result.getInt("cd_operacao"),
					new Mercadoria(result.getInt("cd_mercadoria"), result.getString("nm_mercadoria"),
							result.getString("tp_mercadoria")),
					result.getInt("vl_quantidade"), result.getDouble("vl_preco"),
					result.getString("tp_operacao").toLowerCase());
		}
		result.close();
		statement.close();

		return op;
	}

	public int delete(int id) throws Exception {
		PreparedStatement statement = conn.prepareStatement("DELETE FROM NEGOCMERC.OPERACAO WHERE cd_operacao = ?");
		statement.setInt(1, id);
		int resp = statement.executeUpdate();
		statement.close();

		return resp;
	}
}