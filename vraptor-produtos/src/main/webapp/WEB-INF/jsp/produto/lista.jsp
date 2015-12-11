<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.css">
<head>
<title>Lista de Produtos</title>
</head>
<body>
	<div class="container">
		<h1>Lista de Produtos</h1>
		<table class="table table-stripped table-hover table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>Nome</th>
					<th>Valor</th>
					<th>Quantidade</th>
					<th>Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtoList}" var="produto">
					<tr>
						<td>${produto.id}</td>
						<td>${produto.nome}</td>
						<td>${produto.valor}</td>
						<td>${produto.quantidade}</td>
						<td><a
							href="<c:url value='/produto/remove?produto.id=${produto.id}'/>">Remover</a>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">${mensagem}</div>

		</c:if>

		<table>
			<thead>
				<tr>
					<td><a href="<c:url value='/produto/formulario'/>">Adiciona
							Produto</a></td>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>