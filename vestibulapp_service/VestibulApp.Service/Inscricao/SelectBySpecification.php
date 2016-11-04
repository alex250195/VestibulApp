<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectBySpecificationInscricao', 'urn:server.selectBySpecificationInscricao');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectBySpecificationInscricao';

	$server->wsdl->addComplexType('inscricaoDateType','complexType','struct','all','',
		array(

			'id_inscricao' => array('name'=>'id_inscricao','type'=>'xsd:int'),
			'id_vestibular' => array('name'=>'id_vestibular','type'=>'xsd:int'),
			'id_curso' => array('name'=>'id_curso','type'=>'xsd:int'),
			'id_candidato' => array('name'=>'id_candidato','xsd:int'),
			'lingua' => array('name'=>'data_inscricao','type'=>'xsd:string')
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
				'wsdl:arrayType' => 'tns:inscricaoDateType[]'
			)
		),
		'xsd:string'
	);

	$server->register(
		'selectBySpecificationInscricao',
		array(
			'id_candidato' => 'xsd:string',
			'id_vestibular' => 'xsd:string',
			),
		array('return' => 'tns:Array'),
		'urn:server.selectBySpecificationInscricao',
		'urn:server.selectBySpecificationInscricao#selectBySpecificationInscricao',
		'rpc',
		'encoded',
		'Exibe os dados do usuario.'
	);

	function selectBySpecificationInscricao($id_candidato, $id_vestibular){
		include_once '../../VestibulApp.Core/Inscricao.php';

		$inscricao = new Inscricao();

		$inscricao->setId_Vestibular($id_vestibular);
		$inscricao->setId_candidato($id_candidato);

		$inscricao->openConnect();

		return $inscricao->SelectBySpecification();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>