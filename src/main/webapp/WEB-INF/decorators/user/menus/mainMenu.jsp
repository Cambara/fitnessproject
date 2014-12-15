<nav class="navbar navbar-default" role="navigation">
  <div class="container">
    <div class="col-sm-6 col-xs-10 main_menu">
    	<a href="${pageContext.request.contextPath}/user/index">
    		<img src="/fitnessproject/img/icon/site_icon.png" alt="site icon">
    		<span class="hidden-xs">Fitness Project</span>
    	</a>
    </div>
    <div class="col-md-offset-2 col-md-4 col-sm-offset-1 col-sm-5 col-xs-2">
    	<ul class="nav navbar-nav" role="navigation">
    		<li class="hidden-xs"><a href="${pageContext.request.contextPath}/user/index">Olá, {_user.info.name_}!</a></li>
    		<li class="dropdown">
    			<a href="#config" title="Configuração" class="dropdown-toggle" data-toggle="dropdown">
					<img alt="icon_config" src="/fitnessproject/img/icon/config_icon.png">
				</a>
				<ul  class="dropdown-menu" role="menu">
					<li><a href="#">Geral</a></li>
					<li><a href="#">Nova Senha</a></li>
					<li><a href="#">Notificações</a></li>
					<hr class="visible-xs"/>
					<li class="visible-xs"><a href="#">Sair</a></li>
				</ul>
    		</li>
    		<li class="hidden-xs"><a href="${pageContext.request.contextPath}/logout" title="Logout"><span class="glyphicon glyphicon-log-out"></span></a></li>
    	</ul>
    </div>
  </div>
</nav>