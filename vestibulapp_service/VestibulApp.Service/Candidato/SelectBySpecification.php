<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectBySpecificationCandidato', 'urn:server.selectBySpecificationCandidato');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectBySpecificationCandidato';

	$server->wsdl->addComplexType(
		'Array',          // Name
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
		'selectBySpecificationUsuario',
		array('cpf' => 'xsd:string',
			  'senha' => 'xsd:string'),
		array('return' => 'tns:Array'),
		'urn:server.selectBySpecificationUsuario',
		'urn:server.selectBySpecificationUsuario#selectBySpecificationUsuario',
		'rpc',
		'encoded',
		'Exibe os dados do usuario.'
	);

	function selectBySpecificationUsuario($cpf, $senha){
		include_once '../../VestibulApp.Core/Usuario.php';

		$usuario = new Usuario();

		$usuario->setCpf($cpf);
		$usuario->setSenha($senha);

		$usuario->openConnect();
		
		return $usuario->SelectBySpecification();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>