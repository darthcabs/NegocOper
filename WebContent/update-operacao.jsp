<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Alterar Operação</title>
	<link rel="stylesheet" type="text/css" href="content/styles/bootstrap.min.css">
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="container">
		<h1>Alterar operação</h1>
		<br>
		<form action="operacoes" method="post">
			<div class="form-group">
				<label for="id-merc">Mercadoria</label>
				<select class="form-control" id="id-merc" name="idMerc">
					<option>Selecione</option>
					<c:forEach var="merc" items="${mercadorias}">
						<c:if test="${merc.codigo eq operacao.mercadoria.codigo}">
							<option selected value="${merc.codigo }">${merc.nome }</option>
						</c:if>
						<c:if test="${merc.codigo ne operacao.mercadoria.codigo}">
							<option value="${merc.codigo }">${merc.nome }</option>
						</c:if>	
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="id-preco">Preco</label>
				<input type="text" name="preco" value="${operacao.preco }" id="id-preco" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-qtde">Quantidade</label>
				<input type="number" name="quantidade" value="${operacao.quantidade }" min="0" id="id-qtde" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-tipo">Tipo</label>
				<select class="form-control" id="id-tipo" name="tipo">
					<option>Selecione</option>
					<c:if test="${operacao.tipo eq 'compra'}">
						<option selected value="compra">Compra</option>
						<option value="venda">Venda</option>
					</c:if>
					<c:if test="${operacao.tipo eq 'venda'}">
						<option value="compra">Compra</option>
						<option selected value="venda">Venda</option>
					</c:if>
				</select>
			</div>
			<div class="form-group">
				<input type="hidden" name="codigo" value="${operacao.codigo }">
				<input type="hidden" name="action" value="update"> 
				<input type="submit" class="btn btn-primary" value="Alterar">
			</div>
		</form>
	</div>
</body>
</html>