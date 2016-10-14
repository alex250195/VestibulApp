<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.deleteCurso', 'urn:server.deleteCurso');
	$server->wsdl->schemaTargetNamespace = 'urn:server.deleteCurso';

	$server->register(
		'deleteCurso',
		array('id' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.deleteCurso',
		'urn:server.deleteCurso#deleteCurso',
		'rpc',
		'encoded',
		'Deletando os dados do usuario.'
	);

	function deleteCurso($id){		
		include_once '../../VestibulApp.Core/Curso.php';
		
		$curso = new Curso();

        $curso->setId($id);

		$curso->openConnect();

		return $curso->Delete();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>