<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectAllCurso', 'urn:server.selectAllCurso');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectAllCurso';

	$server->wsdl->addComplexType('cursoDateType','complexType','struct','all','',
		array(
			'id' => array('name'=>'id_curso','type'=>'xsd:int'),
			'id_instituicao' => array('name'=>'id_instituicao','type'=>'xsd:string'),
			'nome' => array('name'=>'nome','type'=>'xsd:string'),
			'descricao' => array('name'=>'descricao','type'=>'xsd:string')
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
				'wsdl:arrayType' => 'tns:cursoDateType[]'
			)
		),
		'xsd:string'
	);

	$server->register(
		'selectAllCurso',
		array(),
		array('return' => 'tns:UserArray'),
		'urn:server.selectAllCurso',
		'urn:server.selectAllCurso#selectAllCurso',
		'rpc',
		'encoded',
		'Exibindo os dados do usuario.'
	);

	function selectAllCurso(){
		include_once '../../VestibulApp.Core/Curso.php';

		$curso = new Curso();
		
		$curso->openConnect();
		
		return $curso->SelectAll2();
		//Close Database Connection (results now in $bookings array)
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>