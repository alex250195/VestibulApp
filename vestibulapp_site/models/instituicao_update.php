<?php
	include_once '../controllers/instituicao.php';
	include_once '../controllers/contato.php';
	include_once '../controllers/endereco.php';
	include_once '../utilitarios/validacao.php';
	include_once '../utilitarios/formatacao.php';

	$instituicao = new Instituicao();
	$endereco = new Endereco();
	$contato = new Contato();

	$formatacao = new Formatacao();

	$instituicao->setId(1);
	$instituicao->setRazaoSocial($_GET['razaoSocial']);
	$instituicao->setNomeFantasia($_GET['nomeFantasia']);

	$endereco->setId_instituicao(1);
	$endereco->setId_candidato("null");
	$endereco->setCep($_GET['cep']);
	$endereco->setLogradouro($_GET['logradouro']);
	$endereco->setEndereco($_GET['endereco']);
	$endereco->setNumero($_GET['numero']);
	$endereco->setComplemento($_GET['complemento']);
	$endereco->setBairro($_GET['bairro']);
	$endereco->setMunicipio($_GET['municipio']);
	$endereco->setUf($_GET['uf']);
	
	$contato->setId_instituicao(1);
	$contato->setId_candidato("null");
	$contato->setTelCelular($_GET['celular']);
	$contato->setTelFixo($_GET['fixo']);
	$contato->setEmail($_GET['email']);

	try{
		$instituicao->Update();
		$endereco->Update();
		$contato->Update();		
	}catch(Exception $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
		exit();
	}finally{
		echo "<script>alert ('Cadastro Efetuado com Sucesso!'); window.location='../loader.php?status=3';</script>";
	}
?>