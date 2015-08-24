<nav class="navbar navbar-default navbar-static-top" role="navigation" onload="activeMenu()">
  <div class="container">
    <div class="col-sm-6 main_menu">
    	<a href="index" class="hidden-xs">
    		<img src="img/icon/site_icon.png" alt="">
    		<span>Fitness Project</span>
    	</a>
    	<a id="menu_guest" href="#" class="visible-xs" onclick="open_close_menu_guest()">
    		<img src="img/icon/site_icon.png" alt="">
    		<span>Fitness Project</span>
    		<span class="glyphicon glyphicon-chevron-down" style="font-size:25px;top:5px;"></span>
    	</a>
    </div>
    <div id="submenu_guest" class="col-sm-6 hidden-xs">
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
	var open_close_menu_guest = function(){
		var menu = document.getElementById('menu_guest');
		submenu = document.getElementById('submenu_guest');
		if(submenu.classList.contains('hidden-xs')){
			submenu.classList.remove('hidden-xs');
			menu.children[2].classList.remove('glyphicon-chevron-down');
			menu.children[2].classList.add('glyphicon-chevron-up');
		}else{
			submenu.classList.add('hidden-xs');
			menu.children[2].classList.remove('glyphicon-chevron-up');
			menu.children[2].classList.add('glyphicon-chevron-down');
		}
	}
</script>