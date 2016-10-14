<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectBySpecificationInstituicao', 'urn:server.selectBySpecificationInstituicao');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectBySpecificationInstituicao';

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
		'selectBySpecificationInstituicao',
		array(),
		array('return' => 'tns:Array'),
		'urn:server.selectBySpecificationInstituicao',
		'urn:server.selectBySpecificationInstituicao#selectBySpecificationInstituicao',
		'rpc',
		'encoded',
		'Exibe os dados do usuario.'
	);

	function selectBySpecificationInstituicao(){
		include_once '../../VestibulApp.Core/Instituicao.php';

		$instituicao = new Instituicao();

		$instituicao->openConnect();
		
		return $instituicao->SelectBySpecification();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>