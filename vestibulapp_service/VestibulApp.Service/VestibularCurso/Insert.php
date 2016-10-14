<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.insertVestibularCurso', 'urn:server.insertVestibularCurso');
	$server->wsdl->schemaTargetNamespace = 'urn:server.insertVestibularCurso';

	$server->register(
		'insertVestibularCurso',
		array('id_vestibular' => 'xsd:string',
			  'id_curso' => 'xsd:string',
			  'vaga' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.insertVestibularCurso',
		'urn:server.insertVestibularCurso#insertVestibularCurso',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function insertVestibularCurso($id_vestibular, $id_curso, $vaga){
		include_once '../../VestibulApp.Core/Vestibular_Curso.php';

		$vestibular = new VestibularCurso();
        
		$vestibular->setId_vestibular($id_vestibular);
		$vestibular->setId_curso($id_curso);
		$vestibular->setVaga($vaga);

        $vestibular->openConnect();

		return $vestibular->Insert();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>