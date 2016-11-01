<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.updateCandidato', 'urn:server.updateCandidato');
	$server->wsdl->schemaTargetNamespace = 'urn:server.updateCandidato';

	$server->register(
		'updateCandidato',
		array(
			'cpf' => 'xsd:string',
			'senha' => 'xsd:string'
		),
		array('return' => 'xsd:string'),
		'urn:server.updateCandidato',
		'urn:server.updateCandidato#updateCandidato',
		'rpc',
		'encoded',
		'Altera os dados do usuario.'
	);

	function updateCandidato($cpf, $senha){
		include_once '../../VestibulApp.Core/Candidato.php';
	
		$candidato = new Candidato();

        $candidato->setCpf($cpf);
		$candidato->setSenha($senha);
		
		$candidato->openConnect();
		
		return $candidato->Update();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>