<?php
	include_once 'controllers/usuario.php';

	$usuario = new Usuario();

	try{
		$resp = $usuario->SelectAll();		
	}catch(Expection $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
        exit();
	}
?>