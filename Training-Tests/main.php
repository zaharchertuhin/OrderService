<?php
session_start();

	if(isset($_SESSION['user'])) {
	   header('Location: index.html');
} 

?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Авторизация и регистрация</title>
	<link rel="stylesheet" href="main.css">
	<script src="script.js" defer></script>
</head>
<body>

<article class="container">
	<div class="block">
		<section class="block_item block_item">
			<h2 class="block_item_tittle">У вас есть аккаунт?</h2>
			<button class="block_item_btn signin-btn" > Войти</button>
		</section>
		<section class="block_item block_item">
			<h2 class="block_item_tittle">У вас нет аккаунта?</h2>
			<button class="block_item_btn signup-btn">Зарегистрироваться</button>
		</section>
		<div class="form-box">
	  <form action="inc/signin.php" method="post" class="form form_signin">
	    	<h3 class="form_title">Вход</h3>
	     		<p>
		      	 <label>Логин</label>
		      	 <input type="text" class="form_input" name="login" placeholder="Введите свой логин">
	     	   </p>
	     	   <p>
				 <label>Пароль</label>
				 <input type="password" class="form_input" name="password" placeholder="Введите свой пароль">
			  </p>
			   <p>
					<button class="form_btn" type="submit">Войти</button>
			  </p>	
			  <?php
			  if (isset($_SESSION['message']))
			  {
			  	echo '<p class="msg_in">' . $_SESSION['message'] . '</p>';
			  }
			  unset($_SESSION['message']);
			  ?>

	  </form> 

	   <form action="inc/signup.php" method="post" class="form form_signup">
	    	<h3 class="form_title">Регистрация</h3>
	    		<p>
		      	 <label>Имя</label>
		      	 <input type="text" class="form_input" name="full_name" placeholder="Введите свое имя">
	     	   </p>
	     		<p>
		      	 <label>Логин</label>
		      	 <input type="text" class="form_input" name="login" placeholder="Введите свой логин">
	     	   </p>
	     	   <p>
		      	 <label>Почта</label>
		      	 <input type="email" class="form_input" name="email" placeholder="Введите свой email">
	     	   </p>
	     	   <p>
				 <label>Пароль</label>
				 <input type="password" class="form_input" name="password" placeholder="Введите свой пароль">
			  </p>
			   <p>
				 <label>Подтвердите пароль</label>
				 <input type="password" class="form_input" name="password_confirm" placeholder="Подтвердите пароль">
			  </p>
			   <p>
					<button class="form_btn  form_btn_signup" type="submit">Зарегистрироваться</button>
			  </p>	
			  <?php
			  if (isset($_SESSION['message1']))
			  {
			  	echo '<p class="msg_out">' . $_SESSION['message1'] . '</p>';
			  }
			 else{
			 	unset($_SESSION['message1']);

			 } 
			  ?>

	  </form> 

	</div>
</article>


</body>
</html>