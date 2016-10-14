<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectVerifyInstituicao', 'urn:server.selectVerifyInstituicao');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectVerifyInstituicao';

	$server->register(
		'selectVerifyInstituicao',
		array(),
		array('return' => 'xsd:string'),
		'urn:server.selectVerifyInstituicao',
		'urn:server.selectVerifyInstituicao#selectVerifyInstituicao',
		'rpc',
		'encoded',
		'Verificando existência de usuários.'
	);

	function selectVerifyInstituicao(){
		include_once '../../VestibulApp.Core/Instituicao.php';

		$instituicao = new Instituicao();
		
		$instituicao->openConnect();
		
		return $instituicao->SelectVerify();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>