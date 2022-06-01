<?php


?>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?familly=Montserrat:300,300i,400,700&display=swap">
	<link rel="stylesheet" href="css/style.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Training tests</title>

</head>
<body>
<header>
	<div class="container">
		
		<div class="header__inner">
			<div class="user">
				<div class="user__avatar">
					<!--<img src="https://catherineasquithgallery.com/uploads/posts/2021-02/1614251282_60-p-kartinki-na-zastavku-telefona-chernie-fon-67.jpg"> -->
					<p>Training Tests</p>
				</div>
				<div class="user__content">
					<div class="user__name">TRAINING</div>
					<div class="user__prof">TESTS</div>
				</div>

			</div>

			<nav class="nav">
				<a class="nav__link" href="index.html">Главная</a>
				<a class="nav__link" href="#">Информация</a>
				<a class="nav__link" href="rez.html">Мои результаты</a>
				<a class="nav__link" href="main.php">Выйти</a>
			</nav>
		</div>

	</div>
</header>
<section class="intro">
	<div class="container">
		<div class="intro__inner">
			<div class="intro__content">
				    <h2 class="intro__title">Добро пожаловать!</h2>
					<h3 class="intro__text">Данная страница содержит тестовые задания </h3>
					<h3 class="intro__text"> для подготовки к базовой математике</h3>
			</div>
			<div class="intro__photo">
				<img src="image/2.png" class="photo">
			</div>
	    </div>
	</div>
	
</section>

<div class="Works">

<?php

function getUrlQuery($url, $key = null)
{
    $parts = parse_url($url);
    if (!empty($parts['query'])) {
        parse_str($parts['query'], $query);
        if (is_null($key)) {
            return $query;
        } elseif (isset($query[$key])) {
            return $query[$key];
        }
    }

    return false;
}


$get = getUrlQuery($_SERVER['REQUEST_URI'], 'answer');

$url = 'http://192.168.0.102:8080/order/';

$ch = curl_init($url."list/1");
curl_setopt($ch, CURLOPT_HEADER, 0);

curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);

$responce = curl_exec($ch);
$data = json_decode($responce, true);
curl_close($ch);

$array = str_split($data['list_of_task']);

?>


	<div class="container">
		
		<div class="works__nav">
			<p>Teст 1<p>
		</div>
        <?php foreach ($array as $value): ?>
		<div class="predm" style="flex-direction: column!important;">
            <h3>Решите пример:</h3>
            <p><?php



            $result = array();

            $ch = curl_init($url."task/".$value);
                curl_setopt($ch, CURLOPT_HEADER, 0);

                curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);

            $responce = curl_exec($ch);
            $data = json_decode($responce, true);
            curl_close($ch);


            $task = $data['taskBody'];
            $answer = $data['answer'];
                print_r($task);

            ?></p>
            <form method="GET">
            <h3>Ответ</h3>
            <input type="text" name="answer<?php echo $value?>" size="40" style="width: 60px" value="<?php echo $get?>">
            <button ="width: 60px" name="button" onClick="toggle(this)">Ответить</button>
            </form>
            <?php
            print_r($get);
            if(isset($get)){
            if($get == $answer){
                $txt = "Ответ правильный";
            }
            else{
                $txt = "";
            }}
            ?>
		</div>

        <div id="mydiv"
             style="background-color:aliceblue;padding:25px;">
            <b><?php echo $txt; ?></b>

        </div>


        <script>
            let toggle = button => {
                let element = document.getElementById("mydiv");
                let hidden = element.getAttribute("hidden");

                if (hidden) {
                    element.removeAttribute("hidden");

                } else {
                    element.setAttribute("hidden", "hidden");

                }
            }
        </script>
        <?php endforeach; ?>
	</div>

</div>

</body>
</html>