<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Nova Mercadoria</title>
	<link rel="stylesheet" type="text/css" href="content/styles/bootstrap.min.css">
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="container">
		<h1>Nova Mercadoria</h1>
		<br>
		<c:if test="${not empty mensagem}">
			<div class="alert alert-info">
				${mensagem}
			</div>
		</c:if>
		<br>
		<form action="mercadorias" method="post">
			<div class="form-group">
				<label for="id-nome">Nome</label>
				<input type="text" name="nome" id="id-nome" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-tipo">Tipo</label>
				<input type="text" name="tipo" id="id-tipo" class="form-control">
			</div>
			<div class="form-group">
				<input type="hidden" name="action" value="create"> 
				<input type="submit" class="btn btn-primary" value="Cadastrar">
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