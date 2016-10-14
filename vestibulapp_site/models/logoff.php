<?php
	include_once '../controllers/logoff.php';

	$sair = new Logoff();

	try{
		$sair->sair();
	}catch(Exception $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
        exit();
	}
?>