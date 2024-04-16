package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.util.List;

import br.edu.ifgoiano.entidade.*;
import br.edu.ifgoiano.UsuarioRepositorio.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/usuario")
public class UsuarioServLet extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		UsuarioRepositorio usus = new UsuarioRepositorio();
		List<Usuario> usuarios = usus.listaUsuarios();
		
		req.setAttribute("usuarios", usuarios);
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
}
