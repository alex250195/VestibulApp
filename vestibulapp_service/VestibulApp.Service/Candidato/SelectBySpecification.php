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
		'selectBySpecificationCandidato',
		array('cpf' => 'xsd:string'),
		array('return' => 'tns:Array'),
		'urn:server.selectBySpecificationCandidato',
		'urn:server.selectBySpecificationCandidato#selectBySpecificationCandidato',
		'rpc',
		'encoded',
		'Exibe os dados do usuario.'
	);

	function selectBySpecificationCandidato($query){
		include_once '../../VestibulApp.Core/Candidato.php';

		$candidato = new Candidato();
		
		$candidato->openConnect();

		return $candidato->SelectBySpecification($query);
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>