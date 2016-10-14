<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectBySpecificationCurso', 'urn:server.selectBySpecificationCurso');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectBySpecificationCurso';

	$server->register(
		'selectBySpecificationCurso',
		array('nome' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.selectBySpecificationCurso',
		'urn:server.selectBySpecificationCurso#selectBySpecificationCurso',
		'rpc',
		'encoded',
		'Exibindo os dados do usuario.'
	);

	function selectBySpecificationCurso($nome){
		include_once '../../VestibulApp.Core/Curso.php';

		$curso = new Curso();

        $curso->setNome($nome);
		
		$curso->openConnect();
		
		return $curso->SelectBySpecification();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>