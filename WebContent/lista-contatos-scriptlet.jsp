<%@ page import="java.util.*, br.com.caelum.agenda.dao.*, br.com.caelum.agenda.modelo.*"

	language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <FMT :FORMATDATE PATTERN = "ddMMyyyy" value="${dataNacimento.time} -->
</head>
<body>
	<table>
		
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data</th>
		</tr>
			
		<% ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
	
		for(Contato contato : contatos) { %>
	
		<tr>
			<td><%=contato.getId() %></td>
			<td><%=contato.getNome() %></td>
			<td><%=contato.getEmail() %></td>
			<td><%=contato.getEndereco() %></td>
			<td><%=contato.getDataNascimento().getTime() %></td>
			
		</tr>	
		<%} %>
	</table>

</body>
</html>