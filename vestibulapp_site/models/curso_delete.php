<?php
	include_once '../controllers/curso.php';

	$curso = new Curso();

	$curso->setId($_GET['id']);

	try{
		$curso->Delete();
	}
	catch(Exception $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
		exit();
	}finally{
		echo "<script>alert ('Curso Excluido com Sucesso!'); window.location='../loader.php?status=10';</script>";
	}
?>