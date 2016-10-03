<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Modificar Mercadoria</title>
	<link rel="stylesheet" type="text/css" href="content/styles/bootstrap.min.css">
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="container">
		<h1>Modificar Mercadoria</h1>
		<br>
		<form action="mercadorias" method="post">
			<div class="form-group">
				<label>Código</label>
				<input type="text" name="codigo" id="id-codigo" class="form-control" value="${mercadoria.codigo }" readonly>
			</div>
			<div class="form-group">
				<label for="id-nome">Nome</label>
				<input type="text" name="nome" id="id-nome" class="form-control" value="${mercadoria.nome }">
			</div>
			<div class="form-group">
				<label for="id-tipo">Tipo</label>
				<input type="text" name="tipo" id="id-tipo" class="form-control" value="${mercadoria.tipo }">
			</div>
			<div class="form-group">
				<input type="hidden" name="action" value="update">		
				<input type="submit" class="btn btn-primary" value="Alterar">
			</div>
		</form>
	</div>
</body>
</html>