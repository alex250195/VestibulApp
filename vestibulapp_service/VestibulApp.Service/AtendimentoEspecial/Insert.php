<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.insertAtendimentoEspecial', 'urn:server.insertAtendimentoEspecial');
	$server->wsdl->schemaTargetNamespace = 'urn:server.insertAtendimentoEspecial';

	$server->register(
		'insertAtendimentoEspecial',
		array('descricao' => 'xsd:string',
              'inscricao' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.insertAtendimentoEspecial',
		'urn:server.insertAtendimentoEspecial#insertAtendimentoEspecial',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function insertAtendimentoEspecial($descricao, $inscricao){
		include_once '../../VestibulApp.Core/AtendimentoEspecial.php';

		$atendimento = new AtendimentoEspecial();

        $atendimento->setDescricao($descricao);
		$atendimento->setInscricao($inscricao);

		$atendimento->openConnect();

		return $atendimento->Insert();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>