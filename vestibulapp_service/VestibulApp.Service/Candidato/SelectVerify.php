<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectVerifyCandidato', 'urn:server.selectVerifyCandidato');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectVerifyCandidato';

	$server->register(
		'selectVerifyCandidato',
		array('cpf' => 'xsd:string',
              'senha' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.selectVerifyCandidato',
		'urn:server.selectVerifyCandidato#selectVerifyCandidato',
		'rpc',
		'encoded',
		'Exibe os dados do usuario.'
	);

	function selectVerifyCandidato($cpf, $senha){
		include_once '../../VestibulApp.Core/Candidato.php';

		$candidato = new Candidato();
		
		$candidato->setCpf($cpf);
        $candidato->setSenha($senha);

		$candidato->openConnect();

		return $candidato->SelectVerify();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>