<?php
	include_once '../controllers/usuario.php';

	$usuario = new Usuario();

    $usuario->setId($_GET['id']);
    $usuario->setSenha($_GET['senha']);

	try{
		$usuario->Update();	
	}catch(Exception $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
        exit();
	}finally{
		echo "<script>alert ('Senha Atualizada com Sucesso!'); window.location='../loader.php?status=7';</script>";
	}
?>