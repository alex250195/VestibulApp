<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.updateInstituicao', 'urn:server.updateInstituicao');
	$server->wsdl->schemaTargetNamespace = 'urn:server.updateInstituicao';

	$server->register(
		'updateInstituicao',
		array('id' => 'xsd:string',
			  'razaoSocial' => 'xsd:string',
              'nomeFantasia' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.updateInstituicao',
		'urn:server.updateInstituicao#updateInstituicao',
		'rpc',
		'encoded',
		'Altera os dados do usuario.'
	);

	function updateInstituicao($id, $razaoSocial, $nomeFantasia){
		include_once '../../VestibulApp.Core/Instituicao.php';
	
		$instituicao = new Instituicao();

		$instituicao->setId($id);
		$instituicao->setRazao_social($razaoSocial);
        $instituicao->setNome_fantasia($nomeFantasia);
		
		$instituicao->openConnect();
		
		return $instituicao->Update();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>