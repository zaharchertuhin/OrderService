<?php
	session_start();
	if (!$_SESSION['user']) {
		header('Location: /');

	}
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Авторизация и регистрация</title>
</head>
<body>
	<form>
		<img src="<?= $_SESSION['user']['avatar'] ?>" width="200" alt="">
		<h2 style="margin: 10px 0;"><?= $_SESSION['user']['full_name'] ?></h2>
		<a href="#"><?= $_SESSION['user']['email'] ?></a>
		<a href="inc/logout.php" class="logout">Выход</a>
	</form>

</body>
</html>