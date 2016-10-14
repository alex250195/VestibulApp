<?php
    include_once 'controllers/instituicao.php';

	$instituicao = new Instituicao();

    try{
        $result = $instituicao->SelectVerify();
    }catch(Exception $e){
        echo "<script>alert ('" .$e->getMessage(). "');</script>";
        exit();
    }
?>