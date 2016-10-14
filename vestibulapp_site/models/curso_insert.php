<?php
	include_once '../controllers/curso.php';

	$curso = new Curso();
	
    $curso->setIdInstituicao(1);
	$curso->setNome($_GET['curso']);
	$curso->setDescricao($_GET['descricao']);

	try{
		$curso->insert();
	}catch(Exception $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
        exit();
	}finally{
		echo "<script>alert ('Curso cadastrado!'); window.location='../loader.php?status=6';</script>";
	}
?>