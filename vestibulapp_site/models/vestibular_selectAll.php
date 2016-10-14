<?php
	include_once 'controllers/vestibular.php';

	$vestibular = new Vestibular();

	try{
		$resp = $vestibular->SelectAll();
	}catch(Expection $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
        exit();
	}
?>