<?php
	class Logoff{
		public function sair(){
			try{
				session_start();
				session_destroy();
				echo "<script>alert ('Ate Logo!'); window.location='../loader.php?status=2';</script>";
				exit;
			}catch(Exception $e){
				echo "<script>alert ('" .$e->getMessage(). "');</script>";
        		exit();
			}
		}
	}
?>