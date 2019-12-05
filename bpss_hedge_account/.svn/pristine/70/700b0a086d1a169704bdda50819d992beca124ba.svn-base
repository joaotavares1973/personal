<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<style type="text/css" class="init">
div.dataTables_wrapper {
	width: 96%;
	margin: 2% 1% 0% 1%;
}
</style>

<tiles:insertDefinition name="template">
	<tiles:putAttribute name="corpo">

		<script type="text/javascript" charset="utf-8">
			$(document)
					.ready(
							function() {
								$('#lista')
										.dataTable(
												{
													paging : true,
													pageLength : 12,
													columnDefs : [ {
														"width" : "15%",
														"targets" : [ 0 ]
													}, {
														"width" : "65%",
														"targets" : [ 1 ]
													}, {
														"width" : "20%",
														"targets" : [ 2 ]
													} ],
													"language" : {
														"decimal" : "999.999.999,99",
														"emptyTable" : "Nenhuma Loja encontrada",
														"info" : "Exibindo _START_ de _END_    de um total de _TOTAL_ Produtos",
														"infoEmpty" : "Exibindo 0 to 0 of 0 <b>Produtos<b>",
														"infoFiltered" : "(filtrado de _MAX_ Produtos)",
														"infoPostFix" : "",
														"thousands" : ",",
														"lengthMenu" : "Exibir _MENU_ Produtos",
														"loadingRecords" : "Carregando...",
														"processing" : "Processando...",
														"search" : "Encontrar:",
														"zeroRecords" : "Nenhum Produto encontrada",
														"paginate" : {
															"first" : "Primeiro",
															"last" : "Último",
															"next" : "Próximo",
															"previous" : "Anterior"
														},
														"aria" : {
															"sortAscending" : ": activate to sort column ascending",
															"sortDescending" : ": activate to sort column descending"
														}
													}
												});
							});
		</script>

		<springform:form name="listaProdutos" method="post"
			action="${pageContext.request.contextPath}/listarProdutos.bpss"
			modelAttribute="loja">
			<table id="lista" class="table table-striped table-bordered nowrap"
				cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Código</th>
						<th>Descrição</th>
						<th>Ações</th>
					</tr>

				</thead>
				<tbody>
					<c:forEach items="${produtos}" var="e">
						<tr>
							<td>${e[0]}</td>
							<td>${e[1]}</td>
							<td>${e[2]}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>

		</springform:form>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>