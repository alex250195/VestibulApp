<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.insertVestibular', 'urn:server.insertVestibular');
	$server->wsdl->schemaTargetNamespace = 'urn:server.insertVestibular';

	$server->register(
		'insertVestibular',
		array('id_instituicao' => 'xsd:string',
			  'status' => 'xsd:string',
			  'dtProva' => 'xsd:string',
			  'dtInscricao' => 'xsd:string',
			  'dtEncerramento' => 'xsd:string',
			  'dtGabarito' => 'xsd:string',
			  'dtOficial' => 'xsd:string',
			  'edital' => 'xsd:string',
			  'gabarito' => 'xsd:string',
			  'classificacao' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.insertVestibular',
		'urn:server.insertVestibular#insertVestibular',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function insertVestibular($id_instituicao, $status, $dtProva, $dtInscricao, $dtEncerramento, $dtGabarito, $dtOficial, $edital, $gabarito, $classificacao){
		include_once '../../VestibulApp.Core/Vestibular.php';
		
		$vestibular = new Vestibular();
        
		$vestibular->setId_instituicao($id_instituicao);
		$vestibular->setStatus($status);
		$vestibular->setData_prova($dtProva);
		$vestibular->setData_inicio_inscricao($dtInscricao);
		$vestibular->setData_termino_inscricao($dtEncerramento);
		$vestibular->setData_resultado_gabarito($dtGabarito);
		$vestibular->setData_resultado_oficial($dtOficial);
		$vestibular->setEdital($edital);
		$vestibular->setGabarito($gabarito);
		$vestibular->setClassificacao($classificacao);

        $vestibular->openConnect();

		return $vestibular->Insert();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>