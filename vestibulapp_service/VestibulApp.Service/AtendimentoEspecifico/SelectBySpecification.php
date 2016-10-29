<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectBySpecificationAtendimentoEspecifico', 'urn:server.selectBySpecificationAtendimentoEspecifico');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectBySpecificationAtendimentoEspecifico';


	$server->wsdl->addComplexType('atendimentoEspecificoDateType','complexType','struct','all','',
		array(
			'id' => array('name'=>'id_especifico','type'=>'xsd:int'),
			'descricao' => array('name'=>'descricao','type'=>'xsd:string'),
			'id_inscricao' => array('name'=>'Inscricao_id_inscricao	','type'=>'xsd:string')
		)
	);

	$server->wsdl->addComplexType(
		'Array',          // Name
		'complexType',    // Type Class
		'array',          // PHP Type
		'',               // Compositor
		'SOAP-ENC:Array', // Restricted Base
		array(),
		array(
			array(
				'ref' => 'SOAP-ENC:arrayType', 
				'wsdl:arrayType' => 'tns:atendimentoEspecificoDateType[]'
			)
		),
		'xsd:string'
	);

	$server->register(
		'selectBySpecificationAtendimentoEspecifico',
		array('inscricao' => 'xsd:string'),
		array('return' => 'tns:Array'),
		'urn:server.selectBySpecificationAtendimentoEspecifico',
		'urn:server.selectBySpecificationAtendimentoEspecifico#selectBySpecificationAtendimentoEspecifico',
		'rpc',
		'encoded',
		'Exibe os dados do usuario.'
	);

	function selectBySpecificationAtendimentoEspecifico($inscricao){
		include_once '../../VestibulApp.Core/AtendimentoEspecifico.php';

		$atendimento = new AtendimentoEspecifico();

		$atendimento->setInscricao($inscricao);
        
		$atendimento->openConnect();

		return $atendimento->SelectBySpecification();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>