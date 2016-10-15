<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.insertAtendimentoEspecifico', 'urn:server.insertAtendimentoEspecifico');
	$server->wsdl->schemaTargetNamespace = 'urn:server.insertAtendimentoEspecifico';

	$server->register(
		'insertAtendimentoEspecifico',
		array('descricao' => 'xsd:string',
              'inscricao' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.insertAtendimentoEspecifico',
		'urn:server.insertAtendimentoEspecifico#insertAtendimentoEspecifico',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function insertAtendimentoEspecifico($descricao, $inscricao){
		include_once '../../VestibulApp.Core/AtendimentoEspecifico.php';

		$atendimento = new AtendimentoEspecifico();
        
        $atendimento->setDescricao($descricao);
		$atendimento->setInscricao($inscricao);

		$atendimento->openConnect();

		return $atendimento->Insert();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>