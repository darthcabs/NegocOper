package br.com.valemobi.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.valemobi.dao.MercadoriaDAO;
import br.com.valemobi.model.Mercadoria;

@WebServlet("/mercadorias")
public class MercadoriasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		switch (action) {
		case "read":
			List<Mercadoria> lstMercs = null;

			try {
				MercadoriaDAO dao = new MercadoriaDAO();
				lstMercs = dao.getAll();
			} catch (Exception e) {
				System.out.println("A Conexão com o banco falhou.");
				e.printStackTrace();
			}
			req.setAttribute("mercadorias", lstMercs);
			req.getRequestDispatcher("lista-mercadorias.jsp").forward(req, resp);

			break;
		case "update":
			int id = Integer.parseInt(req.getParameter("codigo"));
			Mercadoria merc = null;

			try {
				MercadoriaDAO dao = new MercadoriaDAO();
				merc = dao.getById(id);
			} catch (Exception e) {
				System.out.println("A Conexão com o banco falhou.");
				e.printStackTrace();
			}
			req.setAttribute("mercadoria", merc);
			req.getRequestDispatcher("update-mercadoria.jsp").forward(req, resp);

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
				MercadoriaDAO dao = new MercadoriaDAO();
				Mercadoria merc = new Mercadoria(req.getParameter("nome"), req.getParameter("tipo"));

				if (dao.create(merc) > 0) {
					req.setAttribute("mensagem", "Mercadoria criada com sucesso.");
				} else {
					req.setAttribute("mensagem", "Falha ao criar mercadoria.");
				}
				req.setAttribute("mercadorias", dao.getAll());
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("lista-mercadorias.jsp").forward(req, resp);

			break;
		case "update":
			try {
				MercadoriaDAO dao = new MercadoriaDAO();
				Mercadoria merc = dao.getById(Integer.parseInt(req.getParameter("codigo")));
				merc.setNome(req.getParameter("nome"));
				merc.setTipo(req.getParameter("tipo"));

				if (dao.update(merc) > 0) {
					req.setAttribute("mensagem", "Dados alterados com sucesso.");
				} else {
					req.setAttribute("mensagem", "Falha ao alterar os dados.");
				}
				req.setAttribute("mercadorias", dao.getAll());
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("lista-mercadorias.jsp").forward(req, resp);

			break;
		case "delete":
			int codigo = Integer.parseInt(req.getParameter("codigo"));

			try {
				MercadoriaDAO dao = new MercadoriaDAO();
				if (dao.delete(codigo) > 0) {
					req.setAttribute("mensagem", "Mercadoria excluída com sucesso.");
				} else {
					req.setAttribute("mensagem", "Falha ao excluir a mercadoria.");
				}
				req.setAttribute("mercadorias", dao.getAll());
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("lista-mercadorias.jsp").forward(req, resp);

			break;
		default:
			break;
		}
	}
}