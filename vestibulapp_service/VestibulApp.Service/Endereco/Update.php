<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.updateEndereco', 'urn:server.updateEndereco');
	$server->wsdl->schemaTargetNamespace = 'urn:server.updateEndereco';

	$server->register(
		'updateEndereco',
		array('idInstituicao' => 'xsd:string',
              'idCandidato' => 'xsd:string',
			  'cep' => 'xsd:string',
			  'logradouro' => 'xsd:string',
              'domicilio' => 'xsd:string',
              'numero' => 'xsd:string',
              'complemento' => 'xsd:string',
              'bairro' => 'xsd:string',
              'municipio' => 'xsd:string',
			  'uf' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.updateEndereco',
		'urn:server.updateEndereco#updateEndereco',
		'rpc',
		'encoded',
		'Altera os dados do usuario.'
	);

	function updateEndereco($idInstituicao, $idCandidato, $cep, $logradouro, $domicilio, $numero, $complemento, $bairro, $municipio, $uf){
		include_once '../../VestibulApp.Core/Endereco.php';
		
		$endereco = new Endereco();
		
        $endereco->setId_instituicao($idInstituicao);
		$endereco->setId_candidato($idCandidato);
		$endereco->setCep($cep);
		$endereco->setLogradouro($logradouro);
		$endereco->setEndereco($domicilio);
        $endereco->setNumero($numero);
        $endereco->setComplemento($complemento);
        $endereco->setBairro($bairro);
        $endereco->setCidade($municipio);
        $endereco->setEstado($uf);
        
		$endereco->openConnect();
		
		return $endereco->Update();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>