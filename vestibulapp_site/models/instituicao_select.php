<?php
	include_once 'controllers/instituicao.php';
	include_once 'utilitarios/formatacao.php';
    include_once 'models/instituicao_verify.php';

    if(!$result){
        echo "<script>alert ('Favor efetuar o cadastro da instituição!'); window.location='loader.php?status=3';</script>";
    }

	$instituicao = new Instituicao();
	$formata = new Formatacao();

	try{
		 $resp = $instituicao->SelectAll();
         
         $idInstituicao = $resp[0];
         $idEndereco = $resp[6]; 
         $idContato = $resp[15];

         $cnpj = $resp[1];
         $razaoSocial = $resp[2];
         $nomeFantasia = $resp[3];
         $inscMunicipal = $resp[5];
         $dataFundacao = $formata->dataFormata($resp[4]);
         
         $cep = $resp[7];
         $logradouro = $resp[8];
         $endereco = $resp[9];
         $numero = $resp[10];
         $complemento = $resp[11];
         $bairro = $resp[12];
         $municipio = $resp[13]; 
         $uf = $resp[14];
         
         $celular = $resp[16];
         $fixo = $resp[17];
         $email = $resp[18];
	}catch(Exception $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
        exit();
	}
?>