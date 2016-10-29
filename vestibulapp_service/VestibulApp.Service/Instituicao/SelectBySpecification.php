<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.selectBySpecificationInstituicao', 'urn:server.selectBySpecificationInstituicao');
	$server->wsdl->schemaTargetNamespace = 'urn:server.selectBySpecificationInstituicao';


	$server->wsdl->addComplexType('instituicaoDateType','complexType','struct','all','',
		array(
			'id_instituicao' => array('name'=>'id_instituicao','type'=>'xsd:int'),
			'cnpj' => array('name'=>'cnpj','type'=>'xsd:string'),
			'razao_social' => array('name'=>'razao_social','type'=>'xsd:string'),
			'nome_fantasia' => array('name'=>'nome_fantasia','type'=>'xsd:string'),
			'data_fundacao' => array('name'=>'data_fundacao','type'=>'xsd:string'),
			'insc_municipal' => array('name'=>'insc_municipal','type'=>'xsd:string'),
			'id_endereco' => array('name'=>'id_endereco','type'=>'xsd:string'),
			'cep' => array('name'=>'cep','type'=>'xsd:string'),
			'logradouro' => array('name'=>'logradouro','type'=>'xsd:string'),
			'endereco' => array('name'=>'endereco','type'=>'xsd:string'),
			'numero' => array('name'=>'numero','type'=>'xsd:string'),
			'complemento' => array('name'=>'complemento','type'=>'xsd:string'),
			'bairro' => array('name'=>'bairro','type'=>'xsd:string'),
			'municipio' => array('name'=>'municipio','type'=>'xsd:string'),
			'uf' => array('name'=>'uf','type'=>'xsd:string'),
			'id_contato' => array('name'=>'id_contato','type'=>'xsd:string'),
			'telefone_celular' => array('name'=>'telefone_celular','type'=>'xsd:string'),
			'telefone_fixo' => array('name'=>'telefone_fixo','type'=>'xsd:string'),
			'email' => array('name'=>'email','type'=>'xsd:string')
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
				'wsdl:arrayType' => 'tns:instituicaoDateType[]'
			)
		),
		'xsd:string'
	);

	$server->register(
		'selectBySpecificationInstituicao',
		array(),
		array('return' => 'tns:Array'),
		'urn:server.selectBySpecificationInstituicao',
		'urn:server.selectBySpecificationInstituicao#selectBySpecificationInstituicao',
		'rpc',
		'encoded',
		'Exibe os dados do usuario.'
	);

	function selectBySpecificationInstituicao(){
		include_once '../../VestibulApp.Core/Instituicao.php';

		$instituicao = new Instituicao();

		$instituicao->openConnect();
		
		return $instituicao->SelectBySpecification();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>