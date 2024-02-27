package br.edu.ifgoiano;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/agora")
public class AgoraServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		
		String data = formato.format(date);
		
		String html = "<html><body><h1>" + data + "</h1></body></html>";
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().print(html);
	}
}
