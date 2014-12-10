<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ReeducandoSis</title>

<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/bootstrap-responsive.css" rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Cache-Control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<script>
	function focar() {
		document.getElementById("usuario").focus();
	}
</script>

</head>
<body>
	<form action="j_spring_security_check" method="post">
		<div class="wrapper">
			<div class="header">
				<div class="container">
					<div class="row branding">
						<div class="span6">
							<h1 class="pull-left">
								<a href="inicio.jsf"><strong>ReeducandoSis</strong></a>
							</h1>
						</div>
					</div>
					<div class="row navigation">
						<div class="span12">
							<ul class="nav nav-tabs">
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="container content">
				<div class="row">
					<div class="span8 leftContent">
						
						<h2> Sitema Gerencial ReeducandoSis</h2>
						<div class="row">
							<div class="span4">
								<p class="cntPara simpleDesign" align="justify">
									<strong class="lead">O Sistema</strong> O ReeducadoSis foi desenvolvido para 
									atenter áreas de segurança 
									pública prisional 
								</p>
							</div>

							<div class="span4">
								<p class="cntPara itsFree" align="justify">
									<strong class="lead">O Objetivo</strong>  Inserir e padronizar as 
									informações e ter um maior controle delas para que os presídios possam 
									gerenciar melhor as ações de segurança pública
								</p>
							</div>
						</div>
						<hr />
						<div class="row">
							<div class="span4">
								<p class="cntPara secureApp" align="justify">
									<strong class="lead"></strong> 
							</div>

							<div class="span4">
								<p class="cntPara easyUse">
									<strong class="lead"></strong>
								</p>
							</div>
						</div>
						<hr />
						<div class="row">
							<div class="span8">
								<h3 class="quickTour"></h3>
								© 2014/02  Senai.fatesg by: Silas Andre, Luiz Fernando Fiuza
							</div>
						</div>
					</div>

					<div class="span4 sidebar">
						
						<div class="well quickSignupForm">
							<h3>Acesso ao Sistema</h3>
							<%
								if (request.getParameter("msg") != null) {
									out.print("<span style='color: red;font-weight: bold;'>Usuário ou senha incorretos</span>");
								}
							%>
							<label>Login</label> <input type="text" id="usuario"
								name="j_username" class="span3" /> <label>Senha</label> <input
								name="j_password" type="password" class="span3" /> <input
								class="btn btn-large btn-success btnSignup" type="submit"
								value="Entrar" />
						</div>
					</div>

				</div>
			</div>
		</div>
</body>
</html>