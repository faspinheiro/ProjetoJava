<%@page import="negocio.Pedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>AppPedido</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<%List<Pedido> lista = (List<Pedido>)request.getAttribute("usuarios");%>

<div class="container">
  <h2>Listagem de Usuário</h2>
  <form action="usuarioDetalhe.html" method="get">
    <button type="submit" class="btn btn-default">Voltar</button>
  </form>

    <div class="form-group">
		<%for(Pedido item : lista){%>
		<form action="UsuarioController" method="post">
			<h3><%=item%>
			<button name="idUsuario" value="<%=item.getId()%>" type="submit" class="btn btn-link">Excluir</button>
			</h3>
		</form>
		<%}%>
    </div>

</div>

</body>
</html>
