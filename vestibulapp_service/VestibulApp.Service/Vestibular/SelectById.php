<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectByIdVestibular', 'urn:server.selectByIdVestibular');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectByIdVestibular';

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
				'wsdl:arrayType' => 'tns:string[]'
			)
		),
		'xsd:string'
	);

	$server->register(
		'selectByIdVestibular',
		array('id' => 'xsd:string'),
		array('return' => 'tns:UserArray'),
		'urn:server.selectAll',
		'urn:server.selectAll#selectAll',
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