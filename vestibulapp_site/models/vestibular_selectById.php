<?php
	include_once 'controllers/vestibular.php';

	$vestibular = new Vestibular();

	$vestibular->setId($_GET['id']);
	
	try{        
		$resp = $vestibular->SelectById();

		$curso = $vestibular->SelectByCurso();
	}catch(Expection $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
        exit();
	}
?>