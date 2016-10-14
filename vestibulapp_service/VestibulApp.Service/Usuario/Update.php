<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.updateUsuario', 'urn:server.updateUsuario');
	$server->wsdl->schemaTargetNamespace = 'urn:server.updateUsuario';

	$server->register(
		'updateUsuario',
		array('id' => 'xsd:string',
			  'senha' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.updateUsuario',
		'urn:server.updateUsuario#updateUsuario',
		'rpc',
		'encoded',
		'Altera os dados do usuario.'
	);

	function updateUsuario($id, $senha){
		include_once '../../VestibulApp.Core/Usuario.php';
	
		$usuario = new Usuario();

		$usuario->setId($id);
		$usuario->setSenha($senha);
		
		$usuario->openConnect();
		
		return $usuario->Update();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>