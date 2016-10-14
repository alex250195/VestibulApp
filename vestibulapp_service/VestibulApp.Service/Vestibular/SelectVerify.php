<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectVerifyVestibular', 'urn:server.selectVerifyVestibular');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectVerifyVestibular';

	$server->register(
		'selectVerifyVestibular',
		array(),
		array('return' => 'xsd:string'),
		'urn:server.selectVerifyVestibular',
		'urn:server.selectVerifyVestibular#selectVerifyVestibular',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function selectVerifyVestibular(){
		include_once '../../VestibulApp.Core/Vestibular.php';
		
		$vestibular = new Vestibular();
		
        $vestibular->openConnect();

		return $vestibular->SelectVerify();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>