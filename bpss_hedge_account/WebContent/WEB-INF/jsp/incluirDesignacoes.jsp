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
<link href="${pageContext.request.contextPath}/root/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<style type="text/css" class="init">
div.dataTables_wrapper {
	width: 96%;
	margin: 2% 1% 0% 1%;
}

tfoot input {
	width: 120%;
	padding: 3px;
	box-sizing: border-box;
}
</style>

<tiles:insertDefinition name="template">
	<tiles:putAttribute name="corpo">

		<script type="text/javascript" charset="utf-8">
			$(document)
					.ready(
							function() {

								var tabela = $('#lista')
										.DataTable(
												{
													paging : true,
													"scrollX" : true,
													scrollCollapse : true,
													columnDefs : [ {
														"width" : "10%",
														"targets" : [ 0 ]
													}, {
														"width" : "10%",
														"targets" : [ 1 ]
													}, {
														"width" : "15%",
														"targets" : [ 2 ]
													}, {
														"width" : "10%",
														"targets" : [ 3 ]
													}, {
														"width" : "10%",
														"targets" : [ 4 ]
													}, {
														"width" : "10%",
														"targets" : [ 5 ]
													}, {
														"width" : "10%",
														"targets" : [ 6 ]
													}, {
														"width" : "10%",
														"targets" : [ 7 ]
													}, {
														"width" : "10%",
														"targets" : [ 8 ]
													} ],
													"language" : {
														"decimal" : "999.999.999,99",
														"emptyTable" : "Nenhuma Designação encontrada",
														"info" : "Exibindo _START_ de _END_    de um total de _TOTAL_ Designações",
														"infoEmpty" : "Exibindo 0 to 0 of 0 <b>Produtos<b>",
														"infoFiltered" : "(filtrado de _MAX_ Designações)",
														"infoPostFix" : "",
														"thousands" : ",",
														"lengthMenu" : "Exibir _MENU_ Designações",
														"loadingRecords" : "Carregando...",
														"processing" : "Processando...",
														"search" : "Pesquisar:",
														"zeroRecords" : "Nenhuma Designação encontrada",
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

		<springform:form name="listaDesignacoes" method="post"
			action="${pageContext.request.contextPath}/listarDesignacoes.bpss"
			modelAttribute="loja">

			<fieldset>
				<div class="form-row" style="margin-left: 10px; margin-top: 10px;">

					<div class="col-md-2" style="font-size: 10px;">
						<span>Safra:</span> <input type="text" class="form-control"
							id="anoSafra" name="anoSafra" value="${anoSafra}" required="true" />
					</div>

					<div class="col-md-2" style="font-size: 10px;">
						<span>Data de negociação De:</span> <input type="text"
							class="form-control" id="dtNegociacaoIni" name="dtNegociacaoIni"
							value="${dtNegociacaoIni}" required="true" />
					</div>
					<div class="col-md-2" style="font-size: 10px;">
						Até: <input type="text" class="form-control" id="dtNegociacaoFim"
							value="${dtNegociacaoIni}" name="dtNegociacaoFim" required="true" />
					</div>
					<div class="col-md-1" style="font-size: 10px;">
						&nbsp; <input type="button"
							class="form-control d-none d-sm-inline-block btn btn-sm btn-primary" value="Listar"
							onclick="document.listaDesignacoes.submit();" />
					</div>					
				</div>

			</fieldset>

			<fieldset>
				<div class="form-row" style="margin-left: 10px; margin-top: 10px; float:left;">
				<a class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" href="#">
				<i class="fas fa-plus-square"></i>
				<span style="">Incluir</span>
				</a>
				</div>
&nbsp; 
				<div class="form-row" style="margin-left: 10px; margin-top: 10px; float:left; color:#fff;">
				<a class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" href="#">
				<i class="fas fa-check-square"></i>
				Liquidar
				</a>
				</div>

			</fieldset>

			<table id="lista" class="table table-striped table-bordered nowrap"
				cellspacing="0" width="100%">
				<thead>
					<tr>
						<th></th>
						<th>Designação</th>
						<th>Data</th>
						<th>Objeto Hedge</th>
						<th>Produto</th>
						<th>Mês/Ano</th>
						<th>Instrumento</th>
						<th>Qtde Físico</th>
						<th>Qtde Hedge</th>
						<th>Status</th>
						<th>Ações</th>
					</tr>

				</thead>
				<tbody>
					<c:forEach items="${designacoes}" var="e">
						<tr>
						    <td><input type="radio" name="_id"></td>
							<td>${e.cdDesignacaodesignacao}</td>
							<td>${e.dtAlocacao}</td>
							<td>${e.objetoHedge}</td>
							<td>${e.nmGrpProduto}</td>
							<td>${e.mesAno}</td>
							<td>${e.dsTipoInstrumento}</td>
							<td>${e.qtdeFisica}</td>
							<td>${e.qtdeHedge}</td>
							<td>${e.status}</td>
							<td><i class="far fa-minus-square" title="Excluir"></i> <i class="fas fa-search-plus" title="Consultar"></i> <i class="far fa-times-circle" title="Estorno Liquidação"></i> <i class="far fa-calendar-alt" title="Rolagem"></i></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</springform:form>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>