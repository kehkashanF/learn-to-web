<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>

<title>IBMS</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>

<script type="text/javascript">
	function showDiv() {
		document.getElementById('welcomeDiv').style.display = "block";
	}
</script>

<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/stylelogin.css">
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Civil Engineer Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- //end-smoth-scrolling -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
</head>
<body>
	<!--banner start here-->
	<div class="banner">
		<div class="header">
			<div class="container">
				<div class="header-main">
					<div class="logo">
						<h1>
							Connect
						</h1>
					</div>
					<div class="top-nav">
						<span class="menu"> <img src="images/icon.png" alt="" /></span>
						<nav class="cl-effect-1">
							<ul class="res">
								<li><a href="login.jsp" class="active">Home</a></li>
								<li><a href="about.html">About</a></li>
								<li><a href="services.html">Services</a></li>
								<li><a href="gallery.html">Gallery</a></li>
								<li><a href="shortcords.html">Short Codes</a></li>
								<li><a href="contact.html">Contact</a></li>
							</ul>
						</nav>
						<!-- script-for-menu -->
						<script>
							$("span.menu").click(function() {
								$("ul.res").slideToggle(300, function() {
									// Animation complete.
								});
							});
						</script>
						<!-- /script-for-menu -->
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<section class="slider">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<div class="banner-bottom">
								<h2>Login</h2>
								<div class="bs-example" data-example-id="simple-form-inline">

									<form class="form-inline" id="form_id" method="post"
										name="myform">
										<div class="form-group">
											<label class="sr-only" for="exampleInputEmail3">Email
												address</label> 
												
												<input type="email" class="form-control"
												id="email" name="demail" placeholder="Email">
										</div>
										<br> <br>
										<div class="form-group">
											<label class="sr-only" for="exampleInputPassword3"
												name="password" id="password">Password</label> <input
												type="password" class="form-control"
												id="password" placeholder="Password" name="password">
										</div>
										<br> <br>
										

										<input type="button" class="btn btn-1 btn-primary"
											value="Login" id="login" name="login" />
										<a href="PreReg.html">Register As</a>
<!-- 										<a href="demo.jsp">Register As</a> -->

									</form>
									
								</div>




								<div id="welcomeDiv" style="display: none;" class="answer_list">
									<a href="RegisterHospital.html">Hospital</a> <a
										href="RegisterBloodBank.html">Bloodbank</a>
								</div>

								<!-- 								<p>Excepteur sint occaecat cupidatat.</p> -->


								<!-- <a href="#"  onclick="show(document.getElementById('displayOptions'))" >Don't have an account?</a> -->

							</div>
						</li>

					</ul>
				</div>
				<div class="clearfix"></div>
			</section>
		</div>
	</div>
	<!--banner end here-->
	<!-- FlexSlider -->
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript">
		$(function() {

		});
		$(window).load(function() {
			$('.flexslider').flexslider({
				animation : "slide",
				start : function(slider) {
					$('body').removeClass('loading');
				}
			});
		});
	</script>
	<!-- FlexSlider -->

	<!--banner-info strat here-->

</body>
</html>