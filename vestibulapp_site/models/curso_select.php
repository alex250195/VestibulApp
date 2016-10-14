<?php
	include_once 'controllers/curso.php';

	$curso = new Curso();

	try{
		$resp = $curso->SelectAll();
	}catch(Expection $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
	}
?>