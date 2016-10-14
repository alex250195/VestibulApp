<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectAllUsuario', 'urn:server.selectAllUsuario');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectAllUsuario';

	$server->wsdl->addComplexType(
		'UserArray',    // Name
		'complexType',    // Type Class
		'array',          // PHP Type
		'',               // Compositor
		'SOAP-ENC:Array', // Restricted Base
		array(),
		array(
			array(
				'ref' => 'SOAP-ENC:arrayType', 
				'wsdl:arrayType' => 'tns:string[]'
			)
		),
		'xsd:string'
	);

	$server->register(
		'selectAllUsuario',
		array(),
		array('return' => 'tns:UserArray'),
		'urn:server.selectAllUsuario',
		'urn:server.selectAllUsuario#selectAllUsuario',
		'rpc',
		'encoded',
		'Exibindo os dados do usuario.'
	);

	function selectAllUsuario(){
		include_once '../../VestibulApp.Core/Usuario.php';
		
		$usuario = new Usuario();
		
		$usuario->openConnect();
		
		return $usuario->SelectAll();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>