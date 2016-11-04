<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectByIdVestibular', 'urn:server.selectByIdVestibular');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectByIdVestibular';

	$server->wsdl->addComplexType('vestibularDateType','complexType','struct','all','',
		array(

			'id_vestibular' => array('name'=>'id_vestibular','type'=>'xsd:int'),
			'id_instituicao' => array('name'=>'is_instituicao','type'=>'xsd:int'),
			'status' => array('name'=>'status','type'=>'xsd:string'),
			'data_prova' => array('name'=>'data_prova','type'=>'xsd:string'),
			'data_inscricao' => array('name'=>'data_inscricao','type'=>'xsd:string'),
			'data_encerramento_inscricao' => array('name'=>'data_encerramento_inscricao','type'=>'xsd:string'),
			'data_resultado_gabarito' => array('name'=>'data_resultado_gabarito','type'=>'xsd:string'),
			'data_resultado_oficial' => array('name'=>'data_resultado_oficial','type'=>'xsd:string'),
			'edital' => array('name'=>'edital','type'=>'xsd:string'),
			'gabarito' => array('name'=>'gabarito','type'=>'xsd:string'),
			'resultado_classificacao' => array('name'=>'resultado_classificacao','type'=>'xsd:string')
		)
	);

	$server->wsdl->addComplexType(
		'UserArray',    // Name
		'complexType',    // Type Class
		'array',          // PHP Type
		'',               // Compositor
		'SOAP-ENC:Array', // Restricted Base
		array(),
		array(
			array(
				'ref' => 'SOAP-ENC:arrayType', 
				'wsdl:arrayType' => 'tns:vestibularDateType[]'
			)
		),
		'xsd:string'
	);

	$server->register(
		'selectByIdVestibular',
		array('id' => 'xsd:string'),
		array('return' => 'tns:UserArray'),
		'urn:server.selectByIdVestibular',
		'urn:server.selectByIdVestibular#selectByIdVestibular',
		'rpc',
		'encoded',
		'Exibindo os dados do usuario.'
	);

	function selectByIdVestibular($id){
		include_once '../../VestibulApp.Core/Vestibular.php';
		
		$vestibular = new Vestibular();

        $vestibular->setId($id);
		
        $vestibular->openConnect();

		return $vestibular->SelectById();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>