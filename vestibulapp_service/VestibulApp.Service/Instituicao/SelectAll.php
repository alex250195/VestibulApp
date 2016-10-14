<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectAllInstituicao', 'urn:server.selectAllInstituicao');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectAllInstituicao';

    $server->wsdl->addComplexType(
		'Array',    // Name
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
		'selectAllInstituicao',
		array(),
		array('return' => 'tns:Array'),
		'urn:server.selectAllInstituicao',
		'urn:server.selectAllInstituicao#selectAllInstituicao',
		'rpc',
		'encoded',
		'Verificando existência de usuários.'
	);

	function selectAllInstituicao(){
		include_once '../../VestibulApp.Core/Instituicao.php';

		$instituicao = new Instituicao();
		
		$instituicao->openConnect();
		
		return $instituicao->SelectAll();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>