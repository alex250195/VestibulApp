<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.updateVestibular', 'urn:server.updateVestibular');
	$server->wsdl->schemaTargetNamespace = 'urn:server.updateVestibular';

	$server->register(
		'updateVestibular',
		array('idVestibular' => 'xsd:string',
			  'gabarito' => 'xsd:string',
			  'classificacao' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.updateVestibular',
		'urn:server.updateVestibular#updateVestibular',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function updateVestibular($idVestibular, $gabarito, $classificacao){
		include_once '../../VestibulApp.Core/Vestibular.php';
		
		$vestibular = new Vestibular();
        
		$vestibular->setId($idVestibular);
		$vestibular->setGabarito($gabarito);
		$vestibular->setClassificacao($classificacao);

        $vestibular->openConnect();

		return $vestibular->Update();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>