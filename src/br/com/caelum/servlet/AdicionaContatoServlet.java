/*resp.sendredirect('sucesso.jsp"); volta ao servidor para náo ocorrer a duplica;áo na inclusao do relatorio*/
package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;



/**
 * Servlet implementation class AdicionaContatoServlet
 */
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
			return;
		}
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		RequestDispatcher rd = req.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(req, resp);
		
		//implementar o codigo abaixo caso nao queira que o usuario faco o cadastramento duplo com f5
		//resp.sendRedirect("sucesso.jsp");
		
		
		
		
			
			
		}
	
	
}
