<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectAllCurso', 'urn:server.selectAllCurso');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectAllCurso';

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
		'selectAllCurso',
		array(),
		array('return' => 'tns:UserArray'),
		'urn:server.selectAllCurso',
		'urn:server.selectAllCurso#selectAllCurso',
		'rpc',
		'encoded',
		'Exibindo os dados do usuario.'
	);

	function selectAllCurso(){
		include_once '../../VestibulApp.Core/Curso.php';

		$curso = new Curso();
		
		$curso->openConnect();
		
		return $curso->SelectAll();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>