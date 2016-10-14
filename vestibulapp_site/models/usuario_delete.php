<?php
	include_once '../controllers/usuario.php';

	$usuario = new Usuario();

	$usuario->setId($_GET['id']);

	try{		
        $usuario->Delete();	
	}catch(Exception $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
        exit();
	}finally{
		echo "<script>alert ('Usuario Excluido com Sucesso!'); window.location='../loader.php?status=7';</script>";
	}
?>