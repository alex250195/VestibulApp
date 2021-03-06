<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectBySpecificationInscricao', 'urn:server.selectBySpecificationInscricao');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectBySpecificationInscricao';

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
		'selectBySpecificationInscricao',
		array('vestibular' => 'xsd:string'),
		array('return' => 'tns:Array'),
		'urn:server.selectBySpecificationInscricao',
		'urn:server.selectBySpecificationInscricao#selectBySpecificationInscricao',
		'rpc',
		'encoded',
		'Exibe os dados do usuario.'
	);

	function selectBySpecificationInscricao($vestibular){
		include_once '../../VestibulApp.Core/Inscricao.php';

		$inscricao = new Inscricao();

		$inscricao->setId_Vestibular($vestibular);

		$inscricao->openConnect();

		return $inscricao->SelectBySpecification();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>