<nav class="navbar navbar-default" role="navigation">
  <div class="container">
    <div class="col-sm-6 col-xs-12 main_menu">
    	<a href="${pageContext.request.contextPath}/user/index">
    		<img src="/fitnessproject/img/icon/site_icon.png" alt="site icon">
    		<span class="">Fitness Project</span>
    	</a>
    </div>
    <div class="col-md-offset-2 col-md-4 col-sm-offset-1 col-sm-5 hidden-xs">
    	<ul class="nav navbar-nav" role="navigation">
    		<li class=""><a href="${pageContext.request.contextPath}/user/index">Olá, {_user.info.name_}!</a></li>
    		<li class="dropdown">
    			<a href="#config" title="Configuração" class="dropdown-toggle" data-toggle="dropdown">
					<img alt="icon_config" src="/fitnessproject/img/icon/config_icon.png">
				</a>
				<ul  class="dropdown-menu" role="menu">
					<li><a href="#">Geral</a></li>
					<li><a href="#">Nova Senha</a></li>
					<li><a href="#">Notificações</a></li>
					<hr/>
					<li><a href="${pageContext.request.contextPath}/logout">Sair</a></li>
				</ul>
    		</li>
    		
    	</ul>
    </div>
  </div>
</nav>