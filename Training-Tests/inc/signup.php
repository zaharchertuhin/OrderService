<?php
	session_start();
	require_once 'connect.php';

	$full_name=$_POST['full_name'];
	$login=$_POST['login'];
	$email=$_POST['email'];
	$password=$_POST['password'];
	$password_confirm=$_POST['password_confirm'];

   if(!empty($full_name)&& !empty($login)&& !empty($email)&& !empty($password)&& !empty($password_confirm)){
		if($password === $password_confirm) {
			$path = 'uploads/' . time() . $_FILES['avatar']['name'];
			if (!move_uploaded_file($_FILES['avatar']['tmp_name'], '../' . $path)) {
				$_SESSION['message1'] = 'Ошибка при загрузке сообщения';
				header('Location: ../main.php');
			}

			$password = md5($password);

			mysqli_query($connect, "INSERT INTO `users` (`id`, `full_name`, `login`, `email`, `password`, `avatar`) VALUES (NULL, '$full_name', '$login', '$email', '$password', '$path')");
			$_SESSION['message1'] = 'Регистрация прошла успешно!';
			header('Location: ../main.php');
		}
		else{
			$_SESSION['message1'] = 'Пароли не совпадают';
			header('Location: ../main.php');
		}
	}
	else{
		$_SESSION['message1'] = 'Не все поля заполнены';
			header('Location: ../main.php');

	}
?>