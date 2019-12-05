<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="springform"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css">

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">

<script>
	function getLocalProfile(callback) {
		var profileImgSrc = localStorage.getItem("PROFILE_IMG_SRC");
		var profileName = localStorage.getItem("PROFILE_NAME");
		var profileReAuthEmail = localStorage.getItem("PROFILE_REAUTH_EMAIL");

		if (profileName !== null && profileReAuthEmail !== null
				&& profileImgSrc !== null) {
			callback(profileImgSrc, profileName, profileReAuthEmail);
		}
	}

	/**
	 * function that checks if the browser supports HTML5
	 * local storage
	 *
	 * @returns {boolean}
	 */
	function supportsHTML5Storage() {
		try {
			return 'localStorage' in window && window['localStorage'] !== null;
		} catch (e) {
			return false;
		}
	}

	function validaSenha(input) {
		if (input.value != document.Login_Form.password.value) {
			document.getElementById("divPass").style.display = "block";
			document.Login_Form.repassword.value = '';
			document.Login_Form.repassword.focus();
		}else{
			document.getElementById("divPass").style.display = "none";
		}
	}
</script>

</head>


<div class="container">
	<div class="wrapper">
		<form method="post" name="Login_Form"
			action="${pageContext.request.contextPath}/login.do"
			modelAttribute="adCredencials" class="form-signin">

			<input type="hidden" name="reset" value="2" /> <input type="hidden"
				name="email1" value="${adCredencials.login}" /> <br>
			<br>
			<br>
			<br> <input type="text" class="form-control"
				placeholder="Usuário" value="${adCredencials.login}"
				disabled="disabled" /> <br> <input type="password"
				class="form-control" name="password" placeholder="Senha"
				required="true" autofocus="true" /> 
				
				<input type="password"
				class="form-control" name="repassword" placeholder="Confirme Senha"
				required="true" onblur="validaSenha(this)" /> 

			<button class="btn btn-lg btn-primary btn-block" name="Submit"
				value="Login" type="Submit">Login</button>

			<input type="hidden" name="reset" value="1"> <input
				type="hidden" name="login" value="${adCredencials.login}">
				
			<div id="divPass" class="alert alert-warning" role="alert" style="display: none;">Senhas divergentes !</div>	
				
			<c:if test="${mensagem != null}">
				<div class="${mensagem.tipoMensagem.classeCss}" role="alert">${mensagem.texto}</div>
			</c:if>

		</form>
	</div>
</div>

</html>