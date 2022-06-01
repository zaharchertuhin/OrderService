<?php
	$connect = mysqli_connect('localhost', 'root', '', 'test');
	if(!$connect) {
		die('Ошибка соединения с базой данных');
	}
?>