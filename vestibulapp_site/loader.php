<?php
	$status = $_GET['status'];
	
	if($status == 1) include_once 'views/login.php';
	
	else{
		if (!isset($_SESSION)) session_start();
		if (!isset($_SESSION['cpf'])) {
			session_destroy();
			header("Location: index.php");
			exit;
		}
		
		if($status == 2)       include_once 'views/home.php';
		else if($status == 3)  include_once 'views/instituicao_cadastro.php';
		else if($status == 4)  include_once 'views/usuario_cadastro.php';
		else if($status == 5)  include_once 'views/vestibular_cadastro.php';
		else if($status == 6)  include_once 'views/curso_cadastro.php';
		else if($status == 7)  include_once 'views/usuario_exibe.php';
		else if($status == 8)  include_once 'views/usuario_atualiza.php';
		else if($status == 9)  include_once 'views/instituicao_exibe.php';
		else if($status == 10) include_once 'views/curso_exibe.php';
		else if($status == 11) include_once 'views/vestibular_exibe.php';
		else if($status == 12) include_once 'views/vestibular_exibe_detalhe.php';
		else if($status == 13) include_once 'views/edital.php';
		else if($status == 14) include_once 'views/vestibular_atualiza.php';
	}
?>