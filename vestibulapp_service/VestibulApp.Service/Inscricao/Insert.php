<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.insertInscricao', 'urn:server.insertInscricao');
	$server->wsdl->schemaTargetNamespace = 'urn:server.insertInscricao';

	$server->register(
		'insertInscricao',						//methodname
		array('curso' => 'xsd:string',			//parametros de entrada
              'vestibular' => 'xsd:string',
			  'candidato' => 'xsd:string',
			  'lingua' => 'xsd:string'),
		array('return' => 'xsd:string'),		//parametros de saida = array
		'urn:server.insertInscricao',			//namespace
		'urn:server.insertInscricao#insertInscricao',	//soapaction
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function insertInscricao($curso, $vestibular, $candidato, $lingua){
		include_once '../../VestibulApp.Core/Inscricao.php';

		$inscricao = new Inscricao();

        $inscricao->setId_curso($curso);
		$inscricao->setId_vestibular($vestibular);
		$inscricao->setId_candidato($candidato);
		$inscricao->setLingua($lingua);

		$inscricao->openConnect();

		return $inscricao->Insert();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>