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
			function verificaProcessar() {
				$
						.ajax({
							type : "POST",
							url : "${pageContext.request.contextPath}/verifcaProcessarCalculo.bpss",
							dataType : "text",
							success : function(msg) {
								if (msg.split(";")[0] == '0') {
									var r = confirm("Deseja processar o Cálculo referente a " + msg.split(";")[1] + " ?");
									if (r == true) {
										processar();
									}
								} else if (msg.split(";")[0] == '2') {
									alert(msg.split(";")[1]);
								} else if (msg.split(";")[0] == '9') {
									alert(msg.split(";")[1]);
								}
							},
							error : function() {
								alert('Erro na Carga');
							}
						});
			}

			function processar() {
				$
						.ajax({
							type : "POST",
							url : "${pageContext.request.contextPath}/processarCalculo.bpss",
							dataType : "text",
							success : function(msg) {
								if (msg.split(";")[0] == '0') {
									alert(msg.split(";")[1]);
								} else if (msg.split(";")[0] == '9') {
									alert(msg.split(";")[1]);
								}
							},
							error : function() {
								alert('Erro na Carga');
							}
						});
			}
			
			function verificaverificaPeriodoContabil() {
				$
						.ajax({
							type : "POST",
							url : "${pageContext.request.contextPath}/verificaPeriodoContabil.bpss",
							dataType : "text",
							success : function(msg) {
								if (msg.split(";")[0] == '0') {
									var r = confirm("Deseja Encerrar Período Contábil " + msg.split(";")[1] + " ?");
									if (r == true) {
										processarPeriodoContabil();
									}
								} else if (msg.split(";")[0] == '9') {
									alert(msg.split(";")[1]);
								}
							},
							error : function() {
								alert('Erro na Carga');
							}
						});
			}			
			
			function processarPeriodoContabil() {
				$
						.ajax({
							type : "POST",
							url : "${pageContext.request.contextPath}/processarPeriodoContabil.bpss",
							dataType : "text",
							success : function(msg) {
								if (msg.split(";")[0] == '0') {
									alert(msg.split(";")[1]);
								} else if (msg.split(";")[0] == '9') {
									alert(msg.split(";")[1]);
								}
							},
							error : function() {
								alert('Erro na Carga');
							}
						});
			}

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

							});
		</script>

		<springform:form name="listaCalculos" method="get"
			action="${pageContext.request.contextPath}/calculos.bpss"
			modelAttribute="loja">

			<fieldset>
				<div class="form-row" style="margin-left: 10px; margin-top: 10px; float:left;">
				<a class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" href="#" onclick="verificaProcessar();">
				<i class="fas fa-database"></i>
				<span style="">Processar</span>
				</a>
				</div>
&nbsp; 
				<div class="form-row" style="margin-left: 10px; margin-top: 10px; float:left; color:#fff;">
				<a class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" href="#" onclick="verificaverificaPeriodoContabil();">
				<i class="fas fa-lock"></i>
				Período Contábil
				</a>
				</div>
&nbsp; 
				<div class="form-row" style="margin-left: 10px; margin-top: 10px; float:left; color:#fff;">
				<a class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" href="#" onclick="document.listaCalculos.submit();">
				<i class="fas fa-check-square"></i>
				Listar
				</a>
				</div>
&nbsp;
				<div class="form-row" style="margin-left: 60px; margin-top: 10px; float:left; color:#fff;">
				<a class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" href="#">
				Status Finalizado : ${flStatus}
				</a>
				</div>

			</fieldset>

			<table id="lista" class="table table-striped table-bordered nowrap"
				cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Nro.</th>
						<th>Mês/Ano</th>
						<th>Instrumento</th>
						<th>Variação</th>
						<th>Ações</th>
					</tr>

				</thead>
				<tbody>
					<c:forEach items="${calculos}" var="e">
						<tr>
							<td>${e[0]}</td>
							<td>${e[1]}</td>
							<td>${e[2]}</td>
							<td>${e[3]}</td>
							<td><i class="fas fa-search-plus" title="Consultar"></i></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</springform:form>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>