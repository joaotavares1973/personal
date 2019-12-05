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

tfoot input {
	width: 120%;
	padding: 3px;
	box-sizing: border-box;
}
</style>

<tiles:insertDefinition name="template">
	<tiles:putAttribute name="corpo">

		<script type="text/javascript" charset="utf-8">
			function carregar() {
				
				var r = confirm("Deseja carregar operações referentes ao Mês ${mesAno} ?");
				if (r == true) {
					$
					.ajax({
						type : "POST",
						url : "${pageContext.request.contextPath}/carregarOperacoes.bpss",
						dataType : "text",
						success : function(msg) {
							alert('Dados Carregados com sucesso');
						},
						error : function() {
							alert('Erro na Carga');
						}
					});
				}
				
			}

			$(document)
					.ready(
							function() {

								$('#lista tfoot th')
										.each(
												function() {
													var title = $(this).text();
													$(this)
															.html(
																	'<input type="text" placeholder="'+title+'" />');
												});

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
														"width" : "15%",
														"targets" : [ 7 ]
													}, {
														"width" : "10%",
														"targets" : [ 8 ]
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
														"search" : "Pesquisar:",
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

								// Apply the search
								tabela
										.columns()
										.every(
												function() {
													var that = this;

													$('input', this.footer())
															.on(
																	'keyup change clear',
																	function() {
																		if (that
																				.search() !== this.value) {
																			that
																					.search(
																							this.value)
																					.draw();
																		}
																	});
												});

							});
		</script>

		<springform:form name="listaProdutos" method="post"
			action="${pageContext.request.contextPath}/listarOperacoes.bpss"
			modelAttribute="loja">

			<fieldset>
				<div class="form-row" style="margin-left: 10px; margin-top: 10px;">
					<div class="col-md-2" style="font-size: 10px;">
						<span>Safra:</span> <input type="text" class="form-control"
							id="anoSafra" name="anoSafra" value="${anoSafra}" required="true" />
					</div>

					<div class="col-md-2" style="font-size: 10px;">
						<span>Data de negociação:</span> <input type="text"
							class="form-control" id="dtNegociacaoIni" name="dtNegociacaoIni"
							value="${dtNegociacaoIni}" required="true" />
					</div>
					<div class="col-md-2" style="font-size: 10px;">
						Até: <input type="text" class="form-control" id="dtNegociacaoFim"
							name="dtNegociacaoFim" value="${dtNegociacaoFim}" required="true" />
					</div>
					<div class="col-md-1" style="font-size: 10px;">
						&nbsp; <input type="button"
							class="form-control d-none d-sm-inline-block btn btn-sm btn-primary"
							value="Listar" onclick="document.listaProdutos.submit();" />
					</div>
				</div>

				<fieldset>
					<div class="form-row"
						style="margin-left: 10px; margin-top: 10px; float: left;">
						<a
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"
							href="#void" onclick="carregar();"> <i
							class="fas fa-plus-square"></i> <span style="">Carregar
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Finalizado 21/10/2019
								15:40:10</span>
						</a>
					</div>

				</fieldset>

				<table id="lista" class="table table-striped table-bordered nowrap"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Ctr</th>
							<th>Tipo Oper.</th>
							<th>Produto</th>
							<th>Mês/Ano</th>
							<th>Componente</th>
							<th>Quantidade</th>
							<th>Valor</th>
							<th>Status</th>
							<th>Ações</th>
						</tr>

					</thead>
					<tbody>
						<c:forEach items="${operacoes}" var="e">
							<tr>
								<td>${e[0]}</td>
								<td>${e[1]}</td>
								<td>${e[2]}</td>
								<td>${e[3]}</td>
								<td>${e[4]}</td>
								<td>${e[5]}</td>
								<td>${e[6]}</td>
								<td>${e[7]}</td>
								<td><i class="fas fa-search-plus" title="Consultar"></i></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<th>Ctr</th>
							<th>Tipo Oper.</th>
							<th>Produto</th>
							<th>Mês/Ano</th>
							<th>Componente</th>
							<th>Quantidade</th>
							<th>Valor</th>
							<th>Status</th>
							<th>N/A</th>
						</tr>
					</tfoot>
				</table>
		</springform:form>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>