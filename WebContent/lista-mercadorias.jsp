<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lista de Mercadorias</title>
	<link rel="stylesheet" type="text/css" href="content/styles/bootstrap.min.css">
	<script type="text/javascript" src="content/scripts/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="content/scripts/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="container">
		<h1>Lista de Mercadorias</h1>
		<br>
		<c:if test="${not empty mensagem}">
			<div class="alert alert-info">
				${mensagem}
			</div>
		</c:if>
		<br>
		<a href="nova-mercadoria.jsp">Nova mercadoria</a>
		<table class="table">
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Tipo</th>
				<th></th>
			</tr>	
			<c:forEach var="merc" items="${mercadorias}">
				<tr>
					<td>${merc.codigo }</td>
					<td>${merc.nome }</td>
					<td>${merc.tipo }</td>
					<td>
						<a href="mercadorias?action=update&codigo=${merc.codigo}">Alterar&nbsp;</a>
						<a href="#" onclick="callDeleteModal(${merc.codigo})">Deletar</a>
					</td>
				</tr>
			</c:forEach>		
		</table>
		
		<!-- Modal Delete -->
		<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Confirmação</h4>
		      </div>
		      <div class="modal-body">Deseja excluir a mercadoria?</div>
		      <div class="modal-footer">
		      	<form action="mercadorias" method="post">
		      		<input type="hidden" name="action" value="delete">
		      		<input type="hidden" name="codigo" id="id-codigo">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
			        <button type="submit" class="btn btn-primary">Sim</button>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
	
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
		    setTimeout(function() {
        		$(".alert").alert('close');
    		}, 2500);
		});
		
		function callDeleteModal(codigo) {
    		$('#id-codigo').val(codigo);
    		$('#deleteModal').modal('show');
    	}
	</script>
</body>
</html>