<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Nova Operação</title>
	<link rel="stylesheet" type="text/css" href="content/styles/bootstrap.min.css">
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="container">
		<h1>Nova Operação</h1>
		<br>
		<c:if test="${not empty mensagem}">
			<div class="alert alert-info">
				${mensagem}
			</div>
		</c:if>
		<br>
		<form action="operacoes" method="post">
			<div class="form-group">
				<label for="id-merc">Mercadoria</label>
				<select class="form-control" id="id-merc" name="idMerc">
					<option>Selecione</option>
					<c:forEach var="merc" items="${mercadorias}">
						<option value="${merc.codigo }">${merc.nome }</option>
					</c:forEach>
				</select>
				<a href="nova-mercadoria.jsp">Nova mercadoria</a>
			</div>
			<div class="form-group">
				<label for="id-preco">Preço</label>
				<input type="text" name="preco" id="id-preco" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-qtde">Quantidade</label>
				<input type="number" name="quantidade" min="0" id="id-qtde" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-tipo">Tipo</label>
				<select class="form-control" id="id-tipo" name="tipo">
					<option>Selecione</option>
					<option value="compra">Compra</option>
					<option value="venda">Venda</option>
				</select>
			</div>
			<div class="form-group">
				<input type="hidden" name="action" value="create"> 
				<input type="submit" class="btn btn-primary" value="Criar">
			</div>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
		    setTimeout(function() {
        		$(".alert").alert('close');
    		}, 2500);
		});
	</script>
</body>
</html>