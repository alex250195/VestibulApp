<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.insertCurso', 'urn:server.insertCurso');
	$server->wsdl->schemaTargetNamespace = 'urn:server.insertCurso';

	$server->register(
		'insertCurso',
		array('id_instituicao' => 'xsd:string',
              'nome' => 'xsd:string',
			  'descricao' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.insertCurso',
		'urn:server.insertCurso#insertCurso',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function insertCurso($id_instituicao, $nome, $descricao){
		include_once '../../VestibulApp.Core/Curso.php';
		
		$curso = new Curso();

        $curso->setId_instituicao($id_instituicao);
		$curso->setNome($nome);
		$curso->setDescricao($descricao);

		$curso->openConnect();

		return $curso->Insert();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>