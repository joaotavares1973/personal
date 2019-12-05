<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="imagem/png"
	href="${pageContext.request.contextPath}/icon/logo-fundo-branco.png" />

<title>Hedge Accounting</title>

<!-- Custom fonts for this template-->
<link href="${pageContext.request.contextPath}/css/vendor/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/sb-admin-2.min.css">

<!-- Bootstrap core JavaScript-->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script
	src="${pageContext.request.contextPath}/jquery-easing/jquery.easing.min.js"></script>

<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>

</head>

<body id="page-top">

<div>
    <div class="navbar navbar-expand-sm navbar-dark" style="background-color:#000080; height:40px;">

      <div style="text-align:center; width:190px;"><a href="#"><img src="../img/titulo-hedge-accounting.png" alt="título" width="159" height="40"/></a></div>
      <div class="collapse navbar-collapse">
      <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
      <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-lg fa-user-o" aria-hidden="true"></i> Usuário</a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="bd-versions">
              <a class="dropdown-item" href="#"><i class="fas fa-fw fa-power-off"></i>&nbsp; &nbsp; Sair</a>
            </div>
          </li>
      </ul>
      </div>
    </div>
</div>

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul 
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand ${pageContext.request.contextPath}/inicio.do -->

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->

			<!-- Divider -->
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/inicial.bpss"> <i
					class="fas fa-sm fa-home"></i> <span>Inicial</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseCadastros"
				aria-expanded="true" aria-controls="collapseCadastros"> <i
					class="fas fa-sm fa-folder"></i> <span>Cadastros</span>
			</a>
				<div id="collapseCadastros" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-1 collapse-inner rounded">
						<a class="collapse-item"
							href="${pageContext.request.contextPath}/listarProdutos.bpss">
							<i class="fa fa-sm fa-tag"></i>&nbsp;&nbsp;Produto</a>
						<a class="collapse-item"
							href="${pageContext.request.contextPath}/listarTotalAssociadosAblos.do">
							<i class="fas fa-sm fa-chart-line"></i>&nbsp;&nbsp;Bolsa
							Completa</a> <a class="collapse-item"
							href="${pageContext.request.contextPath}/preparaCadastroAssociado.do">
							<i class="fas fa-fw fa-file-alt"></i>&nbsp;&nbsp;Tipo
							de Documento</a> <a class="collapse-item"
							href="${pageContext.request.contextPath}/preparaCadastroAssociado.do">
							<i class="fas fa-fw fa-money-bill"></i>&nbsp;&nbsp;Tipo
							de Instrumento</a> <a class="collapse-item"
							href="${pageContext.request.contextPath}/preparaCadastroAssociado.do">
							<i class="fas fa-fw fa-book"></i>&nbsp;&nbsp;Tipo
							de Contabilidade</a>
					</div>
				</div></li>

			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseComercial"
				aria-expanded="true" aria-controls="collapseComercial"> <i
					class="fas fa-fw fa-briefcase"></i> <span>Comercial</span>
			</a>
				<div id="collapseComercial" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-1 collapse-inner rounded">
						<a class="collapse-item"
							href="${pageContext.request.contextPath}/gestorOperacoes.bpss">
							<i class="fas fa-fw fa-file-alt"></i>&nbsp;&nbsp;Operações</a>
					</div>
				</div></li>

			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseFinanceiro"
				aria-expanded="true" aria-controls="collapseFinanceiro"> <i
					class="fas fa-fw fa-dollar-sign"></i> <span>Financeiro</span>
			</a>
				<div id="collapseFinanceiro" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-1 collapse-inner rounded">
						<a class="collapse-item"
							href="${pageContext.request.contextPath}/designacoes.bpss">
							<i class="fas fa-fw fa-link"></i>&nbsp;&nbsp;Designações</a>
						<a class="collapse-item"
							href="${pageContext.request.contextPath}/calculos.bpss">
							<i class="fas fa-fw fa-calculator"></i>&nbsp;&nbsp;Cálculos</a>
					</div>
				</div></li>

			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseConfigurações"
				aria-expanded="true" aria-controls="collapseConfigurações"> <i
					class="fas fa-fw fa-cog"></i> <span>Configurações</span>
			</a>
				<div id="collapseConfigurações" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-1 collapse-inner rounded">
						<a class="collapse-item"
							href="${pageContext.request.contextPath}/###">
							<i class="fas fa-fw fa-user"></i>&nbsp;&nbsp;Usuário</a>
						<a class="collapse-item"
							href="${pageContext.request.contextPath}/###">
							<i class="fas fa-fw fa-users"></i>&nbsp;&nbsp;Perfil</a>
					</div>
				</div></li>


			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/deslogar.do"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Sair do
						Sistema </span></a></li>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<div class="panel panel-default">
				<div class="panel-body">
					<tiles:insertAttribute name="corpo" />
				</div>
			</div>

<div class="container">
&nbsp; &nbsp; &nbsp;
			<!-- Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>&nbsp;</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

	</div>
		<!-- End of Content Wrapper -->

<div>
    <div class="navbar fixed-bottom navbar-light navbar-dark" style="background-color:#000080; color:#fff; height:30px; font-size:10px;">
		<div style="width:280px;">
  			<span><i><strong>BPSS Head Accounting</strong> - Versão 1.0.0 - 9/10/2019 - 11:44</i></span>
  		</div>
   		<div style="text-aligh:center;">
   		<span><i>Ambiente Homologação</i></span>
		</div>
    </div>
</div>

	</div>
	<!-- End of Page Wrapper -->

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<script>
		//$(document).ready(function() {
		//	$( "#sidebarToggle" ).click();
		//});
	</script>

</body>

</html>