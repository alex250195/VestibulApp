<?php
    include_once '../controllers/usuario.php';

	$acesso = new Usuario();

    if(!$acesso->SelectVerify()){
        $acesso->setId_instituicao("null");
        $acesso->setTipo_usuario("Master");
        $acesso->setCpf("111.111.111-11");
        $acesso->setNome("admin");
        $acesso->setSenha("admin");

        try{
            if($acesso->Insert()){
                if (!isset($_SESSION)) session_start();
                $_SESSION['tipo_usuario']  = "Master";			
                $_SESSION['cpf'] = "111.111.111-11";
                $_SESSION['nome'] = "admin";
            }
            else{
                throw new Exception ("Acesso Negado!");
            }
        }catch(Exception $e){
            echo "<script>alert ('" .$e->getMessage(). "');</script>";
            exit();
        }finally{
            echo "<script>window.location='../loader.php?status=2';</script>";
        }
    }
    else{
        if(empty($_GET['login']) && empty($_GET['senha'])){
            echo "<script>alert ('Acesso Negado!'); window.location='../loader.php?status=1';</script>";
        }

        $acesso->setCpf($_GET['login']);
        $acesso->setSenha($_GET['senha']);

        if($acesso->SelectBySpecification()){
            echo "<script>window.location='../loader.php?status=2';</script>";
        }
        else{
            echo "<script>alert ('Acesso Negado!'); window.location='../loader.php?status=1';</script>";
        }
    }
?>