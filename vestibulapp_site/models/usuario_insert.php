<?php
	include_once '../controllers/usuario.php';
	include_once '../utilitarios/validacao.php';

	$usuario = new Usuario();
	$valida = new Validacao();

	$usuario->setTipo_usuario($_GET['tipo']);	
	$usuario->setId_instituicao(1);
    $usuario->setCpf($_GET['cpf']);
    $usuario->setSenha($_GET['senha']);
    $usuario->setNome($_GET['nome']);
	
	try{
		$usuario->Insert();
	}catch(Exception $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
        exit();
	}finally{
		echo "<script>alert ('Cadastro Efetuado com Sucesso!'); window.location='../loader.php?status=4';</script>";
	}
?>