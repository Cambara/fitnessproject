<nav class="navbar navbar-default navbar-static-top" role="navigation" onload="activeMenu()">
  <div class="container">
    <div class="col-sm-6 main_menu">
    	<a href="index">
    		<img src="img/icon/site_icon.png" alt="">
    		<span>Fitness Project</span>
    	</a>
    </div>
    <div class="col-sm-6">
    	<ul class="nav nav-pills nav-justified menu" role="navigation">
    		<li id="index"><a href="index">HOME</a></li>
    		<li id="login"><a href="login">LOGIN</a></li>
    		<li id="signup"><a href="signup">CADASTRE-SE</a></li>
    	</ul>
    </div>
  </div>
</nav>
<script type="text/javascript">	
	var path = window.location.pathname;
	var paths = new Array();
	paths = path.split("/");
	n = paths.length-1;
	console.log(n);
	$('#'+paths[n]).addClass('active');

</script>