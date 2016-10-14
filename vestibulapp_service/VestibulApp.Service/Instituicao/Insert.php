<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.insertInstituicao', 'urn:server.insertInstituicao');
	$server->wsdl->schemaTargetNamespace = 'urn:server.insertInstituicao';

	$server->register(
		'insertInstituicao',
		array('cnpj' => 'xsd:string',
              'razao_social' => 'xsd:string',
			  'nome_fantasia' => 'xsd:string',
			  'inscricao_municipal' => 'xsd:string',
			  'data_fundacao' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.insertInstituicao',
		'urn:server.insertInstituicao#insertInstituicao',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function insertInstituicao($cnpj, $razao_social, $nome_fantasia, $inscricao_municipal, $data_fundacao){
		include_once '../../VestibulApp.Core/Instituicao.php';
		
		$instituicao = new Instituicao();
		
        $instituicao->setRazao_social($razao_social);
		$instituicao->setNome_Fantasia($nome_fantasia);
		$instituicao->setCnpj($cnpj);
		$instituicao->setData_fundacao($data_fundacao);
		$instituicao->setInscricao_municipal($inscricao_municipal);
		
		$instituicao->openConnect();
		
		return $instituicao->Insert();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>