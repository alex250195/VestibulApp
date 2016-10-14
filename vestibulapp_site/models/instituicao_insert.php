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

	$instituicao->setCnpj($_GET['cnpj']);
	$instituicao->setRazaoSocial($_GET['razaoSocial']);
	$instituicao->setNomeFantasia($_GET['nomeFantasia']);
	$instituicao->setInscMunicipal($_GET['inscMunicipal']);
	$instituicao->setDataFundacao($formatacao->data($_GET['fundacao']));

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
	$contato->setTelCelular($_GET['tel_celular']);
	$contato->setTelFixo($_GET['tel_fixo']);
	$contato->setEmail($_GET['email']);

	try{
		$instituicao->Insert();
		$endereco->Insert();
		$contato->Insert();		
	}catch(Exception $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
		exit();
	}finally{
		echo "<script>alert ('Cadastro Efetuado com Sucesso!'); window.location='../loader.php?status=3';</script>";
	}
?>