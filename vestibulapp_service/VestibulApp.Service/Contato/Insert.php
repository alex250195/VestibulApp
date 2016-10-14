<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.insertContato', 'urn:server.insertContato');
	$server->wsdl->schemaTargetNamespace = 'urn:server.insertContato';

	$server->register(
		'insertContato',
		array('id_instituicao' => 'xsd:string',
              'id_candidato' => 'xsd:string',
			  'celular' => 'xsd:string',
			  'fixo' => 'xsd:string',
			  'email' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.insertContato',
		'urn:server.insertContato#insertContato',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function insertContato($id_instituicao, $id_candidato, $celular, $fixo, $email){
		include_once '../../VestibulApp.Core/Contato.php';
		
		$contato = new Contato();

        $contato->setId_instituicao($id_instituicao);
		$contato->setId_candidato($id_candidato);
		$contato->setTelefone_fixo($fixo);
		$contato->setTelefone_celular($celular);
		$contato->setEmail($email);

		$contato->openConnect();

		return $contato->Insert();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>