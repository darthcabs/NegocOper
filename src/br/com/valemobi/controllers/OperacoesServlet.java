package br.com.valemobi.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.valemobi.dao.MercadoriaDAO;
import br.com.valemobi.dao.OperacaoDAO;
import br.com.valemobi.model.Mercadoria;
import br.com.valemobi.model.Operacao;

@WebServlet("/operacoes")
public class OperacoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		switch (action) {
		case "create":
			try {
				MercadoriaDAO daoMerc;
				List<Mercadoria> mercadorias;
				daoMerc = new MercadoriaDAO();
				mercadorias = daoMerc.getAll();
				req.setAttribute("mercadorias", mercadorias);
			} catch (Exception e1) {
				e1.printStackTrace();
				req.setAttribute("mensagem", "Falha ao obter lista de mercadorias.");
			}
			req.getRequestDispatcher("nova-operacao.jsp").forward(req, resp);

			break;
		case "read":
			List<Operacao> lstOps = null;

			try {
				OperacaoDAO dao = new OperacaoDAO();
				lstOps = dao.getAll();
			} catch (Exception e) {
				System.out.println("A Conexão com o banco falhou.");
				e.printStackTrace();
			}
			req.setAttribute("operacoes", lstOps);
			req.getRequestDispatcher("lista-operacoes.jsp").forward(req, resp);

			break;
		case "update":
			int id = Integer.parseInt(req.getParameter("codigo"));
			try {
				OperacaoDAO dao = new OperacaoDAO();
				Operacao op = dao.getById(id);

				MercadoriaDAO daoMerc = new MercadoriaDAO();
				List<Mercadoria> mercadorias = daoMerc.getAll();

				req.setAttribute("operacao", op);
				req.setAttribute("mercadorias", mercadorias);
			} catch (Exception e) {
				System.out.println("A Conexão com o banco falhou.");
				e.printStackTrace();
			}
			req.getRequestDispatcher("update-operacao.jsp").forward(req, resp);

			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		switch (action) {
		case "create":
			try {
				OperacaoDAO dao = new OperacaoDAO();

				MercadoriaDAO daoMerc = new MercadoriaDAO();
				Mercadoria merc = daoMerc.getById(Integer.parseInt(req.getParameter("idMerc")));

				double preco = Double.parseDouble(req.getParameter("preco"));
				int quantidade = Integer.parseInt(req.getParameter("quantidade"));
				String tipo = req.getParameter("tipo");
				Operacao op = new Operacao(merc, quantidade, preco, tipo);

				if (dao.create(op) > 0) {
					req.setAttribute("mensagem", "Operação criada com sucesso.");
				} else {
					req.setAttribute("mensagem", "Falha ao criar operação.");
				}
				req.setAttribute("operacoes", dao.getAll());
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("lista-operacoes.jsp").forward(req, resp);

			break;
		case "update":
			try {
				OperacaoDAO dao = new OperacaoDAO();
				Operacao op = dao.getById(Integer.parseInt(req.getParameter("codigo")));
				op.setMercadoria(new Mercadoria(Integer.parseInt(req.getParameter("idMerc")),
						req.getParameter("nmMerc"), req.getParameter("tpMerc")));
				op.setPreco(Double.parseDouble(req.getParameter("preco")));
				op.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
				op.setTipo(req.getParameter("tipo"));

				if (dao.update(op) > 0) {
					req.setAttribute("mensagem", "Dados alterados com sucesso.");
				} else {
					req.setAttribute("mensagem", "Falha ao alterar os dados.");
				}
				req.setAttribute("operacoes", dao.getAll());
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("lista-operacoes.jsp").forward(req, resp);

			break;
		case "delete":
			int codigo = Integer.parseInt(req.getParameter("codigo"));

			try {
				OperacaoDAO dao = new OperacaoDAO();
				if (dao.delete(codigo) > 0) {
					req.setAttribute("mensagem", "Operação excluída com sucesso.");
				} else {
					req.setAttribute("mensagem", "Falha ao excluir a operação.");
				}
				req.setAttribute("operacoes", dao.getAll());
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("lista-operacoes.jsp").forward(req, resp);

			break;
		default:
			break;
		}
	}
}