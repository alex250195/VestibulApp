<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectByCurso', 'urn:server.selectByCurso');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectByCurso';

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
		'selectByCurso',
		array('idVestibular' => 'xsd:string'),
		array('return' => 'tns:UserArray'),
		'urn:server.selectByCurso',
		'urn:server.selectByCurso#selectByCurso',
		'rpc',
		'encoded',
		'Exibindo os dados do usuario.'
	);

	function selectByCurso($idVestibular){
		include_once '../../VestibulApp.Core/Vestibular_Curso.php';

		$curso = new VestibularCurso();

        $curso->setId_vestibular($idVestibular);
		
		$curso->openConnect();
		
		return $curso->SelectByCurso();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>