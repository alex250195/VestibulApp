<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectVerify', 'urn:server.selectVerify');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectVerify';

	$server->register(
		'selectVerify',
		array(),
		array('return' => 'xsd:string'),
		'urn:server.selectVerify',
		'urn:server.selectVerify#selectVerify',
		'rpc',
		'encoded',
		'Verificando existência de usuários.'
	);

	function selectVerify(){
		include_once '../../VestibulApp.Core/Usuario.php';

		$usuario = new Usuario();
		
		$usuario->openConnect();
		
		return $usuario->SelectVerify();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>