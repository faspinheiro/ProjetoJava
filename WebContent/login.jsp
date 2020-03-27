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

<%Boolean validou = request.getAttribute("validacao") == null; %>

<div class="container">
  <h2>Login</h2>
  
	<%if(!validou){%>
	<div class="alert alert-danger" display="none">
	  <strong>Erro!</strong> Acesso inválido.
	</div>
  	<%}%>
  <form action="AcessoController" method="post">

    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Entre com o e-mail" name="email">
    </div>

    <div class="form-group">
      <label for="pwd">Senha:</label>
      <input type="password" class="form-control" id="senha" placeholder="Entre com a senha" name="senha">
    </div>

    <button type="submit" class="btn btn-default">Cadastrar</button>
  </form>
</div>

</body>
</html>
