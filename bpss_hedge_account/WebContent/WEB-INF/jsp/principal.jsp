<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<tiles:insertDefinition name="template">
	<tiles:putAttribute name="corpo">
		<div id="main-body" class="panel-body">

			<div class="container">
				&nbsp; &nbsp; &nbsp;
				<div style="text-align: center; size: 2.25rem; padding: 60px;">
					<div class="shadow w-25 p-4 mb-5 bg-white rounded float-left">
						<p class="text-sm-left border-bottom-primary">Caixa 01.</p>
					</div>
					<div class="shadow w-25 p-4 mb-5 bg-white rounded float-right">
						<p class="text-sm-left border-bottom-primary">Caixa 02.</p>
					</div>
				</div>
			</div>

			<div class="container">
				&nbsp; &nbsp; &nbsp;
				<div
					style="text-align: center; size: 2.25rem; padding: 60px; padding-bottom: 15%;">
					<div class="shadow w-25 p-4 mb-5 bg-white rounded float-left">
						<p class="text-sm-left border-bottom-primary">Caixa 03.</p>
					</div>
					<div class="shadow w-25 p-4 mb-5 bg-white rounded float-right">
						<p class="text-sm-left border-bottom-primary">Caixa 04.</p>
					</div>
				</div>
			</div>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>