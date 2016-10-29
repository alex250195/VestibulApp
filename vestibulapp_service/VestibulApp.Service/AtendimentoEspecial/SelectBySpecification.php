<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectBySpecificationAtendimentoEspecial', 'urn:server.selectBySpecificationAtendimentoEspecial');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectBySpecificationAtendimentoEspecial';

	$server->wsdl->addComplexType('atendimentoEspecialDateType','complexType','struct','all','',
		array(
			'id_especial' => array('name'=>'id_especial','type'=>'xsd:int'),
			'descricao' => array('name'=>'descricao','type'=>'xsd:string'),
			'Inscricao_id_inscricao' => array('name'=>'Inscricao_id_inscricao	','type'=>'xsd:string')
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
				'wsdl:arrayType' => 'tns:atendimentoEspecialDateType[]'
			)
		),
		'xsd:string'
	);

	$server->register(
		'selectBySpecificationAtendimentoEspecial',
		array('inscricao' => 'xsd:string'),
		array('return' => 'tns:Array'),
		'urn:server.selectBySpecificationAtendimentoEspecial',
		'urn:server.selectBySpecificationAtendimentoEspecial#selectBySpecificationAtendimentoEspecial',
		'rpc',
		'encoded',
		'Exibe os dados do usuario.'
	);

	function selectBySpecificationAtendimentoEspecial($inscricao){
		include_once '../../VestibulApp.Core/AtendimentoEspecial.php';
        
		$atendimento = new AtendimentoEspecial();

		$atendimento->setInscricao($inscricao);

		$atendimento->openConnect();

		return $atendimento->SelectBySpecification();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>