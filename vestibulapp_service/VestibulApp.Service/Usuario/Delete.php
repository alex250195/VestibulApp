<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.deleteUsuario', 'urn:server.deleteUsuario');
	$server->wsdl->schemaTargetNamespace = 'urn:server.deleteUsuario';

	$server->register(
		'deleteUsuario',
		array('id' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.deleteUsuario',
		'urn:server.deleteUsuario#deleteUsuario',
		'rpc',
		'encoded',
		'Deletando os dados do usuario.'
	);

	function deleteUsuario($id){		
		include_once '../../VestibulApp.Core/Usuario.php';
		
		$usuario = new Usuario();

        $usuario->setId($id);

		$usuario->openConnect();

		return $usuario->Delete();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>